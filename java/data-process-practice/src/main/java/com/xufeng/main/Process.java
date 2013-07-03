package com.xufeng.main;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.xufeng.thread.ProductWeightThread;
import com.xufeng.thread.UserSummaryThread;

public class Process {
	public static void main(String[] args) throws InterruptedException, SQLException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.test.xml");
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("resources/spring/applicationContext.xml");
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
	
		int maxUserId = jdbcTemplate.queryForInt("SELECT id FROM user ORDER BY id DESC LIMIT 1");
		System.out.println(maxUserId);
		
		int startUserId, endUserId, threadNum = 10, increment = maxUserId / threadNum + 1;
		
		for (int i = 0; i < threadNum; i++) {
			startUserId = i * increment + 1;
			endUserId = startUserId + increment - 1;
			if (endUserId > maxUserId) {
				endUserId = maxUserId;
			}
			System.out.println(startUserId + " " + endUserId);
			
			UserSummaryThread userSummary = new UserSummaryThread(jdbcTemplate, startUserId, endUserId);
			new Thread(userSummary, "Thread " + i).start();
		}
	}
}
