package com.xufeng.test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = { "classpath:spring/applicationContext.test.xml" })
public class TestBase extends AbstractJUnit4SpringContextTests {
	protected void setup() {
		
	}
}
