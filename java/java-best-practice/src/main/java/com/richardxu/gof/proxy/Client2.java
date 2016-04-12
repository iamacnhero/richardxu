package com.richardxu.gof.proxy;

public class Client2 {
	public static void main(String[] args) {
		Order order = new Order("设计模式", 100, "张三");
		DynamicProxy dynamicProxy = new DynamicProxy();
		OrderApi orderApi = dynamicProxy.getProxyInterface(order);
		
		orderApi.setOrderNum(123, "李四");
		System.out.println("李四修改后订单记录没有变化：" + orderApi);
		
		order.setOrderNum(123, "张三");
		System.out.println("张三修改后，订单记录：" + orderApi);
	}
}
