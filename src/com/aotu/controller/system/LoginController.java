package com.aotu.controller.system;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.aotu.entity.ReportVO;
import com.aotu.entity.system.Dept;
import com.aotu.entity.system.Menu;
import com.aotu.entity.system.Role;
import com.aotu.entity.system.User;
import com.aotu.service.IDeptService;
import com.aotu.service.IMenuService;
//import com.aotu.service.IReportService;
import com.aotu.service.IRoleService;
import com.aotu.util.Const;

/**
 * 系统登录
 */
@Controller
public class LoginController {
	
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IMenuService menuService;
	@Autowired
	private IDeptService deptService;
//	@Autowired
//	private IReportService reportService;
	
	/**
	 * 跳转到登陆页面
	 * @return
	 */
	@RequestMapping(value="/login_toLogin.do")
	public String toLogin() {
		return "system/admin/login";
	}
	
	/**
	 * 用户登陆
	 * @param loginname
	 * @param password
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/login_login.do")
	public String login(String loginname, String password, 
			HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		if (StringUtils.isEmpty(loginname) || StringUtils.isEmpty(password)) {
			return "system/admin/login";
		}
		try {
			Subject subject = SecurityUtils.getSubject(); //得到Shiro中的Subject对象
			//调用login方法,实现登录功能. Shiro框架会自动调用 AuthRealm.doGetAuthenticationInfo()方法来实现登录的判断
			UsernamePasswordToken upToken = new UsernamePasswordToken(loginname, password);
			subject.login(upToken);
			//Realm域支持单点登录
			User user = (User) subject.getPrincipal();
			Role role = null;
			Dept dept = null;
			List<Menu> menuList = null;
			List<Menu> newMenuList = new ArrayList<Menu>();
//			List<Company> companyList = null;
			String subDeptId = null;// 本级及下级机构ID
			if(user != null) {
				dept = this.deptService.get(user.getDeptId());
//				Company company = new Company();
//				company.setDeptId(user.getDeptId());
//				companyList = this.companyService.queryList(company);
//				this.querySubDeptList(dept);// 查询下级部门
				role = this.roleService.get(user.getRoleId());
				if(role != null) {
					menuList = this.menuService.queryListByRoleId(role.getId());
					if(menuList != null && menuList.size() > 0){
						for (Menu menu : menuList) {
							if("0".equals(menu.getParentMenuId())){
								List<Menu> subMenuList = new ArrayList<Menu>();
								for (Menu submenu : menuList) {
									if(menu.getId().equals(submenu.getParentMenuId())){
										subMenuList.add(submenu);
									}
								}
								menu.setHasMenu(true);
								menu.setSubMenuList(subMenuList);
								newMenuList.add(menu);
							}
						}
					}
				}
			}
			session.setAttribute(Const.SESSION_USER, user);
			session.setAttribute(Const.SESSION_DEPT, dept);
			session.setAttribute(Const.SESSION_ROLE, role);
			session.setAttribute(Const.SESSION_MENU_LIST, newMenuList);
			session.setAttribute("subDeptId", subDeptId);
//			session.setAttribute(Const.SESSION_COMPANY, companyList.get(0));
			
			model.addAttribute("menuList", newMenuList);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("flag", "对不起, 您输入的用户名或密码错误！");
			return "system/admin/login";
		}
		
		return "system/admin/index";
	}
	
	/**
	 * 进入tab标签
	 * @return
	 */
	@RequestMapping(value = "tab.do")
	public String tab() {
		return "system/admin/tab";
	}

	/**
	 * 进入首页后的默认页面
	 * @return
	 */
	@RequestMapping(value = "login_default.do")
	public String defaultPage(Model model) {
//		ReportVO reportvo = null;
//		try {
//			reportvo = this.reportService.queryReport();
//			model.addAttribute("reportVO", reportvo);
//		} catch(Exception e) {
//			e.printStackTrace();	
//		}
		return "system/admin/default";
	}
	
	//用户注销---------------------------------------------------------------------------------------------------
	@RequestMapping("/logout_logout.do")
	public String logout(HttpServletRequest request) {
		return "redirect:/login_toLogin.do";
	}
	
	/**
	 * 访问系统首页
	 */
	@RequestMapping(value = "/main/index")
	public String index() {
		return "system/admin/index";
	}
	
	/*
	 * 获取本级及下级客户 - 递归
	 */
//	private void getSubCustomerList(Customer customer) throws Exception {
//		List<Customer> subCustomerList = this.customerService.querySubCustomerList(customer);// 查找此公司的客户列表
//		if(subCustomerList != null && subCustomerList.size() > 0) {// 存在下级公司
//			Customer customerTemp = subCustomerList.get(0);
//			if ("6".equals(customerTemp.getType())) {// 终端客户则直接返回
//				return;
//			}
//			customer.setSubCustomerList(subCustomerList);
//			for (Customer subCustomer : subCustomerList) {
//				getSubCustomerList(subCustomer);// 继续查询下级的下级
//			}
//		}
//	}
	
	
	/*
	 * 获取下级机构 - 递归
	 */
//	private void querySubDeptList(Dept dept) throws Exception {
//		dept.setUrl("dept/queryList.do?parentDeptId=" + dept.getId());
//		dept.setTarget("listFrame");
//		List<Dept> subDeptList = this.deptService.querySubDeptList(dept);
//		if (subDeptList != null && subDeptList.size() > 0) {
//			dept.setSubDeptList(subDeptList);
//			for (Dept subDept : subDeptList) {
//				this.querySubDeptList(subDept);
//			}
//		}
//	}
	
	
}
