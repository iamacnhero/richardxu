package com.richardxu.dynamicproxy;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * Proxy使用示例
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年6月5日
 */
public class SimpleProxy {
	/**
	 * 为任何接口及其实现类创建代理的工厂方法
	 * @param intf
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T makeProxy(Class<T> intf, final T obj) {
		LoggingInvocationHandler handler = new LoggingInvocationHandler(obj);
		ClassLoader cl = obj.getClass().getClassLoader();
		return (T) Proxy.newProxyInstance(cl, new Class<?>[]{intf}, handler);
	}
	
	@SuppressWarnings("unchecked")
	public static void useGenericProxy() {
		String str = "Hello world";
		Comparable<String> proxy = makeProxy(Comparable.class, str);
		System.out.println(proxy.compareTo("Good"));
		List<String> list = new ArrayList<String>();
		list = makeProxy(List.class, list);
		list.add("Hello");
		System.out.println(list);
	}
	
	public static int useProxy() {
		String str = "Hello world";
		LoggingInvocationHandler handler = new LoggingInvocationHandler(str);
		ClassLoader cl = SimpleProxy.class.getClassLoader();
		@SuppressWarnings("unchecked")
		Comparable<String> obj = (Comparable<String>) Proxy.newProxyInstance(cl, new Class[] { Comparable.class },
				handler);
		return obj.compareTo("Good");
	}

	public static void main(String[] args) {
		System.out.println(useProxy());
		useGenericProxy();
	}
}
