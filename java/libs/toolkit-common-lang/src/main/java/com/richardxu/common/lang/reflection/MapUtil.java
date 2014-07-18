package com.richardxu.common.lang.reflection;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.richardxu.common.lang.CollectionUtil;
import com.richardxu.common.lang.ObjectUtil;
import com.richardxu.common.lang.exception.FieldException;
import com.richardxu.common.lang.reflection.FieldUtil;

/**
 * 
 * @author <a href="mailto:xuc@iphonele.com">saga67</a>
 * 
 * @version create on 2012-3-16 下午1:26:30
 */
public class MapUtil {

	private MapUtil() {

	}

	/**
	 * fieldName 作为Map的一个key，getFieldName()的返回结果作为Map的值
	 * 
	 * @param object
	 *            参数对象
	 * @return Map 返回经过解析的参数对象
	 * @throws Exception
	 */

	public static Map<String, Object> objectToMap(Object object)
			throws IllegalAccessException {
		if (object == null) {
			return CollectionUtil.getHashMap();
		}
		if (object instanceof Map) {
			@SuppressWarnings("unchecked")
			Map<String, Object> result = (Map<String, Object>) object;
			return result;
		}
		Map<String, Object> map = CollectionUtil.getHashMap();
		/**
		 * IBatis的默认对象参数名
		 */
		map.put("value", object);
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			String fieldName = field.getName();
			field.setAccessible(true);
			map.put(fieldName, field.get(object));
		}
		return map;
	}

	/**
	 * 将Map复制到bean
	 * 
	 * @param bean
	 * @param parameters
	 * @throws FieldException
	 */
	public static void populate(Object bean, Map<Object, Object> parameters)
			throws FieldException {
		if (ObjectUtil.isEmpty(bean) || CollectionUtil.isEmpty(parameters))
			return;
		for (Iterator<Entry<Object, Object>> iter = parameters.entrySet()
				.iterator(); iter.hasNext();) {
			Entry<Object, Object> entry = iter.next();
			Object key = entry.getKey();
			Object value = entry.getValue();
			String strKey;
			if (key != null) {
				if (!(key instanceof String))
					strKey = key.toString();
				else
					strKey = (String) key;
				FieldUtil.writeField(bean, strKey, value);
			}
		}
	}

	/**
	 * 将Map复制到bean，检查类型安全
	 * 
	 * @param bean
	 * @param parameters
	 * @throws FieldException
	 */
	public static void populateSafeType(Object bean,
			Map<Object, Object> parameters) throws FieldException {
		if (ObjectUtil.isEmpty(bean) || CollectionUtil.isEmpty(parameters))
			return;
		for (Iterator<Entry<Object, Object>> iter = parameters.entrySet()
				.iterator(); iter.hasNext();) {
			Entry<Object, Object> entry = iter.next();
			Object key = entry.getKey();
			Object value = entry.getValue();
			String strKey;
			if (key != null) {
				if (!(key instanceof String))
					strKey = key.toString();
				else
					strKey = (String) key;

				Field field = FieldUtil.getFieldOfClass(bean, strKey);
				if (field.getType() == value.getClass()) {
					FieldUtil.writeField(bean, strKey, value);
				}
			}
		}
	}
}
