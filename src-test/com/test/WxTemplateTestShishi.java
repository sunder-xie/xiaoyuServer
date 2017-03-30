package com.test;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.aotu.entity.TemplateData;
import com.aotu.entity.WxTemplate;
import com.aotu.util.WxTemplateUtils;
import com.weixin.utils.CommonUtil;

/**
 * 实时交易提醒
 * @author Administrator
 *
 */
public class WxTemplateTestShishi {
	
	public static void main(String[] args) {
		try {
			sendOrderMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    /**
     * 发送模板消息
     * appId 公众账号的唯一标识
     * appSecret 公众账号的密钥
     * openId 用户标识
     */
    public static void sendOrderMessage() throws Exception {
    	WxTemplate wxTemplate = new WxTemplate();
        wxTemplate.setUrl("http://www.jingyubao.com");
        wxTemplate.setTouser("oHDFvxGywA5YUJx4Gxb9AzR1ZMiU");
        wxTemplate.setTopcolor("#000000");
        wxTemplate.setTemplate_id("-QfhhquyUOySIRdBi8-DmWKf4hc3K9KYKevOn_NEihI");
        Map<String,TemplateData> m = new HashMap<String,TemplateData>();
        TemplateData first = new TemplateData();
        first.setColor("#436EEE");
        first.setValue("您好，您有一笔资金转入成功！");
        m.put("first", first);
        
        TemplateData tradeDateTime = new TemplateData();
        tradeDateTime.setColor("#000000");
        tradeDateTime.setValue("2017年3月13日 10:42:12");
        m.put("tradeDateTime", tradeDateTime);
        
        TemplateData tradeType = new TemplateData();
        tradeType.setColor("#000000");
        tradeType.setValue("平安银行卡(尾号1180)转至鲸鱼活期");
        m.put("tradeType", tradeType);
        
        TemplateData curAmount = new TemplateData();
        curAmount.setColor("#436EEE");
        curAmount.setValue("4999元");
        m.put("curAmount", curAmount);
        
        TemplateData remark = new TemplateData();
        remark.setColor("#436EEE");
        String remarkValue = "计息时间：2017年3月13日\n"
        		+ "账户总资产：11499元\n"
        		+ "\n"
        		+ "鲸鱼理财：懒人理财神器，对接债权来自世界500强金融机构，收益高达3.5%~9.4%。一元起投，保本保息，担保无忧\n";
        remark.setValue(remarkValue);
        m.put("remark", remark);
        wxTemplate.setData(m);

		String appid = "wxb525897301aca7ff";
		String appsecret = "e05c3160fe8f53b7c07f2dc313427eb7";
        String URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+ appsecret;
		JSONObject jsonObject = CommonUtil.httpsRequest(URL, "GET", null);
        String access_token = jsonObject.getString("access_token");
    	WxTemplateUtils.sendTemplateMessage(wxTemplate, access_token);
    }
    
}
