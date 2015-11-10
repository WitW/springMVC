package com.zbiti.mvc.android.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zbiti.common.model.table.Page;
import com.zbiti.mvc.android.dao.LockOperateDao;
import com.zbiti.mvc.android.mapper.LockOperateMapper;
import com.zbiti.mvc.android.model.LockOperateInfo;

@Repository
public class LockOperateDaoImpl implements LockOperateDao {

	@Autowired
	private LockOperateMapper lockOperateMapper;

	public List<LockOperateInfo> getDevOpterateInfolistPage(
			Map<String, String> map, Page page) {

		return lockOperateMapper.getDevOpterateInfolistPage(map, page);
	}

	public void insertDevLockInfo(LockOperateInfo operInfo) {

		lockOperateMapper.insertDevLockInfo(operInfo);
	}

	public String getDevState(String deviceNo) {

		return lockOperateMapper.getDevState(deviceNo);
	}

	public void saveLockRfidTwocode(Map<String, String> map) {

		lockOperateMapper.saveLockRfidTwocode(map);
	}

	public List<Map<String, String>> getDevIdByCode(String deviceNo) {
		return lockOperateMapper.getDevIdByCode(deviceNo);
	}

	public void updateDoorState(String deviceNo, String state) {
		
		lockOperateMapper.updateDoorState(deviceNo, state);
		
	}

	public void saveDevLockMan(Map<String, String> map) {
		
		lockOperateMapper.saveDevLockMan(map);
	}

	public String getDplIdByPhyEqpId(String phyEqpId) {
		
		return lockOperateMapper.getDplIdByPhyEqpId(phyEqpId);
	}



	public List<Map<String, String>> getDevLockInfo(String rfid,
			String twoDimCode,String deviceId) {
		
		return lockOperateMapper.getDevLockInfo(rfid, twoDimCode, deviceId);
	}

	public List<Map<String, String>> getCountByRfidAndCode(String deviceNo,
			String rfid, String twoDimCode) {
		
		return lockOperateMapper.getCountByRfidAndCode(deviceNo, rfid, twoDimCode);
	}

	public String getDeviceNoByRfid(String deviceNo, String rfid,
			String twoDimCode) {
		
		return lockOperateMapper.getDeviceNoByRfid(deviceNo, rfid, twoDimCode);
	}

	public List<Map<String, String>> getOperationInfo(Map<String, String> map) {
		
		return lockOperateMapper.getOperationInfo(map);
	}

}
