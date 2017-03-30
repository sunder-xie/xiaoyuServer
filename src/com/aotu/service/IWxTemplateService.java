package com.aotu.service;

import com.aotu.entity.Order;

public interface IWxTemplateService {

	/**
	 * 发送模板消息
	 */
    public void sendOrderMessage(Order order) throws Exception;
    
}
