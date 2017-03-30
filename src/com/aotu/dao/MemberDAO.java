package com.aotu.dao;

import java.util.List;

import com.aotu.entity.Member;
import com.aotu.entity.MemberCollector;

/**
 * 会员信息 DAO 
 */
public interface MemberDAO extends BaseDAO {

	public abstract List<Member> querySum(Member paramMember);

	public abstract List<Member> queryMyCollector(Member paramMember);
	
	public abstract void saveMemberCollector(MemberCollector memberCollector);
	
	public abstract List<MemberCollector> queryMemberCollectorList(MemberCollector memberCollector);
	
}