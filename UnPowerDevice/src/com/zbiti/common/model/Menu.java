package com.zbiti.common.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单bean 
 * @author wyj
 *
 */
public class Menu 
{
  //菜单名	
  private String  menuName;
  
  //菜单跳转路劲
  private String href;
  
  //排序号
  private String orderNo;
  
  //菜单Id
  private String menuId;
  
  //菜单父Id
  private String menuParentId;
  
  //菜单等级
  private String menuLevel;
  
  //子菜单
  private  List<Menu> menuList;
  
  //拼接好的字符串
  
  private String sonMenuStr;
  
  //页面panel id
  private String panelId;
  
  //是否被选
  private String isCheck;

public String getMenuName() {
	return menuName;
}

public void setMenuName(String menuName) {
	this.menuName = menuName;
}

public String getHref() {
	return href;
}

public void setHref(String href) {
	this.href = href;
}

public String getOrderNo() {
	return orderNo;
}

public void setOrderNo(String orderNo) {
	this.orderNo = orderNo;
}

public String getMenuId() {
	return menuId;
}

public void setMenuId(String menuId) {
	this.menuId = menuId;
}

public String getMenuParentId() {
	return menuParentId;
}

public void setMenuParentId(String menuParentId) {
	this.menuParentId = menuParentId;
}

public String getMenuLevel() {
	return menuLevel;
}

public void setMenuLevel(String menuLevel) {
	this.menuLevel = menuLevel;
}

public List<Menu> getMenuList() {
	return menuList;
}

public void setMenuList(List<Menu> menuList) {
	this.menuList = new ArrayList<Menu>();
	if(menuList != null && menuList.size() >0)
	{
		for (Menu menu : menuList) {
			//若是该一级菜单的子菜单则添加至子菜单集合
			if(menu.getMenuParentId() != null && menu.getMenuParentId().equals(this.menuId))
			{
				this.menuList.add(menu);
			}
		}
	}
	
}

public String getIsCheck() {
	return isCheck;
}

public void setIsCheck(String isCheck) {
	this.isCheck = isCheck;
}

public String getSonMenuStr() {
	return sonMenuStr;
}

public void setSonMenuStr(String sonMenuStr) {
	this.sonMenuStr = sonMenuStr;
}

public String getPanelId() {
	return panelId;
}

public void setPanelId(String panelId) {
	this.panelId = panelId;
}

  
  
  
  
}
