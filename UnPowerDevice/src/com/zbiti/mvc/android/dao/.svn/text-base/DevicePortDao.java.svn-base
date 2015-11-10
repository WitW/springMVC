package com.zbiti.mvc.android.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.zbiti.common.model.table.Page;
import com.zbiti.mvc.android.model.DevicePortInfo;
import com.zbiti.mvc.android.model.PortRfidInfo;


public interface DevicePortDao {
	
	/**
	 * 根据端口编码和设备编码获取设备端口的资源信息
	 * @param deviceNo
	 * @param portNo
	 * @return
	 */
	public DevicePortInfo getPortInfoByDeviceNoAndPortNo(String deviceNo,String portNo);
	
	/**
	 * 根据端口ID获取端口位置
	 * @param portId
	 * @return
	 */
	public DevicePortInfo getPortLocationByPortId(String portId);
	
	/**
	 * 根据端口ID获取端口的RFID
	 * @param portId
	 * @return
	 */
	public DevicePortInfo getPortRfIdByPortId(String portId);

	/**
	 * 保存RfId
	 * @param ports
	 * @throws Exception 
	 */
	public void saveFiberRfId(PortRfidInfo portRf) throws Exception;

	/**
	 * 保存绑定操作日志
	 * @param staffId
	 * @param orderId
	 * @param orderEvent
	 * @param ri
	 * @throws Exception 
	 */
	public void saveRfIdLog(String staffId, String orderId, String orderEvent,
			PortRfidInfo ri) throws Exception;

//	/**
//	 * 根据工号和箱体上的Rfid 检查该工号是否有权限打开
//	 * @param staffId
//	 * @param rfId
//	 * @return
//	 */
//	public List checkLockRfid(String staffId, String rfId);
//
//	/**
//	 * 保存开/关锁日志
//	 * @param staffId
//	 * @param rfId
//	 * @param opr
//	 */
//	public void saveLockLog(String staffId, String rfId, String opr);
	
	/**
	 * 获取设备下所有端口信息
	 * @param deviceNo
	 * @return
	 */
	public LinkedList<Map> getPortsInfoByDeviceNo(String deviceNo,String deviceRfid);

	/**
	 * Rfid获取本端端口信息
	 * @param fiberRfid
	 * @return
	 */
	public DevicePortInfo getPortInfoByFiberRfId(String fiberRfid);

	/**
	 * 本端获取对端端口ID
	 * @param portId
	 * @return
	 */
	public String getOtherPortByPortId(String portId);

	/**
	 * 端口ID获取本端端口信息
	 * @param fiberRfid
	 * @return
	 */
	public DevicePortInfo getPortInfoByFiberPortId(String portId);

	/**
	 * 根据2端端口查光路
	 * @param otherPortId
	 * @param portId
	 * @return
	 */
	public Map getGlInfoByPorts(String otherPortId, String portId);

	/**
	 * 保存
	 * @param ri
	 * @throws Exception 
	 */
	public void savePortRfId(PortRfidInfo ri) throws Exception;

	/**
	 * Rfid解绑
	 * @param ri
	 * @throws Exception 
	 */
	public void deletePortRfId(PortRfidInfo ri) throws Exception;

	/**
	 * 插头解绑
	 * @param ri
	 * @throws Exception 
	 */
	public void deleteFiberRfId(PortRfidInfo ri) throws Exception;

	/**
	 * 巡检结果保存
	 * @param ri
	 */
	public void saveCheckResult(PortRfidInfo ri) throws Exception;
	
	/**
	 * 绑定模块信息
	 * @param map
	 * @throws Exception
	 */
	public void saveSlotRfid(Map<String,String> map) throws Exception;
	
	/**
	 * 保存模块日志
	 * @param logs
	 * @throws Exception
	 */
	public void saveMaplog(Map<String,String> logs) throws Exception;
	
	/**
	 * 解绑模块信息
	 * @param map
	 * @throws Exception
	 */
	public void deleteSlotRfid(Map<String,String> map) throws Exception;
	
	/**
	 * 验证设备编码和端口信息是否存在
	 * @param deviceNo
	 * @param portNo
	 * @return
	 */
	public String getDevsPortCount(String deviceNo,String portNo);
	
	/**
	 * 根据区域查询光交柜
	 * @param areaId
	 * @return
	 */
	public List<Map<String,String>> listDevsInfoByArea(String staffId);
	
	
	/**
	 * 
	 * @param map
	 * @return
	 */
	public List<DevicePortInfo> getDeviceInfolistPage(Map<String,String> map,Page page);
	
	/**
	 * 获取设备的位置，经度和纬度
	 * @param deviceNO
	 * @return
	 */
	public List<Map<String,String>> getDevPosition(String deviceNO);
	
	/**
	 * 新增设备经度和纬度信息
	 * @param map
	 */
	public void insertDevPosition(Map<String,String> map);
	
	/**
	 * 根据设备编码，查看设备是否存在
	 * @param deviceNo
	 * @return
	 */
	public String getDeviceCount(String deviceNo);
	
}
