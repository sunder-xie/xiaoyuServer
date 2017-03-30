package com.aotu.entity.system;

import com.aotu.entity.BaseEntity;

/**
 * 系统参数
 */
public class Param extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	private String  paramName;// 参数名称
	private String  paramType;// 参数类型
	private String  paramValue;// 参数值
	private String  paramKey;// 参数Key
	
	public String getParamName() {
		return paramName;
	}
	
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	
	public String getParamType() {
		return paramType;
	}
	
	public void setParamType(String paramType) {
		this.paramType = paramType;
	}
	
	public String getParamValue() {
		return paramValue;
	}
	
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
	
	public String getparamKey() {
		return paramKey;
	}
	
	public void setparamKey(String paramKey) {
		this.paramKey = paramKey;
	}

}
