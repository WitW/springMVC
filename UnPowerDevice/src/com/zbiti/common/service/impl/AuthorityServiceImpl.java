package com.zbiti.common.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zbiti.common.dao.AuthorityDao;
import com.zbiti.common.model.ActionInfo;
import com.zbiti.common.model.RoleInfo;
import com.zbiti.common.model.table.Page;
import com.zbiti.common.service.AuthorityService;

/**
 * 权限管理业务层实现类
 * @author dlt
 *
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	private AuthorityDao authorityDaoImpl;
	
	public List<RoleInfo> listRolesInfo(Map<String,String> map,@Param("page")Page page) {
		
		return authorityDaoImpl.listRolesInfo(map,page);
	}

	public List<ActionInfo> getAllActionInfo() {
		
		return authorityDaoImpl.getAllActionInfo();
	}

	public void updateRoleInfo(RoleInfo roleInfo) {
		
		authorityDaoImpl.updateRoleInfo(roleInfo);
	}

	public List<RoleInfo> getAllRoleInfo() {
		
		return authorityDaoImpl.getAllRoleInfo();
	}

	public void deleteRoleInfo(String roleId) {
		
		authorityDaoImpl.deleteRoleInfo(roleId);
	}

	public void deleteStaffRoleInfoByRoleId(String roleId) {
		
		authorityDaoImpl.deleteStaffRoleInfoByRoleId(roleId);
	}

	public void insertRoleInfo(RoleInfo roleInfo) {
		
		authorityDaoImpl.insertRoleInfo(roleInfo);
	}

	public RoleInfo getRoleInfoById(String roleId) {
		
		return authorityDaoImpl.getRoleInfoById(roleId);
	}

	public Map<String, String> getRoleInfoByRoleName(String roleName) {
		
		return authorityDaoImpl.getRoleInfoByRoleName(roleName);
	}

	public List<ActionInfo> getAllServerActionInfo() {
		
		return authorityDaoImpl.getAllServerActionInfo();
	}


	public Map<String,String> getRoleInfoByRoleNameInfo(String roleName) {
		return authorityDaoImpl.getRoleInfoByRoleNameInfo(roleName);
	}

}
