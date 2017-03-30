package com.aotu.dao;

import java.util.List;

import com.aotu.entity.system.Dept;

/**
 * 系统部门 DAO 
 */
public interface DeptDAO extends BaseDAO {
	
	/**
	 * 获取下级部门
	 * @return
	 */
	public List<Dept> querySubDeptList(Dept dept);
	
}