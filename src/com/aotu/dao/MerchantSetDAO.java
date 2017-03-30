package com.aotu.dao;

import java.util.List;

import com.aotu.entity.MerchantSet;

/**
 * 商户设置 DAO 
 */
public interface MerchantSetDAO extends BaseDAO{

	public List<MerchantSet> querySum(MerchantSet merchantSet) ;
		
	
}