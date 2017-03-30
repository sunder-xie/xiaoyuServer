package com.aotu.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aotu.entity.Order;
import com.aotu.entity.Page;
import com.aotu.service.IOrderService;

/**
 * 订单信息 Controller
 */
@Controller
@RequestMapping(value="/order")
public class OrderController extends BaseController {
	
	@Resource(name="orderService")
	private IOrderService orderService;
	
	/**
	 * 查询列表 - 分页
	 */
	@RequestMapping("/queryList.do")
	public String queryList(Order order, Page page, Model model) throws Exception {
		page = this.orderService.queryPage(page, order);
		model.addAttribute("page", page);
		model.addAttribute("order", order);
		return "order/orderList";
	}
}
