package com.aotu.entity;

import java.math.BigDecimal;

public class MerchantSet extends BaseEntity
{
  private static final long serialVersionUID = 1L;
  private String merchantName;
  private String merchantNo;
  private String appId;
  private String appSecret;
  private String partner;
  private String partnerKey;
  private BigDecimal rakeProportion;
  private BigDecimal merchantBalance;
  private BigDecimal totalIncomeAmt;
  private BigDecimal totalRedPacketAmt;
  private BigDecimal standardAmt;
  private BigDecimal totalProfitAmt;
  private Integer totalPayCount;
  private String currentStage;

  public String getMerchantName()
  {
    return this.merchantName;
  }

  public void setMerchantName(String merchantName) {
    this.merchantName = merchantName;
  }

  public String getMerchantNo() {
    return this.merchantNo;
  }

  public void setMerchantNo(String merchantNo) {
    this.merchantNo = merchantNo;
  }

  public String getAppId() {
    return this.appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public String getAppSecret() {
    return this.appSecret;
  }

  public void setAppSecret(String appSecret) {
    this.appSecret = appSecret;
  }

  public String getPartner() {
    return this.partner;
  }

  public void setPartner(String partner) {
    this.partner = partner;
  }

  public String getPartnerKey() {
    return this.partnerKey;
  }

  public void setPartnerKey(String partnerKey) {
    this.partnerKey = partnerKey;
  }

  public BigDecimal getRakeProportion() {
    return this.rakeProportion;
  }

  public void setRakeProportion(BigDecimal rakeProportion) {
    this.rakeProportion = rakeProportion;
  }

  public BigDecimal getMerchantBalance() {
    return this.merchantBalance;
  }

  public void setMerchantBalance(BigDecimal merchantBalance) {
    this.merchantBalance = merchantBalance;
  }

  public BigDecimal getTotalIncomeAmt() {
    return this.totalIncomeAmt;
  }

  public void setTotalIncomeAmt(BigDecimal totalIncomeAmt) {
    this.totalIncomeAmt = totalIncomeAmt;
  }

  public BigDecimal getTotalRedPacketAmt() {
    return this.totalRedPacketAmt;
  }

  public void setTotalRedPacketAmt(BigDecimal totalRedPacketAmt) {
    this.totalRedPacketAmt = totalRedPacketAmt;
  }

  public BigDecimal getStandardAmt() {
    return this.standardAmt;
  }

  public void setStandardAmt(BigDecimal standardAmt) {
    this.standardAmt = standardAmt;
  }

  public BigDecimal getTotalProfitAmt() {
    return this.totalProfitAmt;
  }

  public void setTotalProfitAmt(BigDecimal totalProfitAmt) {
    this.totalProfitAmt = totalProfitAmt;
  }

  public Integer getTotalPayCount() {
    return this.totalPayCount;
  }

  public void setTotalPayCount(Integer totalPayCount) {
    this.totalPayCount = totalPayCount;
  }

  public String getCurrentStage() {
    return this.currentStage;
  }

  public void setCurrentStage(String currentStage) {
    this.currentStage = currentStage;
  }
}