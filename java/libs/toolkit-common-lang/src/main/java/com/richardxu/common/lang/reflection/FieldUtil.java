/**
 * 
 */
package com.richardxu.common.lang.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import com.richardxu.common.lang.ArrayUtil;
import com.richardxu.common.lang.Assert;
import com.richardxu.common.lang.CollectionUtil;
import com.richardxu.common.lang.exception.FieldException;

/**
 * 有关<code>Field</code>处理的工具类。
 * 
 * @author <a href="mailto:xuc@iphonele.com">saga67</a>
 * 
 * @version 1.0.0
 * @date create on 2011-10-13 上午04:40:38
 */
public class FieldUtil {

	private FieldUtil() {

	}

	/**
	 * 获取类及父类的所有<code>Field</code>，不包括<code>Object</code>的 <code>Field</code>
	 * 
	 * @param clazz
	 *            要获取的类
	 * @return <code>Field</code>数组
	 */
	public static Field[] getAllFieldsOfClass(Class<?> clazz) {
		Assert.notNull(clazz, "Class must not be null");

		return _getAllFieldsOfClass(clazz);
	}

	/**
	 * 获取类及父类的所有非静态<code>Field</code>，不包括<code>Object</code>的 <code>Field</code>
	 * 
	 * @param clazz
	 *            要获取的类
	 * @return <code>Field</code>数组
	 */
	public static Field[] getNonStaticFields(Class<?> clazz) {
		Assert.notNull(clazz, "Class must not be null");

		return _getNonStaticFields(clazz);
	}

	/**
	 * 要求参数不为<code>null</code>
	 * <p>
	 * 获取类及父类的所有非静态<code>Field</code>，不包括<code>Object</code>的 <code>Field</code>
	 * 
	 * @param clazz
	 *            要获取的类
	 * @return <code>Field</code>数组
	 */
	static Field[] _getNonStaticFields(Class<?> clazz) {
		List<Field> fields = CollectionUtil.getArrayList();
		for (Class<?> itr = clazz; hasSuperClass(itr);) {
			Field[] declaredFields = itr.getDeclaredFields();
			for (Field field : declaredFields) {
				if (!Modifier.isStatic(field.getModifiers())) {
					fields.add(field);
				}
			}
			itr = itr.getSuperclass();
		}

		return fields.toArray(new Field[fields.size()]);
	}

	/**
	 * 要求参数不为<code>null</code>
	 * <p>
	 * 获取类及父类的所有<code>Field</code>，不包括<code>Object</code>的 <code>Field</code>
	 * 
	 * @param clazz
	 *            要获取的类
	 * @return <code>Field</code>数组
	 */
	static Field[] _getAllFieldsOfClass(Class<?> clazz) {
		Field[] fields = null;
		for (Class<?> itr = clazz; hasSuperClass(itr);) {
			fields = (Field[]) ArrayUtil
					.addAll(itr.getDeclaredFields(), fields);
			itr = itr.getSuperclass();
		}
		return fields;
	}

	/**
	 * 获取类及父类的所有<code>Field</code>，不包括<code>Object</code>的 <code>Field</code>
	 * 
	 * @param clazz
	 *            要获取的类
	 * @param accessible
	 *            设置访问权限
	 * @return <code>Field</code>数组
	 */
	public static Field[] getAllFieldsOfClass(Class<?> clazz, boolean accessible) {
		Field[] fields = getAllFieldsOfClass(clazz);
		if (ArrayUtil.isNotEmpty(fields))
			AccessibleObject.setAccessible(fields, accessible);
		return fields;
	}

	/**
	 * 获取对象的所有<code>Field</code>，不包括<code>Object</code>的 <code>Field</code>
	 * 
	 * @param object
	 *            要获取的对象
	 * @return <code>Field</code>数组
	 */
	public static Field[] getAllFieldsOfClass(Object object) {
		Assert.notNull(object, "Object must not be null");

		Field[] fields = _getAllFieldsOfClass(object.getClass());
		return fields;
	}

