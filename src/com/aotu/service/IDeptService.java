package com.aotu.service;

import java.util.List;

import com.aotu.entity.Page;
import com.aotu.entity.system.Dept;

/**
 * 系统部门 Service
 */
public interface IDeptService {

	/**
	 * 新增
	 * @param dept
	 * @throws Exception
	 */
	public void save(Dept dept) throws Exception;
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception;
	
	/**
	 * 修改
	 * @param dept
	 * @throws Exception
	 */
	public void update(Dept dept) throws Exception;
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public Dept get(String id) throws Exception;
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, Dept dept) throws Exception;
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<Dept> queryList(Dept dept) throws Exception;
	
	/**
	 * 查询下级机构
	 * @param dept
	 * @return
	 */
	public List<Dept> querySubDeptList(Dept dept) throws Exception;
	
}
