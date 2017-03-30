package com.aotu.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.aotu.entity.Page;
import com.aotu.entity.system.Dept;
import com.aotu.util.Logger;
import com.aotu.util.PageData;
import com.aotu.util.UuidUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/base")
public class BaseController {
	
	protected Logger logger = Logger.getLogger(this.getClass());

//	@Resource(name="baseService")
//	private IBaseService baseService;
	
	/**
	 * 得到PageData
	 */
	public PageData getPageData(){
		return new PageData(this.getRequest());
	}
	
	/**
	 * 得到ModelAndView
	 */
	public ModelAndView getModelAndView(){
		return new ModelAndView();
	}
	
	/**
	 * 得到request对象
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		return request;
	}

	/**
	 * 得到32位的uuid
	 * @return
	 */
	public String get32UUID(){
		
		return UuidUtil.get32UUID();
	}
	
	/**
	 * 得到分页列表的信息 
	 */
	public Page getPage(){
		
		return new Page();
	}
	
	public static void logBefore(Logger logger, String interfaceName){
		logger.info("");
		logger.info("start");
		logger.info(interfaceName);
	}
	
	public static void logAfter(Logger logger){
		logger.info("end");
		logger.info("");
	}
	
	/*
	 * 机构树
	 */
	protected String queryDeptTree(Dept dept){
		// json对象
		try {
			JSONObject jsonArray = JSONObject.fromObject(dept);
			jsonArray.put("open", true);
			String json = jsonArray.toString();
			json = json.replaceAll("deptName", "name");// 替换公司名称
			json = json.replaceAll("id", "id");// 替换公司ID
			json = json.replaceAll("parentDeptId", "pid");// 替换上级公司ID
			json = json.replaceAll("subDeptList", "children");// 替换子机构列表
			return json;
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	protected Session getSession() {
		Subject currentUser = SecurityUtils.getSubject();  
		Session session = currentUser.getSession();
		return session;
	}
	
}
