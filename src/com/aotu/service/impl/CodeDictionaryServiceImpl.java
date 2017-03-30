package com.aotu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aotu.dao.CodeDictionaryDAO;
import com.aotu.entity.Page;
import com.aotu.entity.system.CodeDictionary;
import com.aotu.service.ICodeDictionaryService;

/**
 * 数据字典 Service实现类
 */
@Service("codeDictionaryService")
public class CodeDictionaryServiceImpl implements ICodeDictionaryService {

	@Autowired
	private CodeDictionaryDAO codeDictionaryDAO;
	
	/**
	 * 新增
	 * @param codeDictionary
	 * @throws Exception
	 */
	public void save(CodeDictionary codeDictionary) throws Exception {
		this.codeDictionaryDAO.save(codeDictionary);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception {
		this.codeDictionaryDAO.delete(id);
	}
	
	/**
	 * 修改
	 * @param codeDictionary
	 * @throws Exception
	 */
	public void update(CodeDictionary codeDictionary) throws Exception {
		this.codeDictionaryDAO.update(codeDictionary);
	}
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public CodeDictionary get(String id) throws Exception {
		return (CodeDictionary)this.codeDictionaryDAO.get(id);
	}
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, CodeDictionary codeDictionary) throws Exception {
		//查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = codeDictionaryDAO.queryCount(codeDictionary);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<CodeDictionary> records = codeDictionaryDAO.queryPage(page.getPageSize(), page.getStartIndex(), codeDictionary);
		page.setRecords(records);
		return page;
	}
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<CodeDictionary> queryList(CodeDictionary codeDictionary) throws Exception {
		List<CodeDictionary> records = codeDictionaryDAO.queryList(codeDictionary);
		return records;
	}

}
