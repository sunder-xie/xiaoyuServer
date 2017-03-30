package com.aotu.controller.system;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aotu.controller.BaseController;
import com.aotu.entity.Page;
import com.aotu.entity.system.Role;
import com.aotu.service.IRoleService;

/**
 * 角色信息 Controller
 */
@Controller
@RequestMapping(value="/role")
public class RoleController extends BaseController {
	
	@Resource(name="roleService")
	private IRoleService roleService;
	
	/**
	 * 查询列表 - 分页
	 */
	@RequestMapping("/queryList.do")
	public String queryList(Role role, Page page, Model model) throws Exception {
		page = this.roleService.queryPage(page, role);
		model.addAttribute("page", page);
		return "system/role/roleList";
	}
	
	/**
	 * 跳转至添加界面
	 */
	@RequestMapping("/toAdd.do")
	public String toAdd(Model model) throws Exception {
		return "system/role/roleAdd";
	}
	
	/**
	 * 添加
	 */
	@RequestMapping("/add.do")
	public String add(Role role, Model model) throws Exception {
		this.roleService.save(role);
		return "redirect:/role/queryList.do";
	}
	
	/**
	 * 跳转至修改界面
	 */
	@RequestMapping("/toUpdate.do")
	public String toUpdate(String id, Model model) throws Exception {
		Role role = (Role)this.roleService.get(id);
		model.addAttribute("role", role);
		return "system/role/roleUpdate";
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update.do")
	public String update(Role role, Model model) throws Exception {
		this.roleService.update(role);
		return "redirect:/role/queryList.do";
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete.do")
	public String delete(String id, Model model) throws Exception {
		this.roleService.delete(id);
		return "redirect:/role/queryList.do";
	}
	
}
