package com.zbiti.mvc.android.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zbiti.common.model.table.Page;
import com.zbiti.mvc.android.model.BatchBandObject;
import com.zbiti.mvc.android.model.LockOperateInfo;
import com.zbiti.mvc.android.model.LockRfidTwoCode;
import com.zbiti.mvc.android.model.StaffInfo;
import com.zbiti.mvc.android.service.DeviceInfoService;
import com.zbiti.mvc.android.service.LockOperateService;
import com.zbiti.util.StaticPro;
import com.zbiti.util.Util;

@Controller
@SuppressWarnings("all")
@RequestMapping("LockOperate")
public class LockOperateAction {

	protected final Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private LockOperateService lockOperateServiceImpl;
	
	@Autowired
	private DeviceInfoService deviceInfoServiceImpl;

	/**
	 * 分页查询操作信息，开关门日志
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/listOperationPage")
	public String listOperationPage(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		// 设置参数
		Map<String, String> map = new HashMap<String, String>();

		 if(request.getParameter("staffNbr") != null){
			 map.put("staffNbr", (String)request.getParameter("staffNbr"));
			 model.put("staffNbr", (String)request.getParameter("staffNbr"));
		 }
		 
		 if(request.getParameter("staffName") != null){
			 map.put("staffName", (String)request.getParameter("staffName"));
			 model.put("staffName", (String)request.getParameter("staffName"));
		 }
		 
		 if(request.getParameter("deviceNo") != null){
			 map.put("deviceNo", (String)request.getParameter("deviceNo"));
			 model.put("deviceNo", (String)request.getParameter("deviceNo"));
		 }
		 if(request.getParameter("deviceName") != null){
			 map.put("deviceName", (String)request.getParameter("deviceName"));
			 model.put("deviceName", (String)request.getParameter("deviceName"));
		 }

		Page page = new Page();
		if (request.getParameter("pageNum") != null) {
			String pageNum = (String) request.getParameter("pageNum");
			page.setCurrentPage(Integer.parseInt(pageNum));
		}

		if (request.getParameter("numPerPage") != null) {
			String showCount = (String) request.getParameter("numPerPage");
			page.setShowCount(Integer.parseInt(showCount));
		}
		
//		 HttpSession session = request.getSession();
//		 Map<String,String> user=(Map<String, String>) session.getAttribute("userInfo");
//		 map.put("areaId", Util.convertStr(user.get("AREA_ID")));

		List<LockOperateInfo> result = lockOperateServiceImpl
				.getDevOpterateInfolistPage(map, page);

		model.addAttribute("page", page);
		model.addAttribute("result", result);

		return "door/listOperations";
	}

	/**
	 * 读取照片
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/getPhoto")
	public String getPhoto(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		String photoPath = request.getParameter("photoPath");
		System.out.println(photoPath);
		model.put("photoPath", photoPath);
		return "door/showPhoto";
	}

	/**
	 * 客户端，保存锁的RFID以及二维码
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("/saveLockRfidTwoCode")
	public void saveLockRfidTwocode(HttpServletRequest request,
			HttpServletResponse response) {
		String param = Util.getParam(request);
		//param = "{\"area\":\"74\",\"deviceNo\":\"512SZ.JMJMJ/GJ124\",\"latitude\":\"31.986373\",\"lockRfid\":\"3000E2002076990F015319004E6A7C88\",\"lockTwoCode\":\"欢迎访问太平洋IT百科栏目66！\",\"longitude\":\"118.750058\",\"staffId\":\"wang\"}";
		logger.debug(param);
		JSONObject jo = JSONObject.fromObject(param);

		Map result = new HashMap();
		try {
			
			LockRfidTwoCode lockCode = (LockRfidTwoCode) JSONObject.toBean(jo,
					LockRfidTwoCode.class);
			
			// 根据deviceCode查询deviceId
			List<Map<String, String>> deviceIdList = lockOperateServiceImpl
					.getDevIdByCode(lockCode.getDeviceNo());
			
			// 根据设备编码查询到设备Id时
			if (deviceIdList != null && deviceIdList.size() != 0
					&& !String.valueOf(deviceIdList.get(0).get("PHY_EQP_ID")).equals("")) {
				//不是强制更新
				if(!lockCode.isForceUpdate()){
					//通过二维码或rfid查设备锁信息
					List<Map<String, String>> lock = lockOperateServiceImpl.getDevLockInfo(lockCode.getDeviceNo(),null, null);
					if(lock != null && lock.size()>0){
						result.put("resultCode", "001");//参数错误
						Util.sendParam(response, JSONObject.fromObject(result).toString());
						return;
					}
				}
				//通过二维码或rfid查设备锁信息
				List<Map<String, String>> lockInfo  = lockOperateServiceImpl.getCountByRfidAndCode(lockCode.getDeviceNo(),lockCode.getLockRfid(),lockCode.getLockTwoCode());
				
				if(lockInfo != null && lockInfo.size()>1){//rfid和二维码都重复
					result.put("resultCode", StaticPro.ALL_DOUBLE);
					
					Util.sendParam(response, JSONObject.fromObject(result).toString());
					return;
				}else if(lockInfo != null && lockInfo.size() == 1){//rfid重复
					if(lockInfo.get(0).get("LOCK_RFID").equals(jo.getString("lockRfid"))){
						
							result.put("resultCode", StaticPro.RFID_DOUBLE);
							Util.sendParam(response, JSONObject.fromObject(result).toString());
							return;
						
					}else{		//二维码重复
						
							result.put("resultCode", StaticPro.CODE_DOUBLE);
							Util.sendParam(response, JSONObject.fromObject(result).toString());
							return;
						
					}
				}
				// 保存二维码、RFID数据
				HashMap hp = new HashMap<String, String>();
				hp.put("deviceId", deviceIdList.get(0).get("PHY_EQP_ID"));
				hp.put("rfid", lockCode.getLockRfid());
				hp.put("twoDimCode", lockCode.getLockTwoCode());
				hp.put("staffNbr", lockCode.getStaffId());
				
				//新增或更新设备对应的开门的RFID或二维码
				lockOperateServiceImpl.saveLockRfidTwocode(hp);
				
				//保存设备坐标信息
				if(lockCode.getLongitude()!=null&&lockCode.getLatitude()!=null&&!lockCode.getLongitude().equals("")&&!lockCode.getLatitude().equals("")){
					HashMap hmp = new HashMap();
					hmp.put("deviceId", deviceIdList.get(0).get("PHY_EQP_ID"));
					hmp.put("longitude", lockCode.getLongitude());
					hmp.put("latitude", lockCode.getLatitude());
					hmp.put("staffNbr", lockCode.getStaffId());
					//新增设备经度和纬度信息
					deviceInfoServiceImpl.insertDevPosition(hmp);
				}
				
				result.put("resultCode", StaticPro.CODE_SUCCESS);
			} else {// 未查到设备Id时
				result.put("resultCode", StaticPro.CODE_FOUND_NO_DEVICE);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("resultCode", StaticPro.CODE_SAVE_FAIL);
		}
		Util.sendParam(response, JSONObject.fromObject(result).toString());

	}
}
