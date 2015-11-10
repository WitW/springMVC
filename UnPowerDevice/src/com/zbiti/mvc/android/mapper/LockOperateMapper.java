package com.zbiti.mvc.android.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zbiti.common.model.table.Page;
import com.zbiti.mvc.android.model.LockOperateInfo;

public interface LockOperateMapper {

	/**
	 * 新增用户操作信息
	 * 
	 * @param operInfo
	 */
	public void insertDevLockInfo(LockOperateInfo operInfo);

	/**
	 * 查询用户操作信息
	 * 
	 * @return
	 */
	public List<LockOperateInfo> getDevOpterateInfolistPage(
			@Param("map") Map<String, String> map, @Param("page") Page page);

	/**
	 * 查询设备的状态，是否开门
	 * 
	 * @param deviceNo
	 * @return
	 */
	public String getDevState(@Param("deviceNo") String deviceNo);

	/**
	 * 新增或更新设备对应的开门的RFID或二维码
	 * 
	 * @param map
	 */
	public void saveLockRfidTwocode(Map<String, String> map);

	/**
	 * 根据设备Code查询设备Id
	 */
	public List<Map<String, String>> getDevIdByCode(@Param("deviceNo")String deviceNo);
	
	/**
	 * 修改门的状态
	 * @param deviceNo
	 * @param state 1开门，2关门，3异常关门
	 */
	public void updateDoorState(@Param("deviceNo")String deviceNo,@Param("state")String state);
	
	/**
	 * 保存用户设备锁信息，不存在新增，存在不处理
	 * @param map
	 */
	public void saveDevLockMan(Map<String,String> map);
	
	/**
	 * 根据设备ID获取,查询设备锁具表ID
	 * @param phyEqpId
	 * @return
	 */
	public String getDplIdByPhyEqpId(@Param("phyEqpId")String phyEqpId);
	
	/**
	 * 根据Rfid或者二维码获取设备编码
	 * @param rfid
	 * @param twoDimCode
	 * @return
	 */
	//public String getDeviceNoByRfid(@Param("rfid")String rfid,@Param("twoDimCode")String twoDimCode);
	public String getDeviceNoByRfid(@Param("deviceNo")String deviceNo,@Param("rfid")String rfid,@Param("twoDimCode")String twoDimCode);
	
	/**
	 * 通过二维码或rfid查设备锁信息
	 * @param rfid
	 * @param twoDimCode
	 * @return
	 */
	public List<Map<String, String>> getDevLockInfo(@Param("rfid")String rfid,@Param("twoDimCode")String twoDimCode,@Param("deviceId")String deviceId);
	
	public List<Map<String, String>> getCountByRfidAndCode(@Param("deviceNo")String deviceNo,@Param("rfid")String rfid,@Param("twoDimCode")String twoDimCode);
	
	public  List<Map<String, String>> getOperationInfo(Map<String,String> map);
}
