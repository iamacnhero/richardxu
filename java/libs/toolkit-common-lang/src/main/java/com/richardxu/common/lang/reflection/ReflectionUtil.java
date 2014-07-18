/**
 * 
 */
package com.richardxu.common.lang.reflection;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.UndeclaredThrowableException;
import java.lang.reflect.WildcardType;
import java.security.AccessControlException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import com.richardxu.common.lang.Assert;
import com.richardxu.common.lang.ClassLoaderUtil;
import com.richardxu.common.lang.ClassUtil;
import com.richardxu.common.lang.CollectionUtil;

/**
 * FIXME
 * 
 * @author <a href="mailto:xuc@iphonele.com">saga67</a>
 * 
 * @version create on 2012-4-5 上午12:56:52
 */
public class ReflectionUtil {

	/** an empty class array */
	public static final Class<?>[] NO_PARAMETERS = new Class[0];

	/** an empty object array */
	public static final Object[] NO_ARGUMENTS = new Object[0];

	/** an empty object array */
	public static final Type[] NO_TYPES = new Type[0];

	private static final Pattern CGLIB_RENAMED_METHOD_PATTERN = Pattern
			.compile("CGLIB\\$(.+)\\$\\d+");

	private ReflectionUtil() {

	}

	/**
	 * 从<code>Class</code>及父类中查找<code>Field</code>， 不包括顶层对象<code>Object</code>
	 * <p>
	 * 如果未找到返回<code>null</code>
	 * 
	 * @param clazz
	 *            目标类
	 * @param fieldName
	 *            <code>Field</code>名
	 * @return <code>Field</code>，如果没找到返回<code>null</code>
	 */
	public static Field findField(Class<?> clazz, String fieldName) {
		return findField(clazz, fieldName, null);
	}

	/**
	 * 从<code>Class</code>及父类中查找<code>Field</code>， 不包括顶层对象<code>Object</code>
	 * <p>
	 * 如果未找到返回<code>null</code>
	 * 
	 * @param clazz
	 *            目标类
	 * @param fieldName
	 *            <code>Field</code>名
	 * @param type
	 *            <code>Field</code>类型
	 * @return <code>Field</code>，如果没找到返回<code>null</code>
	 */
	public static Field findField(Class<?> clazz, String fieldName,
			Class<?> type) {
		Assert.notNull(clazz, "Class must not be null");
		Assert.isTrue(fieldName != null || type != null,
				"Either name or type of the field must be specified");
		Class<?> searchType = clazz;
		while (!Object.class.equals(searchType) && searchType != null) {
			Field[] fields = searchType.getDeclaredFields();
			for (Field field : fields) {
				if ((fieldName == null || fieldName.equals(field.getName()))
						&& (type == null || type.equals(field.getType()))) {
					return field;
				}
			}
			searchType = searchType.getSuperclass();
		}
		return null;
	}

	/**
	 * 设置<code>Field</code>值
	 * 
	 * @param field
	 * @see <code>Field</code>
	 * @param target
	 *            目标对象
	 * @param value
	 *            设置的值
	 */
	public static void setField(Field field, Object target, Object value) {
		try {
			field.set(target, value);
		} catch (IllegalAccessException ex) {
			handleReflectionException(ex);
			throw new IllegalStateException(
					"Unexpected reflection exception - "
							+ ex.getClass().getName() + ": " + ex.getMessage());
		}
	}

	/**
	 * 获取<code>的值
	 * 
	 * @param field
	 * @see <code>Field</code>
	 * @param target
	 *            目标对象
	 * @return <code>Field</code>值
	 */
	public static Object getField(Field field, Object target) {
		try {
			return field.get(target);
		} catch (IllegalAccessException ex) {
			handleReflectionException(ex);
			throw new IllegalStateException(
					"Unexpected reflection exception - "
							+ ex.getClass().getName() + ": " + ex.getMessage());
		}
	}

	/**
	 * 从<code>Class</code>及父类中查找<code>Method</code>， 不包括顶层对象<code>Object</code>
	 * <p>
	 * 如果未找到返回<code>null</code>
	 * 
	 * @param clazz
	 *            目标类
	 * @param methodName
	 *            方法名
	 * @return <code>Method</code>, 如果未找到返回<code>null</code>
	 */
	public static Method findMethod(Class<?> clazz, String methodName) {
		return findMethod(clazz, methodName, new Class[0]);
	}

	/**
	 * 从<code>Class</code>及父类中查找<code>Method</code>， 不包括顶层对象<code>Object</code>
	 * <p>
	 * ，如果未找到返回<code>null</code>
	 * 
	 * @param clazz
	 *            目标类
	 * @param methodName
	 *            方法名
	 * @param paramTypes
	 *            方法的参数类型
	 * @return <code>Method</code>, 如果未找到返回<code>null</code>
	 */
	public static Method findMethod(Class<?> clazz, String methodName,
			Class<?>... paramTypes) {
		Assert.notNull(clazz, "Class must not be null");
		Assert.notNull(methodName, "Method name must not be null");
		Class<?> searchType = clazz;
		while (searchType != null) {
			Method[] methods = (searchType.isInterface() ? searchType
					.getMethods() : searchType.getDeclaredMethods());
			for (Method method : methods) {
				if (methodName.equals(method.getName())
						&& (paramTypes == null || Arrays.equals(paramTypes,
								method.getParameterTypes()))) {
					return method;
				}
			}
			searchType = searchType.getSuperclass();
		}
		return null;
	}

