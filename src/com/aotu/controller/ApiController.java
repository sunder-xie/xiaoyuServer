package com.aotu.controller;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aotu.entity.Deliver;
import com.aotu.entity.HandlerResponse;
import com.aotu.entity.Member;
import com.aotu.entity.MemberCollector;
import com.aotu.entity.MerchantSet;
import com.aotu.entity.Order;
import com.aotu.entity.Page;
import com.aotu.entity.system.Param;
import com.aotu.service.IDeliverService;
import com.aotu.service.IMemberService;
import com.aotu.service.IMerchantSetService;
import com.aotu.service.IOrderService;
import com.aotu.service.IParamService;
import com.aotu.service.IWxTemplateService;
import com.aotu.util.CacheUtil;
import com.aotu.util.DateUtil;
import com.aotu.util.PageData;
import com.aotu.util.PayCommonUtil;
import com.weixin.utils.CommonUtil;
import com.weixin.utils.GetWxOrderno;
import com.weixin.utils.Sha1Util;

import jodd.util.StringUtil;
import net.sf.json.JSONObject;

@Controller
@RequestMapping({"/api"})
public class ApiController extends ApiBaseController {

	@Resource(name="memberService")
	private IMemberService memberService;
	@Resource(name="orderService")
	private IOrderService orderService;
	@Resource(name="deliverService")
	private IDeliverService deliverService;
//	@Resource(name="weixinService")
//	private IWeixinService weixinService;
	@Resource(name="paramService")
	private IParamService paramService;
	@Resource(name="merchantSetService")
	private IMerchantSetService merchantSetService;
	@Resource(name="wxTemplateService")
	private IWxTemplateService wxTemplateService;
	
