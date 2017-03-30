package com.aotu.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aotu.entity.Member;
import com.aotu.entity.MerchantSet;
import com.aotu.entity.Order;
import com.aotu.entity.TemplateData;
import com.aotu.entity.WxTemplate;
import com.aotu.service.IMemberService;
import com.aotu.service.IWxTemplateService;
import com.aotu.util.CacheUtil;
import com.aotu.util.WxTemplateUtils;
import com.weixin.utils.CommonUtil;

import net.sf.json.JSONObject;

@Service("wxTemplateService")
public class WxTemplateServiceImpl implements IWxTemplateService {
	
	@Autowired
	private IMemberService memberService;
	
    /**
     * 发送模板消息
     * appId 公众账号的唯一标识
     * appSecret 公众账号的密钥
     * openId 用户标识
     */
    public void sendOrderMessage(Order order) throws Exception {
    	String memberId = order.getMemberId();
    	String collectorId = order.getCollectorId();
    	String status = order.getStatus();
    	WxTemplate wxTemplate = new WxTemplate();
        wxTemplate.setUrl("http://www.wesdzsw.com/api/auth?urlType=2");// TODO 跳转的URL，抽成参数
        Member member = null;
        String statusName = "";
        if ("0".equals(status)) {// 状态：待商家确认,给商户发送信息
        	member = this.memberService.get(collectorId);
        	statusName = "待商家确认";
        } else if ("1".equals(status)) {// 状态：确认送达
        	member = this.memberService.get(memberId);
        	statusName = "确认送达";
        } else if ("2".equals(status)) {// 状态：待确认收货
        	member = this.memberService.get(memberId);
        	statusName = "待确认收货";
        } else if ("3".equals(status)) {// 状态：订单完成
        	member = this.memberService.get(collectorId);
        	statusName = "订单已完成";
        }
        wxTemplate.setTouser(member.getWechatOpenid());
        wxTemplate.setTopcolor("#000000");
        wxTemplate.setTemplate_id("ObIR-VjNFKcx1A-pwSkKHSIvC-qzWBz2maKQddAUXtE");
        Map<String,TemplateData> m = new HashMap<String,TemplateData>();
        TemplateData first = new TemplateData();
        first.setColor("#000000");
        String nickName = member.getWechatName();
        first.setValue("尊敬的" + nickName + ":");
        m.put("first", first);
        TemplateData OrderSn = new TemplateData();
        OrderSn.setColor("#000000");
        String orderNo = order.getOrderNo();
        OrderSn.setValue(orderNo);
        m.put("OrderSn", OrderSn);
        TemplateData OrderStatus = new TemplateData();
        OrderStatus.setColor("#000000");
        OrderStatus.setValue(statusName);
        m.put("OrderStatus", OrderStatus);
        TemplateData remark = new TemplateData();
        remark.setColor("#000000");
        String deliverName = order.getDeliverName();
        String deliverNo = order.getTrackingNo();
        String remarkValue = "物流信息: " + deliverName + "\n"
        		+ "快递单号: " + deliverNo + "\n"
        		+ "点击“详情”查看完整物流信息";
        remark.setValue(remarkValue);
        m.put("remark", remark);
        wxTemplate.setData(m);

        MerchantSet merchantSetCache = CacheUtil.getMerchantSet();
		String appid = merchantSetCache.getAppId();
		String appsecret = merchantSetCache.getAppSecret();
        String URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+ appsecret;
		JSONObject jsonObject = CommonUtil.httpsRequest(URL, "GET", null);
        String access_token = jsonObject.getString("access_token");
    	WxTemplateUtils.sendTemplateMessage(wxTemplate, access_token);
    }
    
}
