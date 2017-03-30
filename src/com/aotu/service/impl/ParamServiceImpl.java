package com.aotu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aotu.dao.ParamDAO;
import com.aotu.entity.Page;
import com.aotu.entity.system.Param;
import com.aotu.service.IParamService;
import com.aotu.util.CacheUtil;

/**
 * 系统参数 Service实现类
 */
@Service("paramService")
public class ParamServiceImpl implements IParamService {

	@Autowired
	private ParamDAO paramDAO;
	
	/**
	 * 新增
	 * @param param
	 * @throws Exception
	 */
	public void save(Param param) throws Exception {
		this.paramDAO.save(param);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception {
		this.paramDAO.delete(id);
	}
	
	/**
	 * 修改
	 * @param param
	 * @throws Exception
	 */
	public void update(Param param) throws Exception {
		this.paramDAO.update(param);
	}
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public Param get(String id) throws Exception {
		return (Param)this.paramDAO.get(id);
	}
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, Param param) throws Exception {
		//查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = paramDAO.queryCount(param);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<Param> records = paramDAO.queryPage(page.getPageSize(), page.getStartIndex(), param);
		page.setRecords(records);
		return page;
	}
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<Param> queryList(Param param) throws Exception {
		List<Param> records = paramDAO.queryList(param);
		return records;
	}
	
	@Override
    public String getParamValueByName(String name) {
        Param param =  paramDAO.getParamByName(name);
        return param.getParamValue();
    }
	
	@Override
    public Param getParamByName(String name) {
        Param param =  paramDAO.getParamByName(name);
        return param;
    }
	
	@Override
    public void refreshParamByValue(String value) {
        CacheUtil.refreshParamByValue(value);
    }
    

}
