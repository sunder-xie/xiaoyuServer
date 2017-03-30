package com.aotu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aotu.entity.system.Menu;

/**
 * 系统菜单 DAO 
 */
public interface MenuDAO extends BaseDAO {
	
	/**
	 * 通过角色ID获取对应的菜单列表
	 * @param roleId
	 * @return
	 */
	public List<Menu> queryListByRoleId(@Param("roleId") String roleId);
	
}