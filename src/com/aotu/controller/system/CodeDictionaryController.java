package com.aotu.controller.system;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aotu.controller.BaseController;
import com.aotu.entity.Page;
import com.aotu.entity.system.CodeDictionary;
import com.aotu.service.ICodeDictionaryService;

/**
 *	菜单管理
 */
@Controller
@RequestMapping(value="/codeDictionary")
public class CodeDictionaryController extends BaseController {

	@Resource(name="codeDictionaryService")
	private ICodeDictionaryService codeDictionaryService;
	
	/**
	 * 查询列表 - 分页
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("queryList")
	public String queryList(Model model,Page page,CodeDictionary codeDictionary) throws Exception {
		page = this.codeDictionaryService.queryPage(page, codeDictionary);
		model.addAttribute("page", page);
		model.addAttribute("codeDictionary", codeDictionary);
		return "system/codeDictionary/codeDictionaryList";
	}
	
	/**
	 * 跳转至新增页面
	 */
	@RequestMapping("toAdd")
	public String toAdd() throws Exception {
		return "system/codeDictionary/codeDictionaryAdd";
	}
	
	/**
	 * 新增
	 */
	@RequestMapping("add")
	public String add(CodeDictionary codeDictionary) throws Exception {
		this.codeDictionaryService.save(codeDictionary);
		return "redirect:/codeDictionary/queryList.do";
	}
	
	/**
	 * 跳转到修改页面
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("toUpdate")
	public String toUpdate(Model model, String id)throws Exception {
		CodeDictionary codeDictionary = (CodeDictionary)this.codeDictionaryService.get(id);
		model.addAttribute("codeDictionary",codeDictionary);
		return "system/codeDictionary/codeDictionaryUpdate";
		
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("update")
	public String update(CodeDictionary codeDictionary, Model model) throws Exception {
		this.codeDictionaryService.update(codeDictionary);
		return "redirect:/codeDictionary/queryList.do";
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("delete")
	public String delete(String id, Model model) throws Exception {
		this.codeDictionaryService.delete(id);
		return "redirect:/codeDictionary/queryList.do";
	}
	
}