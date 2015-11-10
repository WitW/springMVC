package com.zbiti.mvc.android.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbiti.common.model.table.Page;
import com.zbiti.mvc.android.dao.AccessControlDao;
import com.zbiti.mvc.android.mapper.AccessControlMapper;
import com.zbiti.mvc.android.model.DeviceMapInfo;
import com.zbiti.mvc.android.model.OperateTime;

@Service
public class AccessControlDaoImpl implements AccessControlDao {
	
	@Autowired
	private AccessControlMapper accessControlMapper;

	public OperateTime getTimeRange(String opTimeId) {
		
		return accessControlMapper.getTimeRange(opTimeId);
	}

	public List<Map<String, String>> listTimeRange() {
		
		return accessControlMapper.listTimeRange();
	}

	public void updateTimeRange(OperateTime operateTime) {
		
		accessControlMapper.updateTimeRange(operateTime);
	}

	public void insertDevsStaff(String staffId, String devId) {
		
		accessControlMapper.insertDevsStaff(staffId, devId);
	}

	public void deleteDevsStaff(String staffId) {
		
		accessControlMapper.deleteDevsStaff(staffId);
	}

	public List<String> listDevIdsByStaffId(String staffId) {
		
		return accessControlMapper.listDevIdsByStaffId(staffId);
	}

	public List<Map<String, String>> getDevLockInfo(String staffNbr) {
		
		return accessControlMapper.getDevLockInfo(staffNbr);
	}

	public Map<String,String> getDevicePosition(String deviceNo) {
		
		return accessControlMapper.getDevicePosition(deviceNo);
	}

	public List<DeviceMapInfo> getDevicePositionlistPage(
			Map<String, String> map, Page page) {
		
		return accessControlMapper.getDevicePositionlistPage(map, page);
	}

	public List<String> getDplidByDevNos(List<String> devNos) {
		
		return accessControlMapper.getDplidByDevNos(devNos);
	}

	public void saveStaffAccess(String staffNbr, String dplid) {
		
		accessControlMapper.saveStaffAccess(staffNbr, dplid);
	}

	public List<Map<String, String>> getStaffDevInfo(String staffNbr,
			List<String> dplids) {
		
		return accessControlMapper.getStaffDevInfo(staffNbr, dplids);
	}

	public void deleteDevsByStaffNbr(String staffNbr, String dplid) {
		
		accessControlMapper.deleteDevsByStaffNbr(staffNbr, dplid);
	}

	public void updateDevStaffType(String staffNbr, String dplid) {
		
		accessControlMapper.updateDevStaffType(staffNbr, dplid);
	}

	public String getTopPhyIdByNo(String deviceNo) {
		
		return accessControlMapper.getTopPhyIdByNo(deviceNo);
	}

	public List<DeviceMapInfo> getDevicePositionList(Map<String, String> map) {
		
		return accessControlMapper.getDevicePositionList(map);
	}

}
