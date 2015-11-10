package com.zbiti.mvc.android.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zbiti.mvc.android.model.BatchBandObject;
import com.zbiti.mvc.android.model.DevicePortInfo;
import com.zbiti.mvc.android.model.PortRfidInfo;
import com.zbiti.mvc.android.model.SelectOtherReturnObject;
import com.zbiti.mvc.android.model.ShelfObject;
import com.zbiti.mvc.android.model.WorkOrderInfo;
import com.zbiti.mvc.android.model.WorkOrderSaveInfo;
import com.zbiti.mvc.android.model.WorkOrderSaveInfoList;
import com.zbiti.mvc.android.service.DeviceInfoService;
import com.zbiti.mvc.android.service.WorkOrderService;
import com.zbiti.util.StaticPro;
import com.zbiti.util.Util;

@Controller
@RequestMapping("/device")
@SuppressWarnings("all")
public class DeviceInfoAction {

	protected final Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private DeviceInfoService deviceInfoServiceImpl;
	
	@Autowired
	private WorkOrderService workOrderInfoServiceImpl;
	
	
	/**
	 * 保存插头对应关系
	 * @param request
	 * @param response
	 */
	@RequestMapping("/savePortList")
	public void saveDeviceFiberRfIdListInfo(HttpServletRequest request,
			HttpServletResponse response) {
		String param = Util.getParam(request);//获取客户端传来的JSON格式的参数
		logger.debug(param);
//		String param = "{\"ports\":[{\"notes\":\"测试1\",\"phy_port_opr\":\"绑定\",\"staffId\":\"zhao\",\"old_fiber_rf_id\":\"\",\"old_port_rf_id\":\"\",\"new_fiber_rf_id\":\"132029422312\",\"area\":\"21\",\"device_id\":\"128795039774\",\"new_port_rf_id\":\"\",\"phy_port_id\":\"1209785734664\"},{\"notes\":\"测试2\",\"phy_port_opr\":\"绑定\",\"staffId\":\"zhao\",\"old_fiber_rf_id\":\"\",\"old_port_rf_id\":\"\",\"new_fiber_rf_id\":\"132029423123\",\"area\":\"21\",\"device_id\":\"128795032245\",\"new_port_rf_id\":\"\",\"phy_port_id\":\"120978572366\"},{\"notes\":\"测试3\",\"phy_port_opr\":\"绑定\",\"staffId\":\"zhao\",\"old_fiber_rf_id\":\"\",\"old_port_rf_id\":\"\",\"new_fiber_rf_id\":\"132029422231\",\"area\":\"21\",\"device_id\":\"128795034123\",\"new_port_rf_id\":\"\",\"phy_port_id\":\"120978575342\"}],\"staffId\":\"zhao\",\"orderId\":\"192200000041193030\",\"event\":\"新装\",\"area\":\"21\"}";
	//	String param = "{\"area\":\"70\",\"event\":\"拆机\",\"orderId\":\"192200000041193030\",\"ports\":[{\"area\":\"70\",\"device_id\":\"19800000307661\",\"phy_port_id\":\"19800001551011\",\"phy_port_opr\":\"解绑\",\"staffId\":\"zhang\"},{\"area\":\"70\",\"device_id\":\"19320000000229\",\"phy_port_id\":\"19300000414075\",\"phy_port_opr\":\"解绑\",\"staffId\":\"zhang\"}],\"staffId\":\"zhang\"}";
		
//		String param = "{\"staffId\":\"tang\",\"area\":\"21\",\"workOrderSaveInfo\":[{ \"ports\":[{\"notes\":\"测试1\",\"phy_port_opr\":\"绑定\",\"staffId\":\"zhao\",\"old_fiber_rf_id\":\"\",\"old_port_rf_id\":\"\",\"new_fiber_rf_id\":\"132029422312\",\"area\":\"21\",\"device_id\":\"128795039774\",\"new_port_rf_id\":\"\",\"phy_port_id\":\"1209785734664\"},{\"notes\":\"测试2\",\"phy_port_opr\":\"绑定\",\"staffId\":\"zhao\",\"old_fiber_rf_id\":\"\",\"old_port_rf_id\":\"\",\"new_fiber_rf_id\":\"132029423123\",\"area\":\"21\",\"device_id\":\"128795032245\",\"new_port_rf_id\":\"\",\"phy_port_id\":\"120978572366\"},{\"notes\":\"测试3\",\"phy_port_opr\":\"绑定\",\"staffId\":\"zhao\",\"old_fiber_rf_id\":\"\",\"old_port_rf_id\":\"\",\"new_fiber_rf_id\":\"132029422231\",\"area\":\"21\",\"device_id\":\"128795034123\",\"new_port_rf_id\":\"\",\"phy_port_id\":\"120978575342\"}],\"staffId\":\"zhao\",\"orderId\":\"192200000041193030\",\"event\":\"新装\",\"area\":\"21\"}]}";
		
		JSONObject jo = JSONObject.fromObject(param);//将参数转化为JSON
		WorkOrderSaveInfoList workOrderSaveInfoList = (WorkOrderSaveInfoList) jo.toBean(jo,WorkOrderSaveInfoList.class);//将JSON转化为对象
		Map result = new HashMap();
		
		try {
			// 保存端口光纤接头的对应关系
			deviceInfoServiceImpl.saveDeviceFiberRfIdList(workOrderSaveInfoList);
			
			List<WorkOrderSaveInfo>workOrderSaveInfo = workOrderSaveInfoList.getWorkOrderSaveInfo();//获取工单列表
			
			workOrderInfoServiceImpl.updateWorkOrderList(workOrderSaveInfo);//更新工单状态
			
			result.put("resultCode", StaticPro.CODE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().isRollbackOnly();//回滚操作
			result.put("resultCode", StaticPro.CODE_SAVE_FAIL);
		}
		Util.sendParam(response, JSONObject.fromObject(result).toString());//将响应传给客户端
		
	}
	
	
	
	
	

	/**
	 * 保存插头对应关系
	 * @param request
	 * @param response
	 */
	@RequestMapping("/savePort")
	public void saveDeviceFiberRfId(HttpServletRequest request,
			HttpServletResponse response) {
		String param = Util.getParam(request);//接收客户端传来的JSON格式的参数
		logger.debug(param);
	//	String param = "{\"ports\":[{\"notes\":\"测试1\",\"phy_port_opr\":\"绑定\",\"staffId\":\"zhao\",\"old_fiber_rf_id\":\"\",\"old_port_rf_id\":\"\",\"new_fiber_rf_id\":\"132029422312\",\"area\":\"21\",\"device_id\":\"128795039774\",\"new_port_rf_id\":\"\",\"phy_port_id\":\"1209785734664\"},{\"notes\":\"测试2\",\"phy_port_opr\":\"绑定\",\"staffId\":\"zhao\",\"old_fiber_rf_id\":\"\",\"old_port_rf_id\":\"\",\"new_fiber_rf_id\":\"132029423123\",\"area\":\"21\",\"device_id\":\"128795032245\",\"new_port_rf_id\":\"\",\"phy_port_id\":\"120978572366\"},{\"notes\":\"测试3\",\"phy_port_opr\":\"绑定\",\"staffId\":\"zhao\",\"old_fiber_rf_id\":\"\",\"old_port_rf_id\":\"\",\"new_fiber_rf_id\":\"132029422231\",\"area\":\"21\",\"device_id\":\"128795034123\",\"new_port_rf_id\":\"\",\"phy_port_id\":\"120978575342\"}],\"staffId\":\"zhao\",\"orderId\":\"192200000041193030\",\"event\":\"新装\",\"area\":\"21\"}";
	//	String param = "{\"area\":\"70\",\"event\":\"拆机\",\"orderId\":\"192200000041193030\",\"ports\":[{\"area\":\"70\",\"device_id\":\"19800000307661\",\"phy_port_id\":\"19800001551011\",\"phy_port_opr\":\"解绑\",\"staffId\":\"zhang\"},{\"area\":\"70\",\"device_id\":\"19320000000229\",\"phy_port_id\":\"19300000414075\",\"phy_port_opr\":\"解绑\",\"staffId\":\"zhang\"}],\"staffId\":\"zhang\"}";
		JSONObject jo = JSONObject.fromObject(param);//将参数转化为JSON

		Map classMap = new HashMap();
		classMap.put("ports", PortRfidInfo.class);
		//将JSON转化为对象
		WorkOrderSaveInfo ports = (WorkOrderSaveInfo) JSONObject.toBean(jo,
				WorkOrderSaveInfo.class, classMap);
		Map result = new HashMap();
		
		try {
			// 保存端口光纤接头的对应关系
			deviceInfoServiceImpl.saveDeviceFiberRfId(ports);
			//更新工单状态
			workOrderInfoServiceImpl.updateWorkOrder(ports.getOrderId(),ports.getStaffId());
			result.put("resultCode", StaticPro.CODE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("resultCode", StaticPro.CODE_SAVE_FAIL);
		}
		Util.sendParam(response, JSONObject.fromObject(result).toString());//将响应传给客户端
		
	}
	
	/**
	 * 光纤插头查对端
	 * @param request
	 * @param response
	 */
	@RequestMapping("/selectOtherPort")
	public void selectOtherPort(HttpServletRequest request,
			HttpServletResponse response){
		String param = Util.getParam(request);//从客户端获取JSON格式的参数
		logger.debug(param);
		//String param ="{\"staffId\":\"testligx\";\"area\":\"23\",\"fiberRfid\":\"3000E2002076990F01231000B1243836\"}";

		JSONObject jo = JSONObject.fromObject(param);//将参数转化为JSON
		
		String fiberRfid = jo.getString("fiberRfid");
		//获取本端端口信息
		SelectOtherReturnObject ro = new SelectOtherReturnObject();
		//光纤一头获取本段端口信息
		DevicePortInfo curDp = deviceInfoServiceImpl.getPortInfoByFiberRfId(fiberRfid);
		ro.setCurPort(curDp);
		
		System.out.println(".***.."+JSONObject.fromObject(ro).toString());
		//当本端端口存在时
		if(curDp!=null){
			//本端端口ID 获取对端端口ID
			String otherPortId = deviceInfoServiceImpl.getOtherPortByPortId(curDp.getPortId());
			if(otherPortId!=null&&!"".equals(otherPortId)){
				DevicePortInfo curDp2 = deviceInfoServiceImpl.getPortInfoByFiberPortId(otherPortId);
				ro.setOtherPort(curDp2);
				//光路信息
				Map gl_info = deviceInfoServiceImpl.getGlInfoByPorts(otherPortId,curDp.getPortId());
				ro.setGl_no(Util.convertStr(gl_info.get("GL_NO")));
				ro.setAddress(Util.convertStr(gl_info.get("ADDRESS")));
				ro.setLnk_state(Util.convertStr(gl_info.get("LNK_STATE")));
			}
		}
		System.out.println("..."+JSONObject.fromObject(ro).toString());
		Util.sendParam(response, JSONObject.fromObject(ro).toString());//给将响应传给客户端
	}
	
	/**
	 * 巡检
	 * @param request
	 * @param response
	 */
	@RequestMapping("/selectAllPortsByDeviceNo")
	public void selectAllPortsByDeviceNo(HttpServletRequest request,
			HttpServletResponse response){

		String param = Util.getParam(request);//从客户端接受JSON格式的参数

//		String param ="{\"staffId\":\"10000\",\"area\":\"21\",\"deviceNo\":\"JT.WYJ/GJ001\",\"deviceRfid\":\"\"}";
		logger.debug(param);
		
		JSONObject jo = JSONObject.fromObject(param);//将参数转化为JSON对象

		String deviceNo = jo.getString("deviceNo");
		String deviceRfid = jo.getString("deviceRfid");
		//根据设备编号和设备RFID 获取设备下所有端口信息
		ShelfObject result = deviceInfoServiceImpl.getPortsInfoByDeviceNo(deviceNo,deviceRfid);//查询端口信息
		Util.sendParam(response, JSONObject.fromObject(result).toString());//传递JSON参数
	}
	
	/**
	 * 批量绑定
	 * @param request
	 * @param response
	 */
	@RequestMapping("/batchBand")
	public void batchBand(HttpServletRequest request,
			HttpServletResponse response){
		String param = Util.getParam(request);//接受客户端传来的JSON格式的参数
		logger.debug(param);
		//String param ="{\"area\":\"70\",\"deviceRfid\":\"3000E2002076990F01532730063D9953\",\"deviceId\":\"13320000002228\",\"obj\":\"端口\",\"opr\":\"绑定\",\"relas\":{},\"relasS\":{},\"staffId\":\"ligx\"}";
		
		//param = "{\"area\":\"70\",\"deviceId\":\"19800000417068\",\"deviceRfid\":\"\",\"latitude\":\"31.98618\",\"longitude\":\"118.749628\",\"obj\":\"插头\",\"opr\":\"绑定\",\"relas\":{\"19800002187157\":\"3000E2002076990F011324301BEF8DF7\"},\"staffId\":\"cz\"}";
		//解析绑定的对象
		JSONObject jo = JSONObject.fromObject(param);//将参数转化为JSON
		HashMap m = new HashMap();
		m.put("relas", HashMap.class);
		m.put("relasS", HashMap.class);
		BatchBandObject bbo = (BatchBandObject) jo.toBean(jo, BatchBandObject.class,m);//将JSON转化为对象

		Map result = new HashMap();
		try {
			// 保存数据
			deviceInfoServiceImpl.batchBand(bbo);
			
			result.put("resultCode", StaticPro.CODE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("resultCode", StaticPro.CODE_SAVE_FAIL);
		}
		Util.sendParam(response, JSONObject.fromObject(result).toString());//传递JSON参数给客户端
	}
	
	/**
	 * 保存巡检结果
	 * @param request
	 * @param response
	 */
	@RequestMapping("/saveCheckResult")
	public void deviceCheckResult(HttpServletRequest request,
			HttpServletResponse response){
		String param = Util.getParam(request);//接受客户端传来的JSON格式的参数
		logger.debug(param);
		//String param ="{\"relas\":{\"19003123432122\":\"abc123asdjafjaoijf1232222\",\"19003123432124\":\"abc123asdjafjaoijf1234444\",\"19003123432120\":\"abc123asdjafjaoijf1230000\",\"19003123432123\":\"abc123asdjafjaoijf1233333\",\"19003123432121\":\"abc123asdjafjaoijf1231111\"},\"obj\":\"端口\",\"opr\":\"巡检\",\"staffId\":\"zhao\",\"area\":\"70\"}";

		JSONObject jo = JSONObject.fromObject(param);//将参数转化为JSON对象
		HashMap m = new HashMap();
		m.put("relas", HashMap.class);
		BatchBandObject bbo = (BatchBandObject) jo.toBean(jo, BatchBandObject.class,m);//将JSON对象转化为对象

		Map result = new HashMap();
		try {
			// 保存数据
			deviceInfoServiceImpl.saveCheckResult(bbo);
			result.put("resultCode", StaticPro.CODE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("resultCode", StaticPro.CODE_SAVE_FAIL);
		}
		Util.sendParam(response, JSONObject.fromObject(result).toString());//传递JSON参数
	}
	
	/**
	 * 根据端口Rfid查设备和模块信息
	 * @param request
	 * @param response
	 */
//	@RequestMapping("/selectAllPortsByDeviceNo")
//	public void getDevsSlotInfoByPortRfid(HttpServletRequest request,
//			HttpServletResponse response){
////		String param = Util.getParam(request);
////		logger.debug(param);
//		
//		String param ="{\"staffId\":\"10000\",\"area\":\"21\",\"deviceNo\":\"JT.WYJ/GJ001\",\"deviceRfid\":\"\"}";
//		
//		JSONObject jo = JSONObject.fromObject(param);
//
//		String portRfid = jo.getString("deviceRfid");
//		
//		ShelfObject result = deviceInfoServiceImpl.getDevsSlotInfoByPortRfid(portRfid);
//		Util.sendParam(response, JSONObject.fromObject(result).toString());
//	}
	
}
