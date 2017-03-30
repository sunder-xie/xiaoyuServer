package com.aotu.service;

import java.util.List;

import com.aotu.entity.Page;
import com.aotu.entity.system.Param;

/**
 * 系统参数 Service
 */
public interface IParamService {

	/**
	 * 新增
	 * @param param
	 * @throws Exception
	 */
	public void save(Param param) throws Exception;
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception;
	
	/**
	 * 修改
	 * @param param
	 * @throws Exception
	 */
	public void update(Param param) throws Exception;
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public Param get(String id) throws Exception;
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, Param param) throws Exception;
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<Param> queryList(Param param) throws Exception;

	/**
	 * 获取参数值
	 * @param name
	 * @return
	 */
	public String getParamValueByName(String name);
	
	/**
	 * 获取param对象
	 * @param name
	 * @return
	 */
	public Param getParamByName(String name);

	/**
	 * 
	 * @param value
	 */
	public void refreshParamByValue(String value);
	
	
	 
	
}
