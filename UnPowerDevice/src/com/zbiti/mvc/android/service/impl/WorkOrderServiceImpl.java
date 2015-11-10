package com.zbiti.mvc.android.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zbiti.common.model.table.Page;
import com.zbiti.mvc.android.dao.AccessControlDao;
import com.zbiti.mvc.android.dao.DevicePortDao;
import com.zbiti.mvc.android.dao.LockOperateDao;
import com.zbiti.mvc.android.dao.WorkOrderDao;
import com.zbiti.mvc.android.model.DevicePortInfo;
import com.zbiti.mvc.android.model.WorkOrderInfo;
import com.zbiti.mvc.android.model.WorkOrderSaveInfo;
import com.zbiti.mvc.android.service.DeviceInfoService;
import com.zbiti.mvc.android.service.WorkOrderService;
import com.zbiti.util.StaticPro;
import com.zbiti.util.Util;

/**
 * 工单处理业务实现类
 * @author dlt
 *
 */
@Service(value="workOrderInfoServiceImpl")
public class WorkOrderServiceImpl implements WorkOrderService{
	@Autowired
	@Qualifier("DevicePortDao")
	private DevicePortDao devicePortDaoImpl;

	@Autowired
	@Qualifier("WorkOrderDao")
	private WorkOrderDao workOrderDaoImpl;

	@Autowired
	private DeviceInfoService deviceInfoServiceImpl;
	
	@Autowired
	private AccessControlDao  accessControlDaoImpl;
	
	
	@Autowired
	private LockOperateDao lockOperateDaoImpl;
	
	@SuppressWarnings("all")
	public List<WorkOrderInfo> getWorkOrderListByStaffID(String staffId) {
		List<WorkOrderInfo> result = workOrderDaoImpl.getWorkOrderListByStaffID(staffId);
		//处理资源文本中的资源信息
		for(WorkOrderInfo wi :result){
			System.out.println("........."+wi.getNewRes());
//			String old_res = wi.getOldRes();
//			wi.setOldDeviceInfos(convertRes(old_res));
//			String new_res = wi.getNewRes();
//			wi.setNewDeviceInfos(convertRes(new_res));
//			System.out.println("时间。。。。。。。。。。"+wi.getCompleteTime());
			
			//设备和端口编码  格式：512SZ.GJSYE/GJ094:25|DT-POS-017111:90003
			String devPortNo = wi.getDevPortNo();
			wi.setNewDeviceInfos(this.convertDevPortNo(devPortNo));
			
		}
		return result;
	}
	
	/**
	 * 将资源文本转换成对象列表
	 * @param resStr
	 * @return
	 */
//	private List<DevicePortInfo> convertRes(String resStr){
//		List<DevicePortInfo> dpis = new ArrayList<DevicePortInfo>();
//		if(resStr==null||"".equals(resStr)){
//			return null;
//		}
//		String ress [] = resStr.split("\n");		//设备端口信息
//		for (String s : ress){
//			DevicePortInfo dpi = new DevicePortInfo();
//			String []portList = s.split(" ");
//			
//			//第一个参数设备类型和设备编码 格式：【程控交换机】6252-工业园局园区北基站 
//			String device_str = portList[0];
//			String deviceNO =device_str.split("】")[1];
//			
//			//第二个参数设备名称：[工业园局*工业园局_AXE-10-工业园局园区北基站]
//			String device_name_str = portList[1];
//			if(device_name_str!=null&&!"".equals(device_name_str)){
//				dpi.setDeviceName(device_name_str.substring(1, device_name_str.length()-2));
//			}
//			
//			//第三个参数
//			
//			//第四个参数
//			
//			//第五个参数端口编码：格式『语音端子』LI3-0037235
//			String port_no_str = portList[4];
//			String portNo="";
//			if(port_no_str!=null&&!"".equals(port_no_str)){
//				portNo = port_no_str.split("』")[1];
//			}
//			dpi = devicePortDaoImpl.getPortInfoByDeviceNoAndPortNo(deviceNO,portNo); 
//			if(dpi!=null){
//				dpis.add(dpi);
//			}
//		}
//		return dpis;
//	}
	
