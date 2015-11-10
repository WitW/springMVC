package com.zbiti.common.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zbiti.common.model.ActionInfo;
import com.zbiti.common.model.RoleInfo;
import com.zbiti.common.model.table.Page;

/**
 * 权限管理业务层接口
 * @author dlt
 *
 */
public interface AuthorityService {
	
	/**
	 * 通过角色roleName查询角色信息
	 * @param roleName
	 * @return
	 */
	public Map<String,String> getRoleInfoByRoleNameInfo(@Param("roleName")String roleName);
	
	/**
	 * 分页查询角色信息
	 * @param page
	 * @return
	 */
	public List<RoleInfo>  listRolesInfo(Map<String,String> map,@Param("page")Page page);
	
	/**
	 *  修改角色信息
	 * @param roleId
	 */
	public void updateRoleInfo(RoleInfo roleInfo);
	
	/**
	 * 删除角色信息
	 * @param roleId
	 */
	public void deleteRoleInfo(String roleId);
	
	/**
	 * 查询所有系统功能信息
	 * @return
	 */
	public List<ActionInfo> getAllActionInfo();
	
	/**
	 * 查询所有的角色信息，不分页
	 * @return
	 */
	public List<RoleInfo> getAllRoleInfo();
	
	/**
	 * 通过角色ID，删除角色用户信息
	 * @param roleId
	 */
	public void deleteStaffRoleInfoByRoleId(String roleId);
	
	/**
	 * 新增角色信息
	 * @param roleInfo
	 */
	public void insertRoleInfo(RoleInfo roleInfo);
	
	/**
	 * 通过角色ID查询角色信息
	 * @param roleId
	 * @return
	 */
	public RoleInfo getRoleInfoById(String roleId);
	
	/**
	 * 通过角色名称查角色信息
	 * @param roleName
	 * @return
	 */
	public Map<String,String> getRoleInfoByRoleName(String roleName);
	
	/**
	 * 查询所有后台功能
	 * @return
	 */
	public List<ActionInfo> getAllServerActionInfo();
	
}
