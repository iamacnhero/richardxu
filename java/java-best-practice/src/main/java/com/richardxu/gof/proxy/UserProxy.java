package com.richardxu.gof.proxy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 代理对象，代理用户数据对象
 */
public class UserProxy implements UserModelApi {
	
	private UserModel realSubject;	// 持有被代理的具体的目标对象
	
	private boolean loaded = false;	// 标志是否已经重新装载过数据了
	
	public UserProxy(UserModel realSubject) {
		this.setRealSubject(realSubject);
	}

	@Override
	public String getUserId() {
		return realSubject.getUserId();
	}

	@Override
	public void setUserId(String userId) {
		realSubject.setUserId(userId);
	}

	@Override
	public String getName() {
		return realSubject.getName();
	}

	@Override
	public void setName(String name) {
		realSubject.setName(name);
	}

	@Override
	public String getDeptId() {
		if (!this.loaded) {
			reload();			// 从数据库中重新装载
			this.loaded = true;
		}
		return realSubject.getDeptId();
	}

	@Override
	public void setDeptId(String deptId) {
		realSubject.setDeptId(deptId);
	}

	@Override
	public String getGender() {
		if (!this.loaded) {
			reload();
			this.loaded = true;
		}
		return realSubject.getGender();
	}
	
	private void reload() {
		System.out.println("获取完整的用户数据, userId=" + realSubject.getUserId());
		Connection conn = null;
		try {
			conn = this.getConnection();
			String sql = "SELECT * FROM user WHERE userId = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, realSubject.getUserId());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				realSubject.setDeptId(rs.getString("deptId"));
				realSubject.setGender(rs.getString("gender"));
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
	}

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("你用的数据库对应的JDBC驱动类");
		return DriverManager.getConnection("url", "user", "passwd");
	}

	@Override
	public void setGender(String gender) {
		realSubject.setGender(gender);
	}

	public UserModel getRealSubject() {
		return realSubject;
	}

	public void setRealSubject(UserModel realSubject) {
		this.realSubject = realSubject;
	}

}