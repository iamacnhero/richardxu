package com.richardxu.examples.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
	public int deleteUser(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int affect_rows = 0;
		try {
			conn = Conn.getConnection();
			String sql = "DELETE FROM user WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id); // 设置查询条件 id=2
			affect_rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conn.free(null, conn, pstmt); // 关闭连接
		}
		return affect_rows;
	}

	public static void main(String[] args) {
		Delete delete = new Delete();
		int id = 3;
		Query query = new Query();
		if (query.showUser(id) != null) {
			int affect_rows = delete.deleteUser(id);
			if (affect_rows == 0) {
				System.out.println("删除失败！id为 " + id + " 的数据不存在!");
			} else {
				System.out.println("删除了 " + affect_rows + " 条数据!");
			}
		} else {
			System.out.println("删除失败！id为 " + id + " 的数据不存在!");
		}

	}
}