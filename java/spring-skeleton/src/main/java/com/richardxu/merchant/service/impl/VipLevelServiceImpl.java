package com.richardxu.merchant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.richardxu.merchant.dao.VipLevelMapper;
import com.richardxu.merchant.domain.VipLevel;
import com.richardxu.merchant.service.VipLevelService;

@Service
public class VipLevelServiceImpl implements VipLevelService{
	@Autowired
	private VipLevelMapper vipLevelMapper;

	@Override
	public VipLevel getVipLevelById(Integer id) {
		return vipLevelMapper.selectByPrimaryKey(id);
	}

}
