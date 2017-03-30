package com.aotu.util.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.aotu.entity.system.CodeDictionary;
import com.aotu.service.ICodeDictionaryService;
import com.aotu.service.impl.CodeDictionaryServiceImpl;
import com.aotu.util.ApplicationContextUtil;

/**
 * 数据字典标签
 */
public class CodeDictionaryTag extends SimpleTagSupport {
	
	private String codeType;
	private String codeKey;
	
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public void setCodeKey(String codeKey) {
		this.codeKey = codeKey;
	}

	public void doTag() throws JspException, IOException {
		try {
			if (codeType != null && !"".equals(codeType)) {
				PageContext pageContext = (PageContext) getJspContext();
//				// 从RequestFilter过滤器中的线程上获取request对象
//				HttpServletRequest request = RequestFilter.threadLocalRequest.get();
//				// Web工具类WebApplicationContextUtils直接获取容器中的Bean实例并调用其方法
//				ApplicationContext applicationContext = WebApplicationContextUtils
//						.getWebApplicationContext(request.getSession().getServletContext());
				ICodeDictionaryService codeDictionaryService = (CodeDictionaryServiceImpl) ApplicationContextUtil
						.getBean("codeDictionaryService");
				CodeDictionary codeDictionaryTemp = new CodeDictionary();
				codeDictionaryTemp.setCodeType(codeType);
				if ("all".equalsIgnoreCase(codeKey)) {
					codeKey = null;
				}
				codeDictionaryTemp.setCodeKey(codeKey);
				List<CodeDictionary> codeDictionaryList = codeDictionaryService.queryList(codeDictionaryTemp);
				if (codeDictionaryList != null && codeDictionaryList.size() > 0) {
					for (CodeDictionary codeDictionary : codeDictionaryList) {
						pageContext.setAttribute("codeDictionary", codeDictionary);
						getJspBody().invoke(null);// 输出主题内容
					}
				}
				pageContext.removeAttribute("codeDictionary");
			}
		} catch (Exception e) {
			// 异常不做处理
		}
		
	}
}
