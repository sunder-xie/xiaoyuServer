package com.aotu.service;

import java.util.List;

import com.aotu.entity.MerchantSet;
import com.aotu.entity.Page;

/**
 * 商户设置 Service
 */
public interface IMerchantSetService {

	/**
	 * 新增
	 * @param merchantSet
	 * @throws Exception
	 */
	public void save(MerchantSet merchantSet) throws Exception;
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception;
	
	/**
	 * 修改
	 * @param merchantSet
	 * @throws Exception
	 */
	public void update(MerchantSet merchantSet) throws Exception;
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public MerchantSet get(String id) throws Exception;
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, MerchantSet merchantSet) throws Exception;
	
	/**
	 * 查询订单总数 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<MerchantSet> querySum(MerchantSet merchantSet) throws Exception;
	
	/**
	 * 查询订单列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<MerchantSet> queryList(MerchantSet merchantSet) throws Exception;
	
}
