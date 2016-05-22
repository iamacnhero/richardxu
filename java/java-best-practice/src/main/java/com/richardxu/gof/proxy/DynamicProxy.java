package com.richardxu.gof.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 使用Java中的动态代理
 */
public class DynamicProxy implements InvocationHandler {
	
	private OrderApi order = null;		// 被代理的对象
	
	/**
	 * 获取绑定好代理和具体目标对象后的目标对象的接口 
	 */
	public OrderApi getProxyInterface(Order order) {
		this.order = order;			// 设置被代理的对象，好方便invoke里面的操作
		// 把真正的订单对象和动态代理关联起来
		OrderApi orderApi = (OrderApi) Proxy.newProxyInstance(
				order.getClass().getClassLoader(), 
				order.getClass().getInterfaces(), 
				this);
		return orderApi;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 如果是调用setter方法需要验权
		if (method.getName().startsWith("set")) {
			if (order.getOrderUser() != null && order.getOrderUser().equals(args[1])) {
				return method.invoke(order, args);
			} else {
				System.out.println("sorry，you don't have permission!");
			}
		} else {
			// 不是调用setter方法就继续运行
			return method.invoke(order, args);
		}
		return null;
	}

}
