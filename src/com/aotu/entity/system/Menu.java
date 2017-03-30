package com.aotu.entity.system;

import java.util.List;

import com.aotu.entity.BaseEntity;

/**
 * 系统菜单
 */
public class Menu extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	private String menuName;//菜单名称
	private String menuUrl;//菜单URL
	private String parentMenuId;//父级菜单Id
	private String menuIcon;//菜单图标
	private Integer sort;//顺序
	private boolean hasMenu = false;
	
	private List<Menu> subMenuList;// 子菜单列表

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getParentMenuId() {
		return parentMenuId;
	}

	public void setParentMenuId(String parentMenuId) {
		this.parentMenuId = parentMenuId;
	}

	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public List<Menu> getSubMenuList() {
		return subMenuList;
	}

	public void setSubMenuList(List<Menu> subMenuList) {
		this.subMenuList = subMenuList;
	}

	public boolean isHasMenu() {
		return hasMenu;
	}

	public void setHasMenu(boolean hasMenu) {
		this.hasMenu = hasMenu;
	}
	
}