	/**
	 * 微信授权
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping({"/auth"})
	public void auth(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String urlType = request.getParameter("urlType");
		String memberId = request.getParameter("memberId");
		MerchantSet merchantSetCache = CacheUtil.getMerchantSet();
		String appid = merchantSetCache.getAppId();
		String backUri = "http://" +request.getServerName() + "/api/toPay.do?urlType=" + urlType
				+ "&memberId=" + memberId;
		backUri = URLEncoder.encode(backUri);
		String scope = "snsapi_userinfo";
		if (urlType != null && !"".equals(urlType) && !"4".equals(urlType)) {
			scope = "snsapi_userinfo";
//			scope = "snsapi_base";
		}
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?" +
				"appid=" + appid+
				"&redirect_uri=" + backUri+
				"&response_type=code&scope=" + scope + "&state=123#wechat_redirect";
		response.sendRedirect(url);
	}
	
	/**
	 * 授权跳转的页面，用于注册或者获取会员信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping({"/toPay"})
	public void toPay(HttpServletRequest request, HttpServletResponse response) throws Exception {
		this.logger.info(">>>>>>>>>> 请求接口：toPay <<<<<<<<<< ");
		String urlType = request.getParameter("urlType");
		Member memberSession = new Member(); 
		MerchantSet merchantSetCache = CacheUtil.getMerchantSet();
		String appid = merchantSetCache.getAppId();
		String appsecret = merchantSetCache.getAppSecret();
		String code = request.getParameter("code");
		String access_token = "";
		String URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appid + "&secret=" + appsecret + "&code=" + code + "&grant_type=authorization_code";
		JSONObject jsonObject = CommonUtil.httpsRequest(URL, "GET", null);
		if (jsonObject != null && jsonObject.containsKey("openid")) {
			String openId = jsonObject.getString("openid");
			access_token = jsonObject.getString("access_token");
			logger.info(">>>>>>>>>> access_token <<<<<<<<<" + access_token);
			URL = "https://api.weixin.qq.com/sns/userinfo?access_token=" + access_token + "&openid=" + openId + "&lang=zh_CN";
			jsonObject = CommonUtil.httpsRequest(URL, "GET", null);
				
			memberSession.setWechatOpenid(openId);
			List<Member> memberList = this.memberService.queryList(memberSession);
			if (memberList == null || memberList.size() <= 0) {
				memberSession.setWechatName(jsonObject.getString("nickname"));
				memberSession.setHeadImg(jsonObject.getString("headimgurl"));
				memberSession.setSex(jsonObject.getString("sex"));
				memberSession.setCountry(jsonObject.getString("country"));
				memberSession.setProvince(jsonObject.getString("province"));
				memberSession.setCity(jsonObject.getString("city"));
				memberSession.setWechatOpenid(openId);
				memberSession.setRank("3");
				memberSession.setMemberType("1");// 默认为普通会员
				memberSession.setStatus("1");
					
				String memberNo = this.paramService.getParamValueByName("memberNoSeq");
				int memberNoInt = new Integer(memberNo).intValue() + 1;
				memberSession.setMemberNo("ID000" + String.valueOf(memberNoInt));
				Param param = this.paramService.getParamByName("memberNoSeq");
				param.setParamValue(String.valueOf(memberNoInt));
				this.paramService.update(param);
					
				this.memberService.save(memberSession);
			} else {
				memberSession = memberList.get(0);
			}
		} else {
			response.sendRedirect("http://" +request.getServerName() + "/api/auth");
		}
		String urlParams = "?memberId=" + memberSession.getId()
				+ "&memberType=" + memberSession.getMemberType()
				+ "&memberNo=" + memberSession.getMemberNo()
				+ "&nickName=" + memberSession.getWechatName() 
				+ "&headImg=" + memberSession.getHeadImg()
				+ "&urlType=" + urlType;
//				+ "&token=" + access_token;
		String redirectUrl = "http://" +request.getServerName() + "/xiaoyuClient/#/tab/";
		if ("1".equals(urlType)) {// 跳转到申请代收
			redirectUrl = redirectUrl + "wantToCollect";
		} else if ("2".equals(urlType)) {// 跳转到代收单
			redirectUrl = redirectUrl + "account";
		} else if ("3".equals(urlType)) {// 跳转到我的资料
			redirectUrl = redirectUrl + "memberInfo";
		} else if ("4".equals(urlType)) {// 跳转到关注代收人
			redirectUrl = redirectUrl + "followCollect";
			String collectorId = request.getParameter("memberId");
			MemberCollector memberCollector = new MemberCollector();
			memberCollector.setMemberId(memberSession.getId());
			memberCollector.setCollectorId(collectorId);
			List<MemberCollector> memberCollectorList = this.memberService.queryMemberCollectorList(memberCollector);
			String flag = "0";
			if (memberCollectorList != null && memberCollectorList.size() > 0) {
				flag = "1";
			}
			urlParams = urlParams + "&collectorId=" + collectorId + "&flag=" + flag;
		}
		redirectUrl = redirectUrl + urlParams;
		this.logger.info(">>>>>>>>>> redirectUrl <<<<<<<<<< " + redirectUrl);
		response.sendRedirect(redirectUrl);
	}

	/**
	 * 获取会员信息（包括代收人信息）
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping({"/getMemberInfo"})
	public void getMemberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		this.logger.info(">>>>>>>>>> 请求接口：getMemberInfo <<<<<<<<<< ");
		this.validateWechat(request, response);
		HandlerResponse handlerResponse = new HandlerResponse();
		try {
			PageData pageData = getPageData();
			this.logger.info("请求参数 >>>>> " + pageData);
			String memberId = pageData.getString("memberId");
			if (StringUtil.isEmpty(memberId)) {
				throw new Exception("传入参数有误，请检查参数是否正确");
			}
			Member member = this.memberService.get(memberId);
			handlerResponse.setResponseCode("200");
			handlerResponse.setResponseObj(member);
			handlerResponse.setResponseMessage("获取会员信息成功！");
		} catch (Exception e) {
			this.logger.error("getMemberInfo[异常] >>>>> " + e.getMessage());
			handlerResponse.setResponseCode("100");
			handlerResponse.setResponseMessage("获取会员信息失败，请联系客服人员");
		} finally {
			writeJson(response, handlerResponse);
		}
	}
	
	/**
	 * 更新会员信息（包括代收人）
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping({"/updateMember"})
	public void updateMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		this.logger.info(">>>>>>>>>> 请求接口：updateMember <<<<<<<<<< ");
		this.validateWechat(request, response);
		HandlerResponse handlerResponse = new HandlerResponse();
		try {
			PageData pageData = getPageData();
			this.logger.info("请求参数 >>>>> " + pageData);
			String memberId = pageData.getString("memberId");
			String name = pageData.getString("name");
			String address = pageData.getString("address");
			String phone = pageData.getString("phone");
			if (StringUtil.isEmpty(memberId) || StringUtil.isEmpty(name)
					|| StringUtil.isEmpty(address) || StringUtil.isEmpty(phone)) {
				throw new Exception("传入参数有误，请检查参数是否正确");
			}
			Member member = this.memberService.get(memberId);
			member.setAddress(address);
			member.setPhone(phone);
			member.setCollectorName(name);
			this.memberService.update(member);
			handlerResponse.setResponseCode("200");
			handlerResponse.setResponseObj(member);
			handlerResponse.setResponseMessage("更新会员信息成功！");
		} catch (Exception e) {
			this.logger.error("updateMember[异常] >>>>> " + e.getMessage());
			handlerResponse.setResponseCode("100");
			handlerResponse.setResponseMessage("更新会员信息失败，请联系客服人员");
		} finally {
			writeJson(response, handlerResponse);
		}
	}
	
	/**
	 * 会员添加代收人
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping({"/addCollector"})
	public void addCollector(HttpServletRequest request, HttpServletResponse response) throws Exception {
		this.logger.info(">>>>>>>>>> 请求接口：addCollector <<<<<<<<<< ");
		this.validateWechat(request, response);
		HandlerResponse handlerResponse = new HandlerResponse();
		try {
			PageData pageData = getPageData();
			this.logger.info("请求参数 >>>>> " + pageData);
			String memberId = pageData.getString("memberId");
			String collectorId = pageData.getString("collectorId");
			if (StringUtil.isEmpty(memberId) || StringUtil.isEmpty(collectorId)) {
				throw new Exception("传入参数有误，请检查参数是否正确");
			}
			MemberCollector memberCollector = new MemberCollector();
			memberCollector.setMemberId(memberId);
			memberCollector.setCollectorId(collectorId);
			List<MemberCollector> memberCollectorList = this.memberService.queryMemberCollectorList(memberCollector);
			if (memberCollectorList != null && memberCollectorList.size() > 0) {
				throw new Exception("您已关注该代收人，无需重复关注");
			}
			this.memberService.saveMemberCollector(memberCollector);
			handlerResponse.setResponseCode("200");
			handlerResponse.setResponseMessage("会员添加代收人信息成功！");
		} catch (Exception e) {
			this.logger.error("addCollector[异常] >>>>> " + e.getMessage());
			handlerResponse.setResponseCode("100");
			handlerResponse.setResponseMessage("会员添加代收人信息失败，请联系客服人员");
		} finally {
			writeJson(response, handlerResponse);
		}
	}
	
	/**
	 * 申请成为代收人
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping({"/applyCollector"})
	public void applyCollector(HttpServletRequest request, HttpServletResponse response) throws Exception {
		this.logger.info(">>>>>>>>>> 请求接口：applyCollector <<<<<<<<<< ");
		this.validateWechat(request, response);
		HandlerResponse handlerResponse = new HandlerResponse();
		try {
			PageData pageData = getPageData();
			this.logger.info("请求参数 >>>>> " + pageData);
			String memberId = pageData.getString("memberId");
			String phone = pageData.getString("phone");
			String collectorName = pageData.getString("collectorName");
			String address = pageData.getString("address");
			if ((StringUtil.isEmpty(memberId)) || (StringUtil.isEmpty(phone)) || 
					(StringUtil.isEmpty(collectorName)) || (StringUtil.isEmpty(address))) {
				throw new Exception("传入参数有误，请检查参数是否正确");
			}
			Member member = this.memberService.get(memberId);
			member.setPhone(phone);
			member.setAddress(address);
			member.setCollectorName(collectorName);
			this.memberService.update(member);
			handlerResponse.setResponseCode("200");
			handlerResponse.setResponseMessage("申请成为代收人成功！");
		} catch (Exception e) {
			this.logger.error("applyCollector[异常] >>>>> " + e.getMessage());
			handlerResponse.setResponseCode("100");
			handlerResponse.setResponseMessage("申请成为代收人失败，请联系客服人员");
		} finally {
			writeJson(response, handlerResponse);
		}
	}

	/**
	 * 我要申请代收
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping({"/wantToCollect"})
	public void wantToCollect(HttpServletRequest request, HttpServletResponse response) throws Exception {
		this.logger.info(">>>>>>>>>> 请求接口：wantToCollect <<<<<<<<<< ");
		this.validateWechat(request, response);
		HandlerResponse handlerResponse = new HandlerResponse();
		try {
			PageData pageData = getPageData();
			this.logger.info("请求参数 >>>>> " + pageData);
			String memberId = pageData.getString("memberId");
			String phone = pageData.getString("phone");
			String name = pageData.getString("name");
			String address = pageData.getString("address");
			String deliverId = pageData.getString("deliverId");
			String trackingNo = pageData.getString("trackingNo");
			String collectorId = pageData.getString("collectorId");
			String cou = pageData.getString("cou");
			String remark = pageData.getString("remark");
			if ((StringUtil.isEmpty(memberId)) || (StringUtil.isEmpty(phone)) 
					|| (StringUtil.isEmpty(name)) || (StringUtil.isEmpty(deliverId))
					|| (StringUtil.isEmpty(collectorId))) {
				throw new Exception("传入参数有误，请检查参数是否正确");
			}
			Order order = new Order();
			order.setCollectorId(collectorId);
			order.setDeliverId(deliverId);
			order.setTrackingNo(trackingNo);
			order.setMemberId(memberId);
			order.setName(name);
			order.setAddress(address);
			String orderNo = DateUtil.dateToStrDateWithFormat(new Date(), "yyyyMMddHHmmss");
			order.setOrderNo(orderNo + Sha1Util.getTimeStamp());
			order.setPayDate(new Date());
			order.setPayMoney(null);
			order.setPhone(phone);
			order.setStatus("0");
			order.setCou(new Integer(cou));
			order.setRemark(remark);
			this.orderService.save(order);
			try {
				this.wxTemplateService.sendOrderMessage(order);// 发送模板消息
			} catch(Exception e) {
				logger.error("wxTemplateService.sendOrderMessage[异常] >>>>> " + e.getMessage());
			}
			handlerResponse.setResponseCode("200");
			handlerResponse.setResponseMessage("申请代收成功！");
		} catch (Exception e) {
			this.logger.error("wantToCollect[异常] >>>>> " + e.getMessage());
			handlerResponse.setResponseCode("100");
			handlerResponse.setResponseMessage("申请代收失败，请稍后重试或联系客服人员");
		} finally {
			writeJson(response, handlerResponse);
		}
	}

	/**
	 * 变更订单状态
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping({"/changeOrderStatus"})
	public void changeOrderStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
		this.logger.info(">>>>>>>>>> 请求接口：changeOrderStatus <<<<<<<<<< ");
		this.validateWechat(request, response);
		HandlerResponse handlerResponse = new HandlerResponse();
		try {
			PageData pageData = getPageData();
			this.logger.info("请求参数 >>>>> " + pageData);
			String orderId = pageData.getString("orderId");
			String status = pageData.getString("status");
			if ((StringUtil.isEmpty(orderId)) || (StringUtil.isEmpty(status))) {
				throw new Exception("传入参数有误，请检查参数是否正确");
			}
			Order order = this.orderService.get(orderId);
			order.setStatus(status);
			this.orderService.changeStatus(order);
			try {
				this.wxTemplateService.sendOrderMessage(order);// 发送模板消息
			} catch(Exception e) {
				logger.error("wxTemplateService.sendOrderMessage[异常] >>>>> " + e.getMessage());
			}
			handlerResponse.setResponseCode("200");
			handlerResponse.setResponseMessage("订单状态变更成功！");
		} catch (Exception e) {
			this.logger.error("changeOrderStatus[异常] >>>>> " + e.getMessage());
			handlerResponse.setResponseCode("100");
			handlerResponse.setResponseMessage("订单状态变更失败，请稍后重试或联系客服人员");
		} finally {
			writeJson(response, handlerResponse);
		}
	}

	/**
	 * 查询我的订单
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping({"/queryOrderList"})
	public void queryOrderList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		this.logger.info(">>>>>>>>>> 请求接口：queryOrderList <<<<<<<<<< ");
		this.validateWechat(request, response);
		HandlerResponse handlerResponse = new HandlerResponse();
		try {
			PageData pageData = getPageData();
			this.logger.info("请求参数 >>>>> " + pageData);
			String status = pageData.getString("status");
			String orderId = pageData.getString("orderId");
			String memberId = pageData.getString("memberId");
			String collectorId = pageData.getString("collectorId");
			String pageNum = pageData.getString("pageNum");
			if (StringUtil.isEmpty(pageNum)) {
				throw new Exception("传入参数有误，请检查参数是否正确");
			}
			Page page = new Page();
			page.setPageNum(Integer.valueOf(pageNum).intValue());
			Order order = new Order();
			order.setId(orderId);
			order.setStatus(status);
			order.setMemberId(memberId);
			order.setCollectorId(collectorId);
			page = this.orderService.queryPage(page, order);

			handlerResponse.setResponseObj(page);
			handlerResponse.setResponseCode("200");
			handlerResponse.setResponseMessage("订单数据查询成功！");
		} catch (Exception e) {
			this.logger.error("订单数据查询异常 >>>>> " + e);
			handlerResponse.setResponseCode("100");
			handlerResponse.setResponseMessage("订单数据查询失败，请联系客服人员");
		} finally {
			writeJson(response, handlerResponse);
		}
	}

	/**
	 * 我的二维码
	 * @param response
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping({"/myQrCode"})
	public void myQrCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		this.logger.info(">>>>>>>>>> 请求接口：myQrCode <<<<<<<<<< ");
		this.validateWechat(request, response);
		HandlerResponse handlerResponse = new HandlerResponse();
		try {
			PageData pageData = getPageData();
			this.logger.info("请求参数 >>>>> " + pageData);
			String memberId = pageData.getString("memberId");
			if (StringUtil.isEmpty(memberId)) {
				throw new Exception("传入参数有误，请检查参数是否正确");
			}
			String qrCodeUrl = this.memberService.generateQrCode(memberId, request);
			this.logger.info(">>>>>>>>>> qrCodeUrl <<<<<<<<<< " + qrCodeUrl);
			handlerResponse.setResponseObj(qrCodeUrl);
			handlerResponse.setResponseCode("200");
			handlerResponse.setResponseMessage("二维码生成成功！");
		} catch (Exception e) {
			this.logger.error("二维码生成异常 >>>>> " + e);
			handlerResponse.setResponseCode("100");
			handlerResponse.setResponseMessage("二维码生成失败，请稍后重试或联系客服人员");
		} finally {
			writeJson(response, handlerResponse);
		}
	}

	/**
	 * 我的可用代收人列表
	 */
	@RequestMapping({"/myCollectorList"})
	public void myCollectorList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		this.logger.info(">>>>>>>>>> 请求接口：myCollectorList <<<<<<<<<< ");
		this.validateWechat(request, response);
		HandlerResponse handlerResponse = new HandlerResponse();
		try {
			PageData pageData = getPageData();
			this.logger.info("请求参数 >>>>> " + pageData);
			String memberId = pageData.getString("memberId");
			if (StringUtil.isEmpty(memberId)) {
				throw new Exception("传入参数有误，请检查参数是否正确");
			}
			Member member = new Member();
			member.setMemberType("1");
			member.setId(memberId);
			List<Member> memberList = this.memberService.queryMyCollector(member);

			handlerResponse.setResponseObj(memberList);
			handlerResponse.setResponseCode("200");
			handlerResponse.setResponseMessage("我的代收点数据查询成功！");
		} catch (Exception e) {
			this.logger.error("我的代收点数据查询异常 >>>>> " + e);
			handlerResponse.setResponseCode("100");
			handlerResponse.setResponseMessage("我的代收点数据查询失败，请联系客服人员");
		} finally {
			writeJson(response, handlerResponse);
		}
	}

	/**
	 * 快递公司列表
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping({"/deliverList"})
	public void deliverList(HttpServletResponse response) throws Exception {
		this.logger.info(">>>>>>>>>> 请求接口：deliverList <<<<<<<<<< ");
		HandlerResponse handlerResponse = new HandlerResponse();
		try {
			List<Deliver> deliverList = this.deliverService.queryList(new Deliver());
			handlerResponse.setResponseObj(deliverList);
			handlerResponse.setResponseCode("200");
			handlerResponse.setResponseMessage("快递公司数据查询成功！");
		} catch (Exception e) {
			this.logger.error("快递公司数据查询异常 >>>>> " + e);
			handlerResponse.setResponseCode("100");
			handlerResponse.setResponseMessage(e.getMessage());
		} finally {
			writeJson(response, handlerResponse);
		}
	}
	
	/**
	 * 微信回调
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping({"/notify"})
	public void notify(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		System.out.println("微信支付回调开始");
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		request.getInputStream().close();
		System.out.println("sb >>>>>> " + sb.toString());

		sb = new StringBuilder("<xml><appid><![CDATA[wxba27d22962d8af13]]></appid><attach><![CDATA[b88001]]></attach><bank_type><![CDATA[CMB_CREDIT]]></bank_type><cash_fee><![CDATA[1000]]></cash_fee><fee_type><![CDATA[CNY]]></fee_type><is_subscribe><![CDATA[N]]></is_subscribe><mch_id><![CDATA[1381042202]]></mch_id><nonce_str><![CDATA[2226562376]]></nonce_str><openid><![CDATA[oEOf4wIBc4JcZ-_zxxYLa7AgMmEc]]></openid><out_trade_no><![CDATA[wxba27d22962d8af131473344801]]></out_trade_no><result_code><![CDATA[SUCCESS]]></result_code><return_code><![CDATA[SUCCESS]]></return_code><sign><![CDATA[3DC87C78930B6EBD1F9197144E6FBE67]]></sign><time_end><![CDATA[20160908222712]]></time_end><total_fee>1000</total_fee><trade_type><![CDATA[JSAPI]]></trade_type><transaction_id><![CDATA[4007972001201609083458688481]]></transaction_id></xml>");
	    Map map = GetWxOrderno.doXMLParse(sb.toString());

	    SortedMap newPackageParams = new TreeMap();
	    Iterator it = map.keySet().iterator();
	    while (it.hasNext()) {
	    	String parameter = (String)it.next();
	    	String parameterValue = (String)map.get(parameter);
	    	String v = "";
	    	if (parameterValue != null) {
	    		v = parameterValue.trim();
	    	}
	    	newPackageParams.put(parameter, v);
	    }
	    MerchantSet merchantSetCache = CacheUtil.getMerchantSet();
	    if (PayCommonUtil.isTenpaySign("UTF-8", newPackageParams, merchantSetCache.getPartnerKey())) {
	    	String return_code = (String)map.get("return_code");
	    	String resXml = "";

	    	if ("SUCCESS".equals(return_code)) {
	    		String out_trade_no = (String)map.get("out_trade_no");
	    		String openid = (String)map.get("openid");
	    		String total_fee = (String)map.get("total_fee");

	    		out_trade_no = request.getParameter("out_trade_no");
	    		resXml = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml> ";
	    	} else {
	    		resXml = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[报文为空]]></return_msg></xml> ";
	    	}

	    	BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
	    	out.write(resXml.getBytes());
	    	out.flush();
	    	out.close();
	    	System.out.println("微信支付回调结束");
	    }
	}
	
	// 微信校验
	private void validateWechat(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
//		Member memberSession = (Member)request.getSession().getAttribute("memberSession");
//		if (memberSession == null) {
//			this.logger.info(">>>>>>>>>> 未进行微信授权 <<<<<<<<<< ");
//			response.sendRedirect("http://www.luckyyyg.com/api/auth.do");
//		}
	}
  
}