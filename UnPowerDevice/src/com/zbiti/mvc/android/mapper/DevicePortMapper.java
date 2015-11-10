package com.zbiti.mvc.android.mapper;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zbiti.common.model.table.Page;
import com.zbiti.mvc.android.model.DevicePortInfo;
import com.zbiti.mvc.android.model.PortRfidInfo;

public interface DevicePortMapper {
	/**
	 * 根据端口编码和设备编码获取端口的资源
	 * @param deviceNo
	 * @param portNo
	 * @return
	 */
	public DevicePortInfo getPortInfoByDeviceNoAndPortNo(@Param("deviceNo")String deviceNo,@Param("portNo")String portNo);
	
	/**
	 * 根据端口ID获取端口位置
	 * @param portId
	 * @return
	 */
	public DevicePortInfo getPortLocationByPortId(@Param("portId")String portId);
	
	/**
	 * 根据端口ID获取端口的RFID
	 * @param portId
	 * @return
	 */
	public DevicePortInfo getPortRfIdByPortId(@Param("portId")String portId);

	/**
	 * 保存Rfid对应关系
	 * @param ports
	 */
	public void saveFiberRfId(PortRfidInfo ports);
	
	/**
	 * 保存端口Rfid
	 * @param ports
	 */
	public void savePortRfId(PortRfidInfo ports);

	/**
	 * 保存日志
	 * @param param
	 */
	public void saveRfIdLog(Map param);

//	/**
//	 * 验证开锁的关门的RFID
//	 * @param staffId
//	 * @param rfId
//	 * @return
//	 */
//	public List checkLockRfid(@Param("staffId")String staffId, @Param("rfId")String rfId);
//
//	/**
//	 * 保存开/关锁日志
//	 * @param staffId
//	 * @param rfId
//	 * @param opr
//	 */
//	public void saveLockLog(@Param("staffId")String staffId, @Param("rfId")String rfId, @Param("opr")String opr);
//	
	
	/**
	 * 获取设备下所有端口信息
	 * @param deviceNo
	 * @return
	 */
	public LinkedList<Map> getPortsInfoByDeviceNo(@Param("deviceNo")String deviceNo,@Param("deviceRfid")String deviceRfid);

	/**
	 * 插头RFID获取端口信息
	 * @param fiberRfid
	 * @return
	 */
	public List<DevicePortInfo> getPortInfoByFiberRfId(@Param("fiberRfid")String fiberRfid);

	/**
	 * 本端获取对端
	 * @param portId
	 * @return
	 */
	public String getOtherPortByPortId(@Param("portId")String portId);

	/**
	 * 端口ID获取端口信息
	 * @param fiberRfid
	 * @return
	 */
	public DevicePortInfo getPortInfoByFiberPortId(@Param("portId")String portId);

	/**
	 * 2端端口查光路
	 * @param otherPortId
	 * @param portId
	 * @return
	 */
	public Map getGlInfoByPorts(@Param("otherPortId")String otherPortId, @Param("portId")String portId);

	/**
	 * 端口解绑
	 * @param ri
	 */
	public void deletePortRfId(PortRfidInfo ri);
	
	/**
	 * 接头解绑
	 * @param ri
	 */
	public void deleteFiberRfId(PortRfidInfo ri);

	/**
	 * 保存巡检结果
	 * @param ri
	 */
	public void saveCheckResult(PortRfidInfo ri);
	
	/**
	 * 绑定模块信息
	 * @param map
	 */
	public void saveSlotRfid(Map<String,String> map);
	
	/**
	 * 解绑模块信息
	 * @param map
	 * @throws Exception
	 */
	public void deleteSlotRfid(Map<String,String> map);
	
	
	/**
	 * 验证设备编码和端口信息是否存在
	 * @param deviceNo
	 * @param portNo
	 * @return
	 */
	public String getDevsPortCount(@Param("deviceNo")String deviceNo,@Param("portNo")String portNo);
	
	/**
	 * 根据区域查询光交柜
	 * @param areaId
	 * @return
	 */
	public List<Map<String,String>> listDevsInfoByArea(@Param("staffId")String staffId);
	
	/**
	 * 
	 * @param map
	 * @return
	 */
	public List<DevicePortInfo> getDeviceInfolistPage(@Param("map")Map<String,String> map,@Param("page")Page page);
	
	/**
	 * 获取设备的位置，经度和纬度
	 * @param deviceNO
	 * @return
	 */
	public List<Map<String,String>> getDevPosition(@Param("deviceNo")String deviceNo);
	
	/**
	 * 新增设备经度和纬度信息
	 * @param map
	 */
	public void saveDevPosition(Map<String,String> map);
	
	/**
	 * 根据设备编码，查看设备是否存在
	 * @param deviceNo
	 * @return
	 */
	public String getDeviceCount(@Param("deviceNo")String deviceNo);
	
}
