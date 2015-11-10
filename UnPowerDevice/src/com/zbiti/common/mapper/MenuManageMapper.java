package com.zbiti.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zbiti.common.model.Menu;



/**
 * 菜单管理Mapper
 * @author wyj
 *
 */
public interface MenuManageMapper {

	
   
   
   /**
    * 查询菜单
    * @return
    */
   public List<Menu> getAllMenu(@Param("roleId")String roleId);
   
   /**
    * 根据一级菜单查询某个用户该一级菜单下的二级菜单
    * @param menuId
    * @return
    */
   public List<Menu> getSecondMenu(@Param("menuId")String menuId,@Param("staffId")String staffId);
   
   /**
    * 查询一级菜单
    * @param menuId
    * @return
    */
   public List<Menu> getFirstMenu();
   
   
   /**
    * 建立角色与菜单关系
    * @param menuId
    * @param roleId
    */
   public void insertRoleMenu(@Param("menuId")String menuId,@Param("roleId")String roleId);
   
   /**
    * 根据角色ID删除角色菜单配置关系
    * @param roleId
    */
   public void deleteRoleMenu(@Param("roleId")String roleId);
}
