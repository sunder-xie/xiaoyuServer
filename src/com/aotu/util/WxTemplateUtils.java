package com.aotu.util;

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
    
}
