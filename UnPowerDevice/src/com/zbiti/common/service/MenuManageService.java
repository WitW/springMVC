package com.zbiti.common.service;

import java.util.List;

import com.zbiti.common.model.Menu;

/**
 * 局站管理业务接口
 * @author dlt
 *
 */
public interface MenuManageService {
	
	 
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
	   
	   /**
	    * 建立角色菜单关系
	    * @param roleId
	    * @param menuId
	    */
       public  void builtRoleMenuRelation(String roleId,String[] menuIds);
       
       /**
        * 获取用户系统菜单列表
        * @param firstMenus
        */
       public void getSystemMenu(List<Menu> firstMenus,String staffId);
}
