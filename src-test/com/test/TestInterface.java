package com.test;

import net.sf.json.JSONObject;

import com.weixin.utils.CommonUtil;

public class TestInterface {
	
	public static void main(String[] args) {
		try {
			String requestUrl = "http://127.0.0.1:8001/xiaoyuSever/api/sendOrderMessage";
			JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
			System.out.println(jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
