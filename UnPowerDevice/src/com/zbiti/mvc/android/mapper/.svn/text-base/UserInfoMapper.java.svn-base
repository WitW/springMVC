package com.zbiti.mvc.android.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zbiti.common.model.table.Page;
import com.zbiti.mvc.android.model.StaffInfo;

public interface UserInfoMapper {
	/**
	 * 工号查询用户
	 * @param staffNbr
	 * @return
	 */
	public Map getUserInfoByStaffId(@Param("staffNbr")String staffNbr);

	/**
	 * 修改密码
	 * @param userName
	 * @param passWord
	 * @param newpassWord
	 */
	public void updatePassword(@Param("staffId")String userName, @Param("passWord")String passWord,
			@Param("newPassWord")String newPassWord);

	/**
	 * 保存用户反馈信息
	 * @param staffId
	 * @param content
	 */
	public void saveAdvice(@Param("staffId")String staffId, @Param("content")String content);
	
	/**
	 * 分页查询用户信息
	 * @param map
	 * @param page
	 * @return
	 */
	public List<StaffInfo> staffInfolistPage(@Param("map")Map<String,String> map,@Param("page")Page page);
	
	/**
	 * 根据用户ID查询，用户角色关系表
	 * @param staffId
	 * @return
	 */
	public List<String> getStaffRoleInfo(@Param("staffId")String staffId);
	
	/**
	 * 删除用户的角色信息
	 * @param staffId
	 */
	public void deleteStaffRoleInfo(@Param("staffId")String staffId);
	
	/**
	 * 新增用户的角色信息
	 * @param staffId
	 * @param roleId
	 */
	public void insertStaffRoleInfo(@Param("staffId")String staffId,@Param("roleId")String roleId);
	
	/**
	 * 通过用户ID删除用户信息
	 * @param staffId
	 */
	public void deleteStaffInfoById(@Param("staffId")String staffId);
	
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
	public List<Map<String,String>> getAreaInfoByStaffNbr(@Param("staffNbr")String staffNbr,@Param("staffId")String staffId);
	
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
	public List<Integer> getStaffRoleValueByStaffNbr(@Param("staffNbr")String staffNbr);
	
	/**
	 * 通过用户账号，查角色的服务端权值
	 * @param staffNbr
	 * @return
	 */
	public List<Integer> getRoleSerValueByStaffNbr(@Param("staffNbr")String staffNbr);
	
	/**
	 * 与当前用户同一父区域的用户
	 * @param staffNbr
	 * @return
	 */
	public List<StaffInfo> getStaffInfoInOneArea(@Param("staffNbr")String staffNbr);
	
	/**
	 * 修改用户门禁权限级别
	 * @param staffId
	 */
	public void updateStaffDoorLevel(@Param("staffId")String staffId);
	
	/**
	 * 根据地区ID查，地区所在区域的编码
	 * @param areaId
	 */
	public String getAreaCodeById(@Param("areaId")String areaId);
}
