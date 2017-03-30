package com.aotu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aotu.dao.DeptDAO;
import com.aotu.entity.Page;
import com.aotu.entity.system.Dept;
import com.aotu.service.IDeptService;

/**
 * 系统部门 Service实现类
 */
@Service("deptService")
public class DeptServiceImpl implements IDeptService {

	@Autowired
	private DeptDAO deptDAO;
	
	public void save(Dept dept) throws Exception {
		this.deptDAO.save(dept);
	}
	
	public void delete(String id) throws Exception {
		this.deptDAO.delete(id);
	}
	
	public void update(Dept dept) throws Exception {
		this.deptDAO.update(dept);
	}
	
	public Dept get(String id) throws Exception {
		return (Dept)this.deptDAO.get(id);
	}
	
	public Page queryPage(Page page, Dept dept) throws Exception {
		//查询总记录条数(需要判断是否带着查询条件进来, 且带进来几个查询条件)
		int totalRecordsNum = deptDAO.queryCount(dept);
		page.setTotalRecordsNum(totalRecordsNum);
		// 分页查询记录
		List<Dept> records = deptDAO.queryPage(page.getPageSize(), page.getStartIndex(), dept);
		page.setRecords(records);
		return page;
	}
	
	public List<Dept> queryList(Dept dept) throws Exception {
		List<Dept> records = deptDAO.queryList(dept);
		return records;
	}
	
	public List<Dept> querySubDeptList(Dept dept) throws Exception {
		List<Dept> deptList = this.deptDAO.querySubDeptList(dept);
		return deptList;
	}

}
