package com.test;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aotu.entity.Member;
import com.aotu.service.IMemberService;
import com.aotu.util.ApplicationContextUtil;


@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "file:resource/applicationContext.xml")
@ContextConfiguration(locations = { "classpath:spring-common.xml" })
public class JUnitTest extends AbstractJUnit4SpringContextTests{
	
	@Test
    public void test()  {
		IMemberService memberService = (IMemberService)ApplicationContextUtil.getBean("memberService");
		String memberId = "20160919145344M9pmdmm9";
		List<Member> memberList = new ArrayList<Member>();
		try {
			memberService.querySupMemberList(memberList, memberId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(memberList.size());
		
	}
}
