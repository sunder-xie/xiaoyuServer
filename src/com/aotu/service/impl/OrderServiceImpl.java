package com.aotu.service.impl;

import com.aotu.dao.OrderDAO;
import com.aotu.entity.Order;
import com.aotu.entity.Page;
import com.aotu.service.IOrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("unchecked")
@Service("orderService")
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private OrderDAO orderDAO;

	public void save(Order order) throws Exception {
		this.orderDAO.save(order);
	}

	public void delete(String id) throws Exception {
		this.orderDAO.delete(id);
	}

	public void update(Order order) throws Exception {
		this.orderDAO.update(order);
	}

	public Order get(String id) throws Exception {
		return (Order) this.orderDAO.get(id);
	}

	public Page queryPage(Page page, Order order) throws Exception {
		int totalRecordsNum = this.orderDAO.queryCount(order);
		page.setTotalRecordsNum(totalRecordsNum);

		List<Order> records = this.orderDAO.queryPage(page.getPageSize(),
				page.getStartIndex(), order);
		page.setRecords(records);
		return page;
	}

	public List<Order> queryList(Order order) throws Exception {
		List records = this.orderDAO.queryList(order);
		return records;
	}

	public void changeStatus(Order order) throws Exception {
		this.orderDAO.update(order);
	}
}