package com.aotu.entity;

/**
 * 会员代收人关系信息表
 */
public class MemberCollector extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	private String memberId;
	private String collectorId;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getCollectorId() {
		return collectorId;
	}

	public void setCollectorId(String collectorId) {
		this.collectorId = collectorId;
	}

}
