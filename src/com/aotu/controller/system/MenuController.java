package com.aotu.controller.system;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aotu.controller.BaseController;
import com.aotu.entity.Page;
import com.aotu.entity.system.Menu;
import com.aotu.service.IMenuService;

import net.sf.json.JSONArray;

/**
 *	菜单管理
 */
@Controller
@RequestMapping(value="/menu")
public class MenuController extends BaseController {

	@Resource(name="menuService")
	private IMenuService menuService;
	
	/**
	 * 查询列表 - 分页
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("queryList")
	public String queryList(Model model,Page page,Menu menu) throws Exception {
		menu.setParentMenuId("0");
		page = this.menuService.queryPage(page, menu);
		model.addAttribute("page", page);
		return "system/menu/menuList";
	}
	
	/**
	 * 跳转至新增页面
	 */
	@RequestMapping("toAdd")
	public String toAdd() throws Exception {
		return "system/menu/menuAdd";
	}
	
	/**
	 * 新增
	 */
	@RequestMapping("add")
	public String add(Menu menu) throws Exception {
		this.menuService.save(menu);
		return "redirect:/menu/queryList.do";
	}
	
	/**
	 * 跳转到修改页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("toUpdate")
	public String toUpdate(Model model, String id)throws Exception {
		Menu menu = (Menu)this.menuService.get(id);
		model.addAttribute("menu",menu);
		return "system/menu/menuUpdate";
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("update")
	public String update(Menu menu, Model model) throws Exception {
		this.menuService.update(menu);
		return "redirect:/menu/queryList.do";
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("delete")
	public String delete(String id, Model model) throws Exception {
		this.menuService.delete(id);
		return "redirect:/menu/queryList.do";
	}
	
	/**
	 * 查询子列表
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("querySubList")
	public void querySubList(String parentMenuId, HttpServletResponse response) throws Exception {
		Menu menu = new Menu();
		menu.setParentMenuId(parentMenuId);
		List<Menu> subMenuList = this.menuService.queryList(menu);
		JSONArray arr = JSONArray.fromObject(subMenuList);
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String json = arr.toString();
		out.write(json);
		out.flush();
		out.close();
	}
	
}