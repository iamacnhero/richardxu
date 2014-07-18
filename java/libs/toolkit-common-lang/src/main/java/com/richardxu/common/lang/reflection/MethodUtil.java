/**
 * 
 */
package com.richardxu.common.lang.reflection;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.richardxu.common.lang.ArrayUtil;
import com.richardxu.common.lang.ClassUtil;
import com.richardxu.common.lang.exception.MethodException;

/**
 * 有关<code>Method</code>处理的工具类。
 * 
 * @author saga67
 * 
 * @version create on 2011-10-27 上午7:40:50
 */
public class MethodUtil {

	private MethodUtil() {

	}

	/**
	 * <p>
	 * 调用一个命名的方法，其参数类型相匹配的对象类型。
	 * </p>
	 * 
	 * <p>
	 * {@link #getMatchingAccessibleMethod(Class, String, Class[])}.
	 * </p>
	 * 
	 * <p>
	 * 此方法支持基本类型和包装类的转换. 比如, <code>Boolean</code> 匹配 <code>boolean</code>
	 * primitive.
	 * </p>
	 * 
	 * 
	 * @param object
	 *            调用方法作用的对象
	 * @param methodName
	 *            方法名
	 * @param arg
	 *            参数
	 * @return 调用的方法的返回值
	 * 
	 * @throws MethodException
	 * 
	 */
	public static Object invokeMethod(Object object, String methodName,
			Object arg) throws MethodException {
		return invokeMethod(object, methodName, new Object[] { arg });
	}

	/**
	 * <p>
	 * 调用一个命名的方法，其参数类型相匹配的对象类型。
	 * </p>
	 * 
	 * <p>
	 * {@link #getMatchingAccessibleMethod(Class, String, Class[])}.
	 * </p>
	 * 
	 * <p>
	 * 此方法支持基本类型和包装类的转换. 比如, <code>Boolean</code> 匹配 <code>boolean</code>
	 * primitive.
	 * </p>
	 * 
	 * 
	 * @param object
	 *            调用方法作用的对象
	 * @param methodName
	 *            方法名
	 * @param args
	 *            参数
	 * @return 调用的方法的返回值
	 * 
	 * @throws MethodException
	 * 
	 */
	public static Object invokeMethod(Object object, String methodName,
			Object[] args) throws MethodException {
		if (args == null) {
			args = ArrayUtil.EMPTY_OBJECT_ARRAY;
		}
		int arguments = args.length;
		Class<?>[] parameterTypes = new Class[arguments];
		for (int i = 0; i < arguments; i++) {
			parameterTypes[i] = args[i].getClass();
		}
		return invokeMethod(object, methodName, args, parameterTypes);
	}

	/**
	 * <p>
	 * 调用一个命名的方法，其参数类型相匹配的对象类型。
	 * </p>
	 * 
	 * <p>
	 * {@link #getMatchingAccessibleMethod(Class, String, Class[])}.
	 * </p>
	 * 
	 * <p>
	 * 此方法支持基本类型和包装类的转换. 比如, <code>Boolean</code> 匹配 <code>boolean</code>
	 * primitive.
	 * </p>
	 * 
	 * 
	 * @param object
	 *            调用方法作用的对象
	 * @param methodName
	 *            方法名
	 * @param args
	 *            参数值
	 * @param parameterTypes
	 *            参数类型
	 * @return 调用的方法的返回值
	 * 
	 * @throws MethodException
	 * 
	 */
	public static Object invokeMethod(Object object, String methodName,
			Object[] args, Class<?>[] parameterTypes) throws MethodException {
		if (parameterTypes == null) {
			parameterTypes = ArrayUtil.EMPTY_CLASS_ARRAY;
		}
		if (args == null) {
			args = ArrayUtil.EMPTY_OBJECT_ARRAY;
		}
		Method method = getMatchingAccessibleMethod(object.getClass(),
				methodName, parameterTypes);
		if (method == null) {
			throw new MethodException(method, "No such accessible method: "
					+ methodName + "() on object: "
					+ object.getClass().getName());
		}
		try {
			return method.invoke(object, args);
		} catch (IllegalArgumentException e) {
			throw new MethodException(method, "illegal argument on method: "
					+ methodName + "() on object: "
					+ object.getClass().getName());
		} catch (IllegalAccessException e) {
			throw new MethodException(method, "illegal access on method: "
					+ methodName + "() on object: "
					+ object.getClass().getName());
		} catch (InvocationTargetException e) {
			throw new MethodException(method, "method invocation exception: "
					+ methodName + "() on object: "
					+ object.getClass().getName());
		}
	}

	public static Object invokeExactMethod(Object object, String methodName,
			Object arg) throws MethodException {
		return invokeExactMethod(object, methodName, new Object[] { arg });
	}

	public static Object invokeExactMethod(Object object, String methodName,
			Object[] args) throws MethodException {
		if (args == null) {
			args = ArrayUtil.EMPTY_OBJECT_ARRAY;
		}
		int arguments = args.length;
		Class<?>[] parameterTypes = new Class[arguments];
		for (int i = 0; i < arguments; i++) {
			parameterTypes[i] = args[i].getClass();
		}
		return invokeExactMethod(object, methodName, args, parameterTypes);
	}

