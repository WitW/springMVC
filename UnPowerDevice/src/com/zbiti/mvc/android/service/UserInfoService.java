package com.zbiti.mvc.android.service;

import java.util.List;
import java.util.Map;

import com.zbiti.common.model.table.Page;
import com.zbiti.mvc.android.model.StaffInfo;

public interface UserInfoService {
	
	/**
	 * 验证账号密码
	 * @param userName
	 * @return
	 */
	public Map getUserInfoByStaffNbr(String userName);

	/**
	 * 修改密码
	 * @param userName
	 * @param passWord
	 * @param newpassWord
	 */
	public void updatePassword(String userName, String passWord,
			String newpassWord);

	/**
	 * 保存用户试用反馈
	 * @param staffId
	 * @param content
	 */
	public void saveAdvice(String staffId, String content);
	
	/**
	 * 分页查询用户信息
	 * @param map
	 * @param page
	 * @return
	 */
	public List<StaffInfo> staffInfolistPage(Map<String,String> map,Page page);
	
	/**
	 * 根据用户ID查询，用户角色关系表，列出roleId
	 * @param staffId
	 * @return
	 */
	public List<String> getStaffRoleInfo(String staffId);
	
	/**
	 * 删除用户的角色信息
	 * @param staffId
	 */
	public void deleteStaffRoleInfo(String staffId);
	
	/**
	 * 新增用户的角色信息
	 * @param staffId
	 * @param roleId
	 */
	public void insertStaffRoleInfo(String staffId,String roleId);
	
	/**
	 * 通过用户ID删除用户信息
	 * @param staffId
	 */
	public void deleteStaffInfoById(String staffId);
	
	/**
	 * 新增用户信息
	 * @param staffInfo
	 */
	public void insertStaffInfo(StaffInfo staffInfo);
	
	/**
	 * 修改用户信息
	 * @param staffInfo
	 */
	public void updateStaffInfo(StaffInfo staffInfo);
	
	/**
	 * 根据账户名称 查询与用户所在区域同级别的行政区域<br>
	 * @param staffNbr
	 * @return
	 */
	public List<Map<String,String>> getAreaInfoByStaffNbr(String staffNbr,String staffId);
	
	/**
	 * 根据用户Id查询用户信息
	 * @param staffId
	 * @return
	 */
	public StaffInfo getStaffInfoByStaffId(String staffId);
	
	/**
	 * 通过用户的账号，查用户的权值
	 * @param staffNbr
	 * @return
	 */
	public List<Integer> getStaffRoleValueByStaffNbr(String staffNbr);
	
	/**
	 * 通过用户账号，查角色的服务端权值
	 * @param staffNbr
	 * @return
	 */
	public List<Integer> getRoleSerValueByStaffNbr(String staffNbr);
	
	/**
	 * 与当前用户同一父区域的用户
	 * @param staffNbr
	 * @return
	 */
	public List<StaffInfo> getStaffInfoInOneArea(String staffNbr);
	
	/**
	 * 修改用户门禁权限级别
	 * @param staffId
	 */
	public void updateStaffDoorLevel(String staffId);
	
	/**
	 * 根据地区ID查，地区所在区域的编码
	 * @param areaId
	 */
	public String getAreaCodeById(String areaId);
}
