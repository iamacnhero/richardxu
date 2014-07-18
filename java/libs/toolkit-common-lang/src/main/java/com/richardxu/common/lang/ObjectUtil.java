package com.richardxu.common.lang;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

/**
 * 有关<code>Object</code>处理的工具类。
 * 
 * <p>
 * 这个类中的每个方法都可以“安全”地处理<code>null</code>，而不会抛出<code>NullPointerException</code>。
 * </p>
 * 
 * @author <a href="mailto:xuc@iphonele.com">saga67</a>
 * @version create on 2011-5-17 下午03:28:43
 */
public class ObjectUtil {

	private ObjectUtil() {

	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* 常量和singleton。 */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * 用于表示<code>null</code>的常量。
	 * 
	 * <p>
	 * 例如，<code>HashMap.get(Object)</code>方法返回<code>null</code>有两种可能： 值不存在或值为
	 * <code>null</code>。而这个singleton可用来区别这两种情形。
	 * </p>
	 * 
	 * <p>
	 * 另一个例子是，<code>Hashtable</code>的值不能为<code>null</code>。
	 * </p>
	 */
	public static final Object NULL = new Serializable() {
		private static final long serialVersionUID = 7092611880189329093L;

		private Object readResolve() {
			return NULL;
		}
	};

	/*
	 * ==========================================================================
	 * ==
	 */
	/* 默认值函数。 */
	/*                                                                              */
	/* 当对象为null时，将对象转换成指定的默认对象。 */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * 如果对象为<code>null</code>，则返回指定默认对象，否则返回对象本身。
	 * 
	 * <pre>
	 * ObjectUtil.defaultIfNull(null, null)      = null
	 * ObjectUtil.defaultIfNull(null, &quot;&quot;)        = &quot;&quot;
	 * ObjectUtil.defaultIfNull(null, &quot;zz&quot;)      = &quot;zz&quot;
	 * ObjectUtil.defaultIfNull(&quot;abc&quot;, *)        = &quot;abc&quot;
	 * ObjectUtil.defaultIfNull(Boolean.TRUE, *) = Boolean.TRUE
	 * </pre>
	 * 
	 * @param object
	 *            要测试的对象
	 * @param defaultValue
	 *            默认值
	 * 
	 * @return 对象本身或默认对象
	 */
	public static Object defaultIfNull(Object object, Object defaultValue) {
		return (object != null) ? object : defaultValue;
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* 比较函数。 */
	/*                                                                              */
	/* 以下方法用来比较两个对象是否相同。 */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * 比较两个对象是否完全相等。
	 * 
	 * <p>
	 * 此方法可以正确地比较多维数组。
	 * 
	 * <pre>
	 * ObjectUtil.equals(null, null)                  = true
	 * ObjectUtil.equals(null, &quot;&quot;)                    = false
	 * ObjectUtil.equals(&quot;&quot;, null)                    = false
	 * ObjectUtil.equals(&quot;&quot;, &quot;&quot;)                      = true
	 * ObjectUtil.equals(Boolean.TRUE, null)          = false
	 * ObjectUtil.equals(Boolean.TRUE, &quot;true&quot;)        = false
	 * ObjectUtil.equals(Boolean.TRUE, Boolean.TRUE)  = true
	 * ObjectUtil.equals(Boolean.TRUE, Boolean.FALSE) = false
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param object1
	 *            对象1
	 * @param object2
	 *            对象2
	 * 
	 * @return 如果相等, 则返回<code>true</code>
	 */
	public static boolean equals(Object object1, Object object2) {
		return ArrayUtil.equals(object1, object2);
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* Hashcode函数。 */
	/*                                                                              */
	/* 以下方法用来取得对象的hash code。 */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * 取得对象的hash值, 如果对象为<code>null</code>, 则返回<code>0</code>。
	 * 
	 * <p>
	 * 此方法可以正确地处理多维数组。
	 * </p>
	 * 
	 * @param object
	 *            对象
	 * 
	 * @return hash值
	 */
	public static int hashCode(Object object) {
		return ArrayUtil.hashCode(object);
	}

	/**
	 * 取得对象的原始的hash值, 如果对象为<code>null</code>, 则返回<code>0</code>。
	 * 
	 * <p>
	 * 该方法使用<code>System.identityHashCode</code>来取得hash值，该值不受对象本身的
	 * <code>hashCode</code>方法的影响。
	 * </p>
	 * 
	 * @param object
	 *            对象
	 * 
	 * @return hash值
	 */
	public static int identityHashCode(Object object) {
		return (object == null) ? 0 : System.identityHashCode(object);
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* 取得对象的identity。 */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * 取得对象自身的identity，如同对象没有覆盖<code>toString()</code>方法时，
	 * <code>Object.toString()</code>的原始输出。
	 * 
	 * <pre>
	 * ObjectUtil.identityToString(null)          = null
	 * ObjectUtil.identityToString(&quot;&quot;)            = &quot;java.lang.String@1e23&quot;
	 * ObjectUtil.identityToString(Boolean.TRUE)  = &quot;java.lang.Boolean@7fa&quot;
	 * ObjectUtil.identityToString(new int[0])    = &quot;int[]@7fa&quot;
	 * ObjectUtil.identityToString(new Object[0]) = &quot;java.lang.Object[]@7fa&quot;
	 * </pre>
	 * 
	 * @param object
	 *            对象
	 * 
	 * @return 对象的identity，如果对象是<code>null</code>，则返回<code>null</code>
	 */
	public static String identityToString(Object object) {
		if (object == null) {
			return null;
		}

		return appendIdentityToString((StringBuffer) null, object).toString();
	}

	/**
	 * 取得对象自身的identity，如同对象没有覆盖<code>toString()</code>方法时，
	 * <code>Object.toString()</code>的原始输出。
	 * 
	 * <pre>
	 * ObjectUtil.identityToString(null, &quot;NULL&quot;)            = &quot;NULL&quot;
	 * ObjectUtil.identityToString(&quot;&quot;, &quot;NULL&quot;)              = &quot;java.lang.String@1e23&quot;
	 * ObjectUtil.identityToString(Boolean.TRUE, &quot;NULL&quot;)    = &quot;java.lang.Boolean@7fa&quot;
	 * ObjectUtil.identityToString(new int[0], &quot;NULL&quot;)      = &quot;int[]@7fa&quot;
	 * ObjectUtil.identityToString(new Object[0], &quot;NULL&quot;)   = &quot;java.lang.Object[]@7fa&quot;
	 * </pre>
	 * 
	 * @param object
	 *            对象
	 * @param nullStr
	 *            如果对象为<code>null</code>，则返回该字符串
	 * 
	 * @return 对象的identity，如果对象是<code>null</code>，则返回指定字符串
	 */
	public static String identityToString(Object object, String nullStr) {
		if (object == null) {
			return nullStr;
		}

		return appendIdentityToString((StringBuffer) null, object).toString();
	}

	/**
	 * 将对象自身的identity——如同对象没有覆盖<code>toString()</code>方法时，
	 * <code>Object.toString()</code>的原始输出——追加到<code>StringBuilder</code>中。
	 * 
	 * <pre>
	 * ObjectUtil.appendIdentityToString(*, null)            = null
	 * ObjectUtil.appendIdentityToString(null, &quot;&quot;)           = &quot;java.lang.String@1e23&quot;
	 * ObjectUtil.appendIdentityToString(null, Boolean.TRUE) = &quot;java.lang.Boolean@7fa&quot;
	 * ObjectUtil.appendIdentityToString(buf, Boolean.TRUE)  = buf.append(&quot;java.lang.Boolean@7fa&quot;)
	 * ObjectUtil.appendIdentityToString(buf, new int[0])    = buf.append(&quot;int[]@7fa&quot;)
	 * ObjectUtil.appendIdentityToString(buf, new Object[0]) = buf.append(&quot;java.lang.Object[]@7fa&quot;)
	 * </pre>
	 * 
	 * @param builder
	 *            <code>StringBuilder</code>对象，如果是<code>null</code>，则创建新的
	 * @param object
	 *            对象
	 * 
	 * @return <code>StringBuilder</code>对象，如果对象为<code>null</code>，则返回
	 *         <code>null</code>
	 */
	public static StringBuilder appendIdentityToString(StringBuilder builder,
			Object object) {
		if (object == null) {
			return null;
		}

		if (builder == null) {
			builder = new StringBuilder();
		}

		builder.append(ClassUtil.getClassNameForObject(object));

		return builder.append('@').append(
				Integer.toHexString(identityHashCode(object)));
	}

	/**
	 * 将对象自身的identity——如同对象没有覆盖<code>toString()</code>方法时，
	 * <code>Object.toString()</code>的原始输出——追加到<code>StringBuffer</code>中。
	 * 
	 * <pre>
	 * ObjectUtil.appendIdentityToString(*, null)            = null
	 * ObjectUtil.appendIdentityToString(null, &quot;&quot;)           = &quot;java.lang.String@1e23&quot;
	 * ObjectUtil.appendIdentityToString(null, Boolean.TRUE) = &quot;java.lang.Boolean@7fa&quot;
	 * ObjectUtil.appendIdentityToString(buf, Boolean.TRUE)  = buf.append(&quot;java.lang.Boolean@7fa&quot;)
	 * ObjectUtil.appendIdentityToString(buf, new int[0])    = buf.append(&quot;int[]@7fa&quot;)
	 * ObjectUtil.appendIdentityToString(buf, new Object[0]) = buf.append(&quot;java.lang.Object[]@7fa&quot;)
	 * </pre>
	 * 
	 * @param buffer
	 *            <code>StringBuffer</code>对象，如果是<code>null</code>，则创建新的
	 * @param object
	 *            对象
	 * 
	 * @return <code>StringBuffer</code>对象，如果对象为<code>null</code>，则返回
	 *         <code>null</code>
	 */
	public static StringBuffer appendIdentityToString(StringBuffer buffer,
			Object object) {
		if (object == null) {
			return null;
		}

		if (buffer == null) {
			buffer = new StringBuffer();
		}

		buffer.append(ClassUtil.getClassNameForObject(object));

		return buffer.append('@').append(
				Integer.toHexString(identityHashCode(object)));
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* Clone函数。 */
	/*                                                                              */
	/* 以下方法调用Object.clone方法，默认是“浅复制”（shallow copy）。 */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * 复制一个对象。如果对象为<code>null</code>，则返回<code>null</code>。
	 * 
	 * <p>
	 * 此方法调用<code>Object.clone</code>方法，默认只进行“浅复制”。 对于数组，调用
	 * <code>ArrayUtil.clone</code>方法更高效。
	 * </p>
	 * 
	 * @param array
	 *            要复制的数组
	 * 
	 * @return 数组的复本，如果原始数组为<code>null</code>，则返回<code>null</code>
	 * @throws CloneNotSupportedException
	 */
	public static Object clone(Object array) throws CloneNotSupportedException {
		if (array == null) {
			return null;
		}

		// 对数组特殊处理
		if (Object[].class.isInstance(array)) {
			return ArrayUtil.clone((Object[]) array);
		}

		if (long[].class.isInstance(array)) {
			return ArrayUtil.clone((long[]) array);
		}

		if (int[].class.isInstance(array)) {
			return ArrayUtil.clone((int[]) array);
		}

		if (short[].class.isInstance(array)) {
			return ArrayUtil.clone((short[]) array);
		}

		if (byte[].class.isInstance(array)) {
			return ArrayUtil.clone((byte[]) array);
		}

		if (double[].class.isInstance(array)) {
			return ArrayUtil.clone((double[]) array);
		}

		if (float[].class.isInstance(array)) {
			return ArrayUtil.clone((float[]) array);
		}

		if (boolean[].class.isInstance(array)) {
			return ArrayUtil.clone((boolean[]) array);
		}

		if (char[].class.isInstance(array)) {
			return ArrayUtil.clone((char[]) array);
		}

		// Not cloneable
		if (!(Cloneable.class.isInstance(array))) {
			throw new CloneNotSupportedException("Object of class "
					+ array.getClass().getName() + " is not Cloneable");
		}

		// 用reflection调用clone方法
		Class<? extends Object> clazz = array.getClass();

		try {
			Method cloneMethod = clazz.getMethod("clone",
					ArrayUtil.EMPTY_CLASS_ARRAY);

			return cloneMethod.invoke(array, ArrayUtil.EMPTY_OBJECT_ARRAY);
		} catch (NoSuchMethodException e) {
			throw new CloneNotSupportedException(e.getMessage());
		} catch (IllegalArgumentException e) {
			throw new CloneNotSupportedException(e.getMessage());
		} catch (IllegalAccessException e) {
			throw new CloneNotSupportedException(e.getMessage());
		} catch (InvocationTargetException e) {
			throw new CloneNotSupportedException(e.getMessage());
		}
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* 比较对象的类型。 */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * 检查两个对象是否属于相同类型。<code>null</code>将被看作任意类型。
	 * 
	 * @param object1
	 *            对象1
	 * @param object2
	 *            对象2
	 * 
	 * @return 如果两个对象有相同的类型，则返回<code>true</code>
	 */
	public static boolean isSameType(Object object1, Object object2) {
		if ((object1 == null) || (object2 == null)) {
			return true;
		}

		return object1.getClass().equals(object2.getClass());
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* toString方法。 */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * 取得对象的<code>toString()</code>的值，如果对象为<code>null</code>，则返回空字符串
	 * <code>""</code>。
	 * 
	 * <pre>
	 * ObjectUtil.toString(null)         = &quot;&quot;
	 * ObjectUtil.toString(&quot;&quot;)           = &quot;&quot;
	 * ObjectUtil.toString(&quot;bat&quot;)        = &quot;bat&quot;
	 * ObjectUtil.toString(Boolean.TRUE) = &quot;true&quot;
	 * ObjectUtil.toString([1, 2, 3])    = &quot;[1, 2, 3]&quot;
	 * </pre>
	 * 
	 * @param object
	 *            对象
	 * 
	 * @return 对象的<code>toString()</code>的返回值，或空字符串<code>""</code>
	 */
	public static String toString(Object object) {
		return (object == null) ? StringUtil.EMPTY_STRING : (object.getClass()
				.isArray() ? ArrayUtil.toString(object) : object.toString());
	}

	/**
	 * 取得对象的<code>toString()</code>的值，如果对象为<code>null</code>，则返回指定字符串。
	 * 
	 * <pre>
	 * ObjectUtil.toString(null, null)           = null
	 * ObjectUtil.toString(null, &quot;null&quot;)         = &quot;null&quot;
	 * ObjectUtil.toString(&quot;&quot;, &quot;null&quot;)           = &quot;&quot;
	 * ObjectUtil.toString(&quot;bat&quot;, &quot;null&quot;)        = &quot;bat&quot;
	 * ObjectUtil.toString(Boolean.TRUE, &quot;null&quot;) = &quot;true&quot;
	 * ObjectUtil.toString([1, 2, 3], &quot;null&quot;)    = &quot;[1, 2, 3]&quot;
	 * </pre>
	 * 
	 * @param object
	 *            对象
	 * @param nullStr
	 *            如果对象为<code>null</code>，则返回该字符串
	 * 
	 * @return 对象的<code>toString()</code>的返回值，或指定字符串
	 */
	public static String toString(Object object, String nullStr) {
		return (object == null) ? nullStr
				: (object.getClass().isArray() ? ArrayUtil.toString(object)
						: object.toString());
	}

	/**
	 * 判断对象是否是空
	 * 
	 * @param obj
	 *            传入对象
	 * 
	 * @return 如果<code>obj.toString()</code>为<code>""</code>或者为<code>null</code>
	 *         , 则返回<code>true</code>
	 */
	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		}

		return StringUtil.isEmpty(obj.toString());
	}

	/**
	 * 判断对象是否不为空
	 * 
	 * @param obj
	 *            传入对象
	 * 
	 * @return 如果<code>obj.toString()</code>不为<code>""</code>且不为
	 *         <code>null</code>, 则返回<code>true</code>
	 */
	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}

	public static boolean isNull(Object obj) {
		return (obj == null);
	}

	public static boolean isNotNull(Object obj) {
		return (obj != null);
	}

	// Min/Max
	// -----------------------------------------------------------------------
	/**
	 * Null safe comparison of Comparables.
	 * 
	 * @param c1
	 *            the first comparable, may be null
	 * @param c2
	 *            the second comparable, may be null
	 * @return <ul>
	 *         <li>If both objects are non-null and unequal, the lesser object.
	 *         <li>If both objects are non-null and equal, c1.
	 *         <li>If one of the comparables is null, the non-null object.
	 *         <li>If both the comparables are null, null is returned.
	 *         </ul>
	 */
	public static Object min(Comparable<Comparable<?>> c1, Comparable<?> c2) {
		if (c1 != null && c2 != null) {
			return c1.compareTo(c2) < 1 ? c1 : c2;
		}
		return c1 != null ? c1 : c2;
	}

	/**
	 * Null safe comparison of Comparables.
	 * 
	 * @param c1
	 *            the first comparable, may be null
	 * @param c2
	 *            the second comparable, may be null
	 * @return <ul>
	 *         <li>If both objects are non-null and unequal, the greater object.
	 *         <li>If both objects are non-null and equal, c1.
	 *         <li>If one of the comparables is null, the non-null object.
	 *         <li>If both the comparables are null, null is returned.
	 *         </ul>
	 */
	public static Object max(Comparable<Comparable<?>> c1, Comparable<?> c2) {
		if (c1 != null && c2 != null) {
			return c1.compareTo(c2) >= 0 ? c1 : c2;
		}
		return c1 != null ? c1 : c2;
	}

	/**
	 * Compares two objects or two object arrays. Useful for
	 * {@link Object#equals(Object)}.
	 * 
	 * @see #equals(Object, Object)
	 */
	public static boolean equalsEx(Object obj1, Object obj2) {
		if (obj1 == null) {
			return (obj2 == null);
		}
		if (obj2 == null) {
			return false;
		}
		if (obj1.getClass().isArray()) {
			if (!obj2.getClass().isArray()) {
				return false;
			}
			return Arrays.equals((Object[]) obj1, (Object[]) obj2);
		}
		return obj1.equals(obj2);
	}

	/**
	 * Non-symmetric utility for comparing the types of two objects. Might be
	 * useful for {@link Object#equals(Object)} if <code>instanceof</code> is
	 * not used.
	 * 
	 * @param object
	 *            <code>equals()</code> argument
	 * @param thiz
	 *            current class that overrides <code>equals()</code>
	 */
	public static boolean equalsType(Object object, Object thiz) {
		return (object != null) && (object.getClass().equals(thiz.getClass()));
	}

	/**
	 * Returns length of the object.
	 */
	public static int length(Object obj) {
		if (obj == null) {
			return 0;
		}
		if (obj instanceof String) {
			return ((String) obj).length();
		}
		if (obj instanceof Collection) {
			return ((Collection<?>) obj).size();
		}
		if (obj instanceof Map) {
			return ((Map<?, ?>) obj).size();
		}

		int count;
		if (obj instanceof Iterator) {
			Iterator<?> iter = (Iterator<?>) obj;
			count = 0;
			while (iter.hasNext()) {
				count++;
				iter.next();
			}
			return count;
		}
		if (obj instanceof Enumeration) {
			Enumeration<?> enumeration = (Enumeration<?>) obj;
			count = 0;
			while (enumeration.hasMoreElements()) {
				count++;
				enumeration.nextElement();
			}
			return count;
		}
		if (obj.getClass().isArray()) {
			return Array.getLength(obj);
		}
		return -1;
	}

	/**
	 * Returns <code>true</code> if first argument contains provided element. It
	 * works for strings, collections, maps and arrays. s
	 */
	public static boolean containsElement(Object obj, Object element) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof String) {
			if (element == null) {
				return false;
			}
			return ((String) obj).contains(element.toString());
		}
		if (obj instanceof Collection) {
			return ((Collection<?>) obj).contains(element);
		}
		if (obj instanceof Map) {
			return ((Map<?, ?>) obj).values().contains(element);
		}

		if (obj instanceof Iterator) {
			Iterator<?> iter = (Iterator<?>) obj;
			while (iter.hasNext()) {
				Object o = iter.next();
				if (equals(o, element)) {
					return true;
				}
			}
			return false;
		}
		if (obj instanceof Enumeration) {
			Enumeration<?> enumeration = (Enumeration<?>) obj;
			while (enumeration.hasMoreElements()) {
				Object o = enumeration.nextElement();
				if (equals(o, element)) {
					return true;
				}
			}
			return false;
		}
		if (obj.getClass().isArray()) {
			int len = Array.getLength(obj);
			for (int i = 0; i < len; i++) {
				Object o = Array.get(obj, i);
				if (equals(o, element)) {
					return true;
				}
			}
		}
		return false;
	}

}
