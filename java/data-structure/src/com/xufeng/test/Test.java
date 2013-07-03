package com.xufeng.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xufeng.example.sql.Conn;

public class Test {
	public static void main(String[] args) throws SQLException {
		Connection conn = Conn.getConnection();
		Statement stmt = conn.createStatement();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM tb_clazz ");
		ResultSet rs = stmt.executeQuery(sb.toString());
		while(rs.next()) {
			System.out.println(rs.getInt("id") + "\t" + rs.getString("name"));
		}
		
		conn.close();
	}
}