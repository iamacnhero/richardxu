package com.richardxu.hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HiveJdbcClient {
	public static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";
	
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName(driverName);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		Connection conn = DriverManager.getConnection("jdbc:hive://localhost:50000/default", "", "");
		Statement stmt = conn.createStatement();
		String sql = "SELECT user_id, province, url, user_agent FROM guang_access_log LIMIT 10";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getInt("user_id"));
			System.out.println(rs.getString("province"));
			System.out.println(rs.getString("url"));
			System.out.println(rs.getString("user_agent"));
		}
		
		conn.close();
		
	}
}