	/**
	 * 获取对象的所有<code>Field</code>，不包括<code>Object</code>的 <code>Field</code>
	 * 
	 * @param object
	 *            要获取的对象
	 * @param accessible
	 *            设置访问权限
	 * @return <code>Field</code>数组
	 */
	public static Field[] getAllFieldsOfClass(Object object, boolean accessible) {
		Assert.notNull(object, "Object must not be null");

		Field[] fields = getAllFieldsOfClass(object);
		AccessibleObject.setAccessible(fields, accessible);
		return fields;
	}

	/**
	 * 获取类及父类的所有非静态<code>Field</code>，不包括<code>Object</code>的 <code>Field</code>
	 * 
	 * @param clazz
	 *            要获取的类
	 * @param accessible
	 *            设置访问权限
	 * @return <code>Field</code>数组
	 */
	public static Field[] getNonStaticFields(Class<?> clazz, boolean accessible) {
		Field[] fields = getNonStaticFields(clazz);
		if (ArrayUtil.isNotEmpty(fields))
			AccessibleObject.setAccessible(fields, accessible);
		return fields;
	}

	/**
	 * 获取对象的所有非静态<code>Field</code>，不包括<code>Object</code>的 <code>Field</code>
	 * 
	 * @param object
	 *            要获取的对象
	 * @return <code>Field</code>数组
	 */
	public static Field[] getNonStaticFields(Object object) {
		Assert.notNull(object, "Object must not be null");

		Field[] fields = _getNonStaticFields(object.getClass());
		return fields;
	}

	/**
	 * 获取对象的所有非静态<code>Field</code>，不包括<code>Object</code>的 <code>Field</code>
	 * 
	 * @param object
	 *            要获取的对象
	 * @param accessible
	 *            设置访问权限
	 * @return <code>Field</code>数组
	 */
	public static Field[] getNonStaticFields(Object object, boolean accessible) {
		Assert.notNull(object, "Object must not be null");

		Field[] fields = getNonStaticFields(object);
		AccessibleObject.setAccessible(fields, accessible);
		return fields;
	}

	/**
	 * 根据类的<code>Field</code>名返回<code>Field</code>
	 * 
	 * @param clazz
	 *            要获取的类
	 * @param fieldName
	 *            <code>Field</code>名
	 * @return <code>Field</code>
	 * @throws FieldException
	 */
	public static Field getFieldOfClass(Class<?> clazz, String fieldName)
			throws FieldException {
		Assert.notNull(clazz, "Class must not be null");

		Assert.notBlank(fieldName, "fieldName must not be blank");

		return _getFieldOfClass(clazz, fieldName);
	}

	/**
	 * 要求参数<code>clazz</code>不为<code>null</code>
	 * <p>
	 * 根据类的<code>Field</code>名返回 <code>Field</code>
	 * 
	 * @param clazz
	 *            要获取的类
	 * @param fieldName
	 *            <code>Field</code>名
	 * @return <code>Field</code>
	 * @throws FieldException
	 */
	static Field _getFieldOfClass(Class<?> clazz, String fieldName)
			throws FieldException {
		Field[] fields = _getAllFieldsOfClass(clazz);
		for (Field field : fields) {
			if (field.getName().equals(fieldName))
				return field;
		}

		return null;
	}

	/**
	 * 根据类的<code>Field</code>名返回<code>Field</code>
	 * 
	 * @param clazz
	 *            要获取的类
	 * @param fieldName
	 *            <code>Field</code>名
	 * @param accessible
	 *            设置访问权限
	 * @return <code>Field</code>
	 * @throws FieldException
	 */
	public static Field getFieldOfClass(Class<?> clazz, String fieldName,
			boolean accessible) throws FieldException {
		Field field = getFieldOfClass(clazz, fieldName);
		if (field != null)
			field.setAccessible(accessible);
		return field;
	}

	/**
	 * 根据对象的<code>Field</code>名返回<code>Field</code>
	 * 
	 * @param object
	 *            要获取的对象
	 * @param fieldName
	 *            <code>Field</code>名
	 * @return <code>Field</code>
	 * @throws FieldException
	 */
	public static Field getFieldOfClass(Object object, String fieldName)
			throws FieldException {
		Assert.notNull(object, "Object must not be null");

		return _getFieldOfClass(object.getClass(), fieldName);
	}

	/**
	 * 根据对象的<code>Field</code>名返回<code>Field</code>
	 * 
	 * @param object
	 *            要获取的对象
	 * @param fieldName
	 *            <code>Field</code>名
	 * @param accessible
	 *            设置访问权限
	 * @return <code>Field</code>
	 * @throws FieldException
	 */
	public static Field getFieldOfClass(Object object, String fieldName,
			boolean accessible) throws FieldException {
		Field field = getFieldOfClass(object, fieldName);
		if (field != null)
			field.setAccessible(accessible);
		return field;
	}

	/**
	 * 判断是否有超类
	 * 
	 * @param clazz
	 *            目标类
	 * @return 如果有返回<code>true</code>，否则返回<code>false</code>
	 */
	private static boolean hasSuperClass(Class<?> clazz) {
		return (clazz != null) && !clazz.equals(Object.class);
	}

	/**
	 * 读取<code>Field</code>的值
	 * 
	 * @param field
	 *            目标<code>Field</code>
	 * @param target
	 *            目标对象
	 * @return <code>Field</code>值
	 * @throws FieldException
	 */
	public static Object readField(Field field, Object target)
			throws FieldException {
		Assert.notNull(field, "Field must not be null");

		try {
			return _readField(field, target);
		} catch (IllegalArgumentException e) {
			throw new FieldException(field,
					"this is a illegal argument exception", e);
		} catch (IllegalAccessException e) {
			throw new FieldException(field,
					"this is a illegal access exception", e);
		}
	}

	/**
	 * 要求参数参数不为<code>null</code>
	 * <p>
	 * 读取<code>Field</code>的值
	 * 
	 * @param field
	 *            目标<code>Field</code>
	 * @param target
	 *            目标对象
	 * @return <code>Field</code>值
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	static Object _readField(Field field, Object target)
			throws IllegalArgumentException, IllegalAccessException {
		if (!field.isAccessible())
			field.setAccessible(true);
		return field.get(target);
	}

	/**
	 * 读取<code>Field</code>的值
	 * 
	 * @param target
	 *            目标对象
	 * @param fieldName
	 *            目标<code>Field</code>名
	 * @return <code>Field</code>值
	 * @throws FieldException
	 */
	public static Object readField(Object target, String fieldName)
			throws FieldException {
		Field field = getFieldOfClass(target, fieldName);

		Assert.notNull(field, "Cannot locate field " + fieldName + " on "
				+ target);
		try {
			return _readField(field, target);
		} catch (IllegalArgumentException e) {
			throw new FieldException(field,
					"this is a illegal argument exception", e);
		} catch (IllegalAccessException e) {
			throw new FieldException(field,
					"this is a illegal access exception", e);
		}
	}

	/**
	 * 写入<code>Field</code>的值
	 * 
	 * @param field
	 *            目标<code>Field</code>
	 * @param target
	 *            目标对象
	 * @param value
	 *            写入的值
	 * @throws FieldException
	 */
	public static void writeField(Field field, Object target, Object value)
			throws FieldException {
		Assert.notNull(field, "Field must not be null");

		try {
			_writeField(field, target, value);
		} catch (IllegalArgumentException e) {
			throw new FieldException(field,
					"this is a illegal argument exception", e);
		} catch (IllegalAccessException e) {
			throw new FieldException(field,
					"this is a illegal access exception", e);
		}
	}

	/**
	 * 要求参数参数不为<code>null</code>
	 * <p>
	 * 写入<code>Field</code>的值
	 * 
	 * @param field
	 *            目标<code>Field</code>
	 * @param target
	 *            目标对象
	 * @param value
	 *            写入的值
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	static void _writeField(Field field, Object target, Object value)
			throws IllegalArgumentException, IllegalAccessException {
		if (!field.isAccessible())
			field.setAccessible(true);
		field.set(target, value);
	}

	/**
	 * 写入<code>Field</code>的值
	 * 
	 * @param target
	 *            目标对象
	 * @param fieldName
	 *            目标<code>Field</code>名
	 * @param value
	 *            写入的值
	 * @throws FieldException
	 */
	public static void writeField(Object target, String fieldName, Object value)
			throws FieldException {
		Field field = getFieldOfClass(target, fieldName);
		if (field != null)
			try {
				_writeField(field, target, value);
			} catch (IllegalArgumentException e) {
				throw new FieldException(field,
						"this is a illegal argument exception", e);
			} catch (IllegalAccessException e) {
				throw new FieldException(field,
						"this is a illegal access exception", e);
			}
	}

