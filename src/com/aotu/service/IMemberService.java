package com.aotu.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.aotu.entity.Member;
import com.aotu.entity.MemberCollector;
import com.aotu.entity.Page;

public abstract interface IMemberService {
	public abstract void save(Member paramMember) throws Exception;

	public abstract void delete(String paramString) throws Exception;

	public abstract void update(Member paramMember) throws Exception;

	public abstract Member get(String paramString) throws Exception;

	public abstract Page queryPage(Page paramPage, Member paramMember) throws Exception;

	public abstract int queryCount(Member paramMember) throws Exception;

	public abstract List<Member> querySum(Member paramMember) throws Exception;

	public abstract List<Member> queryList(Member paramMember) throws Exception;

	public abstract Page queryUsb(Page paramPage, Member paramMember) throws Exception;

	public abstract Member querySupMemberList(List<Member> paramList, String paramString) throws Exception;

	public abstract String generateQrCode(String paramString, HttpServletRequest paramHttpServletRequest)
			throws Exception;

	public abstract List<Member> queryMyCollector(Member paramMember) throws Exception;

	/**
	 * 保存会员代收人关系
	 * @param memberCollector
	 * @throws Exception
	 */
	public void saveMemberCollector(MemberCollector memberCollector) throws Exception;
	
	/**
	 * 获取会员代收人关系列表
	 * @param memberCollector
	 * @return
	 * @throws Exception
	 */
	public abstract List<MemberCollector> queryMemberCollectorList(MemberCollector memberCollector) throws Exception;
	
	
}