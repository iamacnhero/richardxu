package com.richardxu.merchant.service;

import java.util.List;

import com.richardxu.merchant.domain.Merchant;

public interface MerchantService {
	public Merchant getMerchantByName(String nickname);
	public List<Merchant> getMerchantList(String nickname, int limitStart, int pageSize);
}
