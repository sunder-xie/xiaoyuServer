package com.aotu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aotu.dao.RoleDAO;
import com.aotu.entity.Page;
import com.aotu.entity.system.Role;
import com.aotu.service.IRoleService;

/**
 * 系统角色 Service实现类
 */
@Service("roleService")
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private RoleDAO roleDAO;
	
	/**
	 * 新增
	 * @param role
	 * @throws Exception
	 */
	public void save(Role role) throws Exception {
		this.roleDAO.save(role);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception {
		this.roleDAO.delete(id);
	}
	
	/**
	 * 修改
	 * @param role
	 * @throws Exception
	 */
	public void update(Role role) throws Exception {
		this.roleDAO.update(role);
	}
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public Role get(String id) throws Exception {
		return (Role)this.roleDAO.get(id);
	}
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, Role role) throws Exception {
		//查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = roleDAO.queryCount(role);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<Role> records = roleDAO.queryPage(page.getPageSize(), page.getStartIndex(), role);
		page.setRecords(records);
		return page;
	}
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<Role> queryList(Role role) throws Exception {
		List<Role> records = roleDAO.queryList(role);
		return records;
	}

}