	public static Object invokeExactMethod(Object object, String methodName,
			Object[] args, Class<?>[] parameterTypes) throws MethodException {
		if (args == null) {
			args = ArrayUtil.EMPTY_OBJECT_ARRAY;
		}
		if (parameterTypes == null) {
			parameterTypes = ArrayUtil.EMPTY_CLASS_ARRAY;
		}
		Method method = getAccessibleMethod(object.getClass(), methodName,
				parameterTypes);
		if (method == null) {
			throw new MethodException(method, "No such accessible method: "
					+ methodName + "() on object: "
					+ object.getClass().getName());
		}
		try {
			return method.invoke(object, args);
		} catch (IllegalArgumentException e) {
			throw new MethodException(method, "illegal argument on method: "
					+ methodName + "() on object: "
					+ object.getClass().getName());
		} catch (IllegalAccessException e) {
			throw new MethodException(method, "illegal access on method: "
					+ methodName + "() on object: "
					+ object.getClass().getName());
		} catch (InvocationTargetException e) {
			throw new MethodException(method, "method invocation exception: "
					+ methodName + "() on object: "
					+ object.getClass().getName());
		}
	}

	public static Object invokeExactStaticMethod(Class<?> clazz,
			String methodName, Object[] args, Class<?>[] parameterTypes)
			throws MethodException {
		if (args == null) {
			args = ArrayUtil.EMPTY_OBJECT_ARRAY;
		}
		if (parameterTypes == null) {
			parameterTypes = ArrayUtil.EMPTY_CLASS_ARRAY;
		}
		Method method = getAccessibleMethod(clazz, methodName, parameterTypes);
		if (method == null) {
			throw new MethodException(method, "No such accessible method: "
					+ methodName + "() on class: " + clazz.getName());
		}
		try {
			return method.invoke(null, args);
		} catch (IllegalArgumentException e) {
			throw new MethodException(method, "illegal argument on method: "
					+ methodName + "() on class: " + clazz.getName());
		} catch (IllegalAccessException e) {
			throw new MethodException(method, "illegal access on method: "
					+ methodName + "() on class: " + clazz.getName());
		} catch (InvocationTargetException e) {
			throw new MethodException(method, "method invocation exception: "
					+ methodName + "() on class: " + clazz.getName());
		}
	}

	public static Object invokeStaticMethod(Class<?> clazz, String methodName,
			Object arg) throws MethodException {
		return invokeStaticMethod(clazz, methodName, new Object[] { arg });
	}

	public static Object invokeStaticMethod(Class<?> clazz, String methodName,
			Object[] args) throws MethodException {
		if (args == null) {
			args = ArrayUtil.EMPTY_OBJECT_ARRAY;
		}
		int arguments = args.length;
		Class<?>[] parameterTypes = new Class[arguments];
		for (int i = 0; i < arguments; i++) {
			parameterTypes[i] = args[i].getClass();
		}
		return invokeStaticMethod(clazz, methodName, args, parameterTypes);
	}

	public static Object invokeStaticMethod(Class<?> clazz, String methodName,
			Object[] args, Class<?>[] parameterTypes) throws MethodException {
		if (parameterTypes == null) {
			parameterTypes = ArrayUtil.EMPTY_CLASS_ARRAY;
		}
		if (args == null) {
			args = ArrayUtil.EMPTY_OBJECT_ARRAY;
		}
		Method method = getMatchingAccessibleMethod(clazz, methodName,
				parameterTypes);
		if (method == null) {
			throw new MethodException(method, "No such accessible method: "
					+ methodName + "() on class: " + clazz.getName());
		}
		try {
			return method.invoke(null, args);
		} catch (IllegalArgumentException e) {
			throw new MethodException(method, "illegal argument on method: "
					+ methodName + "() on class: " + clazz.getName());
		} catch (IllegalAccessException e) {
			throw new MethodException(method, "illegal access on method: "
					+ methodName + "() on class: " + clazz.getName());
		} catch (InvocationTargetException e) {
			throw new MethodException(method, "method invocation exception: "
					+ methodName + "() on class: " + clazz.getName());
		}
	}

	public static Object invokeExactStaticMethod(Class<?> clazz,
			String methodName, Object arg) throws MethodException {
		return invokeExactStaticMethod(clazz, methodName, new Object[] { arg });
	}

	public static Object invokeExactStaticMethod(Class<?> clazz,
			String methodName, Object[] args) throws MethodException {
		if (args == null) {
			args = ArrayUtil.EMPTY_OBJECT_ARRAY;
		}
		int arguments = args.length;
		Class<?>[] parameterTypes = new Class[arguments];
		for (int i = 0; i < arguments; i++) {
			parameterTypes[i] = args[i].getClass();
		}
		return invokeExactStaticMethod(clazz, methodName, args, parameterTypes);
	}

