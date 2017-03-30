package com.aotu.controller;

import com.aotu.entity.HandlerResponse;
import com.aotu.util.Logger;
import com.aotu.util.PageData;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class ApiBaseController {
	
	public static final String RESPONSE_CODE_SUCCESS = "200";
	public static final String RESPONSE_CODE_FAIL = "100";
	public static final String RESPONSE_CODE_OUTTIME = "407";
	public static String DATE_FORMAT = "yyyy-MM-dd";
	public static final String SM_CODE_CONTENT_FORGOT_PWD = "SM_CODE_CONTENT_FORGOT_PWD";
  
	protected Logger logger = Logger.getLogger(getClass());

	public PageData getPageData() {
		return new PageData(getRequest());
	}

	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}

	public void writeJson(HttpServletResponse response, HandlerResponse handlerResponse)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Access-Control-allow-Origin", "*");
		PrintWriter writer = response.getWriter();
		try {
			JSONObject json = JSONObject.fromObject(handlerResponse);
			writer.print(json.toString());
			this.logger.info("响应内容:" + json.toString());
			writer.close();
		} catch (Exception e) {
			this.logger.error(e);
			e.printStackTrace();
			handlerResponse.setResponseCode("400");
			handlerResponse.setResponseMessage("当前网络问题，请稍后重试。");
			handlerResponse.setResponseObj(null);
		} finally {
			JSONObject json = JSONObject.fromObject(handlerResponse);
			writer.print(json.toString());
			this.logger.info("响应内容:" + json.toString());
			writer.close();
			response.flushBuffer();
		}
	}
	
}