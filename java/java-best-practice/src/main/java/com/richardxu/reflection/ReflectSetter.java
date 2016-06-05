package com.richardxu.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectSetter {
	
	/**
	 * 使用反射API设置对象的属性值的示例
	 * @param obj
	 * @param field
	 * @param value
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static void invokeSetter(Object obj, String field, Object value) throws NoSuchMethodException,
		SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String methodName = "set" + field.substring(0, 1).toUpperCase() + field.substring(1);
		Class<?> clazz = obj.getClass();
		Method method = clazz.getMethod(methodName, value.getClass());
		method.invoke(obj, value);
	}
	
}