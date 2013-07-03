package com.richardxu.merchant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.richardxu.merchant.dao.MerchantMapper;
import com.richardxu.merchant.domain.Merchant;
import com.richardxu.merchant.service.MerchantService;

@Service
public class MerchantServiceImpl implements MerchantService{
	@Autowired
	private MerchantMapper merchantMapper;
	
	@Override
	public Merchant getMerchantByName(String nickname) {
		return merchantMapper.getMerchantByName(nickname);
	}

	@Override
	public List<Merchant> getMerchantList(String nickname, int limitStart, int pageSize) {
		List<Merchant> list = null;
		list = merchantMapper.getMerchantList(nickname, limitStart, pageSize);
		return list;
	}

}