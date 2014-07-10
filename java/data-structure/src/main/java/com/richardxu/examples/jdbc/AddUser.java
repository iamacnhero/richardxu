package com.richardxu.examples.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddUser {
	public void add(User user) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			conn = Conn.getConnection();
			String sql = "INSERT INTO user (credits, last_ip) VALUES (?, ?)";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, user.getCredits());	 // 第1个参数是参数序号，第2个是参数值
			pstm.setString(2, user.getLastIp());
			pstm.executeUpdate(); // 提交pstm 对象
			System.out.println("添加成功!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conn.free(rs, conn, pstm);
		}
	}

	public static void main(String[] args) {
		User user = new User();
		user.setCredits(33);
		user.setLastIp("192.168.0.4");

		AddUser addUser = new AddUser();
		addUser.add(user);
	}

}