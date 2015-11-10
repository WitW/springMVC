package com.zbiti.mvc.android.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.zbiti.common.model.DwzReturnObject;
import com.zbiti.common.model.table.Page;
import com.zbiti.mvc.android.model.DeviceMapInfo;
import com.zbiti.mvc.android.model.DevicePortInfo;
import com.zbiti.mvc.android.model.LockOperateInfo;
import com.zbiti.mvc.android.model.OperateTime;
import com.zbiti.mvc.android.model.StaffInfo;
import com.zbiti.mvc.android.service.AccessControlService;
import com.zbiti.mvc.android.service.DeviceInfoService;
import com.zbiti.mvc.android.service.LockOperateService;
import com.zbiti.mvc.android.service.UserInfoService;
import com.zbiti.util.ImageTool;
import com.zbiti.util.StaticPro;
import com.zbiti.util.Util;

/**
 * 门禁管理 控制器
 * 
 * @author dlt
 * 
 */
@Controller
@RequestMapping("accessControl")
@SuppressWarnings("all")
public class AccessControlAction {

	protected final Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private AccessControlService accessControlServiceImpl;

	@Autowired
	private UserInfoService userInfoServiceImpl;

	@Autowired
	private DeviceInfoService deviceInfoServiceImpl;

	@Autowired
	private LockOperateService lockOperateServiceImpl;

