package com.aotu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aotu.dao.MenuDAO;
import com.aotu.entity.Page;
import com.aotu.entity.system.Menu;
import com.aotu.service.IMenuService;

/**
 * 系统菜单 Service实现类
 */
@Service("menuService")
public class MenuServiceImpl implements IMenuService {

	@Autowired
	private MenuDAO menuDAO;
	
	/**
	 * 新增
	 * @param menu
	 * @throws Exception
	 */
	public void save(Menu menu) throws Exception {
		this.menuDAO.save(menu);
	}
	
	/**
	 * 删除
	 * @param id
	 * @throws Exception
	 */
	public void delete(String id) throws Exception {
		this.menuDAO.delete(id);
	}
	
	/**
	 * 修改
	 * @param menu
	 * @throws Exception
	 */
	public void update(Menu menu) throws Exception {
		this.menuDAO.update(menu);
	}
	
	/**
	 * 查看
	 * @param id
	 * @throws Exception
	 */
	public Menu get(String id) throws Exception {
		return (Menu)this.menuDAO.get(id);
	}
	
	/**
	 * 查询列表 - 分页
	 * @param page
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Page queryPage(Page page, Menu menu) throws Exception {
		int totalRecordsNum = menuDAO.queryCount(menu);
		page.setTotalRecordsNum(totalRecordsNum);
		List<Menu> records = menuDAO.queryPage(page.getPageSize(), page.getStartIndex(), menu);
		page.setRecords(records);
		return page;
	}
	
	/**
	 * 查询列表 - 不分页
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<Menu> queryList(Menu menu) throws Exception {
		List<Menu> records = menuDAO.queryList(menu);
		return records;
	}
	
	public List<Menu> queryListByRoleId(String roleId) throws Exception {
		List<Menu> records = menuDAO.queryListByRoleId(roleId);
		return records;
	}

}
