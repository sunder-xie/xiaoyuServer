package com.aotu.entity;


public class Deliver extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	private String deliverNo;
	private String deliverName;
	
	public String getDeliverNo() {
		return deliverNo;
	}

	public void setDeliverNo(String deliverNo) {
		this.deliverNo = deliverNo;
	}

	public String getDeliverName() {
		return deliverName;
	}

	public void setDeliverName(String deliverName) {
		this.deliverName = deliverName;
	}

}
