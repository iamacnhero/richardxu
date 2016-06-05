package com.richardxu.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 方法反射
 * 
 * @author <a href="463692574@qq.com">Richard Xu</a>
 * @version 1.0
 * @since 2016年6月5日
 */
public class ReflectMethod {
	private void privateMethod() {
		System.out.println("this is privateMethod!");
	}

	public void publicMethod() {
		System.out.println("this is publicMethod!");
	}
	
	public void publicMethod(String name) {
		System.out.println("this is publicMethod, " + name);
	}

	public void useMethod() throws NoSuchMethodException, SecurityException, IllegalAccessException,
		IllegalArgumentException, InvocationTargetException {
		Method privateMethod = ReflectMethod.class.getDeclaredMethod("privateMethod", null);
		privateMethod.invoke(this, null);

		Method publicMethod = ReflectMethod.class.getDeclaredMethod("publicMethod", null);
		publicMethod.invoke(this, null);
		
		Method publicMethod2 = ReflectMethod.class.getDeclaredMethod("publicMethod", String.class);
		publicMethod2.invoke(this, "Tom");
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
		IllegalArgumentException, InvocationTargetException {
		ReflectMethod reflectMethod = new ReflectMethod();
		reflectMethod.useMethod();
	}
}
