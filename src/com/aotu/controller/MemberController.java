package com.aotu.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aotu.entity.Member;
import com.aotu.entity.Page;
import com.aotu.service.IMemberService;

/**
 * 会员信息 Controller
 */
@Controller
@RequestMapping(value="/member")
public class MemberController extends BaseController {
	
	@Resource(name="memberService")
	private IMemberService memberService;
	
	/**
	 * 查询列表 - 分页
	 */
	@RequestMapping("/queryList.do")
	public String queryList(Member member, Page page, Model model) throws Exception {
		page = this.memberService.queryPage(page, member);
		model.addAttribute("page", page);
		model.addAttribute("member", member);
		return "member/memberList";
	}
	
	/**
	 * 查看下级
	 */
	@RequestMapping("/querySubList.do")
	public String querySubList(String id, Page page, Model model) throws Exception {
		Member member = this.memberService.get(id);
		Member memberTemp = new Member();
		memberTemp.setSuperiorMemberId(member.getId());
		page = this.memberService.queryPage(page, memberTemp);
		model.addAttribute("page", page);
		model.addAttribute("member", member);
		return "member/subMemberList";
	}
	
	/**
	 * 升级代理级别
	 */
	@RequestMapping("/upgrade.do")
	public String upgrade(String id, Model model) throws Exception {
		Member member = this.memberService.get(id);
		member.setRank("1");
		this.memberService.update(member);
		return "redirect:/member/queryList.do";
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete.do")
	public String delete(String id, Model model) throws Exception {
		this.memberService.delete(id);
		return "redirect:/member/queryList.do";
	}
	
	/**
	 * 停用/启用
	 */
	@RequestMapping("/stopOrUsing.do")
	public String stopOrUsing(String id,String status, Model model) throws Exception {
		Member member = this.memberService.get(id);
		member.setStatus(status);
		this.memberService.update(member);
		return "redirect:/member/queryList.do";
	}
	
}
