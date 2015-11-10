package com.zbiti.mvc.android.service;

import java.util.List;
import java.util.Map;

import com.zbiti.common.model.table.Page;
import com.zbiti.mvc.android.model.BatchBandObject;
import com.zbiti.mvc.android.model.DevicePortInfo;
import com.zbiti.mvc.android.model.ShelfObject;
import com.zbiti.mvc.android.model.WorkOrderSaveInfo;
import com.zbiti.mvc.android.model.WorkOrderSaveInfoList;

public interface DeviceInfoService {
	/**
	 * 根据端口编码和设备编码获取端口的ID
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
	public String getPortLocationByPortId(String portId);
	
	/**
	 * 根据端口ID获取端口RFID
	 * @param portId
	 * @return
	 */
	public String getPortRfIdByPortId(String portId);

	
	/**
	 * 保存端口光纤接头的对应关系
	 * @param ports
	 * @return
	 * @throws Exception 
	 */
	public void saveDeviceFiberRfId(WorkOrderSaveInfo ports) throws Exception;
	
	/**
	 * @param workOrderSaveInfoList
	 * @return
	 * @throws Exception 
	 */
	public void saveDeviceFiberRfIdList(WorkOrderSaveInfoList workOrderSaveInfoList) throws Exception;
	
	

//	/**
//	 * 校验开锁的RFID
//	 * @param staffId
//	 * @param rfId
//	 * @return
//	 */
//	public boolean checkLockRfid(String staffId, String rfId);
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
	public ShelfObject getPortsInfoByDeviceNo(String deviceNo,String deviceRfid);

	/**
	 * 光纤一头获取本段端口信息
	 * @param fiberRfid
	 * @return
	 */
	public DevicePortInfo getPortInfoByFiberRfId(String fiberRfid);

	/**
	 * 本端获取对端端口
	 * @param portId
	 * @return
	 */
	public String getOtherPortByPortId(String portId);

	/**
	 * 端口找端口信息
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
	 * 批量绑定
	 * @param bbo
	 * @throws Exception 
	 */
	public void batchBand(BatchBandObject bbo) throws Exception;

	/**
	 * 保存巡检结果
	 * @param bbo
	 * @throws Exception 
	 */
	public void saveCheckResult(BatchBandObject bbo) throws Exception;
	
	
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
	 * 设备信息
	 * @param map
	 * @return
	 */
	public List<DevicePortInfo> getDeviceInfolistPage(Map<String,String> map,Page page);
	
	/**
	 * 获取设备的位置，经度和纬度
	 * @param deviceNO
	 * @return
	 */
	public List<Map<String,String>> getDevPosition(String deviceNo);
	
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
