package com.aotu.entity.system;

import com.aotu.entity.BaseEntity;

/**
 * 角色权限
 */
public class RoleMenu extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	private String roleId;//角色ID
	private String menuId;//菜单ID
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	
	
}
