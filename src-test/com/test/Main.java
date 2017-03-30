package com.test;

import com.alibaba.fastjson.JSONObject;

public class Main {

	public static void main(String[] args) {
		StringBuffer sbf = new StringBuffer("{\"id\":1}");
		JSONObject result = JSONObject.parseObject(sbf.toString());
		System.out.println(result);
	}
	
}