	public static Method findDeclaredMethod(Class<?> clazz, String methodName) {
		return findDeclaredMethod(clazz, methodName, false);
	}

	private static Method findDeclaredMethod(Class<?> clazz, String methodName,
			boolean publicOnly) {
		Assert.notNull(clazz, "Class must not be null");
		Assert.notNull(methodName, "Method name must not be null");
		// if ((StringUtil.isBlank(methodName)) || (clazz == null)) {
		// return null;
		// }
		Method[] ms = publicOnly ? clazz.getMethods() : clazz
				.getDeclaredMethods();
		for (Method m : ms) {
			if (m.getName().equals(methodName)) {
				return m;
			}
		}
		return null;
	}

	/**
	 * 方法调用，如果<code>target</code>为<code>null</code>，则为静态方法
	 * 
	 * @param method
	 *            调用的方法
	 * @param target
	 *            目标对象
	 * @return 调用结果
	 * @see #invokeMethod(java.lang.reflect.Method, Object, Object[])
	 */
	public static Object invokeMethod(Method method, Object target) {
		return invokeMethod(method, target, new Object[0]);
	}

	/**
	 * 方法调用，如果<code>target</code>为<code>null</code>，则为静态方法
	 * 
	 * @param method
	 *            调用的方法
	 * @param target
	 *            目标对象
	 * @param args
	 *            方法的参数值
	 * @return 调用结果
	 * @see #invokeMethod(java.lang.reflect.Method, Object, Object[])
	 */
	public static Object invokeMethod(Method method, Object target,
			Object... args) {
		try {
			return method.invoke(target, args);
		} catch (Exception ex) {
			handleReflectionException(ex);
		}
		throw new IllegalStateException("Should never get here");
	}

	/**
	 * Invokes any method of a class, even private ones.
	 * 
	 * @param c
	 *            class to examine
	 * @param obj
	 *            object to inspect
	 * @param method
	 *            method to invoke
	 * @param paramClasses
	 *            parameter types
	 * @param params
	 *            parameters
	 */
	public static Object invokeDeclared(Class<?> c, Object obj, String method,
			Class<?>[] paramClasses, Object[] params)
			throws IllegalAccessException, NoSuchMethodException,
			InvocationTargetException {
		Method m = c.getDeclaredMethod(method, paramClasses);
		m.setAccessible(true);
		return m.invoke(obj, params);
	}

	/**
	 * Invokes any method of a class suppressing java access checking.
	 * 
	 * @param obj
	 *            object to inspect
	 * @param method
	 *            method to invoke
	 * @param paramClasses
	 *            parameter types
	 * @param params
	 *            parameters
	 */
	public static Object invokeDeclared(Object obj, String method,
			Class<?>[] paramClasses, Object[] params)
			throws IllegalAccessException, NoSuchMethodException,
			InvocationTargetException {
		Method m = obj.getClass().getDeclaredMethod(method, paramClasses);
		m.setAccessible(true);
		return m.invoke(obj, params);
	}

	public static Object invokeDeclared(Object obj, String method,
			Object[] params) throws IllegalAccessException,
			NoSuchMethodException, InvocationTargetException {
		Class<?>[] paramClass = getClasses(params);
		return invokeDeclared(obj, method, paramClass, params);
	}

	public static Object invokeDeclared(Class<?> c, Object obj, String method,
			Object[] params) throws IllegalAccessException,
			NoSuchMethodException, InvocationTargetException {
		Class<?>[] paramClass = getClasses(params);
		return invokeDeclared(c, obj, method, paramClass, params);
	}

	/**
	 * Returns classes from array of specified objects.
	 */
	public static Class<?>[] getClasses(Object... objects) {
		if (objects == null) {
			return null;
		}
		Class<?>[] result = new Class[objects.length];
		for (int i = 0; i < objects.length; i++) {
			if (objects[i] != null) {
				result[i] = objects[i].getClass();
			}
		}
		return result;
	}

	/**
	 * JDBC方法调用，如果<code>target</code>为<code>null</code>，则为静态方法
	 * 
	 * @param method
	 *            调用的方法
	 * @param target
	 *            目标对象
	 * @return 调用结果
	 * @throws SQLException
	 * @see #invokeMethod(java.lang.reflect.Method, Object, Object[])
	 */
	public static Object invokeJdbcMethod(Method method, Object target)
			throws SQLException {
		return invokeJdbcMethod(method, target, new Object[0]);
	}

