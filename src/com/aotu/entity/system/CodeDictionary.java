package com.aotu.entity.system;

import com.aotu.entity.BaseEntity;

/**
 * 数据字典
 */
public class CodeDictionary extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	private String codeType;//字典类型
	private String codeTypeName;//字典类型名称
	private String codeKey;//字典Key
	private String codeValue;//字典值
	private Integer sort;//顺序
	
	public String getCodeType() {
		return codeType;
	}
	
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	
	public String getCodeTypeName() {
		return codeTypeName;
	}
	
	public void setCodeTypeName(String codeTypeName) {
		this.codeTypeName = codeTypeName;
	}
	
	public String getCodeKey() {
		return codeKey;
	}
	
	public void setCodeKey(String codeKey) {
		this.codeKey = codeKey;
	}
	
	public String getCodeValue() {
		return codeValue;
	}
	
	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}
	
	public Integer getSort() {
		return sort;
	}
	
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
}
