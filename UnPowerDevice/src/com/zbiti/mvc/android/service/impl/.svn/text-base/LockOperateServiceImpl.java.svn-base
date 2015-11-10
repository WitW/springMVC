package com.zbiti.mvc.android.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbiti.common.model.table.Page;
import com.zbiti.mvc.android.dao.LockOperateDao;
import com.zbiti.mvc.android.model.LockOperateInfo;
import com.zbiti.mvc.android.service.LockOperateService;

/**
 * 
 * @author dlt
 * 
 */
@Service
public class LockOperateServiceImpl implements LockOperateService {

	@Autowired
	private LockOperateDao lockOperateDaoImpl;

	public List<LockOperateInfo> getDevOpterateInfolistPage(
			Map<String, String> map, Page page) {

		return lockOperateDaoImpl.getDevOpterateInfolistPage(map, page);
	}

	public void insertDevLockInfo(LockOperateInfo operInfo) {

		lockOperateDaoImpl.insertDevLockInfo(operInfo);
	}

	public String getDevState(String deviceNo) {

		return lockOperateDaoImpl.getDevState(deviceNo);
	}

	/**
	 * 保存开关门设备对应的RFID、二维码
	 */
	public void saveLockRfidTwocode(Map<String, String> map) {
		lockOperateDaoImpl.saveLockRfidTwocode(map);
	}

	public List<Map<String, String>> getDevIdByCode(String deviceNo) {
		return lockOperateDaoImpl.getDevIdByCode(deviceNo);
	}

	public void updateDoorState(String deviceNo, String state) {
		
		lockOperateDaoImpl.updateDoorState(deviceNo, state);
	}


	public List<Map<String, String>> getDevLockInfo(String rfid,
			String twoDimCode,String deviceId) {
		
		return lockOperateDaoImpl.getDevLockInfo(rfid, twoDimCode, deviceId);
	}

	public List<Map<String, String>> getCountByRfidAndCode(String deviceNo,
			String rfid, String twoDimCode) {
		
		return lockOperateDaoImpl.getCountByRfidAndCode(deviceNo, rfid, twoDimCode);
	}

	public String getDeviceNoByRfid(String deviceNo, String rfid,
			String twoDimCode) {
		
		return lockOperateDaoImpl.getDeviceNoByRfid(deviceNo, rfid, twoDimCode);
	}

	public List<Map<String, String>> getOperationInfo(Map<String, String> map) {
		
		return lockOperateDaoImpl.getOperationInfo(map);
	}

}