	public static Method getAccessibleMethod(Class<?> clazz, String methodName,
			Class<?> parameterType) {
		return getAccessibleMethod(clazz, methodName,
				new Class[] { parameterType });
	}

	public static Method getAccessibleMethod(Class<?> clazz, String methodName,
			Class<?>[] parameterTypes) {
		try {
			return getAccessibleMethod(clazz.getMethod(methodName,
					parameterTypes));
		} catch (NoSuchMethodException e) {
			return (null);
		}
	}

	public static Method getAccessibleMethod(Method method) {
		if (!MemberUtil.isAccessible(method)) {
			return null;
		}
		// If the declaring class is public, we are done
		Class<?> clazz = method.getDeclaringClass();
		if (Modifier.isPublic(clazz.getModifiers())) {
			return method;
		}
		String methodName = method.getName();
		Class<?>[] parameterTypes = method.getParameterTypes();

		// Check the implemented interfaces and subinterfaces
		method = getAccessibleMethodFromInterfaceNest(clazz, methodName,
				parameterTypes);

		// Check the superclass chain
		if (method == null) {
			method = getAccessibleMethodFromSuperclass(clazz, methodName,
					parameterTypes);
		}
		return method;
	}

	private static Method getAccessibleMethodFromSuperclass(Class<?> clazz,
			String methodName, Class<?>[] parameterTypes) {
		Class<?> parentClass = clazz.getSuperclass();
		while (parentClass != null) {
			if (Modifier.isPublic(parentClass.getModifiers())) {
				try {
					return parentClass.getMethod(methodName, parameterTypes);
				} catch (NoSuchMethodException e) {
					return null;
				}
			}
			parentClass = parentClass.getSuperclass();
		}
		return null;
	}

	private static Method getAccessibleMethodFromInterfaceNest(Class<?> clazz,
			String methodName, Class<?>[] parameterTypes) {
		Method method = null;

		// Search up the superclass chain
		for (; clazz != null; clazz = clazz.getSuperclass()) {

			// Check the implemented interfaces of the parent class
			Class<?>[] interfaces = clazz.getInterfaces();
			for (int i = 0; i < interfaces.length; i++) {
				// Is this interface public?
				if (!Modifier.isPublic(interfaces[i].getModifiers())) {
					continue;
				}
				// Does the method exist on this interface?
				try {
					method = interfaces[i].getDeclaredMethod(methodName,
							parameterTypes);
				} catch (NoSuchMethodException e) {
					/*
					 * Swallow, if no method is found after the loop then this
					 * method returns null.
					 */
				}
				if (method != null) {
					break;
				}
				// Recursively check our parent interfaces
				method = getAccessibleMethodFromInterfaceNest(interfaces[i],
						methodName, parameterTypes);
				if (method != null) {
					break;
				}
			}
		}
		return method;
	}

	public static Method getMatchingAccessibleMethod(Class<?> clazz,
			String methodName, Class<?>[] parameterTypes) {
		try {
			Method method = clazz.getMethod(methodName, parameterTypes);
			MemberUtil.setAccessibleWorkaround(method);
			return method;
		} catch (NoSuchMethodException e) { /* SWALLOW */
		}
		// search through all methods
		Method bestMatch = null;
		Method[] methods = clazz.getMethods();
		for (int i = 0, size = methods.length; i < size; i++) {
			if (methods[i].getName().equals(methodName)) {
				// compare parameters
				if (ClassUtil.isAssignable(parameterTypes,
						methods[i].getParameterTypes())) {
					// get accessible version of method
					Method accessibleMethod = getAccessibleMethod(methods[i]);
					if (accessibleMethod != null) {
						if (bestMatch == null
								|| MemberUtil.compareParameterTypes(
										accessibleMethod.getParameterTypes(),
										bestMatch.getParameterTypes(),
										parameterTypes) < 0) {
							bestMatch = accessibleMethod;
						}
					}
				}
			}
		}
		if (bestMatch != null) {
			MemberUtil.setAccessibleWorkaround(bestMatch);
		}
		return bestMatch;
	}

	/**
	 * 获取类的所有<code>Method</code>，不包括<code>Object</code>的 <code>Method</code>
	 * <p>
	 * 如果<code>clazz</code>为<code>null</code>，返回<code>null</code>
	 * 
	 * 
	 * @param clazz
	 *            要获取的类
	 * @return <code>Method</code>数组
	 */
	public static Method[] getAllMethodsOfClass(final Class<?> clazz) {
		Method[] methods = null;
		Class<?> itr = clazz;
		while (itr != null && !itr.equals(Object.class)) {
			methods = (Method[]) ArrayUtil.addAll(itr.getDeclaredMethods(),
					methods);
			itr = itr.getSuperclass();
		}
		return methods;
	}

	public static Method[] getAllMethodsOfClass(Class<?> clazz,
			boolean accessible) {
		Method[] methods = getAllMethodsOfClass(clazz);
		if (ArrayUtil.isNotEmpty(methods))
			AccessibleObject.setAccessible(methods, accessible);
		return methods;
	}

}
