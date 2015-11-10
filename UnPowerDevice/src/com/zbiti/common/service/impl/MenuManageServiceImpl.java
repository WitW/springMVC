package com.zbiti.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zbiti.common.dao.MenuManageDao;
import com.zbiti.common.model.Menu;
import com.zbiti.common.model.tree.TreeNode;
import com.zbiti.common.service.MenuManageService;

/**
 * 局站管理业务实现类
 * @author dlt
 *
 */
@Service(value = "menuManageService")
public class MenuManageServiceImpl implements MenuManageService{

	@Resource
	private MenuManageDao menuManageDao;

	public List<Menu> getAllMenu(String roleId) {
		
		return menuManageDao.getAllMenu(roleId);
	}

	public List<Menu> getSecondMenu(String menuId,String staffId) {
		
		return menuManageDao.getSecondMenu(menuId,staffId);
	}

	public void insertRoleMenu(String menuId, String roleId) {
		
		menuManageDao.insertRoleMenu(menuId, roleId);
	}

	public void deleteRoleMenu(String roleId) {
		
		menuManageDao.deleteRoleMenu(roleId);
	}

	public List<Menu> getFirstMenu() {
		
		return menuManageDao.getFirstMenu();
	}

	public void builtRoleMenuRelation(String roleId, String[] menuIds) {
		
		//先删除该角色的配置关系
		deleteRoleMenu(roleId);
		
		//建立新的角色菜单关系
		if(menuIds != null && menuIds.length >0)
		{
			int length = menuIds.length;
			for(int i=0;i<length;i++)
			{   
				String menuId = menuIds[i];
				insertRoleMenu(menuId, roleId);
			}
		}
		
	}

	public void getSystemMenu(List<Menu> firstMenus,String staffId) {
		//获取二级菜单 
		List<Menu> secondMenus = this.getSecondMenu("",staffId.toString());
		 for (Menu menu : firstMenus) 
	    	{
	    	 //设置该一级菜单的二级菜单	
			    menu.setMenuList(secondMenus);
				List<TreeNode> nodes = new ArrayList<TreeNode>();
				
				if(menu.getMenuList() != null && menu.getMenuList().size()>0 )
				{
					//若该一级菜单存在二级菜单
					TreeNode node = null;
					for (Menu menu1 : menu.getMenuList()) 
					{
						 node = new TreeNode();
						 node.setId(menu1.getPanelId());
						 node.setHref(menu1.getHref());
						 node.setTitle(menu1.getMenuName());
						 node.setOrderNo(Integer.valueOf(menu1.getOrderNo()));
						 nodes.add(node);
					}
					
					//二级菜单树
					node = new TreeNode(nodes);
					menu.setSonMenuStr(node.getLiStr());
					
				}
			}
		
	}

	
	
	
}
