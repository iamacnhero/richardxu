package com.richardxu.merchant.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.richardxu.entity.Category;
import com.richardxu.merchant.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
//	@RequestMapping(value="/{categoryId}")
//	@ResponseBody
//	public Model getCategoryById(@PathVariable String categoryId, Model model) {
//		Integer cId = null;
//		try {
//			cId = Integer.parseInt(categoryId);
//		} catch (Exception e) {
//			model.addAttribute("code", CommonConstants.RESULT_PARAM_ERROR);
//			return null;
//		}
//		Category category = categoryService.getCategoryById(cId);
//		model.addAttribute("code", CommonConstants.RESULT_SUCCESS);
//		model.addAttribute("category", category);
//		return category;
//	}
	
	@RequestMapping(value="/{categoryId}")
	@ResponseBody
	public Category getCategoryById(@PathVariable String categoryId) {
		Integer cId = null;
		try {
			cId = Integer.parseInt(categoryId);
		} catch (Exception e) {
			return null;
		}
		Category category = categoryService.getCategoryById(cId);
		return category;
	}
}