	/**
	 * JDBC方法调用，如果<code>target</code>为<code>null</code>，则为静态方法
	 * 
	 * @param method
	 *            调用的方法
	 * @param target
	 *            目标对象
	 * @param args
	 *            方法的参数值
	 * @return 调用结果
	 * @throws SQLException
	 * @see #invokeMethod(java.lang.reflect.Method, Object, Object[])
	 */
	public static Object invokeJdbcMethod(Method method, Object target,
			Object... args) throws SQLException {
		try {
			return method.invoke(target, args);
		} catch (IllegalAccessException ex) {
			handleReflectionException(ex);
		} catch (InvocationTargetException ex) {
			if (ex.getTargetException() instanceof SQLException) {
				throw (SQLException) ex.getTargetException();
			}
			handleInvocationTargetException(ex);
		}
		throw new IllegalStateException("Should never get here");
	}

	/**
	 * 处理反射的异常
	 * 
	 * @param ex
	 *            the reflection exception to handle
	 */
	public static void handleReflectionException(Exception ex) {
		if (ex instanceof NoSuchMethodException) {
			throw new IllegalStateException("Method not found: "
					+ ex.getMessage());
		}
		if (ex instanceof IllegalAccessException) {
			throw new IllegalStateException("Could not access method: "
					+ ex.getMessage());
		}
		if (ex instanceof InvocationTargetException) {
			handleInvocationTargetException((InvocationTargetException) ex);
		}
		if (ex instanceof RuntimeException) {
			throw (RuntimeException) ex;
		}
		throw new UndeclaredThrowableException(ex);
	}

	/**
	 * 处理反射的异常
	 * 
	 * @param ex
	 *            the invocation target exception to handle
	 */
	public static void handleInvocationTargetException(
			InvocationTargetException ex) {
		rethrowRuntimeException(ex.getTargetException());
	}

	/**
	 * Rethrow the given {@link Throwable exception}
	 * 
	 * @param ex
	 *            the exception to rethrow
	 * @throws RuntimeException
	 *             the rethrown exception
	 */
	public static void rethrowRuntimeException(Throwable ex) {
		if (ex instanceof RuntimeException) {
			throw (RuntimeException) ex;
		}
		if (ex instanceof Error) {
			throw (Error) ex;
		}
		throw new UndeclaredThrowableException(ex);
	}

	/**
	 * Rethrow the given {@link Throwable exception}
	 * 
	 * @param ex
	 *            the exception to rethrow
	 * @throws Exception
	 *             the rethrown exception (in case of a checked exception)
	 */
	public static void rethrowException(Throwable ex) throws Exception {
		if (ex instanceof Exception) {
			throw (Exception) ex;
		}
		if (ex instanceof Error) {
			throw (Error) ex;
		}
		throw new UndeclaredThrowableException(ex);
	}

