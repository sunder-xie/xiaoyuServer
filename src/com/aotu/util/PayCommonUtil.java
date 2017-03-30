package com.aotu.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

import com.weixin.utils.MD5Util;

public class PayCommonUtil {

	/**
	 * 是否签名正确,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。
	 * 
	 * @return boolean
	 */
	public static boolean isTenpaySign(String characterEncoding,
			SortedMap<Object, Object> packageParams, String API_KEY) {
		StringBuffer sb = new StringBuffer();
		Set es = packageParams.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if (!"sign".equals(k) && null != v && !"".equals(v)) {
				sb.append(k + "=" + v + "&");
			}
		}

		sb.append("key=" + API_KEY);

		// 算出摘要
		String mysign = MD5Util.MD5Encode(sb.toString(), characterEncoding)
				.toLowerCase();
		String tenpaySign = ((String) packageParams.get("sign")).toLowerCase();

		// System.out.println(tenpaySign + "    " + mysign);
		return tenpaySign.equals(mysign);
	}

	/**
	 * @author
	 * @date 2016-4-22
	 * @Description：sign签名
	 * @param characterEncoding
	 *            编码格式
	 * @param parameters
	 *            请求参数
	 * @return
	 */
	public static String createSign(String characterEncoding,
			SortedMap<Object, Object> packageParams, String API_KEY) {
		StringBuffer sb = new StringBuffer();
		Set es = packageParams.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if (null != v && !"".equals(v) && !"sign".equals(k)
					&& !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("key=" + API_KEY);
		String sign = MD5Util.MD5Encode(sb.toString(), characterEncoding)
				.toUpperCase();
		return sign;
	}

	/**
	 * @author
	 * @date 2016-4-22
	 * @Description：将请求参数转换为xml格式的string
	 * @param parameters
	 *            请求参数
	 * @return
	 */
	public static String getRequestXml(SortedMap<Object, Object> parameters) {
		StringBuffer sb = new StringBuffer();
		sb.append("<xml>");
		Set es = parameters.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if ("attach".equalsIgnoreCase(k) || "body".equalsIgnoreCase(k)
					|| "sign".equalsIgnoreCase(k)) {
				sb.append("<" + k + ">" + "<![CDATA[" + v + "]]></" + k + ">");
			} else {
				sb.append("<" + k + ">" + v + "</" + k + ">");
			}
		}
		sb.append("</xml>");
		return sb.toString();
	}

	/**
	 * 取出一个指定长度大小的随机正整数.
	 * 
	 * @param length
	 *            int 设定所取出随机数的长度。length小于11
	 * @return int 返回生成的随机数。
	 */
	public static int buildRandom(int length) {
		int num = 1;
		double random = Math.random();
		if (random < 0.1) {
			random = random + 0.1;
		}
		for (int i = 0; i < length; i++) {
			num = num * 10;
		}
		return (int) ((random * num));
	}

	/**
	 * 获取当前时间 yyyyMMddHHmmss
	 * 
	 * @return String
	 */
	public static String getCurrTime() {
		Date now = new Date();
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String s = outFormat.format(now);
		return s;
	}

//	public void weixin_notify(HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//
//		// 读取参数
//		InputStream inputStream;
//		StringBuffer sb = new StringBuffer();
//		inputStream = request.getInputStream();
//		String s;
//		BufferedReader in = new BufferedReader(new InputStreamReader(
//				inputStream, "UTF-8"));
//		while ((s = in.readLine()) != null) {
//			sb.append(s);
//		}
//		in.close();
//		inputStream.close();
//
//		// 解析xml成map
//		Map<String, String> m = new HashMap<String, String>();
//		m = XMLUtil.doXMLParse(sb.toString());
//
//		// 过滤空 设置 TreeMap
//		SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
//		Iterator it = m.keySet().iterator();
//		while (it.hasNext()) {
//			String parameter = (String) it.next();
//			String parameterValue = m.get(parameter);
//
//			String v = "";
//			if (null != parameterValue) {
//				v = parameterValue.trim();
//			}
//			packageParams.put(parameter, v);
//		}
//
//		// 账号信息
//		String key = PayConfigUtil.API_KEY; // key
//
//		logger.info(packageParams);
//		// 判断签名是否正确
//		if (PayCommonUtil.isTenpaySign("UTF-8", packageParams, key)) {
//			// ------------------------------
//			// 处理业务开始
//			// ------------------------------
//			String resXml = "";
//			if ("SUCCESS".equals((String) packageParams.get("result_code"))) {
//				// 这里是支付成功
//				// ////////执行自己的业务逻辑////////////////
//				String mch_id = (String) packageParams.get("mch_id");
//				String openid = (String) packageParams.get("openid");
//				String is_subscribe = (String) packageParams
//						.get("is_subscribe");
//				String out_trade_no = (String) packageParams
//						.get("out_trade_no");
//
//				String total_fee = (String) packageParams.get("total_fee");
//
//				logger.info("mch_id:" + mch_id);
//				logger.info("openid:" + openid);
//				logger.info("is_subscribe:" + is_subscribe);
//				logger.info("out_trade_no:" + out_trade_no);
//				logger.info("total_fee:" + total_fee);
//
//				// ////////执行自己的业务逻辑////////////////
//
//				logger.info("支付成功");
//				// 通知微信.异步确认成功.必写.不然会一直通知后台.八次之后就认为交易失败了.
//				resXml = "<xml>"
//						+ "<return_code><![CDATA[SUCCESS]]></return_code>"
//						+ "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
//
//			} else {
//				logger.info("支付失败,错误信息：" + packageParams.get("err_code"));
//				resXml = "<xml>"
//						+ "<return_code><![CDATA[FAIL]]></return_code>"
//						+ "<return_msg><![CDATA[报文为空]]></return_msg>"
//						+ "</xml> ";
//			}
//			// ------------------------------
//			// 处理业务完毕
//			// ------------------------------
//			BufferedOutputStream out = new BufferedOutputStream(
//					response.getOutputStream());
//			out.write(resXml.getBytes());
//			out.flush();
//			out.close();
//		} else {
//			logger.info("通知签名验证失败");
//		}
//
//	}
}
