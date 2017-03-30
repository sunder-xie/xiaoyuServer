package com.aotu.service;

import java.util.List;

import com.aotu.entity.Page;
import com.aotu.entity.system.Menu;

/**
 * 系统菜单 Service
 */
public interface IMenuService {

	/**
	 * 新增
	 * @param menu
	 * @throws Exception
	 */
	public void save(Menu menu) throws Exception;
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception;
	
	/**
	 * 修改
	 * @param menu
	 * @throws Exception
	 */
	public void update(Menu menu) throws Exception;
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public Menu get(String id) throws Exception;
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, Menu menu) throws Exception;
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<Menu> queryList(Menu menu) throws Exception;
	
	/**
	 * 通过角色ID获取对应的菜单列表
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	public List<Menu> queryListByRoleId(String roleId) throws Exception;
	
}