	/**
	 * 根据设备和端口编码获取 设备和端口对象列表
	 * @param resStr
	 * @return
	 */
	private List<DevicePortInfo> convertDevPortNo(String resStr){
		
		List<DevicePortInfo> dpis = new ArrayList<DevicePortInfo>();
		if(resStr==null||"".equals(resStr)){
			return null;
		}
		try{
			String ress [] = resStr.split("\\|");		//设备端口信息
			for (String str : ress){
				if(str.equals("")){
					 continue;
				}
				DevicePortInfo dpi = new DevicePortInfo();
				//设备编码
				String deviceNO = str.split(":")[0];
				//端口编码
				String portNo = str.split(":")[1];
				dpi = devicePortDaoImpl.getPortInfoByDeviceNoAndPortNo(deviceNO,portNo); 
				//增加设备坐标
				List<Map<String, String>> list = deviceInfoServiceImpl.getDevPosition(deviceNO);
				if(list!=null&&list.size()>0){
					Map<String, String> hp = list.get(0);
					String longitude = hp.get("LONGITUDE");
					String latitude = hp.get("LATITUDE");
					dpi.setLongitude(longitude);
					dpi.setLatitude(latitude);
				}
				if(dpi!=null){
					dpis.add(dpi);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return dpis;
	}

	@Transactional(rollbackFor = Exception.class)
	public void updateWorkOrder(String orderId,String staffId) {
		
		workOrderDaoImpl.updateWorkOrder(orderId);//更新工单状态
		
		this.changeStaffAccess(staffId, orderId);//获取门禁权限
	}

	public void saveWorkOrder(WorkOrderInfo wo) {
		workOrderDaoImpl.saveWorkOrder(wo);
		
		//以下是给用户开锁权限，设备锁信息存在直接赋权，不存在新增设备锁信息然后赋权限
		String devPortNo = wo.getDevPortNo();
		
		String[] nos = devPortNo.split("\\|");
		//List<String> devNos = new ArrayList<String>();
		for(String tmp : nos){

			String phyId = accessControlDaoImpl.getTopPhyIdByNo(tmp.split(":")[0]);
			
			if(phyId != null){
				Map<String,String> map = new HashMap<String,String>();
				
				map.put("deviceId", phyId);
//				map.put("rfid", lockCode.getLockRfid());
//				map.put("twoDimCode", lockCode.getLockTwoCode());
				map.put("staffNbr",wo.getStaffNbr());
				
				//设备锁信息 不存在则新增，存在不处理
				lockOperateDaoImpl.saveDevLockMan(map);
				
				String dplId = lockOperateDaoImpl.getDplIdByPhyEqpId(phyId);
				
				accessControlDaoImpl.saveStaffAccess(wo.getStaffNbr(), dplId);
			}
		}
	}

	public WorkOrderInfo getWorkOrderId(String orderId) {
		
		return workOrderDaoImpl.getWorkOrderId(orderId);
	}
	
	/**
	 * 改变用户门禁权限
	 * @param staffNbr
	 * @param orderId
	 */
	private void changeStaffAccess(String staffNbr,String orderId) {
		
		List<String> dplids = new ArrayList<String>();
		
		List<WorkOrderInfo> orders = workOrderDaoImpl.getWorkOrderListByStaffID(staffNbr);
		
		for(int i = 0;i < orders.size(); i++){
			String devNos = orders.get(i).getDevPortNo();
			if(devNos != null){
				String[] tmp = devNos.split("\\|");
				for(String devNo : tmp){
					dplids.add(devNo.split(":")[0]);
				}
			}
		}
		
		if(dplids ==null || dplids.size()<1){
			WorkOrderInfo info = workOrderDaoImpl.getWorkOrderId(orderId);
			 String tmp = info.getDevPortNo();
			 List<String> devNos = new ArrayList<String>();
			 for(String no : tmp.split("\\|")){
				 devNos.add(no.split(":")[0]);
			 }
			List<String> listIds = accessControlDaoImpl.getDplidByDevNos(devNos);
			for(String dplid : listIds){
				accessControlDaoImpl.deleteDevsByStaffNbr(staffNbr, dplid);
			}
		}else{
			List<String> listDpl =  accessControlDaoImpl.getDplidByDevNos(dplids);
			
			if(listDpl != null && listDpl.size() > 0){
				List<Map<String,String>> list = accessControlDaoImpl.getStaffDevInfo(staffNbr, listDpl);
				for(Map<String,String> map : list){
					if(Util.convertStr(map.get("TYPE")).equals(StaticPro.DEV_TYPE_ORDER)){
						accessControlDaoImpl.deleteDevsByStaffNbr(staffNbr, Util.convertStr(map.get("DPL_ID")));
					}else if(Util.convertStr(map.get("TYPE")).equals(StaticPro.DEV_TYPE_BOTH)){
						//权限类型为3 的改为1
						accessControlDaoImpl.updateDevStaffType(staffNbr, Util.convertStr(map.get("DPL_ID")));
					}
				}
			}
		}
		
	}

	public List<WorkOrderInfo> getWorkOrderInfolistPage(
			Map<String, String> map, Page page) {
		
		return workOrderDaoImpl.getWorkOrderInfolistPage(map, page);
	}

	@Transactional(rollbackFor = Exception.class)
	public void updateWorkOrderList(List<WorkOrderSaveInfo> workOrderSaveInfo) {
		
		JSONArray jsonArray = JSONArray.fromObject(workOrderSaveInfo);
		for(int i = 0;i < jsonArray.size();i++){
			
			JSONObject json = JSONObject.fromObject(jsonArray.get(i));
			String staffId = (String) json.get("staffId");
			String orderId = (String) json.get("orderId");
//			if(i == 1){
//				workOrderDaoImpl.updateWorkOrderList(orderId);
//			}else{
//			updateWorkOrder(orderId,staffId);}
			
//			if(i == 1){
//				int a=4/0;
//			}else{
			updateWorkOrder(orderId,staffId);//更新工单状态
//			}
			
			
		}
	}

}
