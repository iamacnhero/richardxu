package com.richardxu.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RedisTest extends TestBase {
	@Autowired
	private TestService ts;

	@Autowired
	private RedisService<String> redisService;
	
	@Test
	public void testSet() {
		redisService.getValueOpeartions().set("nations", "china,usa,japan,korea,russia");
		redisService.getListOperations().leftPush("nationList", "china");
		redisService.getListOperations().leftPush("nationList", "usa");
		redisService.getListOperations().leftPush("nationList", "japan");
	}
	
	@Test
	public void testGet() {
		String nations = redisService.getValueOpeartions().get("nations");
		System.out.println(nations);

		List<String> nationList = redisService.getListOperations().range("nationList", 0, -1);
		System.out.println(nationList);
	}
	
	@Test
	public void testServiceTest() {
		System.out.println("message: " + ts.getMessage("Josh"));
		System.out.println("message: " + ts.getMessage("Xufeng"));
		System.out.println("message: " + ts.getMessage("Richard"));
	}
}
