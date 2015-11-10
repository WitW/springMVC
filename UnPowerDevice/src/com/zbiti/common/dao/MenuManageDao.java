package com.zbiti.common.dao;

import java.util.List;

import com.zbiti.common.model.Menu;

/**
 * 局站地图，路由管理接口
 * @author wyj
 *
 */
public interface MenuManageDao 
{

	   /**
	    * 查询菜单
	    * @return
	    */
	   public List<Menu> getAllMenu(String roleId);
	   
	   /**
	    * 根据一级菜单查询二级菜单
	    * @param menuId
	    * @return
	    */
	   public List<Menu> getSecondMenu(String menuId,String staffId);
	   
	   /**
	    * 建立角色与菜单关系
	    * @param menuId
	    * @param roleId
	    */
	   public void insertRoleMenu(String menuId,String roleId);
	   
	   /**
	    * 根据角色ID删除角色菜单配置关系
	    * @param roleId
	    */
	   public void deleteRoleMenu(String roleId);
	   
	   /**
	    * 查询一级菜单
	    * @param menuId
	    * @return
	    */
	   public List<Menu> getFirstMenu();

}
