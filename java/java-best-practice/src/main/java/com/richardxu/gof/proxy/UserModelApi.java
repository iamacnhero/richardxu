package com.richardxu.gof.proxy;

/**
 * 定义用户数据对象的接口
 */
public interface UserModelApi {

	String getUserId();

	void setUserId(String userId);

	String getName();

	void setName(String name);

	String getDeptId();

	void setDeptId(String deptId);

	String getGender();

	void setGender(String gender);

}