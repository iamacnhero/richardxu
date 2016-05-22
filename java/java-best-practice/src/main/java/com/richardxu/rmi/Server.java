package com.richardxu.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * 基于RMI的服务器端
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年3月21日
 */
public class Server {
	public static void main(String[] args) throws RemoteException {
		int port = 9527;
		String name = "BusinessDemo";
		Business business = new BusinessImpl();
		// 通过 UnicastRemoteObject.exportObject 来将此对象绑定到某端口上 
		// Exports the remote object to make it available to receive incoming calls, using the particular supplied port.
		UnicastRemoteObject.exportObject(business, port);
		// 将此对象注册到本地的LocateRegistry上，此时形成一个字符串对应于对象实例的映射关系
		Registry registry = LocateRegistry.createRegistry(1099);
		registry.rebind(name, business);
	}
}
