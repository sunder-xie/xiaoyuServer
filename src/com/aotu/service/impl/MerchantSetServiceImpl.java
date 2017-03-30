package com.aotu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aotu.dao.MerchantSetDAO;
import com.aotu.entity.MerchantSet;
import com.aotu.entity.Page;
import com.aotu.service.IMerchantSetService;

/**
 * 商户设置 Service实现类
 */
@Service("merchantSetService")
public class MerchantSetServiceImpl implements IMerchantSetService {

	@Autowired
	private MerchantSetDAO merchantSetDAO;
	
	/**
	 * 新增
	 * @param merchantSet
	 * @throws Exception
	 */
	public void save(MerchantSet merchantSet) throws Exception {
		this.merchantSetDAO.save(merchantSet);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception {
		this.merchantSetDAO.delete(id);
	}
	
	/**
	 * 修改
	 * @param merchantSet
	 * @throws Exception
	 */
	public void update(MerchantSet merchantSet) throws Exception {
		this.merchantSetDAO.update(merchantSet);
	}
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public MerchantSet get(String id) throws Exception {
		return (MerchantSet)this.merchantSetDAO.get(id);
	}
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, MerchantSet merchantSet) throws Exception {
		//查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = merchantSetDAO.queryCount(merchantSet);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<MerchantSet> records = merchantSetDAO.queryPage(page.getPageSize(), page.getStartIndex(), merchantSet);
		page.setRecords(records);
		return page;
	}
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<MerchantSet> queryList(MerchantSet merchantSet) throws Exception {
		List<MerchantSet> records = merchantSetDAO.queryList(merchantSet);
		return records;
	}

	public List<MerchantSet> querySum(MerchantSet merchantSet) throws Exception{
		List<MerchantSet> records = merchantSetDAO.querySum(merchantSet);
		return records;
	}
}
