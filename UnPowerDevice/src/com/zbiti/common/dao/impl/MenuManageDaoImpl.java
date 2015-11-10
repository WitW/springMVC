package com.zbiti.common.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zbiti.common.dao.MenuManageDao;
import com.zbiti.common.mapper.MenuManageMapper;
import com.zbiti.common.model.Menu;

@Service(value = "menuManageDao")
public class MenuManageDaoImpl implements MenuManageDao {

	@Resource
	private MenuManageMapper menuManageMapper;

	public List<Menu> getAllMenu(String roleId) {
		
		return menuManageMapper.getAllMenu(roleId);
	}

	public List<Menu> getSecondMenu(String menuId,String staffId) {
		
		return menuManageMapper.getSecondMenu(menuId,staffId);
	}

	public void insertRoleMenu(String menuId, String roleId) {
		
		menuManageMapper.insertRoleMenu(menuId, roleId);
	}

	public void deleteRoleMenu(String roleId) {
		
		menuManageMapper.deleteRoleMenu(roleId);
	}

	public List<Menu> getFirstMenu() {
		
		return menuManageMapper.getFirstMenu();
	}


	
	
	
}
