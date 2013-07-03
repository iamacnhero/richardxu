package com.xufeng.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.xufeng.service.ProductWeightService;
import com.xufeng.utils.JSONUtil;

public class ProductWeightTest extends TestBase {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void testProductWeightService() {
		long start = System.currentTimeMillis();
		
		ProductWeightService productWeightService = new ProductWeightService(jdbcTemplate);
		System.out.println(productWeightService.isVipShop(25461));
		
		long end = System.currentTimeMillis();
		System.out.println("spend time: " + (end - start));
	}
	
	@Test
	public void testJson() {
		String s = "{\"discount\":\"8.0\",\"discountPrice\":8640,\"freePost\":\"0\"}";
		System.out.println(JSONUtil.simpleToBean(s).get("discount"));
	}
}
