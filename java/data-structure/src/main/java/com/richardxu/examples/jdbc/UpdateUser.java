package com.richardxu.examples.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateUser {
	public static int update(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = " UPDATE user SET id = ?, credits = ?, last_ip = ? WHERE id = ? ";
		int affectedRows = 0;
		try {
			conn = Conn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getId());
			pstmt.setInt(2, user.getCredits());
			pstmt.setString(3, user.getLastIp());
			pstmt.setInt(4,  user.getId());
			affectedRows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conn.free(null, conn, pstmt);
		}
		return affectedRows;

	}

	public static void main(String[] args) {
		int id = 1;
		Query query = new Query();
		if (query.showUser(id) != null) {
			User user = new User();
			user.setId(id);
			user.setCredits(135);
			user.setLastIp("192.168.0.231");
			int affectedRows = UpdateUser.update(user);
			if (affectedRows == 0) {
				System.out.println("更新失败! id为 " + id + " 的数据不存在!");
			} else {
				System.out.println("更新了 " + affectedRows + " 条数据!");
			}
		} else {
			System.out.println("更新失败! id为 " + " 的数据不存在!");
		}
	}
}