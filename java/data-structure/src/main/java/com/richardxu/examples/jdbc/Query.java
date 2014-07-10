package com.richardxu.examples.jdbc;

/*
 * File: Query.java
 * Author: xufeng  xufeng@richardxu.com
 * Purpose: query from MySQL
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Query {
	public List<User> showUser(Integer id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>(); // 声明一个 List 集合，用于存放查询出的数据
		try {
			conn = Conn.getConnection();
			String sql = "SELECT id, credits, last_ip FROM user WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);  // 设置查询条件 id=2
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setCredits(rs.getInt("credits"));
				user.setLastIp(rs.getString("last_ip"));

				list.add(user); // 把每次获得的对象数据放入 list 集合中
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conn.free(rs, conn, pstmt);// 关闭连接
		}
		return list;
	}
	
	public List<User> showUser() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>(); // 声明一个 List 集合，用于存放查询出的数据
		try {
			conn = Conn.getConnection();
			String sql = "SELECT id, credits, last_ip FROM user";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setCredits(rs.getInt("credits"));
				user.setLastIp(rs.getString("last_ip"));

				list.add(user); // 把每次获得的对象数据放入 list 集合中
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conn.free(rs, conn, pstmt);// 关闭连接
		}
		return list;
	}

	public static void main(String[] args) {
		Query query = new Query();
		List<User> list = query.showUser(); // 调用查询方法
		if (list != null) {
			System.out.println("id\tcredits\tlast_ip");
			for (User user : list) {
				String record = user.getId() + "\t" + user.getCredits() + "\t"
						+ user.getLastIp();
				System.out.println(record);
			}
		} else {
			System.out.println("没有结果!");
		}

	}

}
