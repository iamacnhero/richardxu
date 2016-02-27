package com.richardxu.spi;

/**
 * 接口实现一：MySQL
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年2月27日
 */
public class MySQLConn implements DBConn {

	@Override
	public String getConnection() {
		return "MySQL Connection";
	}

}