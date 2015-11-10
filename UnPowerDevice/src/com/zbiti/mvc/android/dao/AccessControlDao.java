package com.zbiti.mvc.android.dao;

import java.util.List;
import java.util.Map;

import com.zbiti.common.model.table.Page;
import com.zbiti.mvc.android.model.DeviceMapInfo;
import com.zbiti.mvc.android.model.OperateTime;

/**
 * 门禁权限 dao 接口
 * @author dlt
 *
 */
public interface AccessControlDao {

	
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
	public OperateTime getTimeRange(String opTimeId);
	
	/**
	 * 修改时间段信息
	 * @param map  参数
	 */
	public void updateTimeRange(OperateTime operateTime);
	
	
	/**
	 * 新增用户和设备锁具的对应关系
	 * @param staffId 用户ID
	 * @param dplId	 设备锁具表ID
	 */
	public void insertDevsStaff(String staffId,String devId);
	
	/**
	 * 删除用户和锁具设备的对应关系
	 * @param staffId
	 */
	public void deleteDevsStaff(String staffId);
	
	/**
	 * 列出用户具有的设备锁具权限
	 * @param staffId
	 * @return
	 */
	public List<String> listDevIdsByStaffId(String staffId);
	
	/**
	 * 查询用户的权限信息
	 * @param staffId
	 * @return
	 */
	public List<Map<String,String>> getDevLockInfo(String staffNbr);
	
	/**
	 * 查询设备的坐标信息
	 * @return
	 */
	public  Map<String,String> getDevicePosition(String deviceNo);
	
	/**
	 * 分页查询设备坐标信息
	 * @param map
	 * @param page
	 * @return
	 */
	public List<DeviceMapInfo> getDevicePositionlistPage(Map<String,String> map,Page page);
	
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
	public void saveStaffAccess(String staffNbr,String dplid);
	
	/**
	 * 查找 不在 dplids 中的用户门禁权限
	 * @param staffNbr
	 * @param dplids
	 * @return
	 */
	public List<Map<String,String>> getStaffDevInfo(String staffNbr,List<String> dplids);
	
	/**
	 * 删除用户 对应 某个 设备的权限
	 * @param staffNbr
	 * @param dplid
	 */
	public void deleteDevsByStaffNbr(String staffNbr,String dplid);
	
	/**
	 * 修改用户对应某个设备的权限
	 * @param staffNbr
	 * @param dplid
	 */
	public void updateDevStaffType(String staffNbr,String dplid);
	
	/**
	 * 根据设备编码查 光交ID
	 * @param deviceNo
	 * @return
	 */
	public String getTopPhyIdByNo(String deviceNo);
	
	/**
	 * 查询设备坐标信息
	 * @param map
	 * @param page
	 * @return
	 */
	public List<DeviceMapInfo> getDevicePositionList(Map<String,String> map);
	
}
