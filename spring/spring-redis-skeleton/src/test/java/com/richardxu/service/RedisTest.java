package com.richardxu.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisTest extends TestBase {
	@Autowired
	private TestService ts;

	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	@Test
	public void testSet() {
		redisTemplate.opsForValue().set("nations", "china,usa,japan,korea,russia");
		redisTemplate.opsForList().leftPush("nationList", "china");
		redisTemplate.opsForList().leftPush("nationList", "usa");
		redisTemplate.opsForList().leftPush("nationList", "japan");
	}
	
	@Test
	public void testGet() {
		String nations = redisTemplate.opsForValue().get("nations");
		System.out.println(nations);

		List<String> nationList = redisTemplate.opsForList().range("nationList", 0, -1);
		System.out.println(nationList);
	}
	
	@Test
	public void testServiceTest() {
		System.out.println("message: " + ts.getMessage("Josh"));
		System.out.println("message: " + ts.getMessage("Xufeng"));
		System.out.println("message: " + ts.getMessage("Richard"));
	}
}
