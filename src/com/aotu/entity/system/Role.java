package com.aotu.entity.system;

import com.aotu.entity.BaseEntity;

/**
 * 系统角色
 */
public class Role extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	private String roleCode;//角色编号
	private String roleName;//角色名称
	private String sort;//顺序
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	
}
