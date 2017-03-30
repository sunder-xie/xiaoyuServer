package com.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.aotu.entity.Member;
import com.aotu.service.IMemberService;
import com.aotu.util.ApplicationContextUtil;
import com.weixin.utils.RandomUtils;

public class PayTest {

	public static void main(String[] args) {
		
		for (int i = 0; i < 1000; i++) {
			BigDecimal result = new BigDecimal(RandomUtils.GetRandomNum(7,22));
			result = result.multiply(new BigDecimal(0.85)).setScale(2, BigDecimal.ROUND_CEILING);
			System.out.println(result.doubleValue());
			if (result.doubleValue() == 1.11 || result.doubleValue() == 2.22
					|| result.doubleValue() == 3.33 || result.doubleValue() == 4.44
					|| result.doubleValue() == 5.55 || result.doubleValue() == 6.66
					|| result.doubleValue() == 7.77 || result.doubleValue() == 8.88
					|| result.doubleValue() == 9.99 || result.doubleValue() == 11.11
					|| result.doubleValue() == 22.22 || result.doubleValue() == 12.34
					|| result.doubleValue() == 1.23 || result.doubleValue() == 4.56
					|| result.doubleValue() == 7.89 || result.doubleValue() == 5.20
					|| result.doubleValue() == 13.14) {
				result = new BigDecimal(RandomUtils.GetRandomNum(14,15));
				System.out.println(result);
				System.out.println("结束");
				break;
			}
			
//			BigDecimal standardAmt = new BigDecimal(7.77);
//			BigDecimal amt = new BigDecimal("7.77");
//			if (amt.doubleValue() == 7.77) {
//				System.out.println(standardAmt.doubleValue());
//				System.out.println(amt.doubleValue());
//				System.out.println(standardAmt.compareTo(amt));
//				System.out.println(standardAmt.subtract(amt));
//			}
		}
		
//		IMemberService memberService = (IMemberService)ApplicationContextUtil.getBean("memberService");
//		String memberId = "20160919145344M9pmdmm9";
//		List<Member> memberList = new ArrayList<Member>();
//		try {
//			memberService.querySupMemberList(memberList, memberId);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(memberList.size());
		
//		BigDecimal standardAmt = new BigDecimal(7.77);
//		BigDecimal amt = new BigDecimal("7.77");
//		if (amt.doubleValue() == 7.77) {
//			System.out.println(standardAmt.doubleValue());
//			System.out.println(amt.doubleValue());
//			System.out.println(standardAmt.compareTo(amt));
//			System.out.println(standardAmt.subtract(amt));
//		}
//		BigDecimal standardAmt = new BigDecimal(1000);
//		BigDecimal amt = new BigDecimal(700);
//		if (amt.compareTo(standardAmt.multiply(new BigDecimal(1.1))) > 0) {
//			System.out.println("吐金阶段");
//		} else if (amt.compareTo(standardAmt.multiply(new BigDecimal(0.9))) < 0) {
//			System.out.println("吸金阶段");
//		} else {
//			System.out.println("平衡阶段");
//		}
//		for (int i = 0; i < 100; i++) {// 110、120、150、200、300、400、500、600、1000、1200、2000、2400、2500、3000、
//			// 3500、3550、4000、4800、5000、6000、7000、7100、8000、8250、9000、9500、10000、10600、11000
//			try {
//				String urlStr = "http://www.luckyyyg.com/api/notify.do?out_trade_no=TEST000001" + i;
//				sendGet(urlStr);
//			}catch (Exception e) {
//				e.printStackTrace();
//				break;
//			}
//		}
	}
	
	/*
	 * 发送URL
	 */
	public static String sendGet(String urlStr) throws Exception {
		try {
			StringBuffer sb = new StringBuffer();
			URL url = new URL(urlStr);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
			String xml = sb.toString();
			return xml;
		} catch (Exception e) {
			throw e;
		}
	}

}
