package com.zbiti.mvc.android.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zbiti.common.model.table.Page;
import com.zbiti.mvc.android.model.DeviceMapInfo;
import com.zbiti.mvc.android.model.OperateTime;

public interface AccessControlMapper {

	/**
	 *  查询时间段信息
	 * @return  List
	 */
	public List<Map<String,String>> listTimeRange();
	
	/**
	 * 通过ID查询门禁时间段信息
	 * @param opTimeId
	 * @return
	 */
	public OperateTime getTimeRange(@Param("opTimeId")String opTimeId);
	
	/**
	 * 修改时间段信息
	 * @param map  参数
	 */
	public void updateTimeRange(OperateTime operateTime);
	
	/**
	 * 新增用户和设备锁具的对应关系
	 * @param staffId 用户ID
	 * @param dplId	 设备ID
	 */
	public void insertDevsStaff(@Param("staffId")String staffId,@Param("deviceId")String deviceId);
	
	/**
	 * 删除用户和锁具设备的对应关系
	 * @param staffId
	 */
	public void deleteDevsStaff(@Param("staffId")String staffId);
	
	/**
	 * 列出用户具有的设备锁具权限
	 * @param staffId
	 * @return
	 */
	public List<String> listDevIdsByStaffId(@Param("staffId")String staffId);
	
	/**
	 * 查询用户的权限信息
	 * @param staffId
	 * @return
	 */
	public List<Map<String,String>> getDevLockInfo(@Param("staffNbr")String staffNbr);
	
	/**
	 * 查询设备的坐标信息
	 * @return
	 */
	public   Map<String,String> getDevicePosition(@Param("deviceNo")String deviceNo);
	
	/**
	 * 分页查询设备坐标信息
	 * @param map
	 * @param page
	 * @return
	 */
	public List<DeviceMapInfo> getDevicePositionlistPage(@Param("map")Map<String,String> map,@Param("page")Page page);
	
	
	/**
	 * 根据设备编码获取设备锁具表ID
	 * @param devNos
	 * @return
	 */
	public List<String> getDplidByDevNos(List<String> devNos);
	
	/**
	 * 保存用户 门禁权限
	 * @param staffNbr
	 * @param dplid
	 */
	public void saveStaffAccess(@Param("staffNbr")String staffNbr,@Param("dplid")String dplid);
	
	/**
	 * 查找 不在 dplids 中的用户门禁权限
	 * @param staffNbr
	 * @param dplids
	 * @return
	 */
	public List<Map<String,String>> getStaffDevInfo(@Param("staffNbr")String staffNbr,@Param("dplids")List<String> dplids);
	
	
	/**
	 * 删除用户 对应 某个 设备的权限
	 * @param staffNbr
	 * @param dplid
	 */
	public void deleteDevsByStaffNbr(@Param("staffNbr")String staffNbr,@Param("dplid")String dplid);
	
	/**
	 * 修改用户对应某个设备的权限
	 * @param staffNbr
	 * @param dplid
	 */
	public void updateDevStaffType(@Param("staffNbr")String staffNbr,@Param("dplid")String dplid);
	
	/**
	 * 根据设备编码查 光交ID
	 * @param deviceNo
	 * @return
	 */
	public String getTopPhyIdByNo(@Param("deviceNo")String deviceNo);
	
	/**
	 * 查询设备坐标信息
	 * @param map
	 * @param page
	 * @return
	 */
	public List<DeviceMapInfo> getDevicePositionList(@Param("map")Map<String,String> map);
	
}
