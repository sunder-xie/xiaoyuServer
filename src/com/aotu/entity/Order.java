package com.aotu.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Order extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	private String orderNo;
	private String memberId;
	private String collectorId;
	private String collectorName;
	private String collectorPhone;
	private String name;
	private String phone;
	private String address;
	private String deliverId;
	private String deliverName;
	private String trackingNo;
	private Integer cou;
	private BigDecimal payMoney;
	private Date payDate;
	private String status;
	private String createDateStr;

	private String memberHeadImg;
	private String collectorHeadImg;

	public String getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getMemberId() {
		return this.memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getCollectorId() {
		return this.collectorId;
	}

	public void setCollectorId(String collectorId) {
		this.collectorId = collectorId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDeliverId() {
		return this.deliverId;
	}

	public void setDeliverId(String deliverId) {
		this.deliverId = deliverId;
	}

	public String getDeliverName() {
		return this.deliverName;
	}

	public void setDeliverName(String deliverName) {
		this.deliverName = deliverName;
	}

	public BigDecimal getPayMoney() {
		return this.payMoney;
	}

	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
	}

	public Date getPayDate() {
		return this.payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateDateStr() {
		return this.createDateStr;
	}

	public void setCreateDateStr(String createDateStr) {
		this.createDateStr = createDateStr;
	}

	public Integer getCou() {
		return this.cou;
	}

	public void setCou(Integer cou) {
		this.cou = cou;
	}

	public String getTrackingNo() {
		return this.trackingNo;
	}

	public void setTrackingNo(String trackingNo) {
		this.trackingNo = trackingNo;
	}

	public String getMemberHeadImg() {
		return memberHeadImg;
	}

	public void setMemberHeadImg(String memberHeadImg) {
		this.memberHeadImg = memberHeadImg;
	}

	public String getCollectorHeadImg() {
		return collectorHeadImg;
	}

	public void setCollectorHeadImg(String collectorHeadImg) {
		this.collectorHeadImg = collectorHeadImg;
	}

	public String getCollectorName() {
		return collectorName;
	}

	public void setCollectorName(String collectorName) {
		this.collectorName = collectorName;
	}

	public String getCollectorPhone() {
		return collectorPhone;
	}

	public void setCollectorPhone(String collectorPhone) {
		this.collectorPhone = collectorPhone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}