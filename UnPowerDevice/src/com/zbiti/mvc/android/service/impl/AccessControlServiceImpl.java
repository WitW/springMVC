package com.zbiti.mvc.android.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zbiti.common.model.table.Page;
import com.zbiti.mvc.android.dao.AccessControlDao;
import com.zbiti.mvc.android.dao.UserInfoDao;
import com.zbiti.mvc.android.dao.WorkOrderDao;
import com.zbiti.mvc.android.model.DeviceMapInfo;
import com.zbiti.mvc.android.model.OperateTime;
import com.zbiti.mvc.android.model.WorkOrderInfo;
import com.zbiti.mvc.android.service.AccessControlService;
import com.zbiti.util.StaticPro;

@Service
public class AccessControlServiceImpl implements AccessControlService{

	@Autowired
	private AccessControlDao  accessControlDaoImpl;
	
	@Autowired
	private UserInfoDao userInfoDaoImpl ;
	
	
	@Autowired
	@Qualifier("WorkOrderDao")
	private WorkOrderDao workOrderDaoImpl;
	
	public OperateTime getTimeRange(String opTimeId) {
		
		return accessControlDaoImpl.getTimeRange(opTimeId);
	}

	public List<Map<String, String>> listTimeRange() {
		
		return accessControlDaoImpl.listTimeRange();
	}

	public void updateTimeRange(OperateTime operateTime) {
		
		accessControlDaoImpl.updateTimeRange(operateTime);
	}

	public void insertDevsStaff(String staffId, String devId) {
		
		accessControlDaoImpl.insertDevsStaff(staffId, devId);
	}

	public void deleteDevsStaff(String staffId) {
		
		accessControlDaoImpl.deleteDevsStaff(staffId);
	}

	public List<String> listDevIdsByStaffId(String staffId) {
		
		return accessControlDaoImpl.listDevIdsByStaffId(staffId);
	}

	public void updateDevStaffInfo(String staffId, String[] devId) {
		
		accessControlDaoImpl.deleteDevsStaff(staffId);
		
		if(devId != null){
			for(String id : devId){
				accessControlDaoImpl.insertDevsStaff(staffId, id);
			}
		}

		//修改权限级别
		userInfoDaoImpl.updateStaffDoorLevel(staffId);
	}

	public List<Map<String, String>> getDevLockInfo(String staffNbr) {
		
		return accessControlDaoImpl.getDevLockInfo(staffNbr);
	}

	public Map<String,String> getDevicePosition(String deviceNo) {
		
		return accessControlDaoImpl.getDevicePosition(deviceNo);
	}

	public List<DeviceMapInfo> getDevicePositionlistPage(
			Map<String, String> map, Page page) {
		
		return accessControlDaoImpl.getDevicePositionlistPage(map, page);
	}

	public List<String> getDplidByDevNos(List<String> devNos) {
		
		return accessControlDaoImpl.getDplidByDevNos(devNos);
	}

	public void saveStaffAccess(String staffNbr, String dplid) {
		
		accessControlDaoImpl.saveStaffAccess(staffNbr, dplid);
	}

	public List<Map<String, String>> getStaffDevInfo(String staffNbr,
			List<String> dplids) {
	
		return accessControlDaoImpl.getStaffDevInfo(staffNbr, dplids);
	}

	public void deleteDevsByStaffNbr(String staffNbr, String dplid) {
		
		accessControlDaoImpl.deleteDevsByStaffNbr(staffNbr, dplid);
	}

	public void updateDevStaffType(String staffNbr, String dplid) {
		
		accessControlDaoImpl.updateDevStaffType(staffNbr, dplid);
	}

	public void changeStaffAccess(String staffNbr,String orderId) {
		
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
			List<Map<String,String>> list = accessControlDaoImpl.getStaffDevInfo(staffNbr, dplids);
			for(Map<String,String> map : list){
				if(map.get("DPL_ID").equals(StaticPro.DEV_TYPE_ORDER)){
					accessControlDaoImpl.deleteDevsByStaffNbr(staffNbr, map.get("DPL_ID"));
				}else if(map.get("DPL_ID").equals(StaticPro.DEV_TYPE_BOTH)){
					//权限类型为3 的改为1
					accessControlDaoImpl.updateDevStaffType(staffNbr, map.get("DPL_ID"));
				}
			}
		}
		
	}

	public String getTopPhyIdByNo(String deviceNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DeviceMapInfo> getDevicePositionList(Map<String, String> map) {
		
		return accessControlDaoImpl.getDevicePositionList(map);
	}

}
