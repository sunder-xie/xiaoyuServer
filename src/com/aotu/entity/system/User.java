package com.aotu.entity.system;

import java.util.Date;

import com.aotu.entity.BaseEntity;

/**
 * 系统用户
 */
public class User extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	public static final String STATUS_NORMAL = "1";
	public static final String STATUS_FORBIDEN = "0";

	private String userName;// 用户名
	private String password;//密码
	private String name;//名称
	private Date lastLoginDate;//最后登入时间
	private String loginIp;//登入IP
	private String status;//状态(1-可用；0-禁用)
	private String phone;//手机号码
	private String deptId;//所属部门ID
	private String roleId;// 所属角色ID
	
	// 以下为瞬态字段
	private String newPassword;// 新密码
	private String checkPassword;// 确认新密码

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public static String getStatusNormal() {
		return STATUS_NORMAL;
	}

	public static String getStatusForbiden() {
		return STATUS_FORBIDEN;
	}

	public String getCheckPassword() {
		return checkPassword;
	}

	public void setCheckPassword(String checkPassword) {
		this.checkPassword = checkPassword;
	}
	
}
