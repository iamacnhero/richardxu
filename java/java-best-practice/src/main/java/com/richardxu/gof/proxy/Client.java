package com.richardxu.gof.proxy;

import java.util.List;

/**
 * 客户端调用
 */
public class Client {
	public static void main(String[] args) {
		UserManager userManager = new UserManager();
		List<UserModelApi> col = userManager.getUserByDepId("0101");
		
		// 如果只是显示用户名称，则不需要重新查询数据库
		for (UserModelApi userModelApi : col) {
			System.out.println("userId=" + userModelApi.getUserId()
								+ ", name=" + userModelApi.getName());
		}
		
		// 如果访问用户编号和用户姓名外的属性，就会重新查询数据库
		for (UserModelApi userModelApi : col) {
			System.out.println("userId=" + userModelApi.getUserId()
								+ ", name=" + userModelApi.getName()
								+ ", dept=" + userModelApi.getDeptId());
		}
	}
}
