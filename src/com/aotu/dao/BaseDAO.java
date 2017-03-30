package com.aotu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 基类 - DAO
 */
public interface BaseDAO {
	
	/**
	 * 新增
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public void save(Object obj);
	
	/**
	 * 删除
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public void delete(Object obj);
	
	/**
	 * 修改
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public void update(Object obj);
	
	/**
	 * 查看
	 * @param id
	 * @return
	 */
	public Object get(String id);
	
	/**
	 * 查询列表 - 分页
	 * @param pageSize
	 * @param startIndex
	 * @param obj
	 * @return
	 */
	public List queryPage(@Param("pageSize") int pageSize, 
			@Param("startIndex") int startIndex, @Param("obj") Object obj);
	public List queryUsb(@Param("pageSize") int pageSize, 
			@Param("startIndex") int startIndex, @Param("obj") Object obj);
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 */
	public List queryList(Object obj);
	
	/**
	 * 查询总记录数
	 * @param 
	 * @return
	 */
	public int queryCount(Object obj);
	
	
	
}
