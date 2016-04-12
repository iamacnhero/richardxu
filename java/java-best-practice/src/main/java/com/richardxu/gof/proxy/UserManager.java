package com.richardxu.gof.proxy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 实现示例要求的功能 
 */
public class UserManager {
	public List<UserModelApi> getUserByDepId(String deptId) {
		List<UserModelApi> col = new ArrayList<UserModelApi>();
		
		Connection conn = null;
		try {
			conn = this.getConnection();
			String sql = "SELECT userId, name FROM user WHERE deptId like ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deptId + "%");
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				// 这里是创建的代理对象，而不是直接创建UserModel的对象
				UserProxy proxy = new UserProxy(new UserModel());
				// 只要设置userId和name两个值就可以了
				proxy.setUserId(rs.getString("userId"));
				proxy.setName(rs.getString("name"));
				col.add(proxy);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return col;
	}
	
	private Connection getConnection() {
		return null;
	}
}
