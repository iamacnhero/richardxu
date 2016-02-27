package com.richardxu.spi;

import java.util.ServiceLoader;

/**
 * 实现演示
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年2月27日
 */
public class ServiceLoadDemo {
	
	public static void main(String[] args) {
		ServiceLoader<DBConn> dbConns = ServiceLoader.load(DBConn.class);
		for (DBConn dbConn : dbConns) {
			System.out.println(dbConn.getConnection());
		}
	}
	
}
