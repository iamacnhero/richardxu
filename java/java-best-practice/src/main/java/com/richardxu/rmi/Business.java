package com.richardxu.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 服务器端对外提供的接口
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年3月21日
 */
public interface Business extends Remote {
	
	String echo(String msg) throws RemoteException;
	
}
