package com.aotu.dao;

import com.aotu.entity.system.Param;

/**
 * 系统参数DAO 
 */
public interface ParamDAO extends BaseDAO {
	
	public Param getParamByName(String name);
}