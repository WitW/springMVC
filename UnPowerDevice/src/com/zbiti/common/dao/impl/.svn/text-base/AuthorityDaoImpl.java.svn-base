package com.zbiti.common.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zbiti.common.dao.AuthorityDao;
import com.zbiti.common.mapper.AuthorityMapper;
import com.zbiti.common.model.ActionInfo;
import com.zbiti.common.model.RoleInfo;
import com.zbiti.common.model.table.Page;

/**
 * 权限管理dao层实现类
 * @author dlt
 *
 */
@Repository("authorityDaoImpl")
public class AuthorityDaoImpl implements AuthorityDao {
	@Autowired
	private AuthorityMapper authorityMapper;
	
	public List<RoleInfo> listRolesInfo(Map<String,String> map,@Param("page")Page page) {
		
		return authorityMapper.rolesInfolistPage(map,page);
	}

	public List<ActionInfo> getAllActionInfo() {
		
		return authorityMapper.getAllActionInfo();
	}

	public void updateRoleInfo(RoleInfo roleInfo) {
		
		authorityMapper.updateRoleInfo(roleInfo);
	}

	public List<RoleInfo> getAllRoleInfo() {
		
		return authorityMapper.getAllRoleInfo();
	}

	public void deleteRoleInfo(String roleId) {
		authorityMapper.deleteRoleInfo(roleId);
	}

	public void deleteStaffRoleInfoByRoleId(String roleId) {
		
		authorityMapper.deleteStaffRoleInfoByRoleId(roleId);
	}

	public void insertRoleInfo(RoleInfo roleInfo) {
		
		authorityMapper.insertRoleInfo(roleInfo);
		
	}

	public RoleInfo getRoleInfoById(String roleId) {
		
		return authorityMapper.getRoleInfoById(roleId);
	}

	public Map<String, String> getRoleInfoByRoleName(String roleName) {
		
		return authorityMapper.getRoleInfoByRoleName(roleName);
	}

	public List<ActionInfo> getAllServerActionInfo() {
		
		return authorityMapper.getAllServerActionInfo();
	}

	public Map<String,String> getRoleInfoByRoleNameInfo(String roleName) {
		return authorityMapper.getRoleInfoByRoleNameInfo(roleName);
	}



	
	
	

}
