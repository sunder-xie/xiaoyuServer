package com.aotu.dao;

import org.apache.ibatis.annotations.Param;

/**
 * 系统用户 DAO 
 */
public interface UserDAO extends BaseDAO {
	
	/**
	 * 删除
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public void delete(@Param("id") String id);
	
}