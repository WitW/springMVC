package com.zbiti.mvc.android.dao.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zbiti.common.model.table.Page;
import com.zbiti.mvc.android.dao.DevicePortDao;
import com.zbiti.mvc.android.mapper.DevicePortMapper;
import com.zbiti.mvc.android.model.DevicePortInfo;
import com.zbiti.mvc.android.model.PortRfidInfo;

@Repository("DevicePortDao")
public class DevicePortDaoImpl implements DevicePortDao {
	@Autowired
	private DevicePortMapper devicePortMapper;

	public DevicePortInfo getPortInfoByDeviceNoAndPortNo(String deviceNo, String portNo) {
		return devicePortMapper.getPortInfoByDeviceNoAndPortNo(deviceNo, portNo);
	}

	public DevicePortInfo getPortRfIdByPortId(String portId) {
		return devicePortMapper.getPortRfIdByPortId(portId);
	}


	public DevicePortInfo getPortLocationByPortId(String portId) {
		return devicePortMapper.getPortLocationByPortId(portId);
	}

	public void saveFiberRfId(PortRfidInfo ports) throws Exception {
		try{
			devicePortMapper.saveFiberRfId(ports);
		}catch(Exception e){
			throw new Exception("插入失败:"+e.getMessage());
		}
	}

	public void saveRfIdLog(String staffId, String orderId, String orderEvent,
			PortRfidInfo ri) throws Exception{
		try{
			Map<String,String> param = new HashMap<String,String>();
			param.put("staffId", staffId);
			param.put("orderId", orderId);
			param.put("orderEvent", orderEvent);
			param.put("device_id", ri.getDevice_id());
			param.put("phy_port_id", ri.getPhy_port_id());
			param.put("phy_port_opr", ri.getPhy_port_opr());
			param.put("new_fiber_rf_id", ri.getNew_fiber_rf_id());
			param.put("old_fiber_rf_id", ri.getOld_fiber_rf_id());
			devicePortMapper.saveRfIdLog(param);
		}catch(Exception e){
			throw new Exception("插入失败:"+e.getMessage());
		}
	}

//	public List checkLockRfid(String staffId, String rfId) {
//		return devicePortMapper.checkLockRfid(staffId,rfId);
//	}
//
//	public void saveLockLog(String staffId, String rfId, String opr) {
//		devicePortMapper.saveLockLog(staffId,rfId,opr);
//	}

	public LinkedList<Map> getPortsInfoByDeviceNo(String deviceNo,String deviceRfid) {
		return devicePortMapper.getPortsInfoByDeviceNo(deviceNo,deviceRfid);
	}

	public DevicePortInfo getPortInfoByFiberRfId(String fiberRfid) {
		if(devicePortMapper.getPortInfoByFiberRfId(fiberRfid)!=null&&devicePortMapper.getPortInfoByFiberRfId(fiberRfid).size()>0){
			return devicePortMapper.getPortInfoByFiberRfId(fiberRfid).get(0);
		}else{
			return null;
		}
	}

	public String getOtherPortByPortId(String portId) {
		return devicePortMapper.getOtherPortByPortId(portId);
	}

	public DevicePortInfo getPortInfoByFiberPortId(String portId) {
		return devicePortMapper.getPortInfoByFiberPortId(portId);
	}

	public Map getGlInfoByPorts(String otherPortId, String portId) {
		return devicePortMapper.getGlInfoByPorts(otherPortId,portId);
	}

	public void savePortRfId(PortRfidInfo ri) throws Exception {
		try{
			devicePortMapper.savePortRfId(ri);
		}catch(Exception e){
			throw new Exception("插入失败:"+e.getMessage());
		}
	}

	public void deletePortRfId(PortRfidInfo ri) throws Exception {
		try{
			devicePortMapper.deletePortRfId(ri);
		}catch(Exception e){
			throw new Exception("删除失败:"+e.getMessage());
		}
	}

	public void deleteFiberRfId(PortRfidInfo ri) throws Exception {
		try{
			devicePortMapper.deleteFiberRfId(ri);
		}catch(Exception e){
			throw new Exception("删除失败:"+e.getMessage());
		}
	}

	public void saveCheckResult(PortRfidInfo ri) throws Exception {
		try{
			devicePortMapper.saveCheckResult(ri);
		}catch(Exception e){
			throw new Exception("保存失败:"+e.getMessage());
		}
	}

	public void saveSlotRfid(Map<String, String> map) throws Exception {
		try{
			devicePortMapper.saveSlotRfid(map);
		}catch(Exception e){
			throw new Exception("插入失败:"+e.getMessage());
		}
		
	}

	public void saveMaplog(Map<String, String> logs) throws Exception {
		try{
			devicePortMapper.saveRfIdLog(logs);
		}catch(Exception e){
			throw new Exception("插入失败:"+e.getMessage());
		}
	}

	public void deleteSlotRfid(Map<String, String> map) throws Exception {
		try{
			devicePortMapper.deleteSlotRfid(map);
		}catch(Exception e){
			throw new Exception("删除失败:"+e.getMessage());
		}
		
	}

	public String getDevsPortCount(String deviceNo, String portNo) {
		
		return devicePortMapper.getDevsPortCount(deviceNo, portNo);
	}

	public List<Map<String, String>> listDevsInfoByArea(String staffId) {
		
		return devicePortMapper.listDevsInfoByArea(staffId);
	}

	public List<DevicePortInfo> getDeviceInfolistPage(Map<String, String> map,
			Page page) {
		
		return devicePortMapper.getDeviceInfolistPage(map, page);
	}

	public List<Map<String, String>> getDevPosition(String deviceNo) {
		
		return devicePortMapper.getDevPosition(deviceNo);
	}

	public void insertDevPosition(Map<String, String> map) {
		
		devicePortMapper.saveDevPosition(map);
	}

	public String getDeviceCount(String deviceNo) {
		
		return devicePortMapper.getDeviceCount(deviceNo);
	}

}
