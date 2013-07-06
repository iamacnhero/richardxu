package com.richardxu.test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = { "classpath*:applicationContext.xml" })
public class TestBase extends AbstractJUnit4SpringContextTests {
	protected void setup() {
		
	}
}