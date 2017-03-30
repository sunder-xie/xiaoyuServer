package com.aotu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.aotu.entity.system.User;
import com.aotu.util.Const;

/**
 * 后台访问 拦截器
 */
@SuppressWarnings("all")
public class LoginHandlerInterceptor extends HandlerInterceptorAdapter{

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
								Object handler, Exception exception) throws Exception {}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, 
						   Object handler, ModelAndView exception) throws Exception {}

	// 登录验证
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		// 截取URI到".do"的前一段, 防止在".do"后面携带没有权限的窄化请求参数进行访问
		String requestUri = request.getRequestURI().substring(0, request.getRequestURI().indexOf(".do") + 3);

		if (requestUri.indexOf(".do") > 0) {
			if (requestUri.indexOf("login") > 0) { // 如果URI中包含login, 那么这个请求要么是去登录页面, 要么是去验证登录, 放行
				return true;
			}
			if (requestUri.indexOf("logout") > 0) { // 如果URI中包含logout, 那么这个请求去注销登录, 放行
				return true;
			}
			// 判断session中是否有当前登录的用户信息
			User user = (User) request.getSession().getAttribute(Const.SESSION_USER);
			if (null != user) {
				// 访问权限过滤
//				List<Menu> menuList = new ArrayList<Menu>();
//				List<Menu> subMenuList = new ArrayList<Menu>();
//				List<Menu> menus = (List<Menu>) request.getSession().getAttribute(Const.SESSION_menuList);
//				for (Menu menu : menus) {
//					if ("0".equals(menu.getParentMenu().getMenuId()) && !menuList.contains(menu)) {
//						for (Menu subMenu : menus) {
//							if (menu.getMenuId().equals(subMenu.getParentMenu().getMenuId())) {
//								subMenuList.add(subMenu);
//							}
//						}
//						menu.setSubMenu(subMenuList);
//						menuList.add(menu);
//					}
//				}
//				// 获取当前登录者所有的权限, 截取这些权限的窄化请求
//				List<String> menuSubString = new ArrayList<String>();
//				for (Menu menu : subMenuList) {
//					if (null != menu.getMenuUrl() && !"".equals(menu.getMenuUrl())) {
//						menuSubString.add(menu.getMenuUrl().substring(0, menu.getMenuUrl().indexOf("/")));
//					}
//				}
				// 判断用户所允许的的窄化请求是否有一个在当前访问的URI中
//				for (String string : menuSubString) {
//					if (requestUri.indexOf(string) > 0 || requestUri.contains("/tab.do")) {
//						return true;
//					}
//				}
//				// 重定向到登录页面
//				response.sendRedirect(request.getContextPath() + "/login_toLogin.do");
//				return false;
				return true;
			}
			// 重定向到登录页面
			response.sendRedirect(request.getContextPath() + "/login_toLogin.do");
			return false;
		}
		// 重定向到登录页面
		response.sendRedirect(request.getContextPath() + "/login_toLogin.do");
		return false;
	}
	
}
