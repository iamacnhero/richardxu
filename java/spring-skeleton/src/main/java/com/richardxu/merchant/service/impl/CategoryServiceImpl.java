package com.richardxu.merchant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.richardxu.merchant.dao.CategoryMapper;
import com.richardxu.merchant.domain.Category;
import com.richardxu.merchant.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryMapper categoryMapper;
	
	@Override
	public Category getCategoryById(Integer id) {
		return categoryMapper.selectByPrimaryKey(id);
	}

}
