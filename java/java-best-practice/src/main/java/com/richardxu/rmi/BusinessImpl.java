package com.richardxu.rmi;

import java.rmi.RemoteException;

/**
 * 服务器端实现此接口的类
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年3月21日
 */
public class BusinessImpl implements Business {

	@Override
	public String echo(String msg) throws RemoteException {
		if ("quit".equalsIgnoreCase(msg)) {
			System.out.println("Server will be shutdown!");
			System.exit(0);
		}
		System.out.println("Message from client: " + msg);
		return "Server response: " + msg;
	}

}
