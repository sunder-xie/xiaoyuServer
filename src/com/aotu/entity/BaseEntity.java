package com.aotu.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aotu.exception.ParameterErrorException;
import com.aotu.util.DateUtil;
import com.aotu.util.ShortUUID;

/**
 * Entity - 基类
 */
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;       // 主键ID
	private Date createDate; // 创建日期
	private Date modifyDate; // 更新日期
	private String remark;// 备注

	public BaseEntity (){
		try {
			this.setId(ShortUUID.genId());
			Date newDate = new SimpleDateFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS).parse(new SimpleDateFormat(DateUtil.FORMAT_YYYY_MM_DD_HH_MM_SS).format(new Date()));
			this.setCreateDate(newDate);
			this.setModifyDate(newDate);
		} catch (ParseException e) {
			throw new ParameterErrorException("Paramter Exception!");
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
