package com.aotu.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aotu.entity.MerchantSet;
import com.aotu.service.IMerchantSetService;

/**
 * 商户设置 Controller
 */
@Controller
@RequestMapping(value="/merchantSet")
public class MerchantSetController extends BaseController {
	
	@Resource(name="merchantSetService")
	private IMerchantSetService merchantSetService;
	
	/**
	 * 跳转至修改界面
	 */
	@RequestMapping("/toUpdate.do")
	public String toUpdate(String id, Model model) throws Exception {
		List<MerchantSet> merchantSetList = this.merchantSetService.queryList(null);
		MerchantSet merchantSet = new MerchantSet();
		if (merchantSetList != null && merchantSetList.size() > 0) {
			merchantSet = merchantSetList.get(0);
		}
		model.addAttribute("merchantSet", merchantSet);
		return "merchantSet/merchantSetUpdate";
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update.do")
	public String update(MerchantSet merchantSet, Model model) throws Exception {
		this.merchantSetService.update(merchantSet);
		return "redirect:/merchantSet/toUpdate.do";
	}
	
}
