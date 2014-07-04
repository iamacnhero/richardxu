package com.richardxu.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RedisTest extends TestBase {
	@Autowired
	private TestService ts;

	@Test
	public void testCreate() {
		
	}
	
	@Test
	public void testServiceTest() {
		System.out.println("message: " + ts.getMessage("Josh"));
		System.out.println("message: " + ts.getMessage("Xufeng"));
		System.out.println("message: " + ts.getMessage("Richard"));
	}
}