	/**
	 * 获取字段实际类型参数
	 * 
	 * @param field
	 *            目标<code>Field</code>名
	 * @return 实际类型参数
	 */
	public static Class<?> getCompomentClass(Field field) {
		Assert.notNull(field, "Field must not be null");

		Type type = field.getGenericType();
		if (null == type || !(ParameterizedType.class.isInstance(type))) {
			return null;
		}
		ParameterizedType parameterizedType = (ParameterizedType) type;
		Class<?> clazz = (Class<?>) parameterizedType.getActualTypeArguments()[0];
		return clazz;
	}

	/**
	 * 获取所有包含指定<code>Annotation</code>的<code>Field</code>数组
	 * 
	 * @param clazz
	 *            查找类
	 * @param annotationClass
	 *            注解类名
	 * @return <code>Field</code>数组
	 */
	public static Field[] getAnnotationFields(Class<?> clazz,
			Class<? extends Annotation> annotationClass) {
		Assert.notNull(clazz, "Class must not be null");

		Assert.notNull(annotationClass, "annotation class must not be null");

		Field[] fields = _getAllFieldsOfClass(clazz);
		if (ArrayUtil.isEmpty(fields))
			return null;
		int idx = 0;
		for (Field field : fields) {
			if (null != field.getAnnotation(annotationClass)) {
				idx++;
			}
		}
		Field[] result = new Field[idx];
		idx = 0;
		for (Field field : fields) {
			field.setAccessible(true);
			if (null != field.getAnnotation(annotationClass)) {
				result[idx++] = field;
			}
		}
		return result;
	}

	/**
	 * 读取静态<code>Field</code>的值
	 * 
	 * @param field
	 *            目标<code>Field</code>名
	 * @return <code>Field</code>值
	 * @throws FieldException
	 */
	public static Object readStaticField(Field field) throws FieldException {
		Assert.notNull(field, "Field must not be null");

		Assert.isTrue(Modifier.isStatic(field.getModifiers()), "The field '"
				+ field.getName() + "' is not static");

		return readField(field, (Object) null);
	}

	/**
	 * 读取静态<code>Field</code>的值
	 * 
	 * @param clazz
	 *            目标<code>Class</code>名
	 * @return fieldName <code>Field</code>名
	 * @throws FieldException
	 */
	public static Object readStaticField(Class<?> clazz, String fieldName)
			throws FieldException {
		Field field = getFieldOfClass(clazz, fieldName);
		Assert.notNull(field, "Cannot locate field " + fieldName + " on "
				+ clazz);

		return readStaticField(field);
	}

	/**
	 * 写入<code>Field</code>的值
	 * 
	 * @param field
	 *            目标<code>Field</code>
	 * @param value
	 *            写入的值
	 * @throws FieldException
	 */
	public static void writeStaticField(Field field, Object value)
			throws FieldException {
		Assert.notNull(field, "Field must not be null");

		Assert.isTrue(Modifier.isStatic(field.getModifiers()), "The field '"
				+ field.getName() + "' is not static");

		writeField(field, (Object) null, value);
	}

	/**
	 * 写入<code>Field</code>的值
	 * 
	 * @param clazz
	 *            目标<code>Class</code>
	 * @return fieldName <code>Field</code>名
	 * @param value
	 *            写入的值
	 * @throws FieldException
	 */
	public static void writeStaticField(Class<?> clazz, String fieldName,
			Object value) throws FieldException {
		Field field = getFieldOfClass(clazz, fieldName);

		Assert.notNull(field, "Cannot locate field " + fieldName + " on "
				+ clazz);

		writeStaticField(field, value);
	}

	/**
	 * <code>Field</code>是否不用改写
	 * 
	 * @param field
	 *            目标<code>Field</code>
	 * @return 如果是则返回<code>true</code>，否则返回<code>false</code>
	 */
	public static boolean notWriter(Field field) {
		return field == null || Modifier.isFinal(field.getModifiers())
				|| Modifier.isStatic(field.getModifiers());
	}

}