	/**
	 * 客户端请求，检查用户权限是否变化
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/checkUserLevel")
	public void checkUserLevel(HttpServletRequest request,
			HttpServletResponse response) {

		String param = Util.getParam(request);//获取客户端传来的参数

		// 账号，权限等级 判断权限是否变化
		// String param = "{\"staffNbr\":\"ligx\",\"level\":\"1\"}";

		logger.debug(param);

		JSONObject jo = JSONObject.fromObject(param);//将参数转化为JSON对象

		String staffNbr = jo.getString("staffNbr");//获取员工名字

		String level = jo.getString("level");//获取员工权限等级

		Map<String, String> user = userInfoServiceImpl
				.getUserInfoByStaffNbr(staffNbr);

		Map result = new HashMap();

		if (user == null || user.size() == 0) {

			result.put("doorCode", StaticPro.CODE_NONE_USER);

		} else {
			Calendar c = Calendar
					.getInstance(TimeZone.getTimeZone("GMT+08:00"));

			// 今天是星期几
			int week = c.get(Calendar.DAY_OF_WEEK);

			boolean flag = false;

			OperateTime obj = accessControlServiceImpl
					.getTimeRange(StaticPro.TIME_RANG_ID);

			// 判断当前时间是否在门禁时间段内
			switch (week) {
			case 1:
				flag = Util.compareNowTime(obj.getSunStartTime(),
						obj.getSunEndTime());

				break;

			case 2:
				flag = Util.compareNowTime(obj.getMonStartTime(),
						obj.getMonEndTime());

				break;

			case 3:
				flag = Util.compareNowTime(obj.getTuesStartTime(),
						obj.getTuesEndTime());

				break;

			case 4:
				flag = Util.compareNowTime(obj.getWedStartTime(),
						obj.getWedEndTime());

				break;

			case 5:
				flag = Util.compareNowTime(obj.getThurStartTime(),
						obj.getThurEndTime());

				break;

			case 6:
				flag = Util.compareNowTime(obj.getFriStartTime(),
						obj.getFriEndTime());

				break;

			case 7:
				flag = Util.compareNowTime(obj.getSatStartTime(),
						obj.getSatEndTime());

				break;

			default:
				flag = false;

			}

			if (flag) {// 在门禁时间段内

				if (level.equals(String.valueOf(user.get("DOOR_LEVEL")))) {// 权限不变
					// 权限没改变，在门禁时间段内 "2"
					result.put("doorCode", StaticPro.DOOR_CAHNGE_N_TIME);
				} else {
					// 权限改变，在门禁时间段内 "1"
					result.put("doorCode", StaticPro.DOOR_CHANGE_Y_TIME);
					List<Map<String, String>> list = accessControlServiceImpl
							.getDevLockInfo(staffNbr);
					result.put("devList", list);
					result.put("newLevel", user.get("DOOR_LEVEL"));
				}
			} else {// 不在门禁时间段内，不能开门 "0"
				result.put("doorCode", StaticPro.DOOR_CHANGE_NOTIME);

			}
		}

		JSONObject rjo = JSONObject.fromObject(result);

		Util.sendParam(response, rjo.toString()); // 传递json参数
	}

	/**
	 * 客户端,开门请求
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/openDevDoor")
	public void openDevDoor(HttpServletRequest request,
			HttpServletResponse response) {
		Map result = new HashMap();
		// TODO
		String param = Util.getParam(request);//获取客户端参数
		// 账号，设备编码
		// String param =
		// "{\"staffNbr\":\"ligx\",\"deviceNo\":\"TZ.JSH00/GJ070\"}";
		logger.debug(param);

		JSONObject jo = JSONObject.fromObject(param);//将参数转化为json对象

		// 获取设备锁的状态
		// String type =
		// lockOperateServiceImpl.getDevState(jo.getString("deviceNo"));

		// if(!type.equals(StaticPro.DOOR_OPEN)){

		LockOperateInfo operInfo = new LockOperateInfo();

		operInfo.setDeviceNo(jo.getString("deviceNo"));
		operInfo.setNote("开门操作");
		operInfo.setStaffNbr(jo.getString("staffNbr"));
		operInfo.setType(StaticPro.DOOR_OPEN);
		// 记录操作信息
		lockOperateServiceImpl.insertDevLockInfo(operInfo);

		// }
		lockOperateServiceImpl.updateDoorState(jo.getString("deviceNo"),
				StaticPro.DOOR_OPEN);//更新门锁状态

		result.put("result", "000");

		JSONObject rjo = JSONObject.fromObject(result);

		Util.sendParam(response, rjo.toString()); // 传递json参数
	}

	/**
	 * 客户端,关门请求 上传照片
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/closeDevDoor")
	public void closeDevDoor(HttpServletRequest request,
			HttpServletResponse response) {
		Map result = new HashMap();
		String param = Util.getParam(request);//获取客户端参数

		// String param =
		// "{\"staffNbr\":\"ligx\",\"rfid\":\"3000E2002076990F01532730063D9953\",\"twoDimCode\":null,\"photoFile\":\"AAAAAAAA\"}";
		// String param =
		// "{\"staffNbr\":\"ligx\",\"rfid\":\"3000E2002076990F01532730063D9953\",\"photoFile\":\"AAAAAAAA\"}";

		JSONObject jo = JSONObject.fromObject(param);//将参数转化为JSON对象

		String rfid = jo.containsKey("rfid") ? jo.getString("rfid") : null;

		String twoDimCode = jo.containsKey("twoDimCode") ? jo
				.getString("twoDimCode") : null;

		String no = jo.containsKey("deviceNo") ? jo.getString("deviceNo")
				: null;

		// 通过门锁的rfid 或 二维码 获取设备编码

		String deviceNo = lockOperateServiceImpl.getDeviceNoByRfid(no, rfid,
				twoDimCode);

		if (deviceNo == null) {
			result.put("result", "001");

			JSONObject rjo = JSONObject.fromObject(result);

			Util.sendParam(response, rjo.toString()); // 传递json参数

			return;
		}
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));

		String fileName = cal.getTimeInMillis() + ".jpg";

		File tmpf = new File(request.getSession().getServletContext()
				.getRealPath("/"));

		String folderPath = tmpf.getParentFile().getParentFile()
				.getAbsolutePath().replace("\\", "/")
				+ StaticPro.ODN_PHOTO_PATH;

		// 保存文件
		File dir = new File(folderPath);
		// 如果这个目录不存在就创建它
		if (!dir.exists()) {
			dir.mkdir();
		}

		ImageTool photo = new ImageTool(jo.getString("photoFile"));

		try {
			ImageTool.storePhoto(folderPath + "/" + fileName,
					photo.getBufferedImage());
		} catch (IOException e) {
			e.printStackTrace();
		}

		LockOperateInfo operInfo = new LockOperateInfo();

		operInfo.setDeviceNo(deviceNo);
		operInfo.setStaffNbr(jo.getString("staffNbr"));
		operInfo.setType(jo.getString("doorState"));// 1开门，2为正常关门 ，3为强制关门
		operInfo.setPhotoPath(StaticPro.ODN_PHOTO_PATH + "/" + fileName);
		if (jo.getString("doorState").equals(StaticPro.DOOR_CLOSE)) {
			operInfo.setNote("正常关门操作");
		} else if (jo.getString("doorState").equals(StaticPro.DOOR_CLOSE_Exc)) {
			operInfo.setNote("异常关门操作");
		} else {
			operInfo.setNote("非常规操作");
		}
		// 记录操作信息
		lockOperateServiceImpl.insertDevLockInfo(operInfo);
		// }
		lockOperateServiceImpl.updateDoorState(deviceNo,
				jo.getString("doorState"));

		result.put("result", "000");

		JSONObject rjo = JSONObject.fromObject(result);

		Util.sendParam(response, rjo.toString()); // 传递json参数
	}

	/**
	 * 客户端，根据设备编码，查询设备的坐标信息 LOC_CODE 1:查看设备坐标成功,2:设备不存在,3:设备存在，坐标不存在
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/getDevicePositionByDeviceNo")
	public void getDevicePositionByDeviceNo(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, String> result = new HashMap<String, String>();

		String param = Util.getParam(request);

		JSONObject jo = JSONObject.fromObject(param);

		String count = deviceInfoServiceImpl.getDeviceCount(jo
				.getString("deviceNo"));
		if (count == null) {
			result.put("LOC_CODE", StaticPro.LOC_CODE_NODEV);
		} else {
			Map<String, String> map = accessControlServiceImpl
					.getDevicePosition(jo.getString("deviceNo"));
			if (map == null || (map != null && map.size() < 1)) {
				result.put("LOC_CODE", StaticPro.LOC_CODE_NOPOS);
			} else {
				result.put("LOC_CODE", StaticPro.LOC_CODE_SUC);
				result.putAll(map);
			}
		}

		JSONObject rjo = JSONObject.fromObject(result);

		Util.sendParam(response, rjo.toString()); // 传递json参数
	}

	/**
	 * 获取门禁时间段
	 * 
	 * @param request
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping("/getOperateTime")
	public String getOperateTime(HttpServletRequest request, ModelMap model,
			HttpServletResponse response) {

		// TODO
		OperateTime obj = accessControlServiceImpl
				.getTimeRange(StaticPro.TIME_RANG_ID);

		model.put("opt", obj);

		return "door/timeRange";

	}

	/**
	 * 修改门禁时间段
	 * 
	 * @param request
	 * @param operateTime
	 * @param response
	 */
	@RequestMapping("/updateOperateTime")
	public void updateOperateTime(HttpServletRequest request,
			OperateTime operateTime, HttpServletResponse response) {

		DwzReturnObject result = null;

		try {
			accessControlServiceImpl.updateTimeRange(operateTime);
			result = new DwzReturnObject(StaticPro.STATUS_CODE_SUCCESS, "保存成功",
					null, "../accessControl/getOperateTime.do",
					StaticPro.CALLBACK_TYPE_FORWARD);
		} catch (Exception e) {
			e.printStackTrace();
			result = new DwzReturnObject(StaticPro.STATUS_CODE_FAIL, "保存失败",
					null, "../accessControl/getOperateTime.do",
					StaticPro.CALLBACK_TYPE_FORWARD);
		}
		Util.sendParam(response, JSONObject.fromObject(result).toString());

	}

