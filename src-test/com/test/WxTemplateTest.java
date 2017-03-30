package com.test;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.aotu.entity.TemplateData;
import com.aotu.entity.WxTemplate;
import com.aotu.util.WxTemplateUtils;
import com.weixin.utils.CommonUtil;

public class WxTemplateTest {
	
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
        wxTemplate.setUrl("http://www.wesdzsw.com/api/auth?urlType=2");
        wxTemplate.setTouser("oHDFvxGywA5YUJx4Gxb9AzR1ZMiU");
        wxTemplate.setTopcolor("#000000");
        wxTemplate.setTemplate_id("ObIR-VjNFKcx1A-pwSkKHSIvC-qzWBz2maKQddAUXtE");
        Map<String,TemplateData> m = new HashMap<String,TemplateData>();
        TemplateData first = new TemplateData();
        first.setColor("#000000");
        first.setValue("尊敬的Teddy:");
        m.put("first", first);
        TemplateData OrderSn = new TemplateData();
        OrderSn.setColor("#000000");
        OrderSn.setValue("NO2017031000001");
        m.put("OrderSn", OrderSn);
        TemplateData OrderStatus = new TemplateData();
        OrderStatus.setColor("#000000");
        OrderStatus.setValue("确认送达");
        m.put("OrderStatus", OrderStatus);
        TemplateData remark = new TemplateData();
        remark.setColor("#000000");
        String deliverName = "顺丰快递";
        String deliverNo = "000000000000001";
        String remarkValue = "物流信息: " + deliverName + "\n"
        		+ "快递单号: " + deliverNo + "\n"
        		+ "点击“详情”查看完整物流信息";
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
