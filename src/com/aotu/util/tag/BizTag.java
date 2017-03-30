package com.aotu.util.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 业务标签
 */
public class BizTag extends SimpleTagSupport {
	//类型  要查询的类的标识
	private String type;
	//编号  数据编号 可精确到一条记录
	private String code;
	
	public void setType(String type) {
		this.type = type;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void doTag() throws JspException, IOException {
		if (code != null && !"".equals(code)) {
			//从RequestFilter过滤器中的线程上获取request对象
//			HttpServletRequest request = RequestFilter.threadLocalRequest.get();
//			//Web工具类WebApplicationContextUtils直接获取容器中的Bean实例并调用其方法
//			ApplicationContext applicationContext = WebApplicationContextUtils
//					.getWebApplicationContext(request.getSession()
//							.getServletContext());
			PageContext pageContext = (PageContext) getJspContext();
			pageContext.removeAttribute("obj");
		}else {
			//输出主题内容
			getJspBody().invoke(null);
		}
	}
}
