package com.aotu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aotu.dao.UserDAO;
import com.aotu.entity.Page;
import com.aotu.entity.system.User;
import com.aotu.service.IUserService;
import com.aotu.util.Encrypt;

/**
 * 系统用户 Service实现类
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserDAO userDAO;
	
	/**
	 * 新增
	 * @param user
	 * @throws Exception
	 */
	public void save(User user) throws Exception {
		this.userDAO.save(user);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception {
		this.userDAO.delete(id);
	}
	
	/**
	 * 修改
	 * @param user
	 * @throws Exception
	 */
	public void update(User user) throws Exception {
		this.userDAO.update(user);
	}
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public User get(String id) throws Exception {
		return (User)this.userDAO.get(id);
	}
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, User user) throws Exception {
		//查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = userDAO.queryCount(user);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<User> records = userDAO.queryPage(page.getPageSize(), page.getStartIndex(), user);
		page.setRecords(records);
		return page;
	}
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<User> queryList(User user) throws Exception {
		List<User> records = userDAO.queryList(user);
		return records;
	}
	
	public void updatePwd(User user) throws Exception {
		User oldUser = (User)this.userDAO.get(user.getId());
		if (!oldUser.getPassword().equals(Encrypt.md5(user.getPassword(),user.getUserName()))) {
			throw new Exception("原密码错误");
		}
		oldUser.setPassword(Encrypt.md5(user.getNewPassword(),user.getUserName()));
		userDAO.update(oldUser);
	}

}