	/**
	 * Determine whether the given method explicitly declares the given
	 * exception or one of its superclasses, which means that an exception of
	 * that type can be propagated as-is within a reflective invocation.
	 * 
	 * @param method
	 *            the declaring method
	 * @param exceptionType
	 *            the exception to throw
	 * @return <code>true</code> if the exception can be thrown as-is;
	 *         <code>false</code> if it needs to be wrapped
	 */
	public static boolean declaresException(Method method,
			Class<?> exceptionType) {
		Assert.notNull(method, "Method must not be null");
		Class<?>[] declaredExceptions = method.getExceptionTypes();
		for (Class<?> declaredException : declaredExceptions) {
			if (declaredException.isAssignableFrom(exceptionType)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断是否为“常量”
	 * 
	 * @param field
	 *            待检查的<code>Field</code>
	 */
	public static boolean isPublicStaticFinal(Field field) {
		int modifiers = field.getModifiers();
		return (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers) && Modifier
				.isFinal(modifiers));
	}

	/**
	 * 判断是否为<code>equals</code>方法
	 * 
	 * @see java.lang.Object#equals(Object)
	 */
	public static boolean isEqualsMethod(Method method) {
		if (method == null || !method.getName().equals("equals")) {
			return false;
		}
		Class<?>[] paramTypes = method.getParameterTypes();
		return (paramTypes.length == 1 && paramTypes[0] == Object.class);
	}

	/**
	 * 判断是否为<code>hashCode</code>方法
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public static boolean isHashCodeMethod(Method method) {
		return (method != null && method.getName().equals("hashCode") && method
				.getParameterTypes().length == 0);
	}

	/**
	 * 判断是否为<code>toString</code>方法
	 * 
	 * @see java.lang.Object#toString()
	 */
	public static boolean isToStringMethod(Method method) {
		return (method != null && method.getName().equals("toString") && method
				.getParameterTypes().length == 0);
	}

	/**
	 * 判断是否为<code>{@link java.lang.Object}</code>的方法
	 */
	public static boolean isObjectMethod(Method method) {
		return method.getDeclaringClass() == Object.class;
	}

	/**
	 * 判断是否为<code>CGLIB</code>的<code>renamed</code>的方法
	 * 
	 * @param renamedMethod
	 *            被检查的方法
	 * @see net.sf.cglib.proxy.Enhancer#rename
	 */
	public static boolean isCglibRenamedMethod(Method renamedMethod) {
		return CGLIB_RENAMED_METHOD_PATTERN.matcher(renamedMethod.getName())
				.matches();
	}

	/**
	 * 设置<code>Field</code>的访问权限
	 * 
	 * @param field
	 *            待设置的<code>Field</code>
	 * @see java.lang.reflect.Field#setAccessible
	 */
	public static void makeAccessible(Field field) {
		if ((!Modifier.isPublic(field.getModifiers())
				|| !Modifier.isPublic(field.getDeclaringClass().getModifiers()) || Modifier
					.isFinal(field.getModifiers())) && !field.isAccessible()) {
			field.setAccessible(true);
		}
	}

	/**
	 * 设置方法的访问权限
	 * 
	 * @param method
	 *            待设置的方法
	 * @see java.lang.reflect.Method#setAccessible
	 */
	public static void makeAccessible(Method method) {
		if ((!Modifier.isPublic(method.getModifiers()) || !Modifier
				.isPublic(method.getDeclaringClass().getModifiers()))
				&& !method.isAccessible()) {
			method.setAccessible(true);
		}
	}

	/**
	 * 设置构造器的访问权限
	 * 
	 * @param ctor
	 *            待设置的构造器
	 * @see java.lang.reflect.Constructor#setAccessible
	 */
	public static void makeAccessible(Constructor<?> ctor) {
		if ((!Modifier.isPublic(ctor.getModifiers()) || !Modifier.isPublic(ctor
				.getDeclaringClass().getModifiers())) && !ctor.isAccessible()) {
			ctor.setAccessible(true);
		}
	}

	/**
	 * 类和父类所有匹配的方法执行回调操作。
	 * 
	 * 
	 * @param clazz
	 *            开始查找的类
	 * @param mc
	 *            回调方法
	 * @see #doWithMethods(Class, MethodCallback, MethodFilter)
	 */
	public static void doWithMethods(Class<?> clazz, MethodCallback mc)
			throws IllegalArgumentException {
		doWithMethods(clazz, mc, null);
	}

	/**
	 * 类和父类所有匹配的方法执行回调操作。
	 * 
	 * 
	 * @param clazz
	 *            开始查找的类
	 * @param mc
	 *            回调方法
	 * @param mf
	 *            回调方法的过滤器
	 */
	public static void doWithMethods(Class<?> clazz, MethodCallback mc,
			MethodFilter mf) throws IllegalArgumentException {

		// Keep backing up the inheritance hierarchy.
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			if (mf != null && !mf.matches(method)) {
				continue;
			}
			try {
				mc.doWith(method);
			} catch (IllegalAccessException ex) {
				throw new IllegalStateException(
						"Shouldn't be illegal to access method '"
								+ method.getName() + "': " + ex);
			}
		}
		if (clazz.getSuperclass() != null) {
			doWithMethods(clazz.getSuperclass(), mc, mf);
		} else if (clazz.isInterface()) {
			for (Class<?> superIfc : clazz.getInterfaces()) {
				doWithMethods(superIfc, mc, mf);
			}
		}
	}

	/**
	 * 获取所有declared method方法
	 */
	public static Method[] getAllDeclaredMethods(Class<?> leafClass)
			throws IllegalArgumentException {
		final List<Method> methods = CollectionUtil.getArrayList(32);
		doWithMethods(leafClass, new MethodCallback() {
			public void doWith(Method method) {
				methods.add(method);
			}
		});
		return methods.toArray(new Method[methods.size()]);
	}

	/**
	 * 获取所有the unique set of declared method 方法
	 */
	public static Method[] getUniqueDeclaredMethods(Class<?> leafClass)
			throws IllegalArgumentException {
		final List<Method> methods = CollectionUtil.getArrayList(32);
		doWithMethods(leafClass, new MethodCallback() {
			public void doWith(Method method) {
				boolean knownSignature = false;
				Method methodBeingOverriddenWithCovariantReturnType = null;

				for (Method existingMethod : methods) {
					if (method.getName().equals(existingMethod.getName())
							&& Arrays.equals(method.getParameterTypes(),
									existingMethod.getParameterTypes())) {
						// is this a covariant return type situation?
						if (existingMethod.getReturnType() != method
								.getReturnType()
								&& existingMethod.getReturnType()
										.isAssignableFrom(
												method.getReturnType())) {
							methodBeingOverriddenWithCovariantReturnType = existingMethod;
						} else {
							knownSignature = true;
						}
						break;
					}
				}
				if (methodBeingOverriddenWithCovariantReturnType != null) {
					methods.remove(methodBeingOverriddenWithCovariantReturnType);
				}
				if (!knownSignature && !isCglibRenamedMethod(method)) {
					methods.add(method);
				}
			}
		});
		return methods.toArray(new Method[methods.size()]);
	}

	/**
	 * 类中所有<code>Field</code>执行回调操作。
	 * 
	 * 
	 * @param clazz
	 *            目标类
	 * @param fc
	 *            <code>Field</code>的回调
	 */
	public static void doWithFields(Class<?> clazz, FieldCallback fc)
			throws IllegalArgumentException {
		doWithFields(clazz, fc, null);
	}

	/**
	 * 类中所有<code>Field</code>执行回调操作。
	 * 
	 * 
	 * @param clazz
	 *            目标类
	 * @param fc
	 *            <code>Field</code>的回调
	 * @param ff
	 *            <code>Field</code>的回调的过滤器
	 */
	public static void doWithFields(Class<?> clazz, FieldCallback fc,
			FieldFilter ff) throws IllegalArgumentException {

		// Keep backing up the inheritance hierarchy.
		Class<?> targetClass = clazz;
		do {
			Field[] fields = targetClass.getDeclaredFields();
			for (Field field : fields) {
				// Skip static and final fields.
				if (ff != null && !ff.matches(field)) {
					continue;
				}
				try {
					fc.doWith(field);
				} catch (IllegalAccessException ex) {
					throw new IllegalStateException(
							"Shouldn't be illegal to access field '"
									+ field.getName() + "': " + ex);
				}
			}
			targetClass = targetClass.getSuperclass();
		} while (targetClass != null && targetClass != Object.class);
	}

	/**
	 * 拷贝所有包括继承的<code>Field</code>，要求对象必须有无参构造器
	 * 
	 * @throws IllegalArgumentException
	 *             if the arguments are incompatible
	 */
	public static void shallowCopyFieldState(final Object src, final Object dest)
			throws IllegalArgumentException {
		if (src == null) {
			throw new IllegalArgumentException(
					"Source for field copy cannot be null");
		}
		if (dest == null) {
			throw new IllegalArgumentException(
					"Destination for field copy cannot be null");
		}
		if (!src.getClass().isAssignableFrom(dest.getClass())) {
			throw new IllegalArgumentException("Destination class ["
					+ dest.getClass().getName()
					+ "] must be same or subclass as source class ["
					+ src.getClass().getName() + "]");
		}
		doWithFields(src.getClass(), new FieldCallback() {
			public void doWith(Field field) throws IllegalArgumentException,
					IllegalAccessException {
				makeAccessible(field);
				Object srcValue = field.get(src);
				field.set(dest, srcValue);
			}
		}, COPYABLE_FIELDS);
	}

	/**
	 * 方法回调
	 */
	public interface MethodCallback {

		/**
		 * 执行的操作的方法。
		 * 
		 * @param method
		 *            the method to operate on
		 */
		void doWith(Method method) throws IllegalArgumentException,
				IllegalAccessException;
	}

	/**
	 * 方法回调的过滤器
	 */
	public interface MethodFilter {

		/**
		 * 是否匹配
		 * 
		 * @param method
		 *            the method to check
		 */
		boolean matches(Method method);
	}

	/**
	 * <code>Field</code>回调
	 */
	public interface FieldCallback {

		/**
		 * Perform an operation using the given field.
		 * 
		 * @param field
		 *            the field to operate on
		 */
		void doWith(Field field) throws IllegalArgumentException,
				IllegalAccessException;
	}

	/**
	 * <code>Field</code>回调的过滤器
	 */
	public interface FieldFilter {

		/**
		 * 是否匹配
		 * 
		 * @param field
		 *            the field to check
		 */
		boolean matches(Field field);
	}

	/**
	 * 预建<code>FieldFilter<code>匹配所有非静态，非final字段
	 */
	public static FieldFilter COPYABLE_FIELDS = new FieldFilter() {

		public boolean matches(Field field) {
			return !(Modifier.isStatic(field.getModifiers()) || Modifier
					.isFinal(field.getModifiers()));
		}
	};

	/**
	 * 预建<code>MethodFilter</code>匹配所有非桥接的方法
	 */
	public static MethodFilter NON_BRIDGED_METHODS = new MethodFilter() {

		public boolean matches(Method method) {
			return !method.isBridge();
		}
	};

	/**
	 * 预建<code>MethodFilter</code>匹配所有非桥接的方法，不包括<code>java.lang.Object</code>
	 */
	public static MethodFilter USER_DECLARED_METHODS = new MethodFilter() {

		public boolean matches(Method method) {
			return (!method.isBridge() && method.getDeclaringClass() != Object.class);
		}
	};

	/**
	 * 判断是否被重写
	 */
	public static boolean isOverridable(Method method, Class<?> targetClass) {
		Assert.notNull(method, "method must not be null");

		if (Modifier.isPrivate(method.getModifiers())) {
			return false;
		}
		if (Modifier.isPublic(method.getModifiers())
				|| Modifier.isProtected(method.getModifiers())) {
			return true;
		}
		return ClassUtil.getPackageName(method.getDeclaringClass()).equals(
				ClassUtil.getPackageName(targetClass));
	}

	/**
	 * FIXME
	 */
	public static Method getMostSpecificMethod(Method method,
			Class<?> targetClass) {
		Assert.notNull(targetClass, "class must not be null");

		Method specificMethod = null;
		if (method != null && isOverridable(method, targetClass)
				&& targetClass != null
				&& !targetClass.equals(method.getDeclaringClass())) {
			try {
				specificMethod = findMethod(targetClass, method.getName(),
						method.getParameterTypes());
			} catch (AccessControlException ex) {
				// security settings are disallowing reflective access; leave
				// 'specificMethod' null and fall back to 'method' below
			}
		}
		return (specificMethod != null ? specificMethod : method);
	}

	// ---------------------------------------------------------------- generics

	/**
	 * Returns component type of the given <code>type</code>. For
	 * <code>ParameterizedType</code> it returns the last type in array.
	 */
	public static Class<?> getComponentType(Type type) {
		return getComponentType(type, -1);
	}

	/**
	 * Returns the component type of the given <code>type</code>.<br>
	 * For example the following types all have the component-type MyClass:
	 * <ul>
	 * <li>MyClass[]</li>
	 * <li>List&lt;MyClass&gt;</li>
	 * <li>Foo&lt;? extends MyClass&gt;</li>
	 * <li>Bar&lt;? super MyClass&gt;</li>
	 * <li>&lt;T extends MyClass&gt; T[]</li>
	 * </ul>
	 * 
	 * @param type
	 *            is the type where to get the component type from.
	 * @return the component type of the given <code>type</code> or
	 *         <code>null</code> if the given <code>type</code> does NOT have a
	 *         single (component) type.
	 */
	public static Class<?> getComponentType(Type type, int index) {
		Assert.notNull(type, "type must not be null");

		if (type instanceof Class) {
			Class<?> clazz = (Class<?>) type;
			if (clazz.isArray()) {
				return clazz.getComponentType();
			}
		} else if (type instanceof ParameterizedType) {
			ParameterizedType pt = (ParameterizedType) type;
			Type[] generics = pt.getActualTypeArguments();
			if (index < 0) {
				index = generics.length + index;
			}
			if (index < generics.length) {
				return toClass(generics[index]);
			}
		} else if (type instanceof GenericArrayType) {
			GenericArrayType gat = (GenericArrayType) type;
			return toClass(gat.getGenericComponentType());
		}
		return null;
	}

	public static Class<?> getGenericSuperType(Class<?> type, int index) {
		return getComponentType(type.getGenericSuperclass(), index);
	}

	public static Class<?> getGenericSuperType(Class<?> type) {
		return getComponentType(type.getGenericSuperclass());
	}

	/**
	 * Returns {@link Class} for the given <code>type</code>.<br>
	 * Examples: <br>
	 * <table border="1">
	 * <tr>
	 * <th><code>type</code></th>
	 * <th><code>getSimpleType(type)</code></th>
	 * </tr>
	 * <tr>
	 * <td><code>String</code></td>
	 * <td><code>String</code></td> </td>
	 * <tr>
	 * <td><code>List&lt;String&gt;</code></td>
	 * <td><code>List</code></td> </td>
	 * <tr>
	 * <td><code>&lt;T extends MyClass&gt; T[]</code></td>
	 * <td><code>MyClass[]</code></td> </td>
	 * </table>
	 * 
	 * @param type
	 *            is the type to convert.
	 * @return the closest class representing the given <code>type</code>.
	 */
	public static Class<?> toClass(Type type) {
		Assert.notNull(type, "type must not be null");

		if (type instanceof Class) {
			return (Class<?>) type;
		}
		if (type instanceof ParameterizedType) {
			ParameterizedType pt = (ParameterizedType) type;
			return toClass(pt.getRawType());
		}
		if (type instanceof WildcardType) {
			WildcardType wt = (WildcardType) type;
			Type[] lower = wt.getLowerBounds();
			if (lower.length == 1) {
				return toClass(lower[0]);
			}
			Type[] upper = wt.getUpperBounds();
			if (upper.length == 1) {
				return toClass(upper[0]);
			}
		} else if (type instanceof GenericArrayType) {
			GenericArrayType gat = (GenericArrayType) type;
			Class<?> componentType = toClass(gat.getGenericComponentType());
			// this is sort of stupid but there seems no other way...
			return Array.newInstance(componentType, 0).getClass();
		} else if (type instanceof TypeVariable) {
			TypeVariable<?> tv = (TypeVariable<?>) type;
			Type[] bounds = tv.getBounds();
			if (bounds.length == 1) {
				return toClass(bounds[0]);
			}
		}
		return null;
	}

	// ---------------------------------------------------------------- compare

	/**
	 * Compares method declarations: signature and return types.
	 */
	public static boolean compareDeclarations(Method first, Method second) {
		Assert.notNull(first, "method must not be null");
		Assert.notNull(second, "method must not be null");

		if (first.getReturnType() != second.getReturnType()) {
			return false;
		}
		return compareSignatures(first, second);
	}

	/**
	 * Compares method signatures: names and parameters.
	 */
	public static boolean compareSignatures(Method first, Method second) {
		Assert.notNull(first, "method must not be null");
		Assert.notNull(second, "method must not be null");

		if (!first.getName().equals(second.getName())) {
			return false;
		}
		return compareParameters(first.getParameterTypes(),
				second.getParameterTypes());
	}

	/**
	 * Compares constructor signatures: names and parameters.
	 */
	public static boolean compareSignatures(Constructor<?> first,
			Constructor<?> second) {
		Assert.notNull(first, "constructor must not be null");
		Assert.notNull(second, "constructor must not be null");

		if (!first.getName().equals(second.getName())) {
			return false;
		}
		return compareParameters(first.getParameterTypes(),
				second.getParameterTypes());
	}

	public static boolean compareSignatures(Field first, Field second) {
		Assert.notNull(first, "field must not be null");
		Assert.notNull(second, "field must not be null");

		return first.getName().equals(second.getName());
	}

	/**
	 * Compares method or ctor parameters.
	 */
	public static boolean compareParameters(Class<?>[] first, Class<?>[] second) {
		Assert.notNull(first, "Class arrays must not be null");
		Assert.notNull(second, "Class arrays must not be null");

		if (first.length != second.length) {
			return false;
		}
		for (int i = 0; i < first.length; i++) {
			if (first[i] != second[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns <code>true</code> if class member is public.
	 */
	public static boolean isPublic(Member member) {
		Assert.notNull(member, "Member must not be null");
		return Modifier.isPublic(member.getModifiers());
	}

	/**
	 * Returns <code>true</code> if class member is static.
	 */
	public static boolean isStatic(Member member) {
		Assert.notNull(member, "Member must not be null");
		return Modifier.isStatic(member.getModifiers());
	}

	public static void forceAccess(AccessibleObject accObject) {
		Assert.notNull(accObject, "AccessibleObject must not be null");
		if (accObject.isAccessible()) {
			return;
		}
		accObject.setAccessible(true);
	}

	public static void forceAccess(AccessibleObject... accessibleObjects) {
		Assert.notNull(accessibleObjects,
				"AccessibleObject arrays must not be null");
		AccessibleObject.setAccessible(accessibleObjects, true);
	}

	// ----------------------------------------------------------------
	// accessible methods

	/**
	 * Returns array of all methods that are accessible from given class.
	 * 
	 * @see #getAccessibleMethods(Class, Class)
	 */
	public static Method[] getAccessibleMethods(Class<?> clazz) {
		return getAccessibleMethods(clazz, Object.class);
	}

	/**
	 * Returns array of all methods that are accessible from given class, upto
	 * limit (usually <code>Object.class</code>). Abstract methods are ignored.
	 */
	public static Method[] getAccessibleMethods(Class<?> clazz, Class<?> limit) {
		Assert.notNull(clazz, "Class must not be null");
		Assert.notNull(limit, "Class must not be null");

		Package topPackage = clazz.getPackage();
		List<Method> methodList = CollectionUtil.getArrayList();
		int topPackageHash = topPackage == null ? 0 : topPackage.hashCode();
		boolean top = true;
		do {
			if (clazz == null) {
				break;
			}
			Method[] declaredMethods = clazz.getDeclaredMethods();
			for (Method method : declaredMethods) {
				if (Modifier.isVolatile(method.getModifiers())) {
					continue;
				}
				// if (Modifier.isAbstract(method.getModifiers())) {
				// continue;
				// }
				if (top) { // add all top declared methods
					methodList.add(method);
					continue;
				}
				int modifier = method.getModifiers();
				if (Modifier.isPrivate(modifier)) {
					continue; // ignore super private methods
				}
				if (Modifier.isAbstract(modifier)) { // ignore super
														// abstract
														// methods
					continue;
				}
				if (Modifier.isPublic(modifier)) {
					addMethodIfNotExist(methodList, method); // add super public
																// methods
					continue;
				}
				if (Modifier.isProtected(modifier)) {
					addMethodIfNotExist(methodList, method); // add super
																// protected
																// methods
					continue;
				}
				// add super default methods from the same package
				Package pckg = method.getDeclaringClass().getPackage();
				int pckgHash = pckg == null ? 0 : pckg.hashCode();
				if (pckgHash == topPackageHash) {
					addMethodIfNotExist(methodList, method);
				}
			}
			top = false;
		} while ((clazz = clazz.getSuperclass()) != limit);

		Method[] methods = new Method[methodList.size()];
		for (int i = 0; i < methods.length; i++) {
			methods[i] = methodList.get(i);
		}
		return methods;
	}

	private static void addMethodIfNotExist(List<Method> allMethods,
			Method newMethod) {
		for (Method m : allMethods) {
			if (compareSignatures(m, newMethod)) {
				return;
			}
		}
		allMethods.add(newMethod);
	}

	// ----------------------------------------------------------------
	// accessible fields

	public static Field[] getAccessibleFields(Class<?> clazz) {
		return getAccessibleFields(clazz, Object.class);
	}

	public static Field[] getAccessibleFields(Class<?> clazz, Class<?> limit) {
		Assert.notNull(clazz, "Class must not be null");
		Assert.notNull(limit, "Class must not be null");

		Package topPackage = clazz.getPackage();
		List<Field> fieldList = CollectionUtil.getArrayList();
		int topPackageHash = topPackage == null ? 0 : topPackage.hashCode();
		boolean top = true;
		do {
			if (clazz == null) {
				break;
			}
			Field[] declaredFields = clazz.getDeclaredFields();
			for (Field field : declaredFields) {
				if (top) { // add all top declared fields
					fieldList.add(field);
					continue;
				}
				int modifier = field.getModifiers();
				if (Modifier.isPrivate(modifier)) {
					continue; // ignore super private fields
				}
				if (Modifier.isPublic(modifier)) {
					addFieldIfNotExist(fieldList, field); // add super public
															// methods
					continue;
				}
				if (Modifier.isProtected(modifier)) {
					addFieldIfNotExist(fieldList, field); // add super protected
															// methods
					continue;
				}
				// add super default methods from the same package
				Package pckg = field.getDeclaringClass().getPackage();
				int pckgHash = pckg == null ? 0 : pckg.hashCode();
				if (pckgHash == topPackageHash) {
					addFieldIfNotExist(fieldList, field);
				}
			}
			top = false;
		} while ((clazz = clazz.getSuperclass()) != limit);

		Field[] fields = new Field[fieldList.size()];
		for (int i = 0; i < fields.length; i++) {
			fields[i] = fieldList.get(i);
		}
		return fields;
	}

	private static void addFieldIfNotExist(List<Field> allFields, Field newField) {
		for (Field f : allFields) {
			if (compareSignatures(f, newField)) {
				return;
			}
		}
		allFields.add(newField);
	}

	// ----------------------------------------------------------------
	// supported methods

	public static Method[] getSupportedMethods(Class<?> clazz) {
		return getSupportedMethods(clazz, Object.class);
	}

	/**
	 * Returns a <code>Method</code> array of the methods to which instances of
	 * the specified respond except for those methods defined in the class
	 * specified by limit or any of its superclasses. Note that limit is usually
	 * used to eliminate them methods defined by <code>java.lang.Object</code>.
	 * If limit is <code>null</code> then all methods are returned.
	 */
	public static Method[] getSupportedMethods(Class<?> clazz, Class<?> limit) {
		Assert.notNull(clazz, "Class must not be null");
		Assert.notNull(limit, "Class must not be null");

		List<Method> supportedMethods = CollectionUtil.getArrayList();
		for (Class<?> c = clazz; c != limit; c = c.getSuperclass()) {
			Method[] methods = c.getDeclaredMethods();
			for (Method method : methods) {
				boolean found = false;
				for (Method supportedMethod : supportedMethods) {
					if (compareSignatures(method, supportedMethod)) {
						found = true;
						break;
					}
				}
				if (!found) {
					supportedMethods.add(method);
				}
			}
		}
		return supportedMethods.toArray(new Method[supportedMethods.size()]);
	}

	public static Field[] getSupportedFields(Class<?> clazz) {
		return getSupportedFields(clazz, Object.class);
	}

	public static Field[] getSupportedFields(Class<?> clazz, Class<?> limit) {
		Assert.notNull(clazz, "Class must not be null");
		Assert.notNull(limit, "Class must not be null");

		List<Field> supportedFields = CollectionUtil.getArrayList();
		for (Class<?> c = clazz; c != limit; c = c.getSuperclass()) {
			Field[] fields = c.getDeclaredFields();
			for (Field field : fields) {
				boolean found = false;
				for (Field supportedField : supportedFields) {
					if (compareSignatures(field, supportedField)) {
						found = true;
						break;
					}
				}
				if (!found) {
					supportedFields.add(field);
				}
			}
		}
		return supportedFields.toArray(new Field[supportedFields.size()]);
	}

	/**
	 * Defines a class from byte array into the system class loader.
	 * 
	 * @see #defineClass(String, byte[], ClassLoader)
	 */
	public static <T> Class<T> defineClass(byte[] classData) {
		return defineClass(null, classData,
				ClassLoaderUtil.getDefaultClassLoader());
	}

	/**
	 * Defines a class from byte array into the system class loader.
	 * 
	 * @see #defineClass(String, byte[], ClassLoader)
	 */
	public static Class<?> defineClass(String className, byte[] classData) {
		return defineClass(className, classData,
				ClassLoaderUtil.getDefaultClassLoader());
	}

	/**
	 * Defines a class from byte array into the specified class loader.
	 * 
	 * @see #defineClass(String, byte[], ClassLoader)
	 */
	public static Class<?> defineClass(byte[] classData, ClassLoader classLoader) {
		return defineClass(null, classData, classLoader);
	}

	/**
	 * Defines a class from byte array into the specified class loader. Warning:
	 * this is a <b>hack</b>!
	 * 
	 * @param className
	 *            optional class name, may be <code>null</code>
	 * @param classData
	 *            bytecode data
	 * @param classLoader
	 *            classloader that will load class
	 */
	@SuppressWarnings("unchecked")
	public static <T> Class<T> defineClass(String className, byte[] classData,
			ClassLoader classLoader) {
		try {
			return (Class<T>) invokeDeclared(ClassLoader.class, classLoader,
					"defineClass", new Class[] { String.class, byte[].class,
							int.class, int.class }, new Object[] { className,
							classData, new Integer(0),
							new Integer(classData.length) });
		} catch (Throwable th) {
			throw new RuntimeException("Unable to define class: " + className,
					th);
		}
	}
}
