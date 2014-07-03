package com.richardxu.merchant.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.richardxu.common.CommonConstants;
import com.richardxu.entity.Category;
import com.richardxu.entity.Merchant;
import com.richardxu.entity.VipLevel;
import com.richardxu.merchant.service.CategoryService;
import com.richardxu.merchant.service.MerchantService;
import com.richardxu.merchant.service.VipLevelService;

@Controller
public class MerchantController {
	
	@Autowired
	private MerchantService merchantService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private VipLevelService vipLevelService;
	
	@RequestMapping(value="/search")
	public String findMerchant(HttpServletRequest request, Model model) {
		String nickname = request.getParameter("nickname");
		if (null == nickname) {
			nickname = "a2002shan";
		} 
		if (nickname.trim() == "") {			
			model.addAttribute("message", "旺旺不能为空！");
			return "/website/merchant/search";
		}
		Merchant merchant = new Merchant();
		merchant = merchantService.getMerchantByName(nickname);
		if (null == merchant) {
			model.addAttribute("message", "没有找到商家信息！");
			return "/website/merchant/search";
		}
		
		Category categoryCore = new Category();
		categoryCore = categoryService.getCategoryById(merchant.getCoreBusinessCid());
		if (null != categoryCore) {
			model.addAttribute("coreBusinessCid", categoryCore.getCategoryName());
		} else {
			model.addAttribute("coreBusinessCid", "未知");
		}
		
		Category categoryRegister = new Category();
		categoryRegister = categoryService.getCategoryById(merchant.getRegisterCid());
		
		if (null != categoryRegister) {
			model.addAttribute("registerCid", categoryRegister.getCategoryName());
		} else {
			model.addAttribute("registerCid", "未知");
		}
		
		VipLevel vipLevel = new VipLevel(); 
		vipLevel = vipLevelService.getVipLevelById(merchant.getSellerVipLevel());
		
		if (null != vipLevel) {
			model.addAttribute("vipLevel", vipLevel.getStarName());
		} else {
			model.addAttribute("vipLevel", "未知");
		}
		
		model.addAttribute("nickname", nickname);
		model.addAttribute("merchant", merchant);
		return "/website/merchant/search";
	}
	
	// 分页
	@RequestMapping(value = "/list")
	public @ResponseBody List<Merchant> list(
			@RequestParam(value="nickname", defaultValue="a") String nickname,
			@RequestParam(value="p", defaultValue="1") Integer pageNo,
			HttpServletRequest request, HttpServletResponse response, Model model) {
		
		int limitStart = (pageNo - 1) * CommonConstants.PAGE_SIZE;
		List<Merchant> list = merchantService.getMerchantList(nickname, limitStart, CommonConstants.PAGE_SIZE);
		return list;
	}
	
}
