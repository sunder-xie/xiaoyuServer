package com.aotu.service;

import java.util.List;

import com.aotu.entity.Page;
import com.aotu.entity.system.Role;

/**
 * 系统角色 Service
 */
public interface IRoleService {

	/**
	 * 新增
	 * @param role
	 * @throws Exception
	 */
	public void save(Role role) throws Exception;
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception;
	
	/**
	 * 修改
	 * @param role
	 * @throws Exception
	 */
	public void update(Role role) throws Exception;
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public Role get(String id) throws Exception;
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, Role role) throws Exception;
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<Role> queryList(Role role) throws Exception;
	
}
