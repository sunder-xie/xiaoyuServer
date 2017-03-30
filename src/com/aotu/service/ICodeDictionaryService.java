package com.aotu.service;

import java.util.List;

import com.aotu.entity.Page;
import com.aotu.entity.system.CodeDictionary;

/**
 * 数据字典 Service
 */
public interface ICodeDictionaryService {

	/**
	 * 新增
	 * @param codeDictionary
	 * @throws Exception
	 */
	public void save(CodeDictionary codeDictionary) throws Exception;
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception;
	
	/**
	 * 修改
	 * @param codeDictionary
	 * @throws Exception
	 */
	public void update(CodeDictionary codeDictionary) throws Exception;
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public CodeDictionary get(String id) throws Exception;
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, CodeDictionary codeDictionary) throws Exception;
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<CodeDictionary> queryList(CodeDictionary codeDictionary) throws Exception;
	
}
