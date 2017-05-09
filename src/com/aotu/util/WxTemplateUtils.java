package com.aotu.util;

import javax.servlet.http.HttpServletRequest;

import com.aotu.entity.WxTemplate;
import com.weixin.utils.CommonUtil;

import net.sf.json.JSONObject;

public class WxTemplateUtils {

	protected static Logger logger = Logger.getLogger(WxTemplateUtils.class);
	
    public static void sendTemplateMessage(WxTemplate wxTemplate, String access_token) {
    	logger.info(">>>>>>>>>> access_token <<<<<<<<<< " + access_token);
    	String jsonStr = JSONObject.fromObject(wxTemplate).toString();
    	String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + access_token;
        JSONObject jsonObj = CommonUtil.httpsRequest(url, "POST", jsonStr);// 发送URL请求
        logger.info("jsonObj >>>>>>>>> " + jsonObj);
        int result = 0;
        if (null != jsonObj) {  
             if (0 != jsonObj.getInt("errcode")) {  
                 result = jsonObj.getInt("errcode");
                 logger.error("错误 errcode:{} errmsg:{}" + jsonObj.getInt("errcode") + "|" + jsonObj.getString("errmsg"));  
             }  
         }
        logger.info("模板消息发送结果："+result);
    }
    
    public static void sendTemplateMessageNew(HttpServletRequest request, WxTemplate wxTemplate) {
    	int i = 0;
    	while (true) {
    		String access_token = (String)request.getSession().getAttribute("access_token");
        	logger.info(">>>>>>>>>> access_token <<<<<<<<<< " + access_token);
        	String jsonStr = JSONObject.fromObject(wxTemplate).toString();
        	String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + access_token;
        	JSONObject jsonObj = CommonUtil.httpsRequest(url, "POST", jsonStr);// 发送URL请求
        	logger.info("jsonObj >>>>>>>>> " + jsonObj);
        	String errcode = "";
        	if (null != jsonObj) {
        		errcode = jsonObj.getString("errcode");
        		if (!"0".equals(errcode)) {  
        			logger.error("错误 errcode:{} errmsg:{}" + errcode + "|" + jsonObj.getString("errmsg"));  
        		}
        		if ("40001".equals(errcode)) {
        			String appid = "wxb525897301aca7ff";
        			String appsecret = "e05c3160fe8f53b7c07f2dc313427eb7";
        			String URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+ appsecret;
        			JSONObject jsonObject = CommonUtil.httpsRequest(URL, "GET", null);
        			access_token = jsonObject.getString("access_token");
        			request.getSession().setAttribute("access_token", access_token);
        			logger.info(">>>>>>>>>> 重新获取的access_token为  <<<<<<<<<< " + access_token);
        			if (i == 2) {
        				break;
        			}
        			i++;
        			continue;
        		}
        	}
        	logger.info("模板消息发送结果：" + errcode);
        	break;
    	}
    	
    }
    
}
