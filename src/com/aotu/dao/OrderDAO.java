package com.aotu.dao;

import java.math.BigDecimal;

import com.aotu.entity.Order;

/**
 * 订单 DAO 
 */
public interface OrderDAO extends BaseDAO{

	/**
	 * 统计订单金额
	 * @param order
	 * @return
	 */
	public BigDecimal querySum(Order order) ;
		
	
}