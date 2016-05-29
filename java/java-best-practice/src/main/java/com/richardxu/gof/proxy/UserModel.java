package com.richardxu.gof.proxy;

import java.io.Serializable;

public class UserModel implements UserModelApi, Serializable {
    
    private static final long serialVersionUID = 1225433623062573203L;
    
    private String userId;
	private String name;
	private String deptId;
	private String gender;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String toString() {
		return "userId=" + userId + ",name=" + name + ",deptId=" + deptId + ",gender=" + gender + "\n";
	}

}