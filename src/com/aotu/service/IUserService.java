package com.aotu.service;

import java.util.List;

import com.aotu.entity.Page;
import com.aotu.entity.system.User;

/**
 * 系统用户 Service
 */
public interface IUserService {

	/**
	 * 新增
	 * @param user
	 * @throws Exception
	 */
	public void save(User user) throws Exception;
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception;
	
	/**
	 * 修改
	 * @param user
	 * @throws Exception
	 */
	public void update(User user) throws Exception;
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public User get(String id) throws Exception;
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, User user) throws Exception;
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<User> queryList(User user) throws Exception;
	
	/**
	 * 修改密码
	 * @param user
	 * @throws Exception
	 */
	public void updatePwd(User user) throws Exception;
	
}
