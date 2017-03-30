package com.aotu.controller.system;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aotu.controller.BaseController;
import com.aotu.entity.Page;
import com.aotu.entity.system.Dept;
import com.aotu.service.IDeptService;
import com.aotu.util.Const;

/**
 *	菜单管理
 */
@Controller
@RequestMapping(value="/dept")
public class DeptController extends BaseController {

	@Resource(name="deptService")
	private IDeptService deptService;
	
	/**
	 * 查询部门树
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("queryTree")
	public String queryTree(Model model,Page page,Dept dept) throws Exception {
		Dept currentDept = (Dept)this.getSession().getAttribute(Const.SESSION_DEPT);// 当前用户所属部门
		String json = this.queryDeptTree(currentDept);// 获取机构数
		
		model.addAttribute("zTreeNodes", json);
		return "system/dept/deptTree";
	}
	
	/**
	 * 查询列表 - 分页
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("queryList")
	public String queryList(Model model,Page page,Dept dept) throws Exception {
		
		String pid = this.getRequest().getParameter("pid");
		if (pid == null || "".equals(pid)) {
			Dept currentDept = (Dept)this.getSession().getAttribute(Const.SESSION_DEPT);// 当前用户所属部门
			pid = currentDept.getId();
		}
		dept.setParentDeptId(pid);
		page = this.deptService.queryPage(page, dept);
		model.addAttribute("page", page);
		model.addAttribute("pid", pid);
		return "system/dept/deptList";
	}
	
}