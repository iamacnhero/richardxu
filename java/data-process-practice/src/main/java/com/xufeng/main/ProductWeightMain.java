package com.xufeng.main;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.xufeng.thread.ProductWeightThread;

public class ProductWeightMain {
	public static void main(String[] args) throws InterruptedException, SQLException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.test.xml");
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("resources/spring/applicationContext.xml");
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
	
		int maxProductId = jdbcTemplate.queryForInt("SELECT id FROM product ORDER BY id DESC LIMIT 1");
		System.out.println(maxProductId);
		
		int startProductId, endProductId, threadNum = 10, increment = maxProductId / threadNum + 1;
		
		for (int i = 0; i < threadNum; i++) {
			startProductId = i*increment + 1;
			endProductId = startProductId + increment - 1;
			if (endProductId > maxProductId) {
				endProductId = maxProductId;
			}
			System.out.println(startProductId + " " + endProductId);
			
			ProductWeightThread thread = new ProductWeightThread(jdbcTemplate, startProductId, endProductId);
			new Thread(thread, "Thread " + i).start();
		}
	}
}
