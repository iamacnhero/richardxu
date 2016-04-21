package com.richardxu.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * RMI Client
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年3月21日
 */
public class Client {
	public static void main(String[] args) throws RemoteException, NotBoundException {
		// RMI客户端首先通过 LocateRegistry.getRegistry 来获取Registry对象
		String host = "30.9.40.79";
		int port = 1099;
		Registry registry = LocateRegistry.getRegistry(host, port);
		
		String name = "BusinessDemo";
		// 创建 BusinessDemo 类的代理类，当调用时则调用 localhost:1099 上名称为 BusinessDemo 的对象,
		// 如服务端没有对应名称的绑定，则抛出 NotBoundException；如通信出现错误，则抛出RemoteException
		Business business = (Business) registry.lookup(name);
		System.out.println(business.echo("testMsg"));
	}
}
