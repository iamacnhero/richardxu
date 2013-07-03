package com.richardxu.merchant.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.richardxu.merchant.TestBase;
import com.richardxu.merchant.domain.Merchant;
import com.richardxu.merchant.service.MerchantService;

public class MerchantServiceTest extends TestBase {
	@Autowired
	private MerchantService merchantService;
	
	@Test
	public void testMerchantService() {
		Merchant merchant = new Merchant();
		merchant = merchantService.getMerchantByName("格林8832");
		System.out.println(merchant.getEmail());
		System.out.println(merchant.toString());
	}
}