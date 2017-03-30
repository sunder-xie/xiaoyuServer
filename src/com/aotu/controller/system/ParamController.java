package com.aotu.controller.system;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aotu.controller.BaseController;
import com.aotu.entity.Page;
import com.aotu.entity.system.Param;
import com.aotu.service.IParamService;

/**
 * 参数信息 Controller
 */
@Controller
@RequestMapping(value="/param")
public class ParamController extends BaseController {
	
	@Resource(name="paramService")
	private IParamService paramService;
	
	/**
	 * 查询列表 - 分页
	 */
	@RequestMapping("queryList")
	public String queryList(Param param, Page page, Model model) throws Exception {
		page = this.paramService.queryPage(page, param);
		model.addAttribute("page", page);
		return "system/param/paramList";
	}
	
	/**
	 * 跳转至添加界面
	 */
	@RequestMapping("/toAdd.do")
	public String toAdd(Model model) throws Exception {
		return "system/param/paramAdd";
	}
	
	/**
	 * 添加
	 */
	@RequestMapping("/add.do")
	public String add(Param param, Model model) throws Exception {
		this.paramService.save(param);
		return "redirect:/param/queryList.do";
	}
	
	/**
	 * 跳转至修改界面
	 */
	@RequestMapping("/toUpdate.do")
	public String toUpdate(String id, Model model) throws Exception {
		Param param = (Param)this.paramService.get(id);
		model.addAttribute("par", param);
		return "system/param/paramUpdate";
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update.do")
	public String update(Param param, Model model) throws Exception {
		this.paramService.update(param);
		return "redirect:/param/queryList.do";
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete.do")
	public String delete(String id, Model model) throws Exception {
		this.paramService.delete(id);
		return "redirect:/param/queryList.do";
	}
	
}