	/**
	 * 门禁权限中用户信息列表
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/authorityPage")
	public String authorityPage(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		HttpSession session = request.getSession();
		Page page = new Page();
		Map<String, String> map = new HashMap<String, String>();

		if (request.getParameter("staffNbr") != null) {
			map.put("staffNbr", (String) request.getParameter("staffNbr"));

			model.put("staffNbr", (String) request.getParameter("staffNbr"));
		}

		if (request.getParameter("password") != null) {
			map.put("password", (String) request.getParameter("password"));

			model.put("password", (String) request.getParameter("password"));
		}

		if (request.getParameter("staffName") != null) {
			map.put("staffName", (String) request.getParameter("staffName"));

			model.put("staffName", (String) request.getParameter("staffName"));
		}

		if (request.getParameter("org") != null) {
			map.put("org", (String) request.getParameter("org"));
			model.put("org", (String) request.getParameter("org"));
		}

		if (request.getParameter("areaName") != null) {
			map.put("areaName", (String) request.getParameter("areaName"));
			model.put("areaName", (String) request.getParameter("areaName"));
		}

		if (request.getParameter("pageNum") != null) {
			String pageNum = (String) request.getParameter("pageNum");
			page.setCurrentPage(Integer.parseInt(pageNum));
		}

		if (request.getParameter("numPerPage") != null) {
			String showCount = (String) request.getParameter("numPerPage");
			page.setShowCount(Integer.parseInt(showCount));
		}

		Map<String, String> user = (Map<String, String>) session
				.getAttribute("userInfo");
		map.put("areaId", Util.convertStr(user.get("AREA_ID")));

		List<StaffInfo> result = userInfoServiceImpl.staffInfolistPage(map,
				page);

		String staffNbr = (String) session.getAttribute("staffNbr");

		List<Map<String, String>> list = userInfoServiceImpl
				.getAreaInfoByStaffNbr(staffNbr, null);

		model.put("area", list);
		model.addAttribute("page", page);
		model.addAttribute("result", result);

		return "door/listUsers";
	}

	/**
	 * 设备信息
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/getDeviceInfo")
	public String getDeviceInfo(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		Page page = new Page();
		Map<String, String> map = new HashMap<String, String>();

		if (request.getParameter("staffId") != null) {
			map.put("staffId", (String) request.getParameter("staffId"));
			model.put("staffId", (String) request.getParameter("staffId"));
		}
		if (request.getParameter("deviceNo") != null) {
			map.put("deviceNo", (String) request.getParameter("deviceNo"));
			model.put("deviceNo", (String) request.getParameter("deviceNo"));
		}
		if (request.getParameter("areaId") != null) {
			map.put("areaId", (String) request.getParameter("areaId"));
			model.put("areaId", (String) request.getParameter("areaId"));
		}

		if (request.getParameter("pageNum") != null) {
			String pageNum = (String) request.getParameter("pageNum");
			page.setCurrentPage(Integer.parseInt(pageNum));
		}

		if (request.getParameter("numPerPage") != null) {
			String showCount = (String) request.getParameter("numPerPage");
			page.setShowCount(Integer.parseInt(showCount));
		}

		List<String> listDev = accessControlServiceImpl
				.listDevIdsByStaffId((String) request.getParameter("staffId"));

		// HttpSession session = request.getSession();
		// Map<String,String> user=(Map<String, String>)
		// session.getAttribute("userInfo");
		// map.put("areaParId", Util.convertStr(user.get("AREA_ID")));

		List<DevicePortInfo> result = deviceInfoServiceImpl
				.getDeviceInfolistPage(map, page);

		List<Map<String, String>> list = userInfoServiceImpl
				.getAreaInfoByStaffNbr(null,
						(String) request.getParameter("staffId"));

		model.put("area", list);

		model.addAttribute("page", page);
		model.addAttribute("result", result);

		model.addAttribute("listDev", listDev);

		return "door/listDevs";
	}

	/**
	 * 保存用户的门禁权限
	 * 
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping("/saveStaffDevice")
	public void saveStaffDevice(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		String devids = (String) request.getParameter("devids");

		String staffId = (String) request.getParameter("staffId");

		String[] devId = null;
		if (devids != null) {
			devId = devids.split(",");
		}

		DwzReturnObject result = null;
		try {

			accessControlServiceImpl.updateDevStaffInfo(staffId, devId);

			result = new DwzReturnObject(StaticPro.STATUS_CODE_SUCCESS, null,
					"panel_" + StaticPro.LEFT_TREEID_DOOR,
					"../accessControl/authorityPage.do",
					StaticPro.CALLBACK_TYPE_CLOSE);
		} catch (Exception e) {
			e.printStackTrace();
			result = new DwzReturnObject(StaticPro.STATUS_CODE_FAIL, null,
					"panel_" + StaticPro.LEFT_TREEID_DOOR,
					"../accessControl/authorityPage.do",
					StaticPro.CALLBACK_TYPE_CLOSE);
		}
		Util.sendParam(response, JSONObject.fromObject(result).toString());//传递json参数

	}

	/**
	 * 设备坐标展示
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/devicePositionMap")
	public String devicePositionMap(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		Map<String, String> map = new HashMap<String, String>();

		if (request.getParameter("deviceNo") != null) {
			map.put("deviceNo", (String) request.getParameter("deviceNo"));
			model.put("deviceNo", (String) request.getParameter("deviceNo"));
		}

		Page page = new Page();

		if (request.getParameter("pageNum") != null
				&& request.getParameter("pageNum") != "") {
			String pageNum = (String) request.getParameter("pageNum");
			page.setCurrentPage(Integer.parseInt(pageNum));
		}
		if (request.getParameter("numPerPage") != null
				&& request.getParameter("numPerPage") != "") {
			String showCount = (String) request.getParameter("numPerPage");
			page.setShowCount(Integer.parseInt(showCount));
		} else {
			page.setShowCount(50);
		}
		// HttpSession session = request.getSession();
		// Map<String,String> user=(Map<String, String>)
		// session.getAttribute("userInfo");
		// map.put("areaId", Util.convertStr(user.get("AREA_ID")));

		List<DeviceMapInfo> list = accessControlServiceImpl
				.getDevicePositionlistPage(map, page);//分页查看设备信息

		List<DeviceMapInfo> deviceMaps = accessControlServiceImpl
				.getDevicePositionList(map);//不分页查看设备信息

		List<DeviceMapInfo> a = new ArrayList<DeviceMapInfo>();

		Map<String, String> map1 = new HashMap<String, String>();

		// 经度纬度都增加0.72秒=0.0002度
		double lonum = 0.0002;
		double lanum = 0.0002;

		for (DeviceMapInfo info : deviceMaps) {

			if (null != info.getLatitude() && null != info.getLongitude()) {

				String lo = info.getLongitude();
				String la = info.getLatitude();

				// 当多设备在同一个坐标，为了不重叠一起，经纬度做相应改变
				if (null != map1.get(la) && map1.get(la).equals(lo)) {

					info.setLongitude(String.valueOf(Util.add(
							Double.parseDouble(lo), lonum)));
					info.setLatitude(String.valueOf(Util.add(
							Double.parseDouble(la), lanum)));

					lonum = lonum + 0.0002;
					lanum = lanum + 0.0002;
				} else {
					
					info.setLatitude(la);
					info.setLongitude(lo);
				}
				
				map1.put(la, lo);
			}
			a.add(info);
		}
		
		model.put("maps", JSONArray.fromObject(a).toString());

		model.addAttribute("page", page);
		model.addAttribute("DeviceMap", list);

		return "door/deviceMap";
	}

}
