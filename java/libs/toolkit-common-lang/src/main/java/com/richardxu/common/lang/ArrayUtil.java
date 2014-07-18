package com.richardxu.common.lang;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 有关数组处理的工具类。
 * 
 * <p>
 * 这个类中的每个方法都可以“安全”地处理<code>null</code>，而不会抛出<code>NullPointerException</code>。
 * </p>
 * 
 * @author <a href="mailto:xuc@iphonele.com">saga67</a>
 * @version create on 2011-5-17 下午03:26:15
 */
public class ArrayUtil {
	/*
	 * ==========================================================================
	 * ==
	 */
	/* 常量和singleton。 */
	/*
	 * ==========================================================================
	 * ==
	 */

	/** 空的<code>Object</code>数组。 */
	public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];

	/** 空的<code>Class</code>数组。 */
	public static final Class<?>[] EMPTY_CLASS_ARRAY = new Class[0];

	/** 空的<code>String</code>数组。 */
	public static final String[] EMPTY_STRING_ARRAY = new String[0];

	/** 空的<code>long</code>数组。 */
	public static final long[] EMPTY_LONG_ARRAY = new long[0];

	/** 空的<code>Long</code>数组。 */
	public static final Long[] EMPTY_LONG_OBJECT_ARRAY = new Long[0];

	/** 空的<code>int</code>数组。 */
	public static final int[] EMPTY_INT_ARRAY = new int[0];

	/** 空的<code>Integer</code>数组。 */
	public static final Integer[] EMPTY_INTEGER_OBJECT_ARRAY = new Integer[0];

	/** 空的<code>short</code>数组。 */
	public static final short[] EMPTY_SHORT_ARRAY = new short[0];

	/** 空的<code>Short</code>数组。 */
	public static final Short[] EMPTY_SHORT_OBJECT_ARRAY = new Short[0];

	/** 空的<code>byte</code>数组。 */
	public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

	/** 空的<code>Byte</code>数组。 */
	public static final Byte[] EMPTY_BYTE_OBJECT_ARRAY = new Byte[0];

	/** 空的<code>double</code>数组。 */
	public static final double[] EMPTY_DOUBLE_ARRAY = new double[0];

	/** 空的<code>Double</code>数组。 */
	public static final Double[] EMPTY_DOUBLE_OBJECT_ARRAY = new Double[0];

	/** 空的<code>float</code>数组。 */
	public static final float[] EMPTY_FLOAT_ARRAY = new float[0];

	/** 空的<code>Float</code>数组。 */
	public static final Float[] EMPTY_FLOAT_OBJECT_ARRAY = new Float[0];

	/** 空的<code>boolean</code>数组。 */
	public static final boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[0];

	/** 空的<code>Boolean</code>数组。 */
	public static final Boolean[] EMPTY_BOOLEAN_OBJECT_ARRAY = new Boolean[0];

	/** 空的<code>char</code>数组。 */
	public static final char[] EMPTY_CHAR_ARRAY = new char[0];

	/** 空的<code>Character</code>数组。 */
	public static final Character[] EMPTY_CHARACTER_OBJECT_ARRAY = new Character[0];

	/** 计算hashcode所用的常量。 */
	private static final int INITIAL_NON_ZERO_ODD_NUMBER = 17;

	/** 计算hashcode所用的常量。 */
	private static final int MULTIPLIER_NON_ZERO_ODD_NUMBER = 37;

	private static final int INDEX_NOT_FOUND = -1;

	private ArrayUtil() {

	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* 判空函数。 */
	/*                                                                              */
	/* 判断一个数组是否为null或包含0个元素。 */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * 检查数组是否为<code>null</code>或空数组<code>[]</code>。
	 * 
	 * <pre>
	 * ArrayUtil.isEmpty(null)              = true
	 * ArrayUtil.isEmpty(new String[0])     = true
	 * ArrayUtil.isEmpty(new String[10])    = false
	 * </pre>
	 * 
	 * @param array
	 *            要检查的数组
	 * 
	 * @return 如果为空, 则返回<code>true</code>
	 */
	public static boolean isEmpty(Object[] array) {
		return ((array == null) || (array.length == 0));
	}

	/**
	 * 检查数组是否为<code>null</code>或空数组<code>[]</code>。
	 * 
	 * <pre>
	 * ArrayUtil.isEmpty(null)              = true
	 * ArrayUtil.isEmpty(new long[0])     = true
	 * ArrayUtil.isEmpty(new long[10])    = false
	 * </pre>
	 * 
	 * @param array
	 *            要检查的数组
	 * 
	 * @return 如果为空, 则返回<code>true</code>
	 */
	public static boolean isEmpty(long[] array) {
		return ((array == null) || (array.length == 0));
	}

	/**
	 * 检查数组是否为<code>null</code>或空数组<code>[]</code>。
	 * 
	 * <pre>
	 * ArrayUtil.isEmpty(null)              = true
	 * ArrayUtil.isEmpty(new int[0])     = true
	 * ArrayUtil.isEmpty(new int[10])    = false
	 * </pre>
	 * 
	 * @param array
	 *            要检查的数组
	 * 
	 * @return 如果为空, 则返回<code>true</code>
	 */
	public static boolean isEmpty(int[] array) {
		return ((array == null) || (array.length == 0));
	}

	/**
	 * 检查数组是否为<code>null</code>或空数组<code>[]</code>。
	 * 
	 * <pre>
	 * ArrayUtil.isEmpty(null)              = true
	 * ArrayUtil.isEmpty(new short[0])     = true
	 * ArrayUtil.isEmpty(new short[10])    = false
	 * </pre>
	 * 
	 * @param array
	 *            要检查的数组
	 * 
	 * @return 如果为空, 则返回<code>true</code>
	 */
	public static boolean isEmpty(short[] array) {
		return ((array == null) || (array.length == 0));
	}

	/**
	 * 检查数组是否为<code>null</code>或空数组<code>[]</code>。
	 * 
	 * <pre>
	 * ArrayUtil.isEmpty(null)              = true
	 * ArrayUtil.isEmpty(new byte[0])     = true
	 * ArrayUtil.isEmpty(new byte[10])    = false
	 * </pre>
	 * 
	 * @param array
	 *            要检查的数组
	 * 
	 * @return 如果为空, 则返回<code>true</code>
	 */
	public static boolean isEmpty(byte[] array) {
		return ((array == null) || (array.length == 0));
	}

	/**
	 * 检查数组是否为<code>null</code>或空数组<code>[]</code>。
	 * 
	 * <pre>
	 * ArrayUtil.isEmpty(null)              = true
	 * ArrayUtil.isEmpty(new double[0])     = true
	 * ArrayUtil.isEmpty(new double[10])    = false
	 * </pre>
	 * 
	 * @param array
	 *            要检查的数组
	 * 
	 * @return 如果为空, 则返回<code>true</code>
	 */
	public static boolean isEmpty(double[] array) {
		return ((array == null) || (array.length == 0));
	}

	/**
	 * 检查数组是否为<code>null</code>或空数组<code>[]</code>。
	 * 
	 * <pre>
	 * ArrayUtil.isEmpty(null)              = true
	 * ArrayUtil.isEmpty(new float[0])     = true
	 * ArrayUtil.isEmpty(new float[10])    = false
	 * </pre>
	 * 
	 * @param array
	 *            要检查的数组
	 * 
	 * @return 如果为空, 则返回<code>true</code>
	 */
	public static boolean isEmpty(float[] array) {
		return ((array == null) || (array.length == 0));
	}

	/**
	 * 检查数组是否为<code>null</code>或空数组<code>[]</code>。
	 * 
	 * <pre>
	 * ArrayUtil.isEmpty(null)              = true
	 * ArrayUtil.isEmpty(new boolean[0])     = true
	 * ArrayUtil.isEmpty(new boolean[10])    = false
	 * </pre>
	 * 
	 * @param array
	 *            要检查的数组
	 * 
	 * @return 如果为空, 则返回<code>true</code>
	 */
	public static boolean isEmpty(boolean[] array) {
		return ((array == null) || (array.length == 0));
	}

	/**
	 * 检查数组是否为<code>null</code>或空数组<code>[]</code>。
	 * 
	 * <pre>
	 * ArrayUtil.isEmpty(null)              = true
	 * ArrayUtil.isEmpty(new char[0])     = true
	 * ArrayUtil.isEmpty(new char[10])    = false
	 * </pre>
	 * 
	 * @param array
	 *            要检查的数组
	 * 
	 * @return 如果为空, 则返回<code>true</code>
	 */
	public static boolean isEmpty(char[] array) {
		return ((array == null) || (array.length == 0));
	}

	/**
	 * 检查数组是否不是<code>null</code>和空数组<code>[]</code>。
	 * 
	 * <pre>
	 * ArrayUtil.isEmpty(null)              = false
	 * ArrayUtil.isEmpty(new String[0])     = false
	 * ArrayUtil.isEmpty(new String[10])    = true
	 * </pre>
	 * 
	 * @param array
	 *            要检查的数组
	 * 
	 * @return 如果不为空, 则返回<code>true</code>
	 */
	public static boolean isNotEmpty(Object[] array) {
		return ((array != null) && (array.length > 0));
	}

	/**
	 * 检查数组是否不是<code>null</code>和空数组<code>[]</code>。
	 * 
	 * <pre>
	 * ArrayUtil.isEmpty(null)              = false
	 * ArrayUtil.isEmpty(new long[0])     = false
	 * ArrayUtil.isEmpty(new long[10])    = true
	 * </pre>
	 * 
	 * @param array
	 *            要检查的数组
	 * 
	 * @return 如果不为空, 则返回<code>true</code>
	 */
	public static boolean isNotEmpty(long[] array) {
		return ((array != null) && (array.length > 0));
	}

	/**
	 * 检查数组是否不是<code>null</code>和空数组<code>[]</code>。
	 * 
	 * <pre>
	 * ArrayUtil.isEmpty(null)              = false
	 * ArrayUtil.isEmpty(new int[0])     = false
	 * ArrayUtil.isEmpty(new int[10])    = true
	 * </pre>
	 * 
	 * @param array
	 *            要检查的数组
	 * 
	 * @return 如果不为空, 则返回<code>true</code>
	 */
	public static boolean isNotEmpty(int[] array) {
		return ((array != null) && (array.length > 0));
	}

	/**
	 * 检查数组是否不是<code>null</code>和空数组<code>[]</code>。
	 * 
	 * <pre>
	 * ArrayUtil.isEmpty(null)              = false
	 * ArrayUtil.isEmpty(new short[0])     = false
	 * ArrayUtil.isEmpty(new short[10])    = true
	 * </pre>
	 * 
	 * @param array
	 *            要检查的数组
	 * 
	 * @return 如果不为空, 则返回<code>true</code>
	 */
	public static boolean isNotEmpty(short[] array) {
		return ((array != null) && (array.length > 0));
	}

	/**
	 * 检查数组是否不是<code>null</code>和空数组<code>[]</code>。
	 * 
	 * <pre>
	 * ArrayUtil.isEmpty(null)              = false
	 * ArrayUtil.isEmpty(new byte[0])     = false
	 * ArrayUtil.isEmpty(new byte[10])    = true
	 * </pre>
	 * 
	 * @param array
	 *            要检查的数组
	 * 
	 * @return 如果不为空, 则返回<code>true</code>
	 */
	public static boolean isNotEmpty(byte[] array) {
		return ((array != null) && (array.length > 0));
	}

	/**
	 * 检查数组是否不是<code>null</code>和空数组<code>[]</code>。
	 * 
	 * <pre>
	 * ArrayUtil.isEmpty(null)              = false
	 * ArrayUtil.isEmpty(new double[0])     = false
	 * ArrayUtil.isEmpty(new double[10])    = true
	 * </pre>
	 * 
	 * @param array
	 *            要检查的数组
	 * 
	 * @return 如果不为空, 则返回<code>true</code>
	 */
	public static boolean isNotEmpty(double[] array) {
		return ((array != null) && (array.length > 0));
	}

	/**
	 * 检查数组是否不是<code>null</code>和空数组<code>[]</code>。
	 * 
	 * <pre>
	 * ArrayUtil.isEmpty(null)              = false
	 * ArrayUtil.isEmpty(new float[0])     = false
	 * ArrayUtil.isEmpty(new float[10])    = true
	 * </pre>
	 * 
	 * @param array
	 *            要检查的数组
	 * 
	 * @return 如果不为空, 则返回<code>true</code>
	 */
	public static boolean isNotEmpty(float[] array) {
		return ((array != null) && (array.length > 0));
	}

	/**
	 * 检查数组是否不是<code>null</code>和空数组<code>[]</code>。
	 * 
	 * <pre>
	 * ArrayUtil.isEmpty(null)              = false
	 * ArrayUtil.isEmpty(new boolean[0])     = false
	 * ArrayUtil.isEmpty(new boolean[10])    = true
	 * </pre>
	 * 
	 * @param array
	 *            要检查的数组
	 * 
	 * @return 如果不为空, 则返回<code>true</code>
	 */
	public static boolean isNotEmpty(boolean[] array) {
		return ((array != null) && (array.length > 0));
	}

	/**
	 * 检查数组是否不是<code>null</code>和空数组<code>[]</code>。
	 * 
	 * <pre>
	 * ArrayUtil.isEmpty(null)              = false
	 * ArrayUtil.isEmpty(new char[0])     = false
	 * ArrayUtil.isEmpty(new char[10])    = true
	 * </pre>
	 * 
	 * @param array
	 *            要检查的数组
	 * 
	 * @return 如果不为空, 则返回<code>true</code>
	 */
	public static boolean isNotEmpty(char[] array) {
		return ((array != null) && (array.length > 0));
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* 默认值函数。 */
	/*                                                                              */
	/* 当数组为null或empty时，将数组转换成指定的默认数组。 */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * 如果数组是<code>null</code>，则返回空数组<code>[]</code>，否则返回数组本身。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfNull(null)           = []
	 * ArrayUtil.defaultIfNull(new String[0])  = 数组本身
	 * ArrayUtil.defaultIfNull(new String[10]) = 数组本身
	 * </pre>
	 * 
	 * @param array
	 *            要转换的数组
	 * 
	 * @return 数组本身或空数组<code>[]</code>
	 */
	public static Object[] defaultIfNull(Object[] array) {
		return (array == null) ? EMPTY_OBJECT_ARRAY : array;
	}

	/**
	 * 如果数组是<code>null</code>，则返回空数组<code>[]</code>，否则返回数组本身。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfNull(null)           = []
	 * ArrayUtil.defaultIfNull(new long[0])  = 数组本身
	 * ArrayUtil.defaultIfNull(new long[10]) = 数组本身
	 * </pre>
	 * 
	 * @param array
	 *            要转换的数组
	 * 
	 * @return 数组本身或空数组<code>[]</code>
	 */
	public static long[] defaultIfNull(long[] array) {
		return (array == null) ? EMPTY_LONG_ARRAY : array;
	}

	/**
	 * 如果数组是<code>null</code>，则返回空数组<code>[]</code>，否则返回数组本身。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfNull(null)           = []
	 * ArrayUtil.defaultIfNull(new int[0])  = 数组本身
	 * ArrayUtil.defaultIfNull(new int[10]) = 数组本身
	 * </pre>
	 * 
	 * @param array
	 *            要转换的数组
	 * 
	 * @return 数组本身或空数组<code>[]</code>
	 */
	public static int[] defaultIfNull(int[] array) {
		return (array == null) ? EMPTY_INT_ARRAY : array;
	}

	/**
	 * 如果数组是<code>null</code>，则返回空数组<code>[]</code>，否则返回数组本身。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfNull(null)           = []
	 * ArrayUtil.defaultIfNull(new short[0])  = 数组本身
	 * ArrayUtil.defaultIfNull(new short[10]) = 数组本身
	 * </pre>
	 * 
	 * @param array
	 *            要转换的数组
	 * 
	 * @return 数组本身或空数组<code>[]</code>
	 */
	public static short[] defaultIfNull(short[] array) {
		return (array == null) ? EMPTY_SHORT_ARRAY : array;
	}

	/**
	 * 如果数组是<code>null</code>，则返回空数组<code>[]</code>，否则返回数组本身。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfNull(null)           = []
	 * ArrayUtil.defaultIfNull(new byte[0])  = 数组本身
	 * ArrayUtil.defaultIfNull(new byte[10]) = 数组本身
	 * </pre>
	 * 
	 * @param array
	 *            要转换的数组
	 * 
	 * @return 数组本身或空数组<code>[]</code>
	 */
	public static byte[] defaultIfNull(byte[] array) {
		return (array == null) ? EMPTY_BYTE_ARRAY : array;
	}

	/**
	 * 如果数组是<code>null</code>，则返回空数组<code>[]</code>，否则返回数组本身。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfNull(null)           = []
	 * ArrayUtil.defaultIfNull(new double[0])  = 数组本身
	 * ArrayUtil.defaultIfNull(new double[10]) = 数组本身
	 * </pre>
	 * 
	 * @param array
	 *            要转换的数组
	 * 
	 * @return 数组本身或空数组<code>[]</code>
	 */
	public static double[] defaultIfNull(double[] array) {
		return (array == null) ? EMPTY_DOUBLE_ARRAY : array;
	}

	/**
	 * 如果数组是<code>null</code>，则返回空数组<code>[]</code>，否则返回数组本身。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfNull(null)           = []
	 * ArrayUtil.defaultIfNull(new float[0])  = 数组本身
	 * ArrayUtil.defaultIfNull(new float[10]) = 数组本身
	 * </pre>
	 * 
	 * @param array
	 *            要转换的数组
	 * 
	 * @return 数组本身或空数组<code>[]</code>
	 */
	public static float[] defaultIfNull(float[] array) {
		return (array == null) ? EMPTY_FLOAT_ARRAY : array;
	}

	/**
	 * 如果数组是<code>null</code>，则返回空数组<code>[]</code>，否则返回数组本身。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfNull(null)           = []
	 * ArrayUtil.defaultIfNull(new boolean[0])  = 数组本身
	 * ArrayUtil.defaultIfNull(new boolean[10]) = 数组本身
	 * </pre>
	 * 
	 * @param array
	 *            要转换的数组
	 * 
	 * @return 数组本身或空数组<code>[]</code>
	 */
	public static boolean[] defaultIfNull(boolean[] array) {
		return (array == null) ? EMPTY_BOOLEAN_ARRAY : array;
	}

	/**
	 * 如果数组是<code>null</code>，则返回空数组<code>[]</code>，否则返回数组本身。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfNull(null)           = []
	 * ArrayUtil.defaultIfNull(new char[0])  = 数组本身
	 * ArrayUtil.defaultIfNull(new char[10]) = 数组本身
	 * </pre>
	 * 
	 * @param array
	 *            要转换的数组
	 * 
	 * @return 数组本身或空数组<code>[]</code>
	 */
	public static char[] defaultIfNull(char[] array) {
		return (array == null) ? EMPTY_CHAR_ARRAY : array;
	}

	/**
	 * 如果数组是<code>null</code>，则返回指定默认数组，否则返回数组本身。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfNull(null, defaultArray)           = defaultArray
	 * ArrayUtil.defaultIfNull(new String[0], defaultArray)  = 数组本身
	 * ArrayUtil.defaultIfNull(new String[10], defaultArray) = 数组本身
	 * </pre>
	 * 
	 * @param array
	 *            要转换的数组
	 * @param defaultArray
	 *            默认数组
	 * 
	 * @return 数组本身或指定的默认数组
	 */
	public static Object[] defaultIfNull(Object[] array, Object[] defaultArray) {
		return (array == null) ? defaultArray : array;
	}

	/**
	 * 如果数组是<code>null</code>，则返回指定默认数组，否则返回数组本身。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfNull(null, defaultArray)         = defaultArray
	 * ArrayUtil.defaultIfNull(new long[0], defaultArray)  = 数组本身
	 * ArrayUtil.defaultIfNull(new long[10], defaultArray) = 数组本身
	 * </pre>
	 * 
	 * @param array
	 *            要转换的数组
	 * @param defaultArray
	 *            默认数组
	 * 
	 * @return 数组本身或指定的默认数组
	 */
	public static long[] defaultIfNull(long[] array, long[] defaultArray) {
		return (array == null) ? defaultArray : array;
	}

	/**
	 * 如果数组是<code>null</code>，则返回指定默认数组，否则返回数组本身。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfNull(null, defaultArray)        = defaultArray
	 * ArrayUtil.defaultIfNull(new int[0], defaultArray)  = 数组本身
	 * ArrayUtil.defaultIfNull(new int[10], defaultArray) = 数组本身
	 * </pre>
	 * 
	 * @param array
	 *            要转换的数组
	 * @param defaultArray
	 *            默认数组
	 * 
	 * @return 数组本身或指定的默认数组
	 */
	public static int[] defaultIfNull(int[] array, int[] defaultArray) {
		return (array == null) ? defaultArray : array;
	}

	/**
	 * 如果数组是<code>null</code>，则返回指定默认数组，否则返回数组本身。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfNull(null, defaultArray)          = defaultArray
	 * ArrayUtil.defaultIfNull(new short[0], defaultArray)  = 数组本身
	 * ArrayUtil.defaultIfNull(new short[10], defaultArray) = 数组本身
	 * </pre>
	 * 
	 * @param array
	 *            要转换的数组
	 * @param defaultArray
	 *            默认数组
	 * 
	 * @return 数组本身或指定的默认数组
	 */
	public static short[] defaultIfNull(short[] array, short[] defaultArray) {
		return (array == null) ? defaultArray : array;
	}

	/**
	 * 如果数组是<code>null</code>，则返回指定默认数组，否则返回数组本身。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfNull(null, defaultArray)         = defaultArray
	 * ArrayUtil.defaultIfNull(new byte[0], defaultArray)  = 数组本身
	 * ArrayUtil.defaultIfNull(new byte[10], defaultArray) = 数组本身
	 * </pre>
	 * 
	 * @param array
	 *            要转换的数组
	 * @param defaultArray
	 *            默认数组
	 * 
	 * @return 数组本身或指定的默认数组
	 */
	public static byte[] defaultIfNull(byte[] array, byte[] defaultArray) {
		return (array == null) ? defaultArray : array;
	}

	/**
	 * 如果数组是<code>null</code>，则返回指定默认数组，否则返回数组本身。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfNull(null, defaultArray)         = defaultArray
	 * ArrayUtil.defaultIfNull(new double[0], defaultArray)  = 数组本身
	 * ArrayUtil.defaultIfNull(new double[10], defaultArray) = 数组本身
	 * </pre>
	 * 
	 * @param array
	 *            要转换的数组
	 * @param defaultArray
	 *            默认数组
	 * 
	 * @return 数组本身或指定的默认数组
	 */
	public static double[] defaultIfNull(double[] array, double[] defaultArray) {
		return (array == null) ? defaultArray : array;
	}

	/**
	 * 如果数组是<code>null</code>，则返回指定默认数组，否则返回数组本身。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfNull(null, defaultArray)          = defaultArray
	 * ArrayUtil.defaultIfNull(new float[0], defaultArray)  = 数组本身
	 * ArrayUtil.defaultIfNull(new float[10], defaultArray) = 数组本身
	 * </pre>
	 * 
	 * @param array
	 *            要转换的数组
	 * @param defaultArray
	 *            默认数组
	 * 
	 * @return 数组本身或指定的默认数组
	 */
	public static float[] defaultIfNull(float[] array, float[] defaultArray) {
		return (array == null) ? defaultArray : array;
	}

	/**
	 * 如果数组是<code>null</code>，则返回指定默认数组，否则返回数组本身。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfNull(null, defaultArray)            = defaultArray
	 * ArrayUtil.defaultIfNull(new boolean[0], defaultArray)  = 数组本身
	 * ArrayUtil.defaultIfNull(new boolean[10], defaultArray) = 数组本身
	 * </pre>
	 * 
	 * @param array
	 *            要转换的数组
	 * @param defaultArray
	 *            默认数组
	 * 
	 * @return 数组本身或指定的默认数组
	 */
	public static boolean[] defaultIfNull(boolean[] array,
			boolean[] defaultArray) {
		return (array == null) ? defaultArray : array;
	}

	/**
	 * 如果数组是<code>null</code>，则返回指定默认数组，否则返回数组本身。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfNull(null, defaultArray)         = defaultArray
	 * ArrayUtil.defaultIfNull(new char[0], defaultArray)  = 数组本身
	 * ArrayUtil.defaultIfNull(new char[10], defaultArray) = 数组本身
	 * </pre>
	 * 
	 * @param array
	 *            要转换的数组
	 * @param defaultArray
	 *            默认数组
	 * 
	 * @return 数组本身或指定的默认数组
	 */
	public static char[] defaultIfNull(char[] array, char[] defaultArray) {
		return (array == null) ? defaultArray : array;
	}

	/**
	 * 如果数组是<code>null</code>，则返回指定元素类型的空数组，否则返回数组本身。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfNull(null, String.class)           = new String[0]
	 * ArrayUtil.defaultIfNull(new String[0], String.class)  = 数组本身
	 * ArrayUtil.defaultIfNull(new String[10], String.class) = 数组本身
	 * </pre>
	 * 
	 * @param array
	 *            要转换的数组
	 * @param defaultComponentType
	 *            默认数组的元素类型
	 * 
	 * @return 数组本身或指定类型的空数组
	 */
	public static Object[] defaultIfNull(Object[] array,
			Class<?> defaultComponentType) {
		return (array == null) ? (Object[]) Array.newInstance(
				ClassUtil.getNonPrimitiveType(defaultComponentType), 0) : array;
	}

	/**
	 * 如果数组是<code>null</code>或空数组<code>[]</code>，则返回空数组<code>[]</code>，否则返回数组本身。
	 * 
	 * <p>
	 * 此方法实际上和<code>defaultIfNull(Object[])</code>等效。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfEmpty(null)           = []
	 * ArrayUtil.defaultIfEmpty(new String[0])  = 数组本身
	 * ArrayUtil.defaultIfEmpty(new String[10]) = 数组本身
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param array
	 *            要转换的数组
	 * 
	 * @return 数组本身或空数组<code>[]</code>
	 */
	public static Object[] defaultIfEmpty(Object[] array) {
		return (array == null) ? EMPTY_OBJECT_ARRAY : array;
	}

	/**
	 * 如果数组是<code>null</code>或空数组<code>[]</code>，则返回空数组<code>[]</code>，否则返回数组本身。
	 * 
	 * <p>
	 * 此方法实际上和<code>defaultIfNull(Object[])</code>等效。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfEmpty(null)           = []
	 * ArrayUtil.defaultIfEmpty(new long[0])    = 数组本身
	 * ArrayUtil.defaultIfEmpty(new long[10])   = 数组本身
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param array
	 *            要转换的数组
	 * 
	 * @return 数组本身或空数组<code>[]</code>
	 */
	public static long[] defaultIfEmpty(long[] array) {
		return (array == null) ? EMPTY_LONG_ARRAY : array;
	}

	/**
	 * 如果数组是<code>null</code>或空数组<code>[]</code>，则返回空数组<code>[]</code>，否则返回数组本身。
	 * 
	 * <p>
	 * 此方法实际上和<code>defaultIfNull(Object[])</code>等效。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfEmpty(null)          = []
	 * ArrayUtil.defaultIfEmpty(new int[0])    = 数组本身
	 * ArrayUtil.defaultIfEmpty(new int[10])   = 数组本身
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param array
	 *            要转换的数组
	 * 
	 * @return 数组本身或空数组<code>[]</code>
	 */
	public static int[] defaultIfEmpty(int[] array) {
		return (array == null) ? EMPTY_INT_ARRAY : array;
	}

	/**
	 * 如果数组是<code>null</code>或空数组<code>[]</code>，则返回空数组<code>[]</code>，否则返回数组本身。
	 * 
	 * <p>
	 * 此方法实际上和<code>defaultIfNull(Object[])</code>等效。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfEmpty(null)               = []
	 * ArrayUtil.defaultIfEmpty(new short[0])    = 数组本身
	 * ArrayUtil.defaultIfEmpty(new short[10])   = 数组本身
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param array
	 *            要转换的数组
	 * 
	 * @return 数组本身或空数组<code>[]</code>
	 */
	public static short[] defaultIfEmpty(short[] array) {
		return (array == null) ? EMPTY_SHORT_ARRAY : array;
	}

	/**
	 * 如果数组是<code>null</code>或空数组<code>[]</code>，则返回空数组<code>[]</code>，否则返回数组本身。
	 * 
	 * <p>
	 * 此方法实际上和<code>defaultIfNull(Object[])</code>等效。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfEmpty(null)           = []
	 * ArrayUtil.defaultIfEmpty(new byte[0])    = 数组本身
	 * ArrayUtil.defaultIfEmpty(new byte[10])   = 数组本身
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param array
	 *            要转换的数组
	 * 
	 * @return 数组本身或空数组<code>[]</code>
	 */
	public static byte[] defaultIfEmpty(byte[] array) {
		return (array == null) ? EMPTY_BYTE_ARRAY : array;
	}

	/**
	 * 如果数组是<code>null</code>或空数组<code>[]</code>，则返回空数组<code>[]</code>，否则返回数组本身。
	 * 
	 * <p>
	 * 此方法实际上和<code>defaultIfNull(Object[])</code>等效。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfEmpty(null)               = []
	 * ArrayUtil.defaultIfEmpty(new double[0])    = 数组本身
	 * ArrayUtil.defaultIfEmpty(new double[10])   = 数组本身
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param array
	 *            要转换的数组
	 * 
	 * @return 数组本身或空数组<code>[]</code>
	 */
	public static double[] defaultIfEmpty(double[] array) {
		return (array == null) ? EMPTY_DOUBLE_ARRAY : array;
	}

	/**
	 * 如果数组是<code>null</code>或空数组<code>[]</code>，则返回空数组<code>[]</code>，否则返回数组本身。
	 * 
	 * <p>
	 * 此方法实际上和<code>defaultIfNull(Object[])</code>等效。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfEmpty(null)               = []
	 * ArrayUtil.defaultIfEmpty(new float[0])    = 数组本身
	 * ArrayUtil.defaultIfEmpty(new float[10])   = 数组本身
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param array
	 *            要转换的数组
	 * 
	 * @return 数组本身或空数组<code>[]</code>
	 */
	public static float[] defaultIfEmpty(float[] array) {
		return (array == null) ? EMPTY_FLOAT_ARRAY : array;
	}

	/**
	 * 如果数组是<code>null</code>或空数组<code>[]</code>，则返回空数组<code>[]</code>，否则返回数组本身。
	 * 
	 * <p>
	 * 此方法实际上和<code>defaultIfNull(Object[])</code>等效。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfEmpty(null)               = []
	 * ArrayUtil.defaultIfEmpty(new boolean[0])    = 数组本身
	 * ArrayUtil.defaultIfEmpty(new boolean[10])   = 数组本身
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param array
	 *            要转换的数组
	 * 
	 * @return 数组本身或空数组<code>[]</code>
	 */
	public static boolean[] defaultIfEmpty(boolean[] array) {
		return (array == null) ? EMPTY_BOOLEAN_ARRAY : array;
	}

	/**
	 * 如果数组是<code>null</code>或空数组<code>[]</code>，则返回空数组<code>[]</code>，否则返回数组本身。
	 * 
	 * <p>
	 * 此方法实际上和<code>defaultIfNull(Object[])</code>等效。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfEmpty(null)           = []
	 * ArrayUtil.defaultIfEmpty(new char[0])    = 数组本身
	 * ArrayUtil.defaultIfEmpty(new char[10])   = 数组本身
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param array
	 *            要转换的数组
	 * 
	 * @return 数组本身或空数组<code>[]</code>
	 */
	public static char[] defaultIfEmpty(char[] array) {
		return (array == null) ? EMPTY_CHAR_ARRAY : array;
	}

	/**
	 * 如果数组是<code>null</code>或空数组<code>[]</code>，则返回指定默认数组，否则返回数组本身。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfEmpty(null, defaultArray)           = defaultArray
	 * ArrayUtil.defaultIfEmpty(new String[0], defaultArray)  = defaultArray
	 * ArrayUtil.defaultIfEmpty(new String[10], defaultArray) = 数组本身
	 * </pre>
	 * 
	 * @param array
	 *            要转换的数组
	 * @param defaultArray
	 *            默认数组
	 * 
	 * @return 数组本身或指定的默认数组
	 */
	public static Object[] defaultIfEmpty(Object[] array, Object[] defaultArray) {
		return ((array == null) || (array.length == 0)) ? defaultArray : array;
	}

	/**
	 * 如果数组是<code>null</code>或空数组<code>[]</code>，则返回指定默认数组，否则返回数组本身。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfEmpty(null, defaultArray)           = defaultArray
	 * ArrayUtil.defaultIfEmpty(new long[0], defaultArray)    = defaultArray
	 * ArrayUtil.defaultIfEmpty(new long[10], defaultArray)   = 数组本身
	 * </pre>
	 * 
	 * @param array
	 *            要转换的数组
	 * @param defaultArray
	 *            默认数组
	 * 
	 * @return 数组本身或指定的默认数组
	 */
	public static long[] defaultIfEmpty(long[] array, long[] defaultArray) {
		return ((array == null) || (array.length == 0)) ? defaultArray : array;
	}

	/**
	 * 如果数组是<code>null</code>或空数组<code>[]</code>，则返回指定默认数组，否则返回数组本身。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfEmpty(null, defaultArray)           = defaultArray
	 * ArrayUtil.defaultIfEmpty(new int[0], defaultArray)     = defaultArray
	 * ArrayUtil.defaultIfEmpty(new int[10], defaultArray)    = 数组本身
	 * </pre>
	 * 
	 * @param array
	 *            要转换的数组
	 * @param defaultArray
	 *            默认数组
	 * 
	 * @return 数组本身或指定的默认数组
	 */
	public static int[] defaultIfEmpty(int[] array, int[] defaultArray) {
		return ((array == null) || (array.length == 0)) ? defaultArray : array;
	}

	/**
	 * 如果数组是<code>null</code>或空数组<code>[]</code>，则返回指定默认数组，否则返回数组本身。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfEmpty(null, defaultArray)           = defaultArray
	 * ArrayUtil.defaultIfEmpty(new short[0], defaultArray)   = defaultArray
	 * ArrayUtil.defaultIfEmpty(new short[10], defaultArray)  = 数组本身
	 * </pre>
	 * 
	 * @param array
	 *            要转换的数组
	 * @param defaultArray
	 *            默认数组
	 * 
	 * @return 数组本身或指定的默认数组
	 */
	public static short[] defaultIfEmpty(short[] array, short[] defaultArray) {
		return ((array == null) || (array.length == 0)) ? defaultArray : array;
	}

	/**
	 * 如果数组是<code>null</code>或空数组<code>[]</code>，则返回指定默认数组，否则返回数组本身。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfEmpty(null, defaultArray)           = defaultArray
	 * ArrayUtil.defaultIfEmpty(new byte[0], defaultArray)    = defaultArray
	 * ArrayUtil.defaultIfEmpty(new byte[10], defaultArray)   = 数组本身
	 * </pre>
	 * 
	 * @param array
	 *            要转换的数组
	 * @param defaultArray
	 *            默认数组
	 * 
	 * @return 数组本身或指定的默认数组
	 */
	public static byte[] defaultIfEmpty(byte[] array, byte[] defaultArray) {
		return ((array == null) || (array.length == 0)) ? defaultArray : array;
	}

	/**
	 * 如果数组是<code>null</code>或空数组<code>[]</code>，则返回指定默认数组，否则返回数组本身。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfEmpty(null, defaultArray)           = defaultArray
	 * ArrayUtil.defaultIfEmpty(new double[0], defaultArray)  = defaultArray
	 * ArrayUtil.defaultIfEmpty(new double[10], defaultArray) = 数组本身
	 * </pre>
	 * 
	 * @param array
	 *            要转换的数组
	 * @param defaultArray
	 *            默认数组
	 * 
	 * @return 数组本身或指定的默认数组
	 */
	public static double[] defaultIfEmpty(double[] array, double[] defaultArray) {
		return ((array == null) || (array.length == 0)) ? defaultArray : array;
	}

	/**
	 * 如果数组是<code>null</code>或空数组<code>[]</code>，则返回指定默认数组，否则返回数组本身。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfEmpty(null, defaultArray)           = defaultArray
	 * ArrayUtil.defaultIfEmpty(new float[0], defaultArray)   = defaultArray
	 * ArrayUtil.defaultIfEmpty(new float[10], defaultArray)  = 数组本身
	 * </pre>
	 * 
	 * @param array
	 *            要转换的数组
	 * @param defaultArray
	 *            默认数组
	 * 
	 * @return 数组本身或指定的默认数组
	 */
	public static float[] defaultIfEmpty(float[] array, float[] defaultArray) {
		return ((array == null) || (array.length == 0)) ? defaultArray : array;
	}

	/**
	 * 如果数组是<code>null</code>或空数组<code>[]</code>，则返回指定默认数组，否则返回数组本身。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfEmpty(null, defaultArray)              = defaultArray
	 * ArrayUtil.defaultIfEmpty(new boolean[0], defaultArray)    = defaultArray
	 * ArrayUtil.defaultIfEmpty(new boolean[10], defaultArray)   = 数组本身
	 * </pre>
	 * 
	 * @param array
	 *            要转换的数组
	 * @param defaultArray
	 *            默认数组
	 * 
	 * @return 数组本身或指定的默认数组
	 */
	public static boolean[] defaultIfEmpty(boolean[] array,
			boolean[] defaultArray) {
		return ((array == null) || (array.length == 0)) ? defaultArray : array;
	}

	/**
	 * 如果数组是<code>null</code>或空数组<code>[]</code>，则返回指定默认数组，否则返回数组本身。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfEmpty(null, defaultArray)           = defaultArray
	 * ArrayUtil.defaultIfEmpty(new char[0], defaultArray)    = defaultArray
	 * ArrayUtil.defaultIfEmpty(new char[10], defaultArray)   = 数组本身
	 * </pre>
	 * 
	 * @param array
	 *            要转换的数组
	 * @param defaultArray
	 *            默认数组
	 * 
	 * @return 数组本身或指定的默认数组
	 */
	public static char[] defaultIfEmpty(char[] array, char[] defaultArray) {
		return ((array == null) || (array.length == 0)) ? defaultArray : array;
	}

	/**
	 * 如果数组是<code>null</code>或空数组<code>[]</code>，则返回指定元素类型的空数组，否则返回数组本身。
	 * 
	 * <pre>
	 * ArrayUtil.defaultIfNull(null, String.class)           = new String[0]
	 * ArrayUtil.defaultIfNull(new String[0], String.class)  = new String[0]
	 * ArrayUtil.defaultIfNull(new String[10], String.class) = 数组本身
	 * </pre>
	 * 
	 * @param array
	 *            要转换的数组
	 * @param defaultComponentType
	 *            默认数组的元素类型
	 * 
	 * @return 数组本身或指定类型的空数组
	 */
	public static Object[] defaultIfEmpty(Object[] array,
			Class<?> defaultComponentType) {
		return ((array == null) || (array.length == 0)) ? (Object[]) Array
				.newInstance(
						ClassUtil.getNonPrimitiveType(defaultComponentType), 0)
				: array;
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* 比较函数。 */
	/*                                                                              */
	/* 以下方法用来比较两个数组是否完全相同，支持多维数组。 */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * 递归地比较两个数组是否相同，支持多维数组。
	 * 
	 * <p>
	 * 如果比较的对象不是数组，则此方法的结果同<code>ObjectUtil.equals</code>。
	 * </p>
	 * 
	 * @param array1
	 *            数组1
	 * @param array2
	 *            数组2
	 * 
	 * @return 如果相等, 则返回<code>true</code>
	 */
	public static boolean equals(Object array1, Object array2) {
		if (array1 == array2) {
			return true;
		}

		if ((array1 == null) || (array2 == null)) {
			return false;
		}

		Class<? extends Object> clazz = array1.getClass();

		if (!clazz.equals(array2.getClass())) {
			return false;
		}

		if (!clazz.isArray()) {
			return array1.equals(array2);
		}

		// array1和array2为同类型的数组
		if (long[].class.isInstance(array1)) {
			long[] longArray1 = (long[]) array1;
			long[] longArray2 = (long[]) array2;

			if (longArray1.length != longArray2.length) {
				return false;
			}

			for (int i = 0; i < longArray1.length; i++) {
				if (longArray1[i] != longArray2[i]) {
					return false;
				}
			}

			return true;
		} else if (int[].class.isInstance(array1)) {
			int[] intArray1 = (int[]) array1;
			int[] intArray2 = (int[]) array2;

			if (intArray1.length != intArray2.length) {
				return false;
			}

			for (int i = 0; i < intArray1.length; i++) {
				if (intArray1[i] != intArray2[i]) {
					return false;
				}
			}

			return true;
		} else if (short[].class.isInstance(array1)) {
			short[] shortArray1 = (short[]) array1;
			short[] shortArray2 = (short[]) array2;

			if (shortArray1.length != shortArray2.length) {
				return false;
			}

			for (int i = 0; i < shortArray1.length; i++) {
				if (shortArray1[i] != shortArray2[i]) {
					return false;
				}
			}

			return true;
		} else if (byte[].class.isInstance(array1)) {
			byte[] byteArray1 = (byte[]) array1;
			byte[] byteArray2 = (byte[]) array2;

			if (byteArray1.length != byteArray2.length) {
				return false;
			}

			for (int i = 0; i < byteArray1.length; i++) {
				if (byteArray1[i] != byteArray2[i]) {
					return false;
				}
			}

			return true;
		} else if (double[].class.isInstance(array1)) {
			double[] doubleArray1 = (double[]) array1;
			double[] doubleArray2 = (double[]) array2;

			if (doubleArray1.length != doubleArray2.length) {
				return false;
			}

			for (int i = 0; i < doubleArray1.length; i++) {
				if (Double.doubleToLongBits(doubleArray1[i]) != Double
						.doubleToLongBits(doubleArray2[i])) {
					return false;
				}
			}

			return true;
		} else if (float[].class.isInstance(array1)) {
			float[] floatArray1 = (float[]) array1;
			float[] floatArray2 = (float[]) array2;

			if (floatArray1.length != floatArray2.length) {
				return false;
			}

			for (int i = 0; i < floatArray1.length; i++) {
				if (Float.floatToIntBits(floatArray1[i]) != Float
						.floatToIntBits(floatArray2[i])) {
					return false;
				}
			}

			return true;
		} else if (boolean[].class.isInstance(array1)) {
			boolean[] booleanArray1 = (boolean[]) array1;
			boolean[] booleanArray2 = (boolean[]) array2;

			if (booleanArray1.length != booleanArray2.length) {
				return false;
			}

			for (int i = 0; i < booleanArray1.length; i++) {
				if (booleanArray1[i] != booleanArray2[i]) {
					return false;
				}
			}

			return true;
		} else if (char[].class.isInstance(array1)) {
			char[] charArray1 = (char[]) array1;
			char[] charArray2 = (char[]) array2;

			if (charArray1.length != charArray2.length) {
				return false;
			}

			for (int i = 0; i < charArray1.length; i++) {
				if (charArray1[i] != charArray2[i]) {
					return false;
				}
			}

			return true;
		} else {
			Object[] objectArray1 = (Object[]) array1;
			Object[] objectArray2 = (Object[]) array2;

			if (objectArray1.length != objectArray2.length) {
				return false;
			}

			for (int i = 0; i < objectArray1.length; i++) {
				if (!equals(objectArray1[i], objectArray2[i])) {
					return false;
				}
			}

			return true;
		}
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* Hashcode函数。 */
	/*                                                                              */
	/* 以下方法用来取得数组的hash code。 */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * 取得数组的hash值, 如果数组为<code>null</code>, 则返回<code>0</code>。
	 * 
	 * <p>
	 * 如果对象不是数组，则此方法的结果同<code>ObjectUtil.hashCode</code>。
	 * </p>
	 * 
	 * @param array
	 *            数组
	 * 
	 * @return hash值
	 */
	public static int hashCode(Object array) {
		if (array == null) {
			return 0;
		}

		if (!array.getClass().isArray()) {
			return array.hashCode();
		}

		int hashCode = INITIAL_NON_ZERO_ODD_NUMBER;

		// array是数组
		if (long[].class.isInstance(array)) {
			long[] longArray = (long[]) array;

			for (int i = 0; i < longArray.length; i++) {
				hashCode = (hashCode * MULTIPLIER_NON_ZERO_ODD_NUMBER)
						+ ((int) (longArray[i] ^ (longArray[i] >> 32)));
			}
		} else if (int[].class.isInstance(array)) {
			int[] intArray = (int[]) array;

			for (int i = 0; i < intArray.length; i++) {
				hashCode = (hashCode * MULTIPLIER_NON_ZERO_ODD_NUMBER)
						+ intArray[i];
			}
		} else if (short[].class.isInstance(array)) {
			short[] shortArray = (short[]) array;

			for (int i = 0; i < shortArray.length; i++) {
				hashCode = (hashCode * MULTIPLIER_NON_ZERO_ODD_NUMBER)
						+ shortArray[i];
			}
		} else if (byte[].class.isInstance(array)) {
			byte[] byteArray = (byte[]) array;

			for (int i = 0; i < byteArray.length; i++) {
				hashCode = (hashCode * MULTIPLIER_NON_ZERO_ODD_NUMBER)
						+ byteArray[i];
			}
		} else if (double[].class.isInstance(array)) {
			double[] doubleArray = (double[]) array;

			for (int i = 0; i < doubleArray.length; i++) {
				long longBits = Double.doubleToLongBits(doubleArray[i]);

				hashCode = (hashCode * MULTIPLIER_NON_ZERO_ODD_NUMBER)
						+ ((int) (longBits ^ (longBits >> 32)));
			}
		} else if (float[].class.isInstance(array)) {
			float[] floatArray = (float[]) array;

			for (int i = 0; i < floatArray.length; i++) {
				hashCode = (hashCode * MULTIPLIER_NON_ZERO_ODD_NUMBER)
						+ Float.floatToIntBits(floatArray[i]);
			}
		} else if (boolean[].class.isInstance(array)) {
			boolean[] booleanArray = (boolean[]) array;

			for (int i = 0; i < booleanArray.length; i++) {
				hashCode = (hashCode * MULTIPLIER_NON_ZERO_ODD_NUMBER)
						+ (booleanArray[i] ? 1 : 0);
			}
		} else if (char[].class.isInstance(array)) {
			char[] charArray = (char[]) array;

			for (int i = 0; i < charArray.length; i++) {
				hashCode = (hashCode * MULTIPLIER_NON_ZERO_ODD_NUMBER)
						+ charArray[i];
			}
		} else {
			Object[] objectArray = (Object[]) array;

			for (int i = 0; i < objectArray.length; i++) {
				hashCode = (hashCode * MULTIPLIER_NON_ZERO_ODD_NUMBER)
						+ hashCode(objectArray[i]);
			}
		}

		return hashCode;
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* 将数组转换成集合类。 */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * 将数组映射成固定长度的<code>List</code>，当改变这个<code>List</code>中的值时。数组中的相应值也被改变。
	 * 
	 * <p>
	 * 如果输入数组为<code>null</code>，则返回<code>null</code>。
	 * </p>
	 * 
	 * <p>
	 * 该方法内部调用<code>java.util.Arrays.asList</code>
	 * 方法所返回的列表为指定数组的映像（固定长度），因此性能和内存占用上比<code>toList</code>方法更优。
	 * </p>
	 * 
	 * <p>
	 * 这个方法常被用于初始化，例如：
	 * 
	 * <pre>
	 * List myList = ArrayUtil.toFixedList(new String[] { &quot;aaa&quot;, &quot;bbb&quot;, &quot;ccc&quot; });
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param array
	 *            要转换的数组
	 * 
	 * @return 以数组本身为映射的list
	 */
	public static List<Object> toFixedList(Object[] array) {
		if (array == null) {
			return null;
		}

		return Arrays.asList(array);
	}

	/**
	 * 将数组转换成<code>List</code>。
	 * 
	 * <p>
	 * 如果输入数组为<code>null</code>，则返回<code>null</code>。
	 * </p>
	 * 
	 * <p>
	 * 该方法返回的列表为指定数组的复本，而<code>java.util.Arrays.asList</code>
	 * 方法所返回的列表为指定数组的映像（固定长度）。
	 * </p>
	 * 
	 * <p>
	 * 这个方法常被用于初始化，例如：
	 * 
	 * <pre>
	 * List myList = ArrayUtil.toList(new String[] { &quot;aaa&quot;, &quot;bbb&quot;, &quot;ccc&quot; });
	 * List singleList = ArrayUtil.toList(&quot;hello&quot;); // 返回单个元素的列表[&quot;hello&quot;]
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param array
	 *            要转换的数组
	 * 
	 * @return 被创建的list
	 */
	public static List<Object> toList(Object array) {
		return toList(array, null);
	}

	/**
	 * 将数组转换成<code>List</code>。
	 * 
	 * <p>
	 * 如果输入数组为<code>null</code>，则返回<code>null</code>。
	 * </p>
	 * 
	 * <p>
	 * 该方法返回的列表为指定数组的复本，而<code>java.util.Arrays.asList</code>
	 * 方法所返回的列表为指定数组的映像（固定长度）。
	 * </p>
	 * 
	 * <p>
	 * 这个方法常被用于初始化，例如：
	 * 
	 * <pre>
	 * List myList = ArrayUtil.toList(new String[] { &quot;aaa&quot;, &quot;bbb&quot;, &quot;ccc&quot; },
	 * 		new ArrayList());
	 * List singleList = ArrayUtil.toList(&quot;hello&quot;, new ArrayList()); // 返回单个元素的列表[&quot;hello&quot;]
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param array
	 *            要转换的数组
	 * @param list
	 *            要填充的列表，如果是<code>null</code>，则创建之
	 * 
	 * @return 被创建或填充的list
	 */
	public static List<Object> toList(Object array, List<Object> list) {
		if (array == null) {
			return list;
		}

		// 非array，创建一个只有一个元素的列表
		if (!array.getClass().isArray()) {
			if (list == null) {
				list = CollectionUtil.getArrayList(1);
			}

			list.add(array);
		} else if (long[].class.isInstance(array)) {
			long[] longArray = (long[]) array;

			if (list == null) {
				list = CollectionUtil.getArrayList(longArray.length);
			}

			for (int i = 0; i < longArray.length; i++) {
				list.add(Long.valueOf(longArray[i]));
			}
		} else if (int[].class.isInstance(array)) {
			int[] intArray = (int[]) array;

			if (list == null) {
				list = CollectionUtil.getArrayList(intArray.length);
			}

			for (int i = 0; i < intArray.length; i++) {
				list.add(Integer.valueOf(intArray[i]));
			}
		} else if (short[].class.isInstance(array)) {
			short[] shortArray = (short[]) array;

			if (list == null) {
				list = CollectionUtil.getArrayList(shortArray.length);
			}

			for (int i = 0; i < shortArray.length; i++) {
				list.add(Short.valueOf(shortArray[i]));
			}
		} else if (byte[].class.isInstance(array)) {
			byte[] byteArray = (byte[]) array;

			if (list == null) {
				list = CollectionUtil.getArrayList(byteArray.length);
			}

			for (int i = 0; i < byteArray.length; i++) {
				list.add(Byte.valueOf(byteArray[i]));
			}
		} else if (double[].class.isInstance(array)) {
			double[] doubleArray = (double[]) array;

			if (list == null) {
				list = CollectionUtil.getArrayList(doubleArray.length);
			}

			for (int i = 0; i < doubleArray.length; i++) {
				list.add(new Double(doubleArray[i]));
			}
		} else if (float[].class.isInstance(array)) {
			float[] floatArray = (float[]) array;

			if (list == null) {
				list = CollectionUtil.getArrayList(floatArray.length);
			}

			for (int i = 0; i < floatArray.length; i++) {
				list.add(new Float(floatArray[i]));
			}
		} else if (boolean[].class.isInstance(array)) {
			boolean[] booleanArray = (boolean[]) array;

			if (list == null) {
				list = CollectionUtil.getArrayList(booleanArray.length);
			}

			for (int i = 0; i < booleanArray.length; i++) {
				list.add(booleanArray[i] ? Boolean.TRUE : Boolean.FALSE);
			}
		} else if (char[].class.isInstance(array)) {
			char[] charArray = (char[]) array;

			if (list == null) {
				list = CollectionUtil.getArrayList(charArray.length);
			}

			for (int i = 0; i < charArray.length; i++) {
				list.add(Character.valueOf(charArray[i]));
			}
		} else {
			Object[] objectArray = (Object[]) array;

			if (list == null) {
				list = CollectionUtil.getArrayList(objectArray.length);
			}

			for (int i = 0; i < objectArray.length; i++) {
				list.add(objectArray[i]);
			}
		}

		return list;
	}

	/**
	 * 将数组转换成<code>Map</code>。数组的元素必须是<code>Map.Entry</code>或元素个数多于2的子数组。
	 * 
	 * <p>
	 * 如果输入数组为<code>null</code>，则返回<code>null</code>。
	 * </p>
	 * 
	 * <p>
	 * 这个方法常被用于初始化，例如：
	 * 
	 * <pre>
	 * Map colorMap = ArrayUtil.toMap(new String[][] { { &quot;RED&quot;, &quot;#FF0000&quot; },
	 * 		{ &quot;GREEN&quot;, &quot;#00FF00&quot; }, { &quot;BLUE&quot;, &quot;#0000FF&quot; } });
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param array
	 *            要转换的数组
	 * 
	 * @return 被创建的map
	 * 
	 * @throws IllegalArgumentException
	 *             如果有一个子数组元素个数小于2或不是<code>Map.Entry</code>实例
	 */
	public static Map<Object, Object> toMap(Object[] array) {
		return toMap(array, null);
	}

	/**
	 * 将数组转换成<code>Map</code>。数组的元素必须是<code>Map.Entry</code>或元素个数多于2的子数组。
	 * 
	 * <p>
	 * 如果输入数组为<code>null</code>，则返回<code>null</code>。
	 * </p>
	 * 
	 * <p>
	 * 这个方法常被用于初始化，例如：
	 * 
	 * <pre>
	 * Map colorMap = ArrayUtil.toMap(new String[][] {{
	 *     {&quot;RED&quot;, &quot;#FF0000&quot;},
	 *     {&quot;GREEN&quot;, &quot;#00FF00&quot;},
	 *     {&quot;BLUE&quot;, &quot;#0000FF&quot;}}, new HashMap());
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param array
	 *            要转换的数组
	 * @param map
	 *            要填充的map，如果为<code>null</code>则自动创建之
	 * 
	 * @return 被创建或填充的map
	 * 
	 * @throws IllegalArgumentException
	 *             如果有一个子数组元素个数小于2或不是<code>Map.Entry</code>实例
	 */
	public static Map<Object, Object> toMap(Object[] array,
			Map<Object, Object> map) {
		if (array == null) {
			return map;
		}

		if (map == null) {
			map = CollectionUtil.getHashMap((int) (array.length * 1.5));
		}

		for (int i = 0; i < array.length; i++) {
			Object object = array[i];

			if (Map.Entry.class.isInstance(object)) {
				@SuppressWarnings("rawtypes")
				Map.Entry entry = (Map.Entry) object;

				map.put(entry.getKey(), entry.getValue());
			} else if (Object.class.isInstance(object)) {
				Object[] entry = (Object[]) object;

				if (entry.length < 2) {
					throw new IllegalArgumentException("Array element " + i
							+ ", '" + object + "', has a length less than 2");
				}

				map.put(entry[0], entry[1]);
			} else {
				throw new IllegalArgumentException("Array element " + i + ", '"
						+ object
						+ "', is neither of type Map.Entry nor an Array");
			}
		}

		return map;
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* Clone函数。 */
	/*                                                                              */
	/* 以下方法调用Object.clone方法，进行“浅复制”（shallow copy）。 */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * 复制一个数组。如果数组为<code>null</code>，则返回<code>null</code>。
	 * 
	 * <p>
	 * 此方法只进行“浅复制”，也就是说，数组中的对象本身不会被复制。 另外，此方法也不处理多维数组。
	 * </p>
	 * 
	 * @param array
	 *            要复制的数组
	 * 
	 * @return 数组的复本，如果原始数组为<code>null</code>，则返回<code>null</code>
	 */
	public static <T> T[] clone(T[] array) {
		if (array == null) {
			return null;
		}

		return (T[]) array.clone();
	}

	/**
	 * 复制一个数组。如果数组为<code>null</code>，则返回<code>null</code>。
	 * 
	 * <p>
	 * 此方法也不处理多维数组。
	 * </p>
	 * 
	 * @param array
	 *            要复制的数组
	 * 
	 * @return 数组的复本，如果原始数组为<code>null</code>，则返回<code>null</code>
	 */
	public static long[] clone(long[] array) {
		if (array == null) {
			return null;
		}

		return (long[]) array.clone();
	}

	/**
	 * 复制一个数组。如果数组为<code>null</code>，则返回<code>null</code>。
	 * 
	 * <p>
	 * 此方法也不处理多维数组。
	 * </p>
	 * 
	 * @param array
	 *            要复制的数组
	 * 
	 * @return 数组的复本，如果原始数组为<code>null</code>，则返回<code>null</code>
	 */
	public static int[] clone(int[] array) {
		if (array == null) {
			return null;
		}

		return (int[]) array.clone();
	}

	/**
	 * 复制一个数组。如果数组为<code>null</code>，则返回<code>null</code>。
	 * 
	 * <p>
	 * 此方法也不处理多维数组。
	 * </p>
	 * 
	 * @param array
	 *            要复制的数组
	 * 
	 * @return 数组的复本，如果原始数组为<code>null</code>，则返回<code>null</code>
	 */
	public static short[] clone(short[] array) {
		if (array == null) {
			return null;
		}

		return (short[]) array.clone();
	}

	/**
	 * 复制一个数组。如果数组为<code>null</code>，则返回<code>null</code>。
	 * 
	 * <p>
	 * 此方法也不处理多维数组。
	 * </p>
	 * 
	 * @param array
	 *            要复制的数组
	 * 
	 * @return 数组的复本，如果原始数组为<code>null</code>，则返回<code>null</code>
	 */
	public static byte[] clone(byte[] array) {
		if (array == null) {
			return null;
		}

		return (byte[]) array.clone();
	}

	/**
	 * 复制一个数组。如果数组为<code>null</code>，则返回<code>null</code>。
	 * 
	 * <p>
	 * 此方法也不处理多维数组。
	 * </p>
	 * 
	 * @param array
	 *            要复制的数组
	 * 
	 * @return 数组的复本，如果原始数组为<code>null</code>，则返回<code>null</code>
	 */
	public static double[] clone(double[] array) {
		if (array == null) {
			return null;
		}

		return (double[]) array.clone();
	}

	/**
	 * 复制一个数组。如果数组为<code>null</code>，则返回<code>null</code>。
	 * 
	 * <p>
	 * 此方法也不处理多维数组。
	 * </p>
	 * 
	 * @param array
	 *            要复制的数组
	 * 
	 * @return 数组的复本，如果原始数组为<code>null</code>，则返回<code>null</code>
	 */
	public static float[] clone(float[] array) {
		if (array == null) {
			return null;
		}

		return (float[]) array.clone();
	}

	/**
	 * 复制一个数组。如果数组为<code>null</code>，则返回<code>null</code>。
	 * 
	 * <p>
	 * 此方法也不处理多维数组。
	 * </p>
	 * 
	 * @param array
	 *            要复制的数组
	 * 
	 * @return 数组的复本，如果原始数组为<code>null</code>，则返回<code>null</code>
	 */
	public static boolean[] clone(boolean[] array) {
		if (array == null) {
			return null;
		}

		return (boolean[]) array.clone();
	}

	/**
	 * 复制一个数组。如果数组为<code>null</code>，则返回<code>null</code>。
	 * 
	 * <p>
	 * 此方法也不处理多维数组。
	 * </p>
	 * 
	 * @param array
	 *            要复制的数组
	 * 
	 * @return 数组的复本，如果原始数组为<code>null</code>，则返回<code>null</code>
	 */
	public static char[] clone(char[] array) {
		if (array == null) {
			return null;
		}

		return (char[]) array.clone();
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* 比较数组的长度。 */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * 判断两个数组是否具有相同的长度。如果数组为<code>null</code>则被看作长度为<code>0</code>。
	 * 
	 * @param array1
	 *            数组1
	 * @param array2
	 *            数组2
	 * 
	 * @return 如果两个数组长度相同，则返回<code>true</code>
	 */
	public static boolean isSameLength(Object[] array1, Object[] array2) {
		int length1 = (array1 == null) ? 0 : array1.length;
		int length2 = (array2 == null) ? 0 : array2.length;

		return length1 == length2;
	}

	/**
	 * 判断两个数组是否具有相同的长度。如果数组为<code>null</code>则被看作长度为<code>0</code>。
	 * 
	 * @param array1
	 *            数组1
	 * @param array2
	 *            数组2
	 * 
	 * @return 如果两个数组长度相同，则返回<code>true</code>
	 */
	public static boolean isSameLength(long[] array1, long[] array2) {
		int length1 = (array1 == null) ? 0 : array1.length;
		int length2 = (array2 == null) ? 0 : array2.length;

		return length1 == length2;
	}

	/**
	 * 判断两个数组是否具有相同的长度。如果数组为<code>null</code>则被看作长度为<code>0</code>。
	 * 
	 * @param array1
	 *            数组1
	 * @param array2
	 *            数组2
	 * 
	 * @return 如果两个数组长度相同，则返回<code>true</code>
	 */
	public static boolean isSameLength(int[] array1, int[] array2) {
		int length1 = (array1 == null) ? 0 : array1.length;
		int length2 = (array2 == null) ? 0 : array2.length;

		return length1 == length2;
	}

	/**
	 * 判断两个数组是否具有相同的长度。如果数组为<code>null</code>则被看作长度为<code>0</code>。
	 * 
	 * @param array1
	 *            数组1
	 * @param array2
	 *            数组2
	 * 
	 * @return 如果两个数组长度相同，则返回<code>true</code>
	 */
	public static boolean isSameLength(short[] array1, short[] array2) {
		int length1 = (array1 == null) ? 0 : array1.length;
		int length2 = (array2 == null) ? 0 : array2.length;

		return length1 == length2;
	}

	/**
	 * 判断两个数组是否具有相同的长度。如果数组为<code>null</code>则被看作长度为<code>0</code>。
	 * 
	 * @param array1
	 *            数组1
	 * @param array2
	 *            数组2
	 * 
	 * @return 如果两个数组长度相同，则返回<code>true</code>
	 */
	public static boolean isSameLength(byte[] array1, byte[] array2) {
		int length1 = (array1 == null) ? 0 : array1.length;
		int length2 = (array2 == null) ? 0 : array2.length;

		return length1 == length2;
	}

	/**
	 * 判断两个数组是否具有相同的长度。如果数组为<code>null</code>则被看作长度为<code>0</code>。
	 * 
	 * @param array1
	 *            数组1
	 * @param array2
	 *            数组2
	 * 
	 * @return 如果两个数组长度相同，则返回<code>true</code>
	 */
	public static boolean isSameLength(double[] array1, double[] array2) {
		int length1 = (array1 == null) ? 0 : array1.length;
		int length2 = (array2 == null) ? 0 : array2.length;

		return length1 == length2;
	}

	/**
	 * 判断两个数组是否具有相同的长度。如果数组为<code>null</code>则被看作长度为<code>0</code>。
	 * 
	 * @param array1
	 *            数组1
	 * @param array2
	 *            数组2
	 * 
	 * @return 如果两个数组长度相同，则返回<code>true</code>
	 */
	public static boolean isSameLength(float[] array1, float[] array2) {
		int length1 = (array1 == null) ? 0 : array1.length;
		int length2 = (array2 == null) ? 0 : array2.length;

		return length1 == length2;
	}

	/**
	 * 判断两个数组是否具有相同的长度。如果数组为<code>null</code>则被看作长度为<code>0</code>。
	 * 
	 * @param array1
	 *            数组1
	 * @param array2
	 *            数组2
	 * 
	 * @return 如果两个数组长度相同，则返回<code>true</code>
	 */
	public static boolean isSameLength(boolean[] array1, boolean[] array2) {
		int length1 = (array1 == null) ? 0 : array1.length;
		int length2 = (array2 == null) ? 0 : array2.length;

		return length1 == length2;
	}

	/**
	 * 判断两个数组是否具有相同的长度。如果数组为<code>null</code>则被看作长度为<code>0</code>。
	 * 
	 * @param array1
	 *            数组1
	 * @param array2
	 *            数组2
	 * 
	 * @return 如果两个数组长度相同，则返回<code>true</code>
	 */
	public static boolean isSameLength(char[] array1, char[] array2) {
		int length1 = (array1 == null) ? 0 : array1.length;
		int length2 = (array2 == null) ? 0 : array2.length;

		return length1 == length2;
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* 反转数组的元素顺序。 */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * 反转数组的元素顺序。如果数组为<code>null</code>，则什么也不做。
	 * 
	 * @param array
	 *            要反转的数组
	 */
	public static void reverse(Object[] array) {
		if (array == null) {
			return;
		}

		Object tmp;

		for (int i = 0, j = array.length - 1; j > i; i++, j--) {
			tmp = array[j];
			array[j] = array[i];
			array[i] = tmp;
		}
	}

	/**
	 * 反转数组的元素顺序。如果数组为<code>null</code>，则什么也不做。
	 * 
	 * @param array
	 *            要反转的数组
	 */
	public static void reverse(long[] array) {
		if (array == null) {
			return;
		}

		long tmp;

		for (int i = 0, j = array.length - 1; j > i; i++, j--) {
			tmp = array[j];
			array[j] = array[i];
			array[i] = tmp;
		}
	}

	/**
	 * 反转数组的元素顺序。如果数组为<code>null</code>，则什么也不做。
	 * 
	 * @param array
	 *            要反转的数组
	 */
	public static void reverse(int[] array) {
		if (array == null) {
			return;
		}

		int tmp;

		for (int i = 0, j = array.length - 1; j > i; i++, j--) {
			tmp = array[j];
			array[j] = array[i];
			array[i] = tmp;
		}
	}

	/**
	 * 反转数组的元素顺序。如果数组为<code>null</code>，则什么也不做。
	 * 
	 * @param array
	 *            要反转的数组
	 */
	public static void reverse(short[] array) {
		if (array == null) {
			return;
		}

		short tmp;

		for (int i = 0, j = array.length - 1; j > i; i++, j--) {
			tmp = array[j];
			array[j] = array[i];
			array[i] = tmp;
		}
	}

	/**
	 * 反转数组的元素顺序。如果数组为<code>null</code>，则什么也不做。
	 * 
	 * @param array
	 *            要反转的数组
	 */
	public static void reverse(byte[] array) {
		if (array == null) {
			return;
		}

		byte tmp;

		for (int i = 0, j = array.length - 1; j > i; i++, j--) {
			tmp = array[j];
			array[j] = array[i];
			array[i] = tmp;
		}
	}

	/**
	 * 反转数组的元素顺序。如果数组为<code>null</code>，则什么也不做。
	 * 
	 * @param array
	 *            要反转的数组
	 */
	public static void reverse(double[] array) {
		if (array == null) {
			return;
		}

		double tmp;

		for (int i = 0, j = array.length - 1; j > i; i++, j--) {
			tmp = array[j];
			array[j] = array[i];
			array[i] = tmp;
		}
	}

	/**
	 * 反转数组的元素顺序。如果数组为<code>null</code>，则什么也不做。
	 * 
	 * @param array
	 *            要反转的数组
	 */
	public static void reverse(float[] array) {
		if (array == null) {
			return;
		}

		float tmp;

		for (int i = 0, j = array.length - 1; j > i; i++, j--) {
			tmp = array[j];
			array[j] = array[i];
			array[i] = tmp;
		}
	}

	/**
	 * 反转数组的元素顺序。如果数组为<code>null</code>，则什么也不做。
	 * 
	 * @param array
	 *            要反转的数组
	 */
	public static void reverse(boolean[] array) {
		if (array == null) {
			return;
		}

		boolean tmp;

		for (int i = 0, j = array.length - 1; j > i; i++, j--) {
			tmp = array[j];
			array[j] = array[i];
			array[i] = tmp;
		}
	}

	/**
	 * 反转数组的元素顺序。如果数组为<code>null</code>，则什么也不做。
	 * 
	 * @param array
	 *            要反转的数组
	 */
	public static void reverse(char[] array) {
		if (array == null) {
			return;
		}

		char tmp;

		for (int i = 0, j = array.length - 1; j > i; i++, j--) {
			tmp = array[j];
			array[j] = array[i];
			array[i] = tmp;
		}
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* 在数组中查找一个元素或一个元素序列。 */
	/*                                                                              */
	/* 类型：Object[] */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * 在数组中查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param objectToFind
	 *            要查找的元素
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(Object[] array, Object objectToFind) {
		return indexOf(array, objectToFind, 0);
	}

	/**
	 * 在数组中查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(Object[] array, Object[] arrayToFind) {
		return indexOf(array, arrayToFind, 0);
	}

	/**
	 * 在数组中查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则看作<code>0</code>，超出数组长度的起始索引则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param objectToFind
	 *            要查找的元素
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(Object[] array, Object objectToFind,
			int startIndex) {
		if (array == null) {
			return -1;
		}

		if (startIndex < 0) {
			startIndex = 0;
		}

		if (objectToFind == null) {
			for (int i = startIndex; i < array.length; i++) {
				if (array[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = startIndex; i < array.length; i++) {
				if (objectToFind.equals(array[i])) {
					return i;
				}
			}
		}

		return -1;
	}

	/**
	 * 在数组中查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则看作<code>0</code>，超出数组长度的起始索引则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(Object[] array, Object[] arrayToFind,
			int startIndex) {
		if ((array == null) || (arrayToFind == null)) {
			return -1;
		}

		int sourceLength = array.length;
		int targetLength = arrayToFind.length;

		if (startIndex >= sourceLength) {
			return (targetLength == 0) ? sourceLength : (-1);
		}

		if (startIndex < 0) {
			startIndex = 0;
		}

		if (targetLength == 0) {
			return startIndex;
		}

		Object first = arrayToFind[0];
		int i = startIndex;
		int max = sourceLength - targetLength;

		startSearchForFirst: while (true) {
			// 查找第一个元素
			while ((i <= max) && !ObjectUtil.equals(array[i], first)) {
				i++;
			}

			if (i > max) {
				return -1;
			}

			// 已经找到第一个元素，接着找
			int j = i + 1;
			int end = (j + targetLength) - 1;
			int k = 1;

			while (j < end) {
				if (!ObjectUtil.equals(array[j++], arrayToFind[k++])) {
					i++;

					// 重新查找第一个元素
					continue startSearchForFirst;
				}
			}

			// 找到了
			return i;
		}
	}

	/**
	 * 在数组中从末尾开始查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param objectToFind
	 *            要查找的元素
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(Object[] array, Object objectToFind) {
		return lastIndexOf(array, objectToFind, Integer.MAX_VALUE);
	}

	/**
	 * 在数组中从末尾开始查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(Object[] array, Object[] arrayToFind) {
		return lastIndexOf(array, arrayToFind, Integer.MAX_VALUE);
	}

	/**
	 * 在数组中从末尾开始查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则返回<code>-1</code>，超出数组长度的起始索引则从数组末尾开始找。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param objectToFind
	 *            要查找的元素
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(Object[] array, Object objectToFind,
			int startIndex) {
		if (array == null) {
			return -1;
		}

		if (startIndex < 0) {
			return -1;
		} else if (startIndex >= array.length) {
			startIndex = array.length - 1;
		}

		if (objectToFind == null) {
			for (int i = startIndex; i >= 0; i--) {
				if (array[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = startIndex; i >= 0; i--) {
				if (objectToFind.equals(array[i])) {
					return i;
				}
			}
		}

		return -1;
	}

	/**
	 * 在数组中从末尾开始查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则返回<code>-1</code>，超出数组长度的起始索引则从数组末尾开始找。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(Object[] array, Object[] arrayToFind,
			int startIndex) {
		if ((array == null) || (arrayToFind == null)) {
			return -1;
		}

		int sourceLength = array.length;
		int targetLength = arrayToFind.length;

		int rightIndex = sourceLength - targetLength;

		if (startIndex < 0) {
			return -1;
		}

		if (startIndex > rightIndex) {
			startIndex = rightIndex;
		}

		if (targetLength == 0) {
			return startIndex;
		}

		int lastIndex = targetLength - 1;
		Object last = arrayToFind[lastIndex];
		int min = targetLength - 1;
		int i = min + startIndex;

		startSearchForLast: while (true) {
			while ((i >= min) && !ObjectUtil.equals(array[i], last)) {
				i--;
			}

			if (i < min) {
				return -1;
			}

			int j = i - 1;
			int start = j - (targetLength - 1);
			int k = lastIndex - 1;

			while (j > start) {
				if (!ObjectUtil.equals(array[j--], arrayToFind[k--])) {
					i--;
					continue startSearchForLast;
				}
			}

			return start + 1;
		}
	}

	/**
	 * 判断指定对象是否存在于指定数组中。
	 * 
	 * <p>
	 * 如果数组为<code>null</code>则返回<code>false</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param objectToFind
	 *            要查找的元素
	 * 
	 * @return 如果找到则返回<code>true</code>
	 */
	public static boolean contains(Object[] array, Object objectToFind) {
		return indexOf(array, objectToFind) != -1;
	}

	/**
	 * 判断指定元素序列是否存在于指定数组中。
	 * 
	 * <p>
	 * 如果数组为<code>null</code>则返回<code>false</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * 
	 * @return 如果找到则返回<code>true</code>
	 */
	public static boolean contains(Object[] array, Object[] arrayToFind) {
		return indexOf(array, arrayToFind) != -1;
	}

	public static boolean contains(Object[] array, Object value, int startIndex) {
		return indexOf(array, value, startIndex) != -1;
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* 在数组中查找一个元素或一个元素序列。 */
	/*                                                                              */
	/* 类型：long[] */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * 在数组中查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param longToFind
	 *            要查找的元素
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(long[] array, long longToFind) {
		return indexOf(array, longToFind, 0);
	}

	/**
	 * 在数组中查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(long[] array, long[] arrayToFind) {
		return indexOf(array, arrayToFind, 0);
	}

	/**
	 * 在数组中查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则看作<code>0</code>，超出数组长度的起始索引则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param longToFind
	 *            要查找的元素
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(long[] array, long longToFind, int startIndex) {
		if (array == null) {
			return -1;
		}

		if (startIndex < 0) {
			startIndex = 0;
		}

		for (int i = startIndex; i < array.length; i++) {
			if (longToFind == array[i]) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * 在数组中查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则看作<code>0</code>，超出数组长度的起始索引则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(long[] array, long[] arrayToFind, int startIndex) {
		if ((array == null) || (arrayToFind == null)) {
			return -1;
		}

		int sourceLength = array.length;
		int targetLength = arrayToFind.length;

		if (startIndex >= sourceLength) {
			return (targetLength == 0) ? sourceLength : (-1);
		}

		if (startIndex < 0) {
			startIndex = 0;
		}

		if (targetLength == 0) {
			return startIndex;
		}

		long first = arrayToFind[0];
		int i = startIndex;
		int max = sourceLength - targetLength;

		startSearchForFirst: while (true) {
			// 查找第一个元素
			while ((i <= max) && (array[i] != first)) {
				i++;
			}

			if (i > max) {
				return -1;
			}

			// 已经找到第一个元素，接着找
			int j = i + 1;
			int end = (j + targetLength) - 1;
			int k = 1;

			while (j < end) {
				if (array[j++] != arrayToFind[k++]) {
					i++;

					// 重新查找第一个元素
					continue startSearchForFirst;
				}
			}

			// 找到了
			return i;
		}
	}

	/**
	 * 在数组中从末尾开始查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param longToFind
	 *            要查找的元素
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(long[] array, long longToFind) {
		return lastIndexOf(array, longToFind, Integer.MAX_VALUE);
	}

	/**
	 * 在数组中从末尾开始查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(long[] array, long[] arrayToFind) {
		return lastIndexOf(array, arrayToFind, Integer.MAX_VALUE);
	}

	/**
	 * 在数组中从末尾开始查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则返回<code>-1</code>，超出数组长度的起始索引则从数组末尾开始找。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param longToFind
	 *            要查找的元素
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(long[] array, long longToFind, int startIndex) {
		if (array == null) {
			return -1;
		}

		if (startIndex < 0) {
			return -1;
		} else if (startIndex >= array.length) {
			startIndex = array.length - 1;
		}

		for (int i = startIndex; i >= 0; i--) {
			if (longToFind == array[i]) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * 在数组中从末尾开始查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则返回<code>-1</code>，超出数组长度的起始索引则从数组末尾开始找。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(long[] array, long[] arrayToFind,
			int startIndex) {
		if ((array == null) || (arrayToFind == null)) {
			return -1;
		}

		int sourceLength = array.length;
		int targetLength = arrayToFind.length;

		int rightIndex = sourceLength - targetLength;

		if (startIndex < 0) {
			return -1;
		}

		if (startIndex > rightIndex) {
			startIndex = rightIndex;
		}

		if (targetLength == 0) {
			return startIndex;
		}

		int lastIndex = targetLength - 1;
		long last = arrayToFind[lastIndex];
		int min = targetLength - 1;
		int i = min + startIndex;

		startSearchForLast: while (true) {
			while ((i >= min) && (array[i] != last)) {
				i--;
			}

			if (i < min) {
				return -1;
			}

			int j = i - 1;
			int start = j - (targetLength - 1);
			int k = lastIndex - 1;

			while (j > start) {
				if (array[j--] != arrayToFind[k--]) {
					i--;
					continue startSearchForLast;
				}
			}

			return start + 1;
		}
	}

	/**
	 * 判断指定对象是否存在于指定数组中。
	 * 
	 * <p>
	 * 如果数组为<code>null</code>则返回<code>false</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param longToFind
	 *            要查找的元素
	 * 
	 * @return 如果找到则返回<code>true</code>
	 */
	public static boolean contains(long[] array, long longToFind) {
		return indexOf(array, longToFind) != -1;
	}

	/**
	 * 判断指定元素序列是否存在于指定数组中。
	 * 
	 * <p>
	 * 如果数组为<code>null</code>则返回<code>false</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * 
	 * @return 如果找到则返回<code>true</code>
	 */
	public static boolean contains(long[] array, long[] arrayToFind) {
		return indexOf(array, arrayToFind) != -1;
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* 在数组中查找一个元素或一个元素序列。 */
	/*                                                                              */
	/* 类型：int[] */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * 在数组中查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param intToFind
	 *            要查找的元素
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(int[] array, int intToFind) {
		return indexOf(array, intToFind, 0);
	}

	/**
	 * 在数组中查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(int[] array, int[] arrayToFind) {
		return indexOf(array, arrayToFind, 0);
	}

	/**
	 * 在数组中查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则看作<code>0</code>，超出数组长度的起始索引则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param intToFind
	 *            要查找的元素
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(int[] array, int intToFind, int startIndex) {
		if (array == null) {
			return -1;
		}

		if (startIndex < 0) {
			startIndex = 0;
		}

		for (int i = startIndex; i < array.length; i++) {
			if (intToFind == array[i]) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * 在数组中查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则看作<code>0</code>，超出数组长度的起始索引则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(int[] array, int[] arrayToFind, int startIndex) {
		if ((array == null) || (arrayToFind == null)) {
			return -1;
		}

		int sourceLength = array.length;
		int targetLength = arrayToFind.length;

		if (startIndex >= sourceLength) {
			return (targetLength == 0) ? sourceLength : (-1);
		}

		if (startIndex < 0) {
			startIndex = 0;
		}

		if (targetLength == 0) {
			return startIndex;
		}

		int first = arrayToFind[0];
		int i = startIndex;
		int max = sourceLength - targetLength;

		startSearchForFirst: while (true) {
			// 查找第一个元素
			while ((i <= max) && (array[i] != first)) {
				i++;
			}

			if (i > max) {
				return -1;
			}

			// 已经找到第一个元素，接着找
			int j = i + 1;
			int end = (j + targetLength) - 1;
			int k = 1;

			while (j < end) {
				if (array[j++] != arrayToFind[k++]) {
					i++;

					// 重新查找第一个元素
					continue startSearchForFirst;
				}
			}

			// 找到了
			return i;
		}
	}

	/**
	 * 在数组中从末尾开始查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param intToFind
	 *            要查找的元素
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(int[] array, int intToFind) {
		return lastIndexOf(array, intToFind, Integer.MAX_VALUE);
	}

	/**
	 * 在数组中从末尾开始查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(int[] array, int[] arrayToFind) {
		return lastIndexOf(array, arrayToFind, Integer.MAX_VALUE);
	}

	/**
	 * 在数组中从末尾开始查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则返回<code>-1</code>，超出数组长度的起始索引则从数组末尾开始找。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param intToFind
	 *            要查找的元素
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(int[] array, int intToFind, int startIndex) {
		if (array == null) {
			return -1;
		}

		if (startIndex < 0) {
			return -1;
		} else if (startIndex >= array.length) {
			startIndex = array.length - 1;
		}

		for (int i = startIndex; i >= 0; i--) {
			if (intToFind == array[i]) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * 在数组中从末尾开始查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则返回<code>-1</code>，超出数组长度的起始索引则从数组末尾开始找。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(int[] array, int[] arrayToFind, int startIndex) {
		if ((array == null) || (arrayToFind == null)) {
			return -1;
		}

		int sourceLength = array.length;
		int targetLength = arrayToFind.length;

		int rightIndex = sourceLength - targetLength;

		if (startIndex < 0) {
			return -1;
		}

		if (startIndex > rightIndex) {
			startIndex = rightIndex;
		}

		if (targetLength == 0) {
			return startIndex;
		}

		int lastIndex = targetLength - 1;
		int last = arrayToFind[lastIndex];
		int min = targetLength - 1;
		int i = min + startIndex;

		startSearchForLast: while (true) {
			while ((i >= min) && (array[i] != last)) {
				i--;
			}

			if (i < min) {
				return -1;
			}

			int j = i - 1;
			int start = j - (targetLength - 1);
			int k = lastIndex - 1;

			while (j > start) {
				if (array[j--] != arrayToFind[k--]) {
					i--;
					continue startSearchForLast;
				}
			}

			return start + 1;
		}
	}

	/**
	 * 判断指定对象是否存在于指定数组中。
	 * 
	 * <p>
	 * 如果数组为<code>null</code>则返回<code>false</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param intToFind
	 *            要查找的元素
	 * 
	 * @return 如果找到则返回<code>true</code>
	 */
	public static boolean contains(int[] array, int intToFind) {
		return indexOf(array, intToFind) != -1;
	}

	/**
	 * 判断指定元素序列是否存在于指定数组中。
	 * 
	 * <p>
	 * 如果数组为<code>null</code>则返回<code>false</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * 
	 * @return 如果找到则返回<code>true</code>
	 */
	public static boolean contains(int[] array, int[] arrayToFind) {
		return indexOf(array, arrayToFind) != -1;
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* 在数组中查找一个元素或一个元素序列。 */
	/*                                                                              */
	/* 类型：short[] */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * 在数组中查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param shortToFind
	 *            要查找的元素
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(short[] array, short shortToFind) {
		return indexOf(array, shortToFind, 0);
	}

	/**
	 * 在数组中查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(short[] array, short[] arrayToFind) {
		return indexOf(array, arrayToFind, 0);
	}

	/**
	 * 在数组中查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则看作<code>0</code>，超出数组长度的起始索引则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param shortToFind
	 *            要查找的元素
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(short[] array, short shortToFind, int startIndex) {
		if (array == null) {
			return -1;
		}

		if (startIndex < 0) {
			startIndex = 0;
		}

		for (int i = startIndex; i < array.length; i++) {
			if (shortToFind == array[i]) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * 在数组中查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则看作<code>0</code>，超出数组长度的起始索引则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(short[] array, short[] arrayToFind, int startIndex) {
		if ((array == null) || (arrayToFind == null)) {
			return -1;
		}

		int sourceLength = array.length;
		int targetLength = arrayToFind.length;

		if (startIndex >= sourceLength) {
			return (targetLength == 0) ? sourceLength : (-1);
		}

		if (startIndex < 0) {
			startIndex = 0;
		}

		if (targetLength == 0) {
			return startIndex;
		}

		short first = arrayToFind[0];
		int i = startIndex;
		int max = sourceLength - targetLength;

		startSearchForFirst: while (true) {
			// 查找第一个元素
			while ((i <= max) && (array[i] != first)) {
				i++;
			}

			if (i > max) {
				return -1;
			}

			// 已经找到第一个元素，接着找
			int j = i + 1;
			int end = (j + targetLength) - 1;
			int k = 1;

			while (j < end) {
				if (array[j++] != arrayToFind[k++]) {
					i++;

					// 重新查找第一个元素
					continue startSearchForFirst;
				}
			}

			// 找到了
			return i;
		}
	}

	/**
	 * 在数组中从末尾开始查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param shortToFind
	 *            要查找的元素
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(short[] array, short shortToFind) {
		return lastIndexOf(array, shortToFind, Integer.MAX_VALUE);
	}

	/**
	 * 在数组中从末尾开始查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(short[] array, short[] arrayToFind) {
		return lastIndexOf(array, arrayToFind, Integer.MAX_VALUE);
	}

	/**
	 * 在数组中从末尾开始查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则返回<code>-1</code>，超出数组长度的起始索引则从数组末尾开始找。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param shortToFind
	 *            要查找的元素
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(short[] array, short shortToFind,
			int startIndex) {
		if (array == null) {
			return -1;
		}

		if (startIndex < 0) {
			return -1;
		} else if (startIndex >= array.length) {
			startIndex = array.length - 1;
		}

		for (int i = startIndex; i >= 0; i--) {
			if (shortToFind == array[i]) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * 在数组中从末尾开始查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则返回<code>-1</code>，超出数组长度的起始索引则从数组末尾开始找。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(short[] array, short[] arrayToFind,
			int startIndex) {
		if ((array == null) || (arrayToFind == null)) {
			return -1;
		}

		int sourceLength = array.length;
		int targetLength = arrayToFind.length;

		int rightIndex = sourceLength - targetLength;

		if (startIndex < 0) {
			return -1;
		}

		if (startIndex > rightIndex) {
			startIndex = rightIndex;
		}

		if (targetLength == 0) {
			return startIndex;
		}

		int lastIndex = targetLength - 1;
		short last = arrayToFind[lastIndex];
		int min = targetLength - 1;
		int i = min + startIndex;

		startSearchForLast: while (true) {
			while ((i >= min) && (array[i] != last)) {
				i--;
			}

			if (i < min) {
				return -1;
			}

			int j = i - 1;
			int start = j - (targetLength - 1);
			int k = lastIndex - 1;

			while (j > start) {
				if (array[j--] != arrayToFind[k--]) {
					i--;
					continue startSearchForLast;
				}
			}

			return start + 1;
		}
	}

	/**
	 * 判断指定对象是否存在于指定数组中。
	 * 
	 * <p>
	 * 如果数组为<code>null</code>则返回<code>false</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param shortToFind
	 *            要查找的元素
	 * 
	 * @return 如果找到则返回<code>true</code>
	 */
	public static boolean contains(short[] array, short shortToFind) {
		return indexOf(array, shortToFind) != -1;
	}

	/**
	 * 判断指定元素序列是否存在于指定数组中。
	 * 
	 * <p>
	 * 如果数组为<code>null</code>则返回<code>false</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * 
	 * @return 如果找到则返回<code>true</code>
	 */
	public static boolean contains(short[] array, short[] arrayToFind) {
		return indexOf(array, arrayToFind) != -1;
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* 在数组中查找一个元素或一个元素序列。 */
	/*                                                                              */
	/* 类型：byte[] */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * 在数组中查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param byteToFind
	 *            要查找的元素
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(byte[] array, byte byteToFind) {
		return indexOf(array, byteToFind, 0);
	}

	/**
	 * 在数组中查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(byte[] array, byte[] arrayToFind) {
		return indexOf(array, arrayToFind, 0);
	}

	/**
	 * 在数组中查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则看作<code>0</code>，超出数组长度的起始索引则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param byteToFind
	 *            要查找的元素
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(byte[] array, byte byteToFind, int startIndex) {
		if (array == null) {
			return -1;
		}

		if (startIndex < 0) {
			startIndex = 0;
		}

		for (int i = startIndex; i < array.length; i++) {
			if (byteToFind == array[i]) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * 在数组中查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则看作<code>0</code>，超出数组长度的起始索引则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(byte[] array, byte[] arrayToFind, int startIndex) {
		if ((array == null) || (arrayToFind == null)) {
			return -1;
		}

		int sourceLength = array.length;
		int targetLength = arrayToFind.length;

		if (startIndex >= sourceLength) {
			return (targetLength == 0) ? sourceLength : (-1);
		}

		if (startIndex < 0) {
			startIndex = 0;
		}

		if (targetLength == 0) {
			return startIndex;
		}

		byte first = arrayToFind[0];
		int i = startIndex;
		int max = sourceLength - targetLength;

		startSearchForFirst: while (true) {
			// 查找第一个元素
			while ((i <= max) && (array[i] != first)) {
				i++;
			}

			if (i > max) {
				return -1;
			}

			// 已经找到第一个元素，接着找
			int j = i + 1;
			int end = (j + targetLength) - 1;
			int k = 1;

			while (j < end) {
				if (array[j++] != arrayToFind[k++]) {
					i++;

					// 重新查找第一个元素
					continue startSearchForFirst;
				}
			}

			// 找到了
			return i;
		}
	}

	/**
	 * 在数组中从末尾开始查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param byteToFind
	 *            要查找的元素
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(byte[] array, byte byteToFind) {
		return lastIndexOf(array, byteToFind, Integer.MAX_VALUE);
	}

	/**
	 * 在数组中从末尾开始查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(byte[] array, byte[] arrayToFind) {
		return lastIndexOf(array, arrayToFind, Integer.MAX_VALUE);
	}

	/**
	 * 在数组中从末尾开始查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则返回<code>-1</code>，超出数组长度的起始索引则从数组末尾开始找。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param byteToFind
	 *            要查找的元素
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(byte[] array, byte byteToFind, int startIndex) {
		if (array == null) {
			return -1;
		}

		if (startIndex < 0) {
			return -1;
		} else if (startIndex >= array.length) {
			startIndex = array.length - 1;
		}

		for (int i = startIndex; i >= 0; i--) {
			if (byteToFind == array[i]) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * 在数组中从末尾开始查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则返回<code>-1</code>，超出数组长度的起始索引则从数组末尾开始找。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(byte[] array, byte[] arrayToFind,
			int startIndex) {
		if ((array == null) || (arrayToFind == null)) {
			return -1;
		}

		int sourceLength = array.length;
		int targetLength = arrayToFind.length;

		int rightIndex = sourceLength - targetLength;

		if (startIndex < 0) {
			return -1;
		}

		if (startIndex > rightIndex) {
			startIndex = rightIndex;
		}

		if (targetLength == 0) {
			return startIndex;
		}

		int lastIndex = targetLength - 1;
		byte last = arrayToFind[lastIndex];
		int min = targetLength - 1;
		int i = min + startIndex;

		startSearchForLast: while (true) {
			while ((i >= min) && (array[i] != last)) {
				i--;
			}

			if (i < min) {
				return -1;
			}

			int j = i - 1;
			int start = j - (targetLength - 1);
			int k = lastIndex - 1;

			while (j > start) {
				if (array[j--] != arrayToFind[k--]) {
					i--;
					continue startSearchForLast;
				}
			}

			return start + 1;
		}
	}

	/**
	 * 判断指定对象是否存在于指定数组中。
	 * 
	 * <p>
	 * 如果数组为<code>null</code>则返回<code>false</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param byteToFind
	 *            要查找的元素
	 * 
	 * @return 如果找到则返回<code>true</code>
	 */
	public static boolean contains(byte[] array, byte byteToFind) {
		return indexOf(array, byteToFind) != -1;
	}

	/**
	 * 判断指定元素序列是否存在于指定数组中。
	 * 
	 * <p>
	 * 如果数组为<code>null</code>则返回<code>false</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * 
	 * @return 如果找到则返回<code>true</code>
	 */
	public static boolean contains(byte[] array, byte[] arrayToFind) {
		return indexOf(array, arrayToFind) != -1;
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* 在数组中查找一个元素或一个元素序列。 */
	/*                                                                              */
	/* 类型：double[] */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * 在数组中查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param doubleToFind
	 *            要查找的元素
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(double[] array, double doubleToFind) {
		return indexOf(array, doubleToFind, 0, 0);
	}

	/**
	 * 在数组中查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param doubleToFind
	 *            要查找的元素
	 * @param tolerance
	 *            误差
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(double[] array, double doubleToFind,
			double tolerance) {
		return indexOf(array, doubleToFind, 0, tolerance);
	}

	/**
	 * 在数组中查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(double[] array, double[] arrayToFind) {
		return indexOf(array, arrayToFind, 0, 0);
	}

	/**
	 * 在数组中查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * @param tolerance
	 *            误差
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(double[] array, double[] arrayToFind,
			double tolerance) {
		return indexOf(array, arrayToFind, 0, tolerance);
	}

	/**
	 * 在数组中查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则看作<code>0</code>，超出数组长度的起始索引则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param doubleToFind
	 *            要查找的元素
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(double[] array, double doubleToFind,
			int startIndex) {
		return indexOf(array, doubleToFind, startIndex, 0);
	}

	/**
	 * 在数组中查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则看作<code>0</code>，超出数组长度的起始索引则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param doubleToFind
	 *            要查找的元素
	 * @param startIndex
	 *            起始索引
	 * @param tolerance
	 *            误差
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(double[] array, double doubleToFind,
			int startIndex, double tolerance) {
		if (array == null) {
			return -1;
		}

		if (startIndex < 0) {
			startIndex = 0;
		}

		double min = doubleToFind - tolerance;
		double max = doubleToFind + tolerance;

		for (int i = startIndex; i < array.length; i++) {
			if ((array[i] >= min) && (array[i] <= max)) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * 在数组中查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则看作<code>0</code>，超出数组长度的起始索引则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(double[] array, double[] arrayToFind,
			int startIndex) {
		return indexOf(array, arrayToFind, startIndex, 0);
	}

	/**
	 * 在数组中查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则看作<code>0</code>，超出数组长度的起始索引则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * @param startIndex
	 *            起始索引
	 * @param tolerance
	 *            误差
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(double[] array, double[] arrayToFind,
			int startIndex, double tolerance) {
		if ((array == null) || (arrayToFind == null)) {
			return -1;
		}

		int sourceLength = array.length;
		int targetLength = arrayToFind.length;

		if (startIndex >= sourceLength) {
			return (targetLength == 0) ? sourceLength : (-1);
		}

		if (startIndex < 0) {
			startIndex = 0;
		}

		if (targetLength == 0) {
			return startIndex;
		}

		double firstMin = arrayToFind[0] - tolerance;
		double firstMax = arrayToFind[0] + tolerance;
		int i = startIndex;
		int max = sourceLength - targetLength;

		startSearchForFirst: while (true) {
			// 查找第一个元素
			while ((i <= max)
					&& ((array[i] < firstMin) || (array[i] > firstMax))) {
				i++;
			}

			if (i > max) {
				return -1;
			}

			// 已经找到第一个元素，接着找
			int j = i + 1;
			int end = (j + targetLength) - 1;
			int k = 1;

			while (j < end) {
				if (Math.abs(array[j++] - arrayToFind[k++]) > tolerance) {
					i++;

					// 重新查找第一个元素
					continue startSearchForFirst;
				}
			}

			// 找到了
			return i;
		}
	}

	/**
	 * 在数组中从末尾开始查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param doubleToFind
	 *            要查找的元素
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(double[] array, double doubleToFind) {
		return lastIndexOf(array, doubleToFind, Integer.MAX_VALUE, 0);
	}

	/**
	 * 在数组中从末尾开始查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param doubleToFind
	 *            要查找的元素
	 * @param tolerance
	 *            误差
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(double[] array, double doubleToFind,
			double tolerance) {
		return lastIndexOf(array, doubleToFind, Integer.MAX_VALUE, tolerance);
	}

	/**
	 * 在数组中从末尾开始查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(double[] array, double[] arrayToFind) {
		return lastIndexOf(array, arrayToFind, Integer.MAX_VALUE, 0);
	}

	/**
	 * 在数组中从末尾开始查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * @param tolerance
	 *            误差
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(double[] array, double[] arrayToFind,
			double tolerance) {
		return lastIndexOf(array, arrayToFind, Integer.MAX_VALUE, tolerance);
	}

	/**
	 * 在数组中从末尾开始查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则返回<code>-1</code>，超出数组长度的起始索引则从数组末尾开始找。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param doubleToFind
	 *            要查找的元素
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(double[] array, double doubleToFind,
			int startIndex) {
		return lastIndexOf(array, doubleToFind, startIndex, 0);
	}

	/**
	 * 在数组中从末尾开始查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则返回<code>-1</code>，超出数组长度的起始索引则从数组末尾开始找。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param doubleToFind
	 *            要查找的元素
	 * @param startIndex
	 *            起始索引
	 * @param tolerance
	 *            误差
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(double[] array, double doubleToFind,
			int startIndex, double tolerance) {
		if (array == null) {
			return -1;
		}

		if (startIndex < 0) {
			return -1;
		} else if (startIndex >= array.length) {
			startIndex = array.length - 1;
		}

		double min = doubleToFind - tolerance;
		double max = doubleToFind + tolerance;

		for (int i = startIndex; i >= 0; i--) {
			if ((array[i] >= min) && (array[i] <= max)) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * 在数组中从末尾开始查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则返回<code>-1</code>，超出数组长度的起始索引则从数组末尾开始找。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(double[] array, double[] arrayToFind,
			int startIndex) {
		return lastIndexOf(array, arrayToFind, startIndex, 0);
	}

	/**
	 * 在数组中从末尾开始查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则返回<code>-1</code>，超出数组长度的起始索引则从数组末尾开始找。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * @param startIndex
	 *            起始索引
	 * @param tolerance
	 *            误差
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(double[] array, double[] arrayToFind,
			int startIndex, double tolerance) {
		if ((array == null) || (arrayToFind == null)) {
			return -1;
		}

		int sourceLength = array.length;
		int targetLength = arrayToFind.length;

		int rightIndex = sourceLength - targetLength;

		if (startIndex < 0) {
			return -1;
		}

		if (startIndex > rightIndex) {
			startIndex = rightIndex;
		}

		if (targetLength == 0) {
			return startIndex;
		}

		int lastIndex = targetLength - 1;
		double lastMin = arrayToFind[lastIndex] - tolerance;
		double lastMax = arrayToFind[lastIndex] + tolerance;
		int min = targetLength - 1;
		int i = min + startIndex;

		startSearchForLast: while (true) {
			while ((i >= min) && ((array[i] < lastMin) || (array[i] > lastMax))) {
				i--;
			}

			if (i < min) {
				return -1;
			}

			int j = i - 1;
			int start = j - (targetLength - 1);
			int k = lastIndex - 1;

			while (j > start) {
				if (Math.abs(array[j--] - arrayToFind[k--]) > tolerance) {
					i--;
					continue startSearchForLast;
				}
			}

			return start + 1;
		}
	}

	/**
	 * 判断指定对象是否存在于指定数组中。
	 * 
	 * <p>
	 * 如果数组为<code>null</code>则返回<code>false</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param doubleToFind
	 *            要查找的元素
	 * 
	 * @return 如果找到则返回<code>true</code>
	 */
	public static boolean contains(double[] array, double doubleToFind) {
		return indexOf(array, doubleToFind) != -1;
	}

	/**
	 * 判断指定对象是否存在于指定数组中。
	 * 
	 * <p>
	 * 如果数组为<code>null</code>则返回<code>false</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param doubleToFind
	 *            要查找的元素
	 * @param tolerance
	 *            误差
	 * 
	 * @return 如果找到则返回<code>true</code>
	 */
	public static boolean contains(double[] array, double doubleToFind,
			double tolerance) {
		return indexOf(array, doubleToFind, tolerance) != -1;
	}

	/**
	 * 判断指定元素序列是否存在于指定数组中。
	 * 
	 * <p>
	 * 如果数组为<code>null</code>则返回<code>false</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * 
	 * @return 如果找到则返回<code>true</code>
	 */
	public static boolean contains(double[] array, double[] arrayToFind) {
		return indexOf(array, arrayToFind) != -1;
	}

	/**
	 * 判断指定元素序列是否存在于指定数组中。
	 * 
	 * <p>
	 * 如果数组为<code>null</code>则返回<code>false</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * @param tolerance
	 *            误差
	 * 
	 * @return 如果找到则返回<code>true</code>
	 */
	public static boolean contains(double[] array, double[] arrayToFind,
			double tolerance) {
		return indexOf(array, arrayToFind, tolerance) != -1;
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* 在数组中查找一个元素或一个元素序列。 */
	/*                                                                              */
	/* 类型：float[] */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * 在数组中查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param floatToFind
	 *            要查找的元素
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(float[] array, float floatToFind) {
		return indexOf(array, floatToFind, 0, 0);
	}

	/**
	 * 在数组中查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param floatToFind
	 *            要查找的元素
	 * @param tolerance
	 *            误差
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(float[] array, float floatToFind, float tolerance) {
		return indexOf(array, floatToFind, 0, tolerance);
	}

	/**
	 * 在数组中查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(float[] array, float[] arrayToFind) {
		return indexOf(array, arrayToFind, 0, 0);
	}

	/**
	 * 在数组中查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * @param tolerance
	 *            误差
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(float[] array, float[] arrayToFind,
			float tolerance) {
		return indexOf(array, arrayToFind, 0, tolerance);
	}

	/**
	 * 在数组中查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则看作<code>0</code>，超出数组长度的起始索引则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param floatToFind
	 *            要查找的元素
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(float[] array, float floatToFind, int startIndex) {
		return indexOf(array, floatToFind, startIndex, 0);
	}

	/**
	 * 在数组中查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则看作<code>0</code>，超出数组长度的起始索引则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param floatToFind
	 *            要查找的元素
	 * @param startIndex
	 *            起始索引
	 * @param tolerance
	 *            误差
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(float[] array, float floatToFind, int startIndex,
			float tolerance) {
		if (array == null) {
			return -1;
		}

		if (startIndex < 0) {
			startIndex = 0;
		}

		float min = floatToFind - tolerance;
		float max = floatToFind + tolerance;

		for (int i = startIndex; i < array.length; i++) {
			if ((array[i] >= min) && (array[i] <= max)) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * 在数组中查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则看作<code>0</code>，超出数组长度的起始索引则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(float[] array, float[] arrayToFind, int startIndex) {
		return indexOf(array, arrayToFind, startIndex, 0);
	}

	/**
	 * 在数组中查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则看作<code>0</code>，超出数组长度的起始索引则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * @param startIndex
	 *            起始索引
	 * @param tolerance
	 *            误差
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(float[] array, float[] arrayToFind,
			int startIndex, float tolerance) {
		if ((array == null) || (arrayToFind == null)) {
			return -1;
		}

		int sourceLength = array.length;
		int targetLength = arrayToFind.length;

		if (startIndex >= sourceLength) {
			return (targetLength == 0) ? sourceLength : (-1);
		}

		if (startIndex < 0) {
			startIndex = 0;
		}

		if (targetLength == 0) {
			return startIndex;
		}

		float firstMin = arrayToFind[0] - tolerance;
		float firstMax = arrayToFind[0] + tolerance;
		int i = startIndex;
		int max = sourceLength - targetLength;

		startSearchForFirst: while (true) {
			// 查找第一个元素
			while ((i <= max)
					&& ((array[i] < firstMin) || (array[i] > firstMax))) {
				i++;
			}

			if (i > max) {
				return -1;
			}

			// 已经找到第一个元素，接着找
			int j = i + 1;
			int end = (j + targetLength) - 1;
			int k = 1;

			while (j < end) {
				if (Math.abs(array[j++] - arrayToFind[k++]) > tolerance) {
					i++;

					// 重新查找第一个元素
					continue startSearchForFirst;
				}
			}

			// 找到了
			return i;
		}
	}

	/**
	 * 在数组中从末尾开始查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param floatToFind
	 *            要查找的元素
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(float[] array, float floatToFind) {
		return lastIndexOf(array, floatToFind, Integer.MAX_VALUE, 0);
	}

	/**
	 * 在数组中从末尾开始查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param floatToFind
	 *            要查找的元素
	 * @param tolerance
	 *            误差
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(float[] array, float floatToFind,
			float tolerance) {
		return lastIndexOf(array, floatToFind, Integer.MAX_VALUE, tolerance);
	}

	/**
	 * 在数组中从末尾开始查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(float[] array, float[] arrayToFind) {
		return lastIndexOf(array, arrayToFind, Integer.MAX_VALUE, 0);
	}

	/**
	 * 在数组中从末尾开始查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * @param tolerance
	 *            误差
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(float[] array, float[] arrayToFind,
			float tolerance) {
		return lastIndexOf(array, arrayToFind, Integer.MAX_VALUE, tolerance);
	}

	/**
	 * 在数组中从末尾开始查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则返回<code>-1</code>，超出数组长度的起始索引则从数组末尾开始找。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param floatToFind
	 *            要查找的元素
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(float[] array, float floatToFind,
			int startIndex) {
		return lastIndexOf(array, floatToFind, startIndex, 0);
	}

	/**
	 * 在数组中从末尾开始查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则返回<code>-1</code>，超出数组长度的起始索引则从数组末尾开始找。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param floatToFind
	 *            要查找的元素
	 * @param startIndex
	 *            起始索引
	 * @param tolerance
	 *            误差
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(float[] array, float floatToFind,
			int startIndex, float tolerance) {
		if (array == null) {
			return -1;
		}

		if (startIndex < 0) {
			return -1;
		} else if (startIndex >= array.length) {
			startIndex = array.length - 1;
		}

		float min = floatToFind - tolerance;
		float max = floatToFind + tolerance;

		for (int i = startIndex; i >= 0; i--) {
			if ((array[i] >= min) && (array[i] <= max)) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * 在数组中从末尾开始查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则返回<code>-1</code>，超出数组长度的起始索引则从数组末尾开始找。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(float[] array, float[] arrayToFind,
			int startIndex) {
		return lastIndexOf(array, arrayToFind, startIndex, 0);
	}

	/**
	 * 在数组中从末尾开始查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则返回<code>-1</code>，超出数组长度的起始索引则从数组末尾开始找。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * @param startIndex
	 *            起始索引
	 * @param tolerance
	 *            误差
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(float[] array, float[] arrayToFind,
			int startIndex, float tolerance) {
		if ((array == null) || (arrayToFind == null)) {
			return -1;
		}

		int sourceLength = array.length;
		int targetLength = arrayToFind.length;

		int rightIndex = sourceLength - targetLength;

		if (startIndex < 0) {
			return -1;
		}

		if (startIndex > rightIndex) {
			startIndex = rightIndex;
		}

		if (targetLength == 0) {
			return startIndex;
		}

		int lastIndex = targetLength - 1;
		float lastMin = arrayToFind[lastIndex] - tolerance;
		float lastMax = arrayToFind[lastIndex] + tolerance;
		int min = targetLength - 1;
		int i = min + startIndex;

		startSearchForLast: while (true) {
			while ((i >= min) && ((array[i] < lastMin) || (array[i] > lastMax))) {
				i--;
			}

			if (i < min) {
				return -1;
			}

			int j = i - 1;
			int start = j - (targetLength - 1);
			int k = lastIndex - 1;

			while (j > start) {
				if (Math.abs(array[j--] - arrayToFind[k--]) > tolerance) {
					i--;
					continue startSearchForLast;
				}
			}

			return start + 1;
		}
	}

	/**
	 * 判断指定对象是否存在于指定数组中。
	 * 
	 * <p>
	 * 如果数组为<code>null</code>则返回<code>false</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param floatToFind
	 *            要查找的元素
	 * 
	 * @return 如果找到则返回<code>true</code>
	 */
	public static boolean contains(float[] array, float floatToFind) {
		return indexOf(array, floatToFind) != -1;
	}

	/**
	 * 判断指定对象是否存在于指定数组中。
	 * 
	 * <p>
	 * 如果数组为<code>null</code>则返回<code>false</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param floatToFind
	 *            要查找的元素
	 * @param tolerance
	 *            误差
	 * 
	 * @return 如果找到则返回<code>true</code>
	 */
	public static boolean contains(float[] array, float floatToFind,
			float tolerance) {
		return indexOf(array, floatToFind, tolerance) != -1;
	}

	/**
	 * 判断指定元素序列是否存在于指定数组中。
	 * 
	 * <p>
	 * 如果数组为<code>null</code>则返回<code>false</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * 
	 * @return 如果找到则返回<code>true</code>
	 */
	public static boolean contains(float[] array, float[] arrayToFind) {
		return indexOf(array, arrayToFind) != -1;
	}

	/**
	 * 判断指定元素序列是否存在于指定数组中。
	 * 
	 * <p>
	 * 如果数组为<code>null</code>则返回<code>false</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * @param tolerance
	 *            误差
	 * 
	 * @return 如果找到则返回<code>true</code>
	 */
	public static boolean contains(float[] array, float[] arrayToFind,
			float tolerance) {
		return indexOf(array, arrayToFind, tolerance) != -1;
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* 在数组中查找一个元素或一个元素序列。 */
	/*                                                                              */
	/* 类型：boolean[] */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * 在数组中查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param booleanToFind
	 *            要查找的元素
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(boolean[] array, boolean booleanToFind) {
		return indexOf(array, booleanToFind, 0);
	}

	/**
	 * 在数组中查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(boolean[] array, boolean[] arrayToFind) {
		return indexOf(array, arrayToFind, 0);
	}

	/**
	 * 在数组中查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则看作<code>0</code>，超出数组长度的起始索引则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param booleanToFind
	 *            要查找的元素
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(boolean[] array, boolean booleanToFind,
			int startIndex) {
		if (array == null) {
			return -1;
		}

		if (startIndex < 0) {
			startIndex = 0;
		}

		for (int i = startIndex; i < array.length; i++) {
			if (booleanToFind == array[i]) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * 在数组中查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则看作<code>0</code>，超出数组长度的起始索引则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(boolean[] array, boolean[] arrayToFind,
			int startIndex) {
		if ((array == null) || (arrayToFind == null)) {
			return -1;
		}

		int sourceLength = array.length;
		int targetLength = arrayToFind.length;

		if (startIndex >= sourceLength) {
			return (targetLength == 0) ? sourceLength : (-1);
		}

		if (startIndex < 0) {
			startIndex = 0;
		}

		if (targetLength == 0) {
			return startIndex;
		}

		boolean first = arrayToFind[0];
		int i = startIndex;
		int max = sourceLength - targetLength;

		startSearchForFirst: while (true) {
			// 查找第一个元素
			while ((i <= max) && (array[i] != first)) {
				i++;
			}

			if (i > max) {
				return -1;
			}

			// 已经找到第一个元素，接着找
			int j = i + 1;
			int end = (j + targetLength) - 1;
			int k = 1;

			while (j < end) {
				if (array[j++] != arrayToFind[k++]) {
					i++;

					// 重新查找第一个元素
					continue startSearchForFirst;
				}
			}

			// 找到了
			return i;
		}
	}

	/**
	 * 在数组中从末尾开始查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param booleanToFind
	 *            要查找的元素
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(boolean[] array, boolean booleanToFind) {
		return lastIndexOf(array, booleanToFind, Integer.MAX_VALUE);
	}

	/**
	 * 在数组中从末尾开始查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(boolean[] array, boolean[] arrayToFind) {
		return lastIndexOf(array, arrayToFind, Integer.MAX_VALUE);
	}

	/**
	 * 在数组中从末尾开始查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则返回<code>-1</code>，超出数组长度的起始索引则从数组末尾开始找。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param booleanToFind
	 *            要查找的元素
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(boolean[] array, boolean booleanToFind,
			int startIndex) {
		if (array == null) {
			return -1;
		}

		if (startIndex < 0) {
			return -1;
		} else if (startIndex >= array.length) {
			startIndex = array.length - 1;
		}

		for (int i = startIndex; i >= 0; i--) {
			if (booleanToFind == array[i]) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * 在数组中从末尾开始查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则返回<code>-1</code>，超出数组长度的起始索引则从数组末尾开始找。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(boolean[] array, boolean[] arrayToFind,
			int startIndex) {
		if ((array == null) || (arrayToFind == null)) {
			return -1;
		}

		int sourceLength = array.length;
		int targetLength = arrayToFind.length;

		int rightIndex = sourceLength - targetLength;

		if (startIndex < 0) {
			return -1;
		}

		if (startIndex > rightIndex) {
			startIndex = rightIndex;
		}

		if (targetLength == 0) {
			return startIndex;
		}

		int lastIndex = targetLength - 1;
		boolean last = arrayToFind[lastIndex];
		int min = targetLength - 1;
		int i = min + startIndex;

		startSearchForLast: while (true) {
			while ((i >= min) && (array[i] != last)) {
				i--;
			}

			if (i < min) {
				return -1;
			}

			int j = i - 1;
			int start = j - (targetLength - 1);
			int k = lastIndex - 1;

			while (j > start) {
				if (array[j--] != arrayToFind[k--]) {
					i--;
					continue startSearchForLast;
				}
			}

			return start + 1;
		}
	}

	/**
	 * 判断指定对象是否存在于指定数组中。
	 * 
	 * <p>
	 * 如果数组为<code>null</code>则返回<code>false</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param booleanToFind
	 *            要查找的元素
	 * 
	 * @return 如果找到则返回<code>true</code>
	 */
	public static boolean contains(boolean[] array, boolean booleanToFind) {
		return indexOf(array, booleanToFind) != -1;
	}

	/**
	 * 判断指定元素序列是否存在于指定数组中。
	 * 
	 * <p>
	 * 如果数组为<code>null</code>则返回<code>false</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * 
	 * @return 如果找到则返回<code>true</code>
	 */
	public static boolean contains(boolean[] array, boolean[] arrayToFind) {
		return indexOf(array, arrayToFind) != -1;
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* 在数组中查找一个元素或一个元素序列。 */
	/*                                                                              */
	/* 类型：char[] */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * 在数组中查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param charToFind
	 *            要查找的元素
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(char[] array, char charToFind) {
		return indexOf(array, charToFind, 0);
	}

	/**
	 * 在数组中查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(char[] array, char[] arrayToFind) {
		return indexOf(array, arrayToFind, 0);
	}

	/**
	 * 在数组中查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则看作<code>0</code>，超出数组长度的起始索引则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param charToFind
	 *            要查找的元素
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(char[] array, char charToFind, int startIndex) {
		if (array == null) {
			return -1;
		}

		if (startIndex < 0) {
			startIndex = 0;
		}

		for (int i = startIndex; i < array.length; i++) {
			if (charToFind == array[i]) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * 在数组中查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则看作<code>0</code>，超出数组长度的起始索引则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int indexOf(char[] array, char[] arrayToFind, int startIndex) {
		if ((array == null) || (arrayToFind == null)) {
			return -1;
		}

		int sourceLength = array.length;
		int targetLength = arrayToFind.length;

		if (startIndex >= sourceLength) {
			return (targetLength == 0) ? sourceLength : (-1);
		}

		if (startIndex < 0) {
			startIndex = 0;
		}

		if (targetLength == 0) {
			return startIndex;
		}

		char first = arrayToFind[0];
		int i = startIndex;
		int max = sourceLength - targetLength;

		startSearchForFirst: while (true) {
			// 查找第一个元素
			while ((i <= max) && (array[i] != first)) {
				i++;
			}

			if (i > max) {
				return -1;
			}

			// 已经找到第一个元素，接着找
			int j = i + 1;
			int end = (j + targetLength) - 1;
			int k = 1;

			while (j < end) {
				if (array[j++] != arrayToFind[k++]) {
					i++;

					// 重新查找第一个元素
					continue startSearchForFirst;
				}
			}

			// 找到了
			return i;
		}
	}

	/**
	 * 在数组中从末尾开始查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param charToFind
	 *            要查找的元素
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(char[] array, char charToFind) {
		return lastIndexOf(array, charToFind, Integer.MAX_VALUE);
	}

	/**
	 * 在数组中从末尾开始查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(char[] array, char[] arrayToFind) {
		return lastIndexOf(array, arrayToFind, Integer.MAX_VALUE);
	}

	/**
	 * 在数组中从末尾开始查找一个元素。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则返回<code>-1</code>，超出数组长度的起始索引则从数组末尾开始找。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param charToFind
	 *            要查找的元素
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(char[] array, char charToFind, int startIndex) {
		if (array == null) {
			return -1;
		}

		if (startIndex < 0) {
			return -1;
		} else if (startIndex >= array.length) {
			startIndex = array.length - 1;
		}

		for (int i = startIndex; i >= 0; i--) {
			if (charToFind == array[i]) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * 在数组中从末尾开始查找一个元素序列。
	 * 
	 * <p>
	 * 如果未找到或数组为<code>null</code>则返回<code>-1</code>。
	 * </p>
	 * 
	 * <p>
	 * 起始索引小于<code>0</code>则返回<code>-1</code>，超出数组长度的起始索引则从数组末尾开始找。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * @param startIndex
	 *            起始索引
	 * 
	 * @return 该元素序列在数组中的序号，如果数组为<code>null</code>或未找到，则返回<code>-1</code>。
	 */
	public static int lastIndexOf(char[] array, char[] arrayToFind,
			int startIndex) {
		if ((array == null) || (arrayToFind == null)) {
			return -1;
		}

		int sourceLength = array.length;
		int targetLength = arrayToFind.length;

		int rightIndex = sourceLength - targetLength;

		if (startIndex < 0) {
			return -1;
		}

		if (startIndex > rightIndex) {
			startIndex = rightIndex;
		}

		if (targetLength == 0) {
			return startIndex;
		}

		int lastIndex = targetLength - 1;
		char last = arrayToFind[lastIndex];
		int min = targetLength - 1;
		int i = min + startIndex;

		startSearchForLast: while (true) {
			while ((i >= min) && (array[i] != last)) {
				i--;
			}

			if (i < min) {
				return -1;
			}

			int j = i - 1;
			int start = j - (targetLength - 1);
			int k = lastIndex - 1;

			while (j > start) {
				if (array[j--] != arrayToFind[k--]) {
					i--;
					continue startSearchForLast;
				}
			}

			return start + 1;
		}
	}

	/**
	 * 判断指定对象是否存在于指定数组中。
	 * 
	 * <p>
	 * 如果数组为<code>null</code>则返回<code>false</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param charToFind
	 *            要查找的元素
	 * 
	 * @return 如果找到则返回<code>true</code>
	 */
	public static boolean contains(char[] array, char charToFind) {
		return indexOf(array, charToFind) != -1;
	}

	/**
	 * 判断指定元素序列是否存在于指定数组中。
	 * 
	 * <p>
	 * 如果数组为<code>null</code>则返回<code>false</code>。
	 * </p>
	 * 
	 * @param array
	 *            要扫描的数组
	 * @param arrayToFind
	 *            要查找的元素序列
	 * 
	 * @return 如果找到则返回<code>true</code>
	 */
	public static boolean contains(char[] array, char[] arrayToFind) {
		return indexOf(array, arrayToFind) != -1;
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* 将数组转换成易于阅读的字符串表示。 */
	/*                                                                              */
	/* 支持多维数组。 */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * Converts an array to string. Return string contains no brackets.
	 */
	public static String toString(Object[] array) {
		if (array == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			if (i != 0) {
				sb.append(',').append(' ');
			}
			sb.append(array[i]);
		}
		return sb.toString();
	}

	/**
	 * Converts an array to string. Return string contains no brackets.
	 */
	public static String toString(String[] array) {
		if (array == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			if (i != 0) {
				sb.append(',').append(' ');
			}
			sb.append(array[i]);
		}
		return sb.toString();
	}

	/**
	 * Converts an array to string. Return string contains no brackets.
	 */
	public static String toString(byte[] array) {
		if (array == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			if (i != 0) {
				sb.append(',').append(' ');
			}
			sb.append(array[i]);
		}
		return sb.toString();
	}

	/**
	 * Converts an array to string. Return string contains no brackets.
	 */
	public static String toString(char[] array) {
		if (array == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			if (i != 0) {
				sb.append(',').append(' ');
			}
			sb.append(array[i]);
		}
		return sb.toString();
	}

	/**
	 * Converts an array to string. Return string contains no brackets.
	 */
	public static String toString(short[] array) {
		if (array == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			if (i != 0) {
				sb.append(',').append(' ');
			}
			sb.append(array[i]);
		}
		return sb.toString();
	}

	/**
	 * Converts an array to string. Return string contains no brackets.
	 */
	public static String toString(int[] array) {
		if (array == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			if (i != 0) {
				sb.append(',').append(' ');
			}
			sb.append(array[i]);
		}
		return sb.toString();
	}

	/**
	 * Converts an array to string. Return string contains no brackets.
	 */
	public static String toString(long[] array) {
		if (array == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			if (i != 0) {
				sb.append(',').append(' ');
			}
			sb.append(array[i]);
		}
		return sb.toString();
	}

	/**
	 * Converts an array to string. Return string contains no brackets.
	 */
	public static String toString(float[] array) {
		if (array == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			if (i != 0) {
				sb.append(',').append(' ');
			}
			sb.append(array[i]);
		}
		return sb.toString();
	}

	/**
	 * Converts an array to string. Return string contains no brackets.
	 */
	public static String toString(double[] array) {
		if (array == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			if (i != 0) {
				sb.append(',').append(' ');
			}
			sb.append(array[i]);
		}
		return sb.toString();
	}

	/**
	 * Converts an array to string. Return string contains no brackets.
	 */
	public static String toString(boolean[] array) {
		if (array == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			if (i != 0) {
				sb.append(',').append(' ');
			}
			sb.append(array[i]);
		}
		return sb.toString();
	}

	/**
	 * 将数组转换成易于阅读的字符串表示。
	 * 
	 * <p>
	 * 如果数组是<code>null</code>则返回<code>[]</code>，支持多维数组。 如果数组元素为<code>null</code>
	 * ，则显示<code>&lt;null&gt;</code>。
	 * 
	 * <pre>
	 * ArrayUtil.toString(null)                              = &quot;[]&quot;
	 * ArrayUtil.toString(new int[] {1, 2, 3})               = &quot;[1, 2, 3]&quot;
	 * ArrayUtil.toString(new boolean[] {true, false, true}) = &quot;[true, false, true]&quot;
	 * ArrayUtil.toString(new Object[] {
	 *                       {1, 2, 3},  // 嵌套数组
	 *                       hello,      // 嵌套非数组
	 *                       null,       // 嵌套null
	 *                       {},         // 嵌套空数组
	 *                       {2, 3, 4}   // 嵌套数组
	 *                    })                                 = &quot;[[1, 2, 3], hello, &lt;null&gt;, [], [2, 3, 4]]&quot;
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param array
	 *            要转换的数组
	 * 
	 * @return 字符串表示，<code>"[]"</code>表示空数组或<code>null</code>
	 */
	public static String toString(Object array) {
		return toString(array, "[]", "<null>");
	}

	/**
	 * 将数组转换成易于阅读的字符串表示。
	 * 
	 * <p>
	 * 如果数组是<code>null</code>则返回指定字符串，支持多维数组。 如果数组元素为<code>null</code>，则显示
	 * <code>&lt;null&gt;</code>。
	 * 
	 * <pre>
	 * ArrayUtil.toString(null, &quot;null&quot;)                              = &quot;null&quot;
	 * ArrayUtil.toString(new int[] {1, 2, 3}, &quot;null&quot;)               = &quot;[1, 2, 3]&quot;
	 * ArrayUtil.toString(new boolean[] {true, false, true}, &quot;null&quot;) = &quot;[true, false, true]&quot;
	 * ArrayUtil.toString(new Object[] {
	 *                       {1, 2, 3},  // 嵌套数组
	 *                       hello,      // 嵌套非数组
	 *                       null,       // 嵌套null
	 *                       {},         // 嵌套空数组
	 *                       {2, 3, 4}   // 嵌套数组
	 *                    }, &quot;null&quot;)                                 = &quot;[[1, 2, 3], hello, &lt;null&gt;, [], [2, 3, 4]]&quot;
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param array
	 *            要转换的数组
	 * @param nullArrayStr
	 *            如果数组是<code>null</code>，则返回此字符串
	 * 
	 * @return 字符串表示，或返回指定字符串表示<code>null</code>
	 */
	public static String toString(Object array, String nullArrayStr) {
		return toString(array, nullArrayStr, "<null>");
	}

	/**
	 * 将数组转换成易于阅读的字符串表示。
	 * 
	 * <p>
	 * 如果数组是<code>null</code>则返回指定字符串，支持多维数组。 如果数组元素为<code>null</code>，则显示指定字符串。
	 * 
	 * <pre>
	 * ArrayUtil.toString(null, &quot;null&quot;, &quot;NULL&quot;)                              = &quot;null&quot;
	 * ArrayUtil.toString(new int[] {1, 2, 3}, &quot;null&quot;, &quot;NULL&quot;)               = &quot;[1, 2, 3]&quot;
	 * ArrayUtil.toString(new boolean[] {true, false, true}, &quot;null&quot;, &quot;NULL&quot;) = &quot;[true, false, true]&quot;
	 * ArrayUtil.toString(new Object[] {
	 *                       {1, 2, 3},  // 嵌套数组
	 *                       hello,      // 嵌套非数组
	 *                       null,       // 嵌套null
	 *                       {},         // 嵌套空数组
	 *                       {2, 3, 4}   // 嵌套数组
	 *                    }, &quot;null&quot;, &quot;NULL&quot;)                                 = &quot;[[1, 2, 3], hello, NULL, [], [2, 3, 4]]&quot;
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param array
	 *            要转换的数组
	 * @param nullArrayStr
	 *            如果数组是<code>null</code>，则返回此字符串
	 * @param nullElementStr
	 *            如果数组中的元素为<code>null</code>，则返回此字符串
	 * 
	 * @return 字符串表示，或返回指定字符串表示<code>null</code>
	 */
	public static String toString(Object array, String nullArrayStr,
			String nullElementStr) {
		if (array == null) {
			return nullArrayStr;
		}

		StringBuilder builder = new StringBuilder();

		toString(builder, array, nullArrayStr, nullElementStr);

		return builder.toString();
	}

	/**
	 * 将数组转换成易于阅读的字符串表示。<code>null</code>将被看作空数组。 支持多维数组。FIXME
	 * 
	 * @param builder
	 *            将转换后的字符串加入到这个<code>StringBuilder</code>中
	 * @param array
	 *            要转换的数组
	 * @param nullArrayStr
	 *            如果数组是<code>null</code>，则返回此字符串
	 * @param nullElementStr
	 *            如果数组中的元素为<code>null</code>，则返回此字符串
	 */
	private static void toString(StringBuilder builder, Object array,
			String nullArrayStr, String nullElementStr) {
		if (array == null) {
			builder.append(nullElementStr);
			return;
		}

		if (!array.getClass().isArray()) {
			builder.append(ObjectUtil.toString(array, nullElementStr));
			return;
		}

		builder.append('[');

		// array为数组
		if (long[].class.isInstance(array)) {
			long[] longArray = (long[]) array;
			int length = longArray.length;

			for (int i = 0; i < length; i++) {
				if (i > 0) {
					builder.append(", ");
				}

				builder.append(longArray[i]);
			}
		} else if (int[].class.isInstance(array)) {
			int[] intArray = (int[]) array;
			int length = intArray.length;

			for (int i = 0; i < length; i++) {
				if (i > 0) {
					builder.append(", ");
				}

				builder.append(intArray[i]);
			}
		} else if (short[].class.isInstance(array)) {
			short[] shortArray = (short[]) array;
			int length = shortArray.length;

			for (int i = 0; i < length; i++) {
				if (i > 0) {
					builder.append(", ");
				}

				builder.append(shortArray[i]);
			}
		} else if (byte[].class.isInstance(array)) {
			byte[] byteArray = (byte[]) array;
			int length = byteArray.length;

			for (int i = 0; i < length; i++) {
				if (i > 0) {
					builder.append(", ");
				} else {
					builder.append("0x");
				}

				String hexStr = Integer.toHexString(0xFF & byteArray[i])
						.toUpperCase();

				if (hexStr.length() == 0) {
					builder.append("00");
				} else if (hexStr.length() == 1) {
					builder.append("0");
				}

				builder.append(hexStr);
			}
		} else if (double[].class.isInstance(array)) {
			double[] doubleArray = (double[]) array;
			int length = doubleArray.length;

			for (int i = 0; i < length; i++) {
				if (i > 0) {
					builder.append(", ");
				}

				builder.append(doubleArray[i]);
			}
		} else if (float[].class.isInstance(array)) {
			float[] floatArray = (float[]) array;
			int length = floatArray.length;

			for (int i = 0; i < length; i++) {
				if (i > 0) {
					builder.append(", ");
				}

				builder.append(floatArray[i]);
			}
		} else if (boolean[].class.isInstance(array)) {
			boolean[] booleanArray = (boolean[]) array;
			int length = booleanArray.length;

			for (int i = 0; i < length; i++) {
				if (i > 0) {
					builder.append(", ");
				}

				builder.append(booleanArray[i]);
			}
		} else if (char[].class.isInstance(array)) {
			char[] charArray = (char[]) array;
			int length = charArray.length;

			for (int i = 0; i < length; i++) {
				if (i > 0) {
					builder.append(", ");
				}

				builder.append(charArray[i]);
			}
		} else {
			Object[] objectArray = (Object[]) array;
			int length = objectArray.length;

			for (int i = 0; i < length; i++) {
				if (i > 0) {
					builder.append(", ");
				}

				toString(builder, objectArray[i], nullArrayStr, nullElementStr);
			}
		}

		builder.append(']');
	}

	/**
	 * 判断两个数组的相容性, 如果一个被另一个包含，即为相容
	 * 
	 * @param <T>
	 * @param arrayA
	 *            数组A
	 * @param arrayB
	 *            数组B
	 * @return 如果相容则返回<code>true</code>，否则返回<code>false</code>
	 */
	public static <T> boolean isCompatible(T[] arrayA, T[] arrayB) {
		if (arrayA == null) {
			return arrayB == null;
		}
		if (arrayB == null) {
			return false;
		}
		if (arrayA.length > arrayB.length) {
			final T[] tmp = arrayA;
			arrayA = arrayB;
			arrayB = tmp;
		}
		boolean flag;
		for (final T a : arrayA) {
			flag = false;
			for (final T b : arrayB) {
				if (a.equals(b)) {
					flag = true;
				}
			}
			if (!flag) {
				return false;
			}
		}
		return true;
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* 新增方法。 */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * <p>
	 * Adds all the elements of the given arrays into a new array.
	 * </p>
	 * <p>
	 * The new array contains all of the element of <code>array1</code> followed
	 * by all of the elements <code>array2</code>. When an array is returned, it
	 * is always a new array.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.addAll(null, null)     = null
	 * ArrayUtil.addAll(array1, null)   = cloned copy of array1
	 * ArrayUtil.addAll(null, array2)   = cloned copy of array2
	 * ArrayUtil.addAll([], [])         = []
	 * ArrayUtil.addAll([null], [null]) = [null, null]
	 * ArrayUtil.addAll(["a", "b", "c"], ["1", "2", "3"]) = ["a", "b", "c", "1", "2", "3"]
	 * </pre>
	 * 
	 * @param array1
	 *            the first array whose elements are added to the new array, may
	 *            be <code>null</code>
	 * @param array2
	 *            the second array whose elements are added to the new array,
	 *            may be <code>null</code>
	 * @return The new array, <code>null</code> if both arrays are
	 *         <code>null</code>. The type of the new array is the type of the
	 *         first array, unless the first array is null, in which case the
	 *         type is the same as the second array.
	 * @since 2.1
	 * @throws IllegalArgumentException
	 *             if the array types are incompatible
	 */
	public static <T> T[] addAll(T[] array1, T[] array2) {
		if (array1 == null) {
			return (T[]) clone(array2);
		} else if (array2 == null) {
			return (T[]) clone(array1);
		}
		@SuppressWarnings("unchecked")
		T[] joinedArray = (T[]) Array.newInstance(array1.getClass()
				.getComponentType(), array1.length + array2.length);
		System.arraycopy(array1, 0, joinedArray, 0, array1.length);
		try {
			System.arraycopy(array2, 0, joinedArray, array1.length,
					array2.length);
		} catch (ArrayStoreException ase) {
			// Check if problem was due to incompatible types
			/*
			 * We do this here, rather than before the copy because: - it would
			 * be a wasted check most of the time - safer, in case check turns
			 * out to be too strict
			 */
			final Class<?> type1 = array1.getClass().getComponentType();
			final Class<?> type2 = array2.getClass().getComponentType();
			if (!type1.isAssignableFrom(type2)) {
				throw new IllegalArgumentException("Cannot store "
						+ type2.getName() + " in an array of "
						+ type1.getName());
			}
			throw ase; // No, so rethrow original
		}
		return joinedArray;
	}

	/**
	 * <p>
	 * Adds all the elements of the given arrays into a new array.
	 * </p>
	 * <p>
	 * The new array contains all of the element of <code>array1</code> followed
	 * by all of the elements <code>array2</code>. When an array is returned, it
	 * is always a new array.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.addAll(array1, null)   = cloned copy of array1
	 * ArrayUtil.addAll(null, array2)   = cloned copy of array2
	 * ArrayUtil.addAll([], [])         = []
	 * </pre>
	 * 
	 * @param array1
	 *            the first array whose elements are added to the new array.
	 * @param array2
	 *            the second array whose elements are added to the new array.
	 * @return The new boolean[] array.
	 * @since 2.1
	 */
	public static boolean[] addAll(boolean[] array1, boolean[] array2) {
		if (array1 == null) {
			return clone(array2);
		} else if (array2 == null) {
			return clone(array1);
		}
		boolean[] joinedArray = new boolean[array1.length + array2.length];
		System.arraycopy(array1, 0, joinedArray, 0, array1.length);
		System.arraycopy(array2, 0, joinedArray, array1.length, array2.length);
		return joinedArray;
	}

	/**
	 * <p>
	 * Adds all the elements of the given arrays into a new array.
	 * </p>
	 * <p>
	 * The new array contains all of the element of <code>array1</code> followed
	 * by all of the elements <code>array2</code>. When an array is returned, it
	 * is always a new array.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.addAll(array1, null)   = cloned copy of array1
	 * ArrayUtil.addAll(null, array2)   = cloned copy of array2
	 * ArrayUtil.addAll([], [])         = []
	 * </pre>
	 * 
	 * @param array1
	 *            the first array whose elements are added to the new array.
	 * @param array2
	 *            the second array whose elements are added to the new array.
	 * @return The new char[] array.
	 * @since 2.1
	 */
	public static char[] addAll(char[] array1, char[] array2) {
		if (array1 == null) {
			return clone(array2);
		} else if (array2 == null) {
			return clone(array1);
		}
		char[] joinedArray = new char[array1.length + array2.length];
		System.arraycopy(array1, 0, joinedArray, 0, array1.length);
		System.arraycopy(array2, 0, joinedArray, array1.length, array2.length);
		return joinedArray;
	}

	/**
	 * <p>
	 * Adds all the elements of the given arrays into a new array.
	 * </p>
	 * <p>
	 * The new array contains all of the element of <code>array1</code> followed
	 * by all of the elements <code>array2</code>. When an array is returned, it
	 * is always a new array.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.addAll(array1, null)   = cloned copy of array1
	 * ArrayUtil.addAll(null, array2)   = cloned copy of array2
	 * ArrayUtil.addAll([], [])         = []
	 * </pre>
	 * 
	 * @param array1
	 *            the first array whose elements are added to the new array.
	 * @param array2
	 *            the second array whose elements are added to the new array.
	 * @return The new byte[] array.
	 * @since 2.1
	 */
	public static byte[] addAll(byte[] array1, byte[] array2) {
		if (array1 == null) {
			return clone(array2);
		} else if (array2 == null) {
			return clone(array1);
		}
		byte[] joinedArray = new byte[array1.length + array2.length];
		System.arraycopy(array1, 0, joinedArray, 0, array1.length);
		System.arraycopy(array2, 0, joinedArray, array1.length, array2.length);
		return joinedArray;
	}

	/**
	 * <p>
	 * Adds all the elements of the given arrays into a new array.
	 * </p>
	 * <p>
	 * The new array contains all of the element of <code>array1</code> followed
	 * by all of the elements <code>array2</code>. When an array is returned, it
	 * is always a new array.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.addAll(array1, null)   = cloned copy of array1
	 * ArrayUtil.addAll(null, array2)   = cloned copy of array2
	 * ArrayUtil.addAll([], [])         = []
	 * </pre>
	 * 
	 * @param array1
	 *            the first array whose elements are added to the new array.
	 * @param array2
	 *            the second array whose elements are added to the new array.
	 * @return The new short[] array.
	 * @since 2.1
	 */
	public static short[] addAll(short[] array1, short[] array2) {
		if (array1 == null) {
			return clone(array2);
		} else if (array2 == null) {
			return clone(array1);
		}
		short[] joinedArray = new short[array1.length + array2.length];
		System.arraycopy(array1, 0, joinedArray, 0, array1.length);
		System.arraycopy(array2, 0, joinedArray, array1.length, array2.length);
		return joinedArray;
	}

	/**
	 * <p>
	 * Adds all the elements of the given arrays into a new array.
	 * </p>
	 * <p>
	 * The new array contains all of the element of <code>array1</code> followed
	 * by all of the elements <code>array2</code>. When an array is returned, it
	 * is always a new array.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.addAll(array1, null)   = cloned copy of array1
	 * ArrayUtil.addAll(null, array2)   = cloned copy of array2
	 * ArrayUtil.addAll([], [])         = []
	 * </pre>
	 * 
	 * @param array1
	 *            the first array whose elements are added to the new array.
	 * @param array2
	 *            the second array whose elements are added to the new array.
	 * @return The new int[] array.
	 * @since 2.1
	 */
	public static int[] addAll(int[] array1, int[] array2) {
		if (array1 == null) {
			return clone(array2);
		} else if (array2 == null) {
			return clone(array1);
		}
		int[] joinedArray = new int[array1.length + array2.length];
		System.arraycopy(array1, 0, joinedArray, 0, array1.length);
		System.arraycopy(array2, 0, joinedArray, array1.length, array2.length);
		return joinedArray;
	}

	/**
	 * <p>
	 * Adds all the elements of the given arrays into a new array.
	 * </p>
	 * <p>
	 * The new array contains all of the element of <code>array1</code> followed
	 * by all of the elements <code>array2</code>. When an array is returned, it
	 * is always a new array.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.addAll(array1, null)   = cloned copy of array1
	 * ArrayUtil.addAll(null, array2)   = cloned copy of array2
	 * ArrayUtil.addAll([], [])         = []
	 * </pre>
	 * 
	 * @param array1
	 *            the first array whose elements are added to the new array.
	 * @param array2
	 *            the second array whose elements are added to the new array.
	 * @return The new long[] array.
	 * @since 2.1
	 */
	public static long[] addAll(long[] array1, long[] array2) {
		if (array1 == null) {
			return clone(array2);
		} else if (array2 == null) {
			return clone(array1);
		}
		long[] joinedArray = new long[array1.length + array2.length];
		System.arraycopy(array1, 0, joinedArray, 0, array1.length);
		System.arraycopy(array2, 0, joinedArray, array1.length, array2.length);
		return joinedArray;
	}

	/**
	 * <p>
	 * Adds all the elements of the given arrays into a new array.
	 * </p>
	 * <p>
	 * The new array contains all of the element of <code>array1</code> followed
	 * by all of the elements <code>array2</code>. When an array is returned, it
	 * is always a new array.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.addAll(array1, null)   = cloned copy of array1
	 * ArrayUtil.addAll(null, array2)   = cloned copy of array2
	 * ArrayUtil.addAll([], [])         = []
	 * </pre>
	 * 
	 * @param array1
	 *            the first array whose elements are added to the new array.
	 * @param array2
	 *            the second array whose elements are added to the new array.
	 * @return The new float[] array.
	 * @since 2.1
	 */
	public static float[] addAll(float[] array1, float[] array2) {
		if (array1 == null) {
			return clone(array2);
		} else if (array2 == null) {
			return clone(array1);
		}
		float[] joinedArray = new float[array1.length + array2.length];
		System.arraycopy(array1, 0, joinedArray, 0, array1.length);
		System.arraycopy(array2, 0, joinedArray, array1.length, array2.length);
		return joinedArray;
	}

	/**
	 * <p>
	 * Adds all the elements of the given arrays into a new array.
	 * </p>
	 * <p>
	 * The new array contains all of the element of <code>array1</code> followed
	 * by all of the elements <code>array2</code>. When an array is returned, it
	 * is always a new array.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.addAll(array1, null)   = cloned copy of array1
	 * ArrayUtil.addAll(null, array2)   = cloned copy of array2
	 * ArrayUtil.addAll([], [])         = []
	 * </pre>
	 * 
	 * @param array1
	 *            the first array whose elements are added to the new array.
	 * @param array2
	 *            the second array whose elements are added to the new array.
	 * @return The new double[] array.
	 * @since 2.1
	 */
	public static double[] addAll(double[] array1, double[] array2) {
		if (array1 == null) {
			return clone(array2);
		} else if (array2 == null) {
			return clone(array1);
		}
		double[] joinedArray = new double[array1.length + array2.length];
		System.arraycopy(array1, 0, joinedArray, 0, array1.length);
		System.arraycopy(array2, 0, joinedArray, array1.length, array2.length);
		return joinedArray;
	}

	public static <T> T[] join(T[] array1, T[] array2) {
		return addAll(array1, array2);
	}

	/**
	 * <p>
	 * Adds all the elements of the given arrays into a new array.
	 * </p>
	 * <p>
	 * The new array contains all of the element of <code>array1</code> followed
	 * by all of the elements <code>array2</code>. When an array is returned, it
	 * is always a new array.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.addAll(array1, null)   = cloned copy of array1
	 * ArrayUtil.addAll(null, array2)   = cloned copy of array2
	 * ArrayUtil.addAll([], [])         = []
	 * </pre>
	 * 
	 * @param array1
	 *            the first array whose elements are added to the new array.
	 * @param array2
	 *            the second array whose elements are added to the new array.
	 * @return The new boolean[] array.
	 * @since 2.1
	 */
	public static boolean[] join(boolean[] array1, boolean[] array2) {
		return addAll(array1, array2);
	}

	/**
	 * <p>
	 * Adds all the elements of the given arrays into a new array.
	 * </p>
	 * <p>
	 * The new array contains all of the element of <code>array1</code> followed
	 * by all of the elements <code>array2</code>. When an array is returned, it
	 * is always a new array.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.addAll(array1, null)   = cloned copy of array1
	 * ArrayUtil.addAll(null, array2)   = cloned copy of array2
	 * ArrayUtil.addAll([], [])         = []
	 * </pre>
	 * 
	 * @param array1
	 *            the first array whose elements are added to the new array.
	 * @param array2
	 *            the second array whose elements are added to the new array.
	 * @return The new char[] array.
	 * @since 2.1
	 */
	public static char[] join(char[] array1, char[] array2) {
		return addAll(array1, array2);
	}

	/**
	 * <p>
	 * Adds all the elements of the given arrays into a new array.
	 * </p>
	 * <p>
	 * The new array contains all of the element of <code>array1</code> followed
	 * by all of the elements <code>array2</code>. When an array is returned, it
	 * is always a new array.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.addAll(array1, null)   = cloned copy of array1
	 * ArrayUtil.addAll(null, array2)   = cloned copy of array2
	 * ArrayUtil.addAll([], [])         = []
	 * </pre>
	 * 
	 * @param array1
	 *            the first array whose elements are added to the new array.
	 * @param array2
	 *            the second array whose elements are added to the new array.
	 * @return The new byte[] array.
	 * @since 2.1
	 */
	public static byte[] join(byte[] array1, byte[] array2) {
		return addAll(array1, array2);
	}

	/**
	 * <p>
	 * Adds all the elements of the given arrays into a new array.
	 * </p>
	 * <p>
	 * The new array contains all of the element of <code>array1</code> followed
	 * by all of the elements <code>array2</code>. When an array is returned, it
	 * is always a new array.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.addAll(array1, null)   = cloned copy of array1
	 * ArrayUtil.addAll(null, array2)   = cloned copy of array2
	 * ArrayUtil.addAll([], [])         = []
	 * </pre>
	 * 
	 * @param array1
	 *            the first array whose elements are added to the new array.
	 * @param array2
	 *            the second array whose elements are added to the new array.
	 * @return The new short[] array.
	 * @since 2.1
	 */
	public static short[] join(short[] array1, short[] array2) {
		return addAll(array1, array2);
	}

	/**
	 * <p>
	 * Adds all the elements of the given arrays into a new array.
	 * </p>
	 * <p>
	 * The new array contains all of the element of <code>array1</code> followed
	 * by all of the elements <code>array2</code>. When an array is returned, it
	 * is always a new array.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.addAll(array1, null)   = cloned copy of array1
	 * ArrayUtil.addAll(null, array2)   = cloned copy of array2
	 * ArrayUtil.addAll([], [])         = []
	 * </pre>
	 * 
	 * @param array1
	 *            the first array whose elements are added to the new array.
	 * @param array2
	 *            the second array whose elements are added to the new array.
	 * @return The new int[] array.
	 * @since 2.1
	 */
	public static int[] join(int[] array1, int[] array2) {
		return addAll(array1, array2);
	}

	/**
	 * <p>
	 * Adds all the elements of the given arrays into a new array.
	 * </p>
	 * <p>
	 * The new array contains all of the element of <code>array1</code> followed
	 * by all of the elements <code>array2</code>. When an array is returned, it
	 * is always a new array.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.addAll(array1, null)   = cloned copy of array1
	 * ArrayUtil.addAll(null, array2)   = cloned copy of array2
	 * ArrayUtil.addAll([], [])         = []
	 * </pre>
	 * 
	 * @param array1
	 *            the first array whose elements are added to the new array.
	 * @param array2
	 *            the second array whose elements are added to the new array.
	 * @return The new long[] array.
	 * @since 2.1
	 */
	public static long[] join(long[] array1, long[] array2) {
		return addAll(array1, array2);
	}

	/**
	 * <p>
	 * Adds all the elements of the given arrays into a new array.
	 * </p>
	 * <p>
	 * The new array contains all of the element of <code>array1</code> followed
	 * by all of the elements <code>array2</code>. When an array is returned, it
	 * is always a new array.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.addAll(array1, null)   = cloned copy of array1
	 * ArrayUtil.addAll(null, array2)   = cloned copy of array2
	 * ArrayUtil.addAll([], [])         = []
	 * </pre>
	 * 
	 * @param array1
	 *            the first array whose elements are added to the new array.
	 * @param array2
	 *            the second array whose elements are added to the new array.
	 * @return The new float[] array.
	 * @since 2.1
	 */
	public static float[] join(float[] array1, float[] array2) {
		return addAll(array1, array2);
	}

	/**
	 * <p>
	 * Adds all the elements of the given arrays into a new array.
	 * </p>
	 * <p>
	 * The new array contains all of the element of <code>array1</code> followed
	 * by all of the elements <code>array2</code>. When an array is returned, it
	 * is always a new array.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.addAll(array1, null)   = cloned copy of array1
	 * ArrayUtil.addAll(null, array2)   = cloned copy of array2
	 * ArrayUtil.addAll([], [])         = []
	 * </pre>
	 * 
	 * @param array1
	 *            the first array whose elements are added to the new array.
	 * @param array2
	 *            the second array whose elements are added to the new array.
	 * @return The new double[] array.
	 * @since 2.1
	 */
	public static double[] join(double[] array1, double[] array2) {
		return addAll(array1, array2);
	}

	// Subarrays
	// -----------------------------------------------------------------------
	/**
	 * <p>
	 * Produces a new array containing the elements between the start and end
	 * indices.
	 * </p>
	 * 
	 * <p>
	 * The start index is inclusive, the end index exclusive. Null array input
	 * produces null output.
	 * </p>
	 * 
	 * <p>
	 * The component type of the subarray is always the same as that of the
	 * input array. Thus, if the input is an array of type <code>Date</code>,
	 * the following usage is envisaged:
	 * </p>
	 * 
	 * <pre>
	 * Date[] someDates = (Date[]) ArrayUtil.subarray(allDates, 2, 5);
	 * </pre>
	 * 
	 * @param array
	 *            the array
	 * @param startIndexInclusive
	 *            the starting index. Undervalue (&lt;0) is promoted to 0,
	 *            overvalue (&gt;array.length) results in an empty array.
	 * @param endIndexExclusive
	 *            elements up to endIndex-1 are present in the returned
	 *            subarray. Undervalue (&lt; startIndex) produces empty array,
	 *            overvalue (&gt;array.length) is demoted to array length.
	 * @return a new array containing the elements between the start and end
	 *         indices.
	 * @since 2.1
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] subarray(T[] array, int startIndexInclusive,
			int endIndexExclusive) {
		if (array == null) {
			return null;
		}
		if (startIndexInclusive < 0) {
			startIndexInclusive = 0;
		}
		if (endIndexExclusive > array.length) {
			endIndexExclusive = array.length;
		}
		int newSize = endIndexExclusive - startIndexInclusive;
		Class<?> type = array.getClass().getComponentType();
		if (newSize <= 0) {
			return (T[]) Array.newInstance(type, 0);
		}
		T[] subarray = (T[]) Array.newInstance(type, newSize);
		System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
		return subarray;
	}

	/**
	 * <p>
	 * Produces a new <code>long</code> array containing the elements between
	 * the start and end indices.
	 * </p>
	 * 
	 * <p>
	 * The start index is inclusive, the end index exclusive. Null array input
	 * produces null output.
	 * </p>
	 * 
	 * @param array
	 *            the array
	 * @param startIndexInclusive
	 *            the starting index. Undervalue (&lt;0) is promoted to 0,
	 *            overvalue (&gt;array.length) results in an empty array.
	 * @param endIndexExclusive
	 *            elements up to endIndex-1 are present in the returned
	 *            subarray. Undervalue (&lt; startIndex) produces empty array,
	 *            overvalue (&gt;array.length) is demoted to array length.
	 * @return a new array containing the elements between the start and end
	 *         indices.
	 * @since 2.1
	 */
	public static long[] subarray(long[] array, int startIndexInclusive,
			int endIndexExclusive) {
		if (array == null) {
			return null;
		}
		if (startIndexInclusive < 0) {
			startIndexInclusive = 0;
		}
		if (endIndexExclusive > array.length) {
			endIndexExclusive = array.length;
		}
		int newSize = endIndexExclusive - startIndexInclusive;
		if (newSize <= 0) {
			return EMPTY_LONG_ARRAY;
		}

		long[] subarray = new long[newSize];
		System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
		return subarray;
	}

	/**
	 * <p>
	 * Produces a new <code>int</code> array containing the elements between the
	 * start and end indices.
	 * </p>
	 * 
	 * <p>
	 * The start index is inclusive, the end index exclusive. Null array input
	 * produces null output.
	 * </p>
	 * 
	 * @param array
	 *            the array
	 * @param startIndexInclusive
	 *            the starting index. Undervalue (&lt;0) is promoted to 0,
	 *            overvalue (&gt;array.length) results in an empty array.
	 * @param endIndexExclusive
	 *            elements up to endIndex-1 are present in the returned
	 *            subarray. Undervalue (&lt; startIndex) produces empty array,
	 *            overvalue (&gt;array.length) is demoted to array length.
	 * @return a new array containing the elements between the start and end
	 *         indices.
	 * @since 2.1
	 */
	public static int[] subarray(int[] array, int startIndexInclusive,
			int endIndexExclusive) {
		if (array == null) {
			return null;
		}
		if (startIndexInclusive < 0) {
			startIndexInclusive = 0;
		}
		if (endIndexExclusive > array.length) {
			endIndexExclusive = array.length;
		}
		int newSize = endIndexExclusive - startIndexInclusive;
		if (newSize <= 0) {
			return EMPTY_INT_ARRAY;
		}

		int[] subarray = new int[newSize];
		System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
		return subarray;
	}

	/**
	 * <p>
	 * Produces a new <code>short</code> array containing the elements between
	 * the start and end indices.
	 * </p>
	 * 
	 * <p>
	 * The start index is inclusive, the end index exclusive. Null array input
	 * produces null output.
	 * </p>
	 * 
	 * @param array
	 *            the array
	 * @param startIndexInclusive
	 *            the starting index. Undervalue (&lt;0) is promoted to 0,
	 *            overvalue (&gt;array.length) results in an empty array.
	 * @param endIndexExclusive
	 *            elements up to endIndex-1 are present in the returned
	 *            subarray. Undervalue (&lt; startIndex) produces empty array,
	 *            overvalue (&gt;array.length) is demoted to array length.
	 * @return a new array containing the elements between the start and end
	 *         indices.
	 * @since 2.1
	 */
	public static short[] subarray(short[] array, int startIndexInclusive,
			int endIndexExclusive) {
		if (array == null) {
			return null;
		}
		if (startIndexInclusive < 0) {
			startIndexInclusive = 0;
		}
		if (endIndexExclusive > array.length) {
			endIndexExclusive = array.length;
		}
		int newSize = endIndexExclusive - startIndexInclusive;
		if (newSize <= 0) {
			return EMPTY_SHORT_ARRAY;
		}

		short[] subarray = new short[newSize];
		System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
		return subarray;
	}

	/**
	 * <p>
	 * Produces a new <code>char</code> array containing the elements between
	 * the start and end indices.
	 * </p>
	 * 
	 * <p>
	 * The start index is inclusive, the end index exclusive. Null array input
	 * produces null output.
	 * </p>
	 * 
	 * @param array
	 *            the array
	 * @param startIndexInclusive
	 *            the starting index. Undervalue (&lt;0) is promoted to 0,
	 *            overvalue (&gt;array.length) results in an empty array.
	 * @param endIndexExclusive
	 *            elements up to endIndex-1 are present in the returned
	 *            subarray. Undervalue (&lt; startIndex) produces empty array,
	 *            overvalue (&gt;array.length) is demoted to array length.
	 * @return a new array containing the elements between the start and end
	 *         indices.
	 * @since 2.1
	 */
	public static char[] subarray(char[] array, int startIndexInclusive,
			int endIndexExclusive) {
		if (array == null) {
			return null;
		}
		if (startIndexInclusive < 0) {
			startIndexInclusive = 0;
		}
		if (endIndexExclusive > array.length) {
			endIndexExclusive = array.length;
		}
		int newSize = endIndexExclusive - startIndexInclusive;
		if (newSize <= 0) {
			return EMPTY_CHAR_ARRAY;
		}

		char[] subarray = new char[newSize];
		System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
		return subarray;
	}

	/**
	 * <p>
	 * Produces a new <code>byte</code> array containing the elements between
	 * the start and end indices.
	 * </p>
	 * 
	 * <p>
	 * The start index is inclusive, the end index exclusive. Null array input
	 * produces null output.
	 * </p>
	 * 
	 * @param array
	 *            the array
	 * @param startIndexInclusive
	 *            the starting index. Undervalue (&lt;0) is promoted to 0,
	 *            overvalue (&gt;array.length) results in an empty array.
	 * @param endIndexExclusive
	 *            elements up to endIndex-1 are present in the returned
	 *            subarray. Undervalue (&lt; startIndex) produces empty array,
	 *            overvalue (&gt;array.length) is demoted to array length.
	 * @return a new array containing the elements between the start and end
	 *         indices.
	 * @since 2.1
	 */
	public static byte[] subarray(byte[] array, int startIndexInclusive,
			int endIndexExclusive) {
		if (array == null) {
			return null;
		}
		if (startIndexInclusive < 0) {
			startIndexInclusive = 0;
		}
		if (endIndexExclusive > array.length) {
			endIndexExclusive = array.length;
		}
		int newSize = endIndexExclusive - startIndexInclusive;
		if (newSize <= 0) {
			return EMPTY_BYTE_ARRAY;
		}

		byte[] subarray = new byte[newSize];
		System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
		return subarray;
	}

	/**
	 * <p>
	 * Produces a new <code>double</code> array containing the elements between
	 * the start and end indices.
	 * </p>
	 * 
	 * <p>
	 * The start index is inclusive, the end index exclusive. Null array input
	 * produces null output.
	 * </p>
	 * 
	 * @param array
	 *            the array
	 * @param startIndexInclusive
	 *            the starting index. Undervalue (&lt;0) is promoted to 0,
	 *            overvalue (&gt;array.length) results in an empty array.
	 * @param endIndexExclusive
	 *            elements up to endIndex-1 are present in the returned
	 *            subarray. Undervalue (&lt; startIndex) produces empty array,
	 *            overvalue (&gt;array.length) is demoted to array length.
	 * @return a new array containing the elements between the start and end
	 *         indices.
	 * @since 2.1
	 */
	public static double[] subarray(double[] array, int startIndexInclusive,
			int endIndexExclusive) {
		if (array == null) {
			return null;
		}
		if (startIndexInclusive < 0) {
			startIndexInclusive = 0;
		}
		if (endIndexExclusive > array.length) {
			endIndexExclusive = array.length;
		}
		int newSize = endIndexExclusive - startIndexInclusive;
		if (newSize <= 0) {
			return EMPTY_DOUBLE_ARRAY;
		}

		double[] subarray = new double[newSize];
		System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
		return subarray;
	}

	/**
	 * <p>
	 * Produces a new <code>float</code> array containing the elements between
	 * the start and end indices.
	 * </p>
	 * 
	 * <p>
	 * The start index is inclusive, the end index exclusive. Null array input
	 * produces null output.
	 * </p>
	 * 
	 * @param array
	 *            the array
	 * @param startIndexInclusive
	 *            the starting index. Undervalue (&lt;0) is promoted to 0,
	 *            overvalue (&gt;array.length) results in an empty array.
	 * @param endIndexExclusive
	 *            elements up to endIndex-1 are present in the returned
	 *            subarray. Undervalue (&lt; startIndex) produces empty array,
	 *            overvalue (&gt;array.length) is demoted to array length.
	 * @return a new array containing the elements between the start and end
	 *         indices.
	 * @since 2.1
	 */
	public static float[] subarray(float[] array, int startIndexInclusive,
			int endIndexExclusive) {
		if (array == null) {
			return null;
		}
		if (startIndexInclusive < 0) {
			startIndexInclusive = 0;
		}
		if (endIndexExclusive > array.length) {
			endIndexExclusive = array.length;
		}
		int newSize = endIndexExclusive - startIndexInclusive;
		if (newSize <= 0) {
			return EMPTY_FLOAT_ARRAY;
		}

		float[] subarray = new float[newSize];
		System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
		return subarray;
	}

	/**
	 * <p>
	 * Produces a new <code>boolean</code> array containing the elements between
	 * the start and end indices.
	 * </p>
	 * 
	 * <p>
	 * The start index is inclusive, the end index exclusive. Null array input
	 * produces null output.
	 * </p>
	 * 
	 * @param array
	 *            the array
	 * @param startIndexInclusive
	 *            the starting index. Undervalue (&lt;0) is promoted to 0,
	 *            overvalue (&gt;array.length) results in an empty array.
	 * @param endIndexExclusive
	 *            elements up to endIndex-1 are present in the returned
	 *            subarray. Undervalue (&lt; startIndex) produces empty array,
	 *            overvalue (&gt;array.length) is demoted to array length.
	 * @return a new array containing the elements between the start and end
	 *         indices.
	 * @since 2.1
	 */
	public static boolean[] subarray(boolean[] array, int startIndexInclusive,
			int endIndexExclusive) {
		if (array == null) {
			return null;
		}
		if (startIndexInclusive < 0) {
			startIndexInclusive = 0;
		}
		if (endIndexExclusive > array.length) {
			endIndexExclusive = array.length;
		}
		int newSize = endIndexExclusive - startIndexInclusive;
		if (newSize <= 0) {
			return EMPTY_BOOLEAN_ARRAY;
		}

		boolean[] subarray = new boolean[newSize];
		System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
		return subarray;
	}

	/**
	 * Returns subarray.
	 */
	public static <T> T[] subarrayTo(T[] buffer, int offset, int length) {
		return subarrayTo(buffer, offset, length, null);
	}

	/**
	 * Returns subarray.
	 */
	public static <T> T[] subarrayTo(T[] buffer, int offset, int length,
			Class<?> componentType) {
		if (buffer == null) {
			return null;
		}

		if (componentType == null) {
			componentType = buffer.getClass().getComponentType();
		}
		@SuppressWarnings({ "unchecked" })
		T[] temp = (T[]) Array.newInstance(componentType, length);
		System.arraycopy(buffer, offset, temp, 0, length);
		return temp;
	}

	/**
	 * Returns subarray.
	 */
	public static String[] subarrayTo(String[] buffer, int offset, int length) {
		if (buffer == null) {
			return null;
		}
		String temp[] = new String[length];
		System.arraycopy(buffer, offset, temp, 0, length);
		return temp;
	}

	/**
	 * Returns subarray.
	 */
	public static byte[] subarrayTo(byte[] buffer, int offset, int length) {
		if (buffer == null) {
			return null;
		}
		byte temp[] = new byte[length];
		System.arraycopy(buffer, offset, temp, 0, length);
		return temp;
	}

	/**
	 * Returns subarray.
	 */
	public static char[] subarrayTo(char[] buffer, int offset, int length) {
		if (buffer == null) {
			return null;
		}
		char temp[] = new char[length];
		System.arraycopy(buffer, offset, temp, 0, length);
		return temp;
	}

	/**
	 * Returns subarray.
	 */
	public static short[] subarrayTo(short[] buffer, int offset, int length) {
		if (buffer == null) {
			return null;
		}
		short temp[] = new short[length];
		System.arraycopy(buffer, offset, temp, 0, length);
		return temp;
	}

	/**
	 * Returns subarray.
	 */
	public static int[] subarrayTo(int[] buffer, int offset, int length) {
		if (buffer == null) {
			return null;
		}
		int temp[] = new int[length];
		System.arraycopy(buffer, offset, temp, 0, length);
		return temp;
	}

	/**
	 * Returns subarray.
	 */
	public static long[] subarrayTo(long[] buffer, int offset, int length) {
		if (buffer == null) {
			return null;
		}
		long temp[] = new long[length];
		System.arraycopy(buffer, offset, temp, 0, length);
		return temp;
	}

	/**
	 * Returns subarray.
	 */
	public static float[] subarrayTo(float[] buffer, int offset, int length) {
		if (buffer == null) {
			return null;
		}
		float temp[] = new float[length];
		System.arraycopy(buffer, offset, temp, 0, length);
		return temp;
	}

	/**
	 * Returns subarray.
	 */
	public static double[] subarrayTo(double[] buffer, int offset, int length) {
		if (buffer == null) {
			return null;
		}
		double temp[] = new double[length];
		System.arraycopy(buffer, offset, temp, 0, length);
		return temp;
	}

	/**
	 * Returns subarray.
	 */
	public static boolean[] subarrayTo(boolean[] buffer, int offset, int length) {
		if (buffer == null) {
			return null;
		}
		boolean temp[] = new boolean[length];
		System.arraycopy(buffer, offset, temp, 0, length);
		return temp;
	}

	/**
	 * <p>
	 * Copies the given array and adds the given element at the end of the new
	 * array.
	 * </p>
	 * 
	 * <p>
	 * The new array contains the same elements of the input array plus the
	 * given element in the last position. The component type of the new array
	 * is the same as that of the input array.
	 * </p>
	 * 
	 * <p>
	 * If the input array is <code>null</code>, a new one element array is
	 * returned whose component type is the same as the element, unless the
	 * element itself is null, in which case the return type is Object[]
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.add(null, null)      = [null]
	 * ArrayUtil.add(null, "a")       = ["a"]
	 * ArrayUtil.add(["a"], null)     = ["a", null]
	 * ArrayUtil.add(["a"], "b")      = ["a", "b"]
	 * ArrayUtil.add(["a", "b"], "c") = ["a", "b", "c"]
	 * </pre>
	 * 
	 * @param array
	 *            the array to "add" the element to, may be <code>null</code>
	 * @param element
	 *            the object to add, may be <code>null</code>
	 * @return A new array containing the existing elements plus the new element
	 *         The returned array type will be that of the input array (unless
	 *         null), in which case it will have the same type as the element.
	 * @since 2.1
	 */
	public static <T> T[] add(T[] array, T element) {
		Class<?> type;
		if (array != null) {
			type = array.getClass();
		} else if (element != null) {
			type = element.getClass();
		} else {
			type = Object.class;
		}
		@SuppressWarnings("unchecked")
		T[] newArray = (T[]) copyArrayGrow(array, type);
		newArray[newArray.length - 1] = element;
		return newArray;
	}

	/**
	 * <p>
	 * Copies the given array and adds the given element at the end of the new
	 * array.
	 * </p>
	 * 
	 * <p>
	 * The new array contains the same elements of the input array plus the
	 * given element in the last position. The component type of the new array
	 * is the same as that of the input array.
	 * </p>
	 * 
	 * <p>
	 * If the input array is <code>null</code>, a new one element array is
	 * returned whose component type is the same as the element.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.add(null, true)          = [true]
	 * ArrayUtil.add([true], false)       = [true, false]
	 * ArrayUtil.add([true, false], true) = [true, false, true]
	 * </pre>
	 * 
	 * @param array
	 *            the array to copy and add the element to, may be
	 *            <code>null</code>
	 * @param element
	 *            the object to add at the last index of the new array
	 * @return A new array containing the existing elements plus the new element
	 * @since 2.1
	 */
	public static boolean[] add(boolean[] array, boolean element) {
		boolean[] newArray = (boolean[]) copyArrayGrow(array, Boolean.TYPE);
		newArray[newArray.length - 1] = element;
		return newArray;
	}

	/**
	 * <p>
	 * Copies the given array and adds the given element at the end of the new
	 * array.
	 * </p>
	 * 
	 * <p>
	 * The new array contains the same elements of the input array plus the
	 * given element in the last position. The component type of the new array
	 * is the same as that of the input array.
	 * </p>
	 * 
	 * <p>
	 * If the input array is <code>null</code>, a new one element array is
	 * returned whose component type is the same as the element.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.add(null, 0)   = [0]
	 * ArrayUtil.add([1], 0)    = [1, 0]
	 * ArrayUtil.add([1, 0], 1) = [1, 0, 1]
	 * </pre>
	 * 
	 * @param array
	 *            the array to copy and add the element to, may be
	 *            <code>null</code>
	 * @param element
	 *            the object to add at the last index of the new array
	 * @return A new array containing the existing elements plus the new element
	 * @since 2.1
	 */
	public static byte[] add(byte[] array, byte element) {
		byte[] newArray = (byte[]) copyArrayGrow(array, Byte.TYPE);
		newArray[newArray.length - 1] = element;
		return newArray;
	}

	/**
	 * <p>
	 * Copies the given array and adds the given element at the end of the new
	 * array.
	 * </p>
	 * 
	 * <p>
	 * The new array contains the same elements of the input array plus the
	 * given element in the last position. The component type of the new array
	 * is the same as that of the input array.
	 * </p>
	 * 
	 * <p>
	 * If the input array is <code>null</code>, a new one element array is
	 * returned whose component type is the same as the element.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.add(null, '0')       = ['0']
	 * ArrayUtil.add(['1'], '0')      = ['1', '0']
	 * ArrayUtil.add(['1', '0'], '1') = ['1', '0', '1']
	 * </pre>
	 * 
	 * @param array
	 *            the array to copy and add the element to, may be
	 *            <code>null</code>
	 * @param element
	 *            the object to add at the last index of the new array
	 * @return A new array containing the existing elements plus the new element
	 * @since 2.1
	 */
	public static char[] add(char[] array, char element) {
		char[] newArray = (char[]) copyArrayGrow(array, Character.TYPE);
		newArray[newArray.length - 1] = element;
		return newArray;
	}

	/**
	 * <p>
	 * Copies the given array and adds the given element at the end of the new
	 * array.
	 * </p>
	 * 
	 * <p>
	 * The new array contains the same elements of the input array plus the
	 * given element in the last position. The component type of the new array
	 * is the same as that of the input array.
	 * </p>
	 * 
	 * <p>
	 * If the input array is <code>null</code>, a new one element array is
	 * returned whose component type is the same as the element.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.add(null, 0)   = [0]
	 * ArrayUtil.add([1], 0)    = [1, 0]
	 * ArrayUtil.add([1, 0], 1) = [1, 0, 1]
	 * </pre>
	 * 
	 * @param array
	 *            the array to copy and add the element to, may be
	 *            <code>null</code>
	 * @param element
	 *            the object to add at the last index of the new array
	 * @return A new array containing the existing elements plus the new element
	 * @since 2.1
	 */
	public static double[] add(double[] array, double element) {
		double[] newArray = (double[]) copyArrayGrow(array, Double.TYPE);
		newArray[newArray.length - 1] = element;
		return newArray;
	}

	/**
	 * <p>
	 * Copies the given array and adds the given element at the end of the new
	 * array.
	 * </p>
	 * 
	 * <p>
	 * The new array contains the same elements of the input array plus the
	 * given element in the last position. The component type of the new array
	 * is the same as that of the input array.
	 * </p>
	 * 
	 * <p>
	 * If the input array is <code>null</code>, a new one element array is
	 * returned whose component type is the same as the element.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.add(null, 0)   = [0]
	 * ArrayUtil.add([1], 0)    = [1, 0]
	 * ArrayUtil.add([1, 0], 1) = [1, 0, 1]
	 * </pre>
	 * 
	 * @param array
	 *            the array to copy and add the element to, may be
	 *            <code>null</code>
	 * @param element
	 *            the object to add at the last index of the new array
	 * @return A new array containing the existing elements plus the new element
	 * @since 2.1
	 */
	public static float[] add(float[] array, float element) {
		float[] newArray = (float[]) copyArrayGrow(array, Float.TYPE);
		newArray[newArray.length - 1] = element;
		return newArray;
	}

	/**
	 * <p>
	 * Copies the given array and adds the given element at the end of the new
	 * array.
	 * </p>
	 * 
	 * <p>
	 * The new array contains the same elements of the input array plus the
	 * given element in the last position. The component type of the new array
	 * is the same as that of the input array.
	 * </p>
	 * 
	 * <p>
	 * If the input array is <code>null</code>, a new one element array is
	 * returned whose component type is the same as the element.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.add(null, 0)   = [0]
	 * ArrayUtil.add([1], 0)    = [1, 0]
	 * ArrayUtil.add([1, 0], 1) = [1, 0, 1]
	 * </pre>
	 * 
	 * @param array
	 *            the array to copy and add the element to, may be
	 *            <code>null</code>
	 * @param element
	 *            the object to add at the last index of the new array
	 * @return A new array containing the existing elements plus the new element
	 * @since 2.1
	 */
	public static int[] add(int[] array, int element) {
		int[] newArray = (int[]) copyArrayGrow(array, Integer.TYPE);
		newArray[newArray.length - 1] = element;
		return newArray;
	}

	/**
	 * <p>
	 * Copies the given array and adds the given element at the end of the new
	 * array.
	 * </p>
	 * 
	 * <p>
	 * The new array contains the same elements of the input array plus the
	 * given element in the last position. The component type of the new array
	 * is the same as that of the input array.
	 * </p>
	 * 
	 * <p>
	 * If the input array is <code>null</code>, a new one element array is
	 * returned whose component type is the same as the element.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.add(null, 0)   = [0]
	 * ArrayUtil.add([1], 0)    = [1, 0]
	 * ArrayUtil.add([1, 0], 1) = [1, 0, 1]
	 * </pre>
	 * 
	 * @param array
	 *            the array to copy and add the element to, may be
	 *            <code>null</code>
	 * @param element
	 *            the object to add at the last index of the new array
	 * @return A new array containing the existing elements plus the new element
	 * @since 2.1
	 */
	public static long[] add(long[] array, long element) {
		long[] newArray = (long[]) copyArrayGrow(array, Long.TYPE);
		newArray[newArray.length - 1] = element;
		return newArray;
	}

	/**
	 * <p>
	 * Copies the given array and adds the given element at the end of the new
	 * array.
	 * </p>
	 * 
	 * <p>
	 * The new array contains the same elements of the input array plus the
	 * given element in the last position. The component type of the new array
	 * is the same as that of the input array.
	 * </p>
	 * 
	 * <p>
	 * If the input array is <code>null</code>, a new one element array is
	 * returned whose component type is the same as the element.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.add(null, 0)   = [0]
	 * ArrayUtil.add([1], 0)    = [1, 0]
	 * ArrayUtil.add([1, 0], 1) = [1, 0, 1]
	 * </pre>
	 * 
	 * @param array
	 *            the array to copy and add the element to, may be
	 *            <code>null</code>
	 * @param element
	 *            the object to add at the last index of the new array
	 * @return A new array containing the existing elements plus the new element
	 * @since 2.1
	 */
	public static short[] add(short[] array, short element) {
		short[] newArray = (short[]) copyArrayGrow(array, Short.TYPE);
		newArray[newArray.length - 1] = element;
		return newArray;
	}

	/**
	 * Returns a copy of the given array of size 1 greater than the argument.
	 * The last value of the array is left to the default value.
	 * 
	 * @param array
	 *            The array to copy, must not be <code>null</code>.
	 * @param newArrayComponentType
	 *            If <code>array</code> is <code>null</code>, create a size 1
	 *            array of this type.
	 * @return A new copy of the array of size 1 greater than the input.
	 */
	private static Object copyArrayGrow(Object array,
			Class<?> newArrayComponentType) {
		if (array != null) {
			int arrayLength = Array.getLength(array);
			Object newArray = Array.newInstance(array.getClass()
					.getComponentType(), arrayLength + 1);
			System.arraycopy(array, 0, newArray, 0, arrayLength);
			return newArray;
		}
		return Array.newInstance(newArrayComponentType, 1);
	}

	/**
	 * <p>
	 * Inserts the specified element at the specified position in the array.
	 * Shifts the element currently at that position (if any) and any subsequent
	 * elements to the right (adds one to their indices).
	 * </p>
	 * 
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * plus the given element on the specified position. The component type of
	 * the returned array is always the same as that of the input array.
	 * </p>
	 * 
	 * <p>
	 * If the input array is <code>null</code>, a new one element array is
	 * returned whose component type is the same as the element.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.add(null, 0, null)      = [null]
	 * ArrayUtil.add(null, 0, "a")       = ["a"]
	 * ArrayUtil.add(["a"], 1, null)     = ["a", null]
	 * ArrayUtil.add(["a"], 1, "b")      = ["a", "b"]
	 * ArrayUtil.add(["a", "b"], 3, "c") = ["a", "b", "c"]
	 * </pre>
	 * 
	 * @param array
	 *            the array to add the element to, may be <code>null</code>
	 * @param index
	 *            the position of the new object
	 * @param element
	 *            the object to add
	 * @return A new array containing the existing elements and the new element
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >
	 *             array.length).
	 */
	public static Object[] add(Object[] array, int index, Object element) {
		Class<?> clss = null;
		if (array != null) {
			clss = array.getClass().getComponentType();
		} else if (element != null) {
			clss = element.getClass();
		} else {
			return new Object[] { null };
		}
		return (Object[]) add(array, index, element, clss);
	}

	/**
	 * <p>
	 * Inserts the specified element at the specified position in the array.
	 * Shifts the element currently at that position (if any) and any subsequent
	 * elements to the right (adds one to their indices).
	 * </p>
	 * 
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * plus the given element on the specified position. The component type of
	 * the returned array is always the same as that of the input array.
	 * </p>
	 * 
	 * <p>
	 * If the input array is <code>null</code>, a new one element array is
	 * returned whose component type is the same as the element.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.add(null, 0, true)          = [true]
	 * ArrayUtil.add([true], 0, false)       = [false, true]
	 * ArrayUtil.add([false], 1, true)       = [false, true]
	 * ArrayUtil.add([true, false], 1, true) = [true, true, false]
	 * </pre>
	 * 
	 * @param array
	 *            the array to add the element to, may be <code>null</code>
	 * @param index
	 *            the position of the new object
	 * @param element
	 *            the object to add
	 * @return A new array containing the existing elements and the new element
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >
	 *             array.length).
	 */
	public static boolean[] add(boolean[] array, int index, boolean element) {
		return (boolean[]) add(array, index, (element ? Boolean.TRUE
				: Boolean.FALSE), Boolean.TYPE);
	}

	/**
	 * <p>
	 * Inserts the specified element at the specified position in the array.
	 * Shifts the element currently at that position (if any) and any subsequent
	 * elements to the right (adds one to their indices).
	 * </p>
	 * 
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * plus the given element on the specified position. The component type of
	 * the returned array is always the same as that of the input array.
	 * </p>
	 * 
	 * <p>
	 * If the input array is <code>null</code>, a new one element array is
	 * returned whose component type is the same as the element.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.add(null, 0, 'a')            = ['a']
	 * ArrayUtil.add(['a'], 0, 'b')           = ['b', 'a']
	 * ArrayUtil.add(['a', 'b'], 0, 'c')      = ['c', 'a', 'b']
	 * ArrayUtil.add(['a', 'b'], 1, 'k')      = ['a', 'k', 'b']
	 * ArrayUtil.add(['a', 'b', 'c'], 1, 't') = ['a', 't', 'b', 'c']
	 * </pre>
	 * 
	 * @param array
	 *            the array to add the element to, may be <code>null</code>
	 * @param index
	 *            the position of the new object
	 * @param element
	 *            the object to add
	 * @return A new array containing the existing elements and the new element
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >
	 *             array.length).
	 */
	public static char[] add(char[] array, int index, char element) {
		return (char[]) add(array, index, new Character(element),
				Character.TYPE);
	}

	/**
	 * <p>
	 * Inserts the specified element at the specified position in the array.
	 * Shifts the element currently at that position (if any) and any subsequent
	 * elements to the right (adds one to their indices).
	 * </p>
	 * 
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * plus the given element on the specified position. The component type of
	 * the returned array is always the same as that of the input array.
	 * </p>
	 * 
	 * <p>
	 * If the input array is <code>null</code>, a new one element array is
	 * returned whose component type is the same as the element.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.add([1], 0, 2)         = [2, 1]
	 * ArrayUtil.add([2, 6], 2, 3)      = [2, 6, 3]
	 * ArrayUtil.add([2, 6], 0, 1)      = [1, 2, 6]
	 * ArrayUtil.add([2, 6, 3], 2, 1)   = [2, 6, 1, 3]
	 * </pre>
	 * 
	 * @param array
	 *            the array to add the element to, may be <code>null</code>
	 * @param index
	 *            the position of the new object
	 * @param element
	 *            the object to add
	 * @return A new array containing the existing elements and the new element
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >
	 *             array.length).
	 */
	public static byte[] add(byte[] array, int index, byte element) {
		return (byte[]) add(array, index, new Byte(element), Byte.TYPE);
	}

	/**
	 * <p>
	 * Inserts the specified element at the specified position in the array.
	 * Shifts the element currently at that position (if any) and any subsequent
	 * elements to the right (adds one to their indices).
	 * </p>
	 * 
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * plus the given element on the specified position. The component type of
	 * the returned array is always the same as that of the input array.
	 * </p>
	 * 
	 * <p>
	 * If the input array is <code>null</code>, a new one element array is
	 * returned whose component type is the same as the element.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.add([1], 0, 2)         = [2, 1]
	 * ArrayUtil.add([2, 6], 2, 10)     = [2, 6, 10]
	 * ArrayUtil.add([2, 6], 0, -4)     = [-4, 2, 6]
	 * ArrayUtil.add([2, 6, 3], 2, 1)   = [2, 6, 1, 3]
	 * </pre>
	 * 
	 * @param array
	 *            the array to add the element to, may be <code>null</code>
	 * @param index
	 *            the position of the new object
	 * @param element
	 *            the object to add
	 * @return A new array containing the existing elements and the new element
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >
	 *             array.length).
	 */
	public static short[] add(short[] array, int index, short element) {
		return (short[]) add(array, index, new Short(element), Short.TYPE);
	}

	/**
	 * <p>
	 * Inserts the specified element at the specified position in the array.
	 * Shifts the element currently at that position (if any) and any subsequent
	 * elements to the right (adds one to their indices).
	 * </p>
	 * 
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * plus the given element on the specified position. The component type of
	 * the returned array is always the same as that of the input array.
	 * </p>
	 * 
	 * <p>
	 * If the input array is <code>null</code>, a new one element array is
	 * returned whose component type is the same as the element.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.add([1], 0, 2)         = [2, 1]
	 * ArrayUtil.add([2, 6], 2, 10)     = [2, 6, 10]
	 * ArrayUtil.add([2, 6], 0, -4)     = [-4, 2, 6]
	 * ArrayUtil.add([2, 6, 3], 2, 1)   = [2, 6, 1, 3]
	 * </pre>
	 * 
	 * @param array
	 *            the array to add the element to, may be <code>null</code>
	 * @param index
	 *            the position of the new object
	 * @param element
	 *            the object to add
	 * @return A new array containing the existing elements and the new element
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >
	 *             array.length).
	 */
	public static int[] add(int[] array, int index, int element) {
		return (int[]) add(array, index, new Integer(element), Integer.TYPE);
	}

	/**
	 * <p>
	 * Inserts the specified element at the specified position in the array.
	 * Shifts the element currently at that position (if any) and any subsequent
	 * elements to the right (adds one to their indices).
	 * </p>
	 * 
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * plus the given element on the specified position. The component type of
	 * the returned array is always the same as that of the input array.
	 * </p>
	 * 
	 * <p>
	 * If the input array is <code>null</code>, a new one element array is
	 * returned whose component type is the same as the element.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.add([1L], 0, 2L)           = [2L, 1L]
	 * ArrayUtil.add([2L, 6L], 2, 10L)      = [2L, 6L, 10L]
	 * ArrayUtil.add([2L, 6L], 0, -4L)      = [-4L, 2L, 6L]
	 * ArrayUtil.add([2L, 6L, 3L], 2, 1L)   = [2L, 6L, 1L, 3L]
	 * </pre>
	 * 
	 * @param array
	 *            the array to add the element to, may be <code>null</code>
	 * @param index
	 *            the position of the new object
	 * @param element
	 *            the object to add
	 * @return A new array containing the existing elements and the new element
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >
	 *             array.length).
	 */
	public static long[] add(long[] array, int index, long element) {
		return (long[]) add(array, index, new Long(element), Long.TYPE);
	}

	/**
	 * <p>
	 * Inserts the specified element at the specified position in the array.
	 * Shifts the element currently at that position (if any) and any subsequent
	 * elements to the right (adds one to their indices).
	 * </p>
	 * 
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * plus the given element on the specified position. The component type of
	 * the returned array is always the same as that of the input array.
	 * </p>
	 * 
	 * <p>
	 * If the input array is <code>null</code>, a new one element array is
	 * returned whose component type is the same as the element.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.add([1.1f], 0, 2.2f)               = [2.2f, 1.1f]
	 * ArrayUtil.add([2.3f, 6.4f], 2, 10.5f)        = [2.3f, 6.4f, 10.5f]
	 * ArrayUtil.add([2.6f, 6.7f], 0, -4.8f)        = [-4.8f, 2.6f, 6.7f]
	 * ArrayUtil.add([2.9f, 6.0f, 0.3f], 2, 1.0f)   = [2.9f, 6.0f, 1.0f, 0.3f]
	 * </pre>
	 * 
	 * @param array
	 *            the array to add the element to, may be <code>null</code>
	 * @param index
	 *            the position of the new object
	 * @param element
	 *            the object to add
	 * @return A new array containing the existing elements and the new element
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >
	 *             array.length).
	 */
	public static float[] add(float[] array, int index, float element) {
		return (float[]) add(array, index, new Float(element), Float.TYPE);
	}

	/**
	 * <p>
	 * Inserts the specified element at the specified position in the array.
	 * Shifts the element currently at that position (if any) and any subsequent
	 * elements to the right (adds one to their indices).
	 * </p>
	 * 
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * plus the given element on the specified position. The component type of
	 * the returned array is always the same as that of the input array.
	 * </p>
	 * 
	 * <p>
	 * If the input array is <code>null</code>, a new one element array is
	 * returned whose component type is the same as the element.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.add([1.1], 0, 2.2)              = [2.2, 1.1]
	 * ArrayUtil.add([2.3, 6.4], 2, 10.5)        = [2.3, 6.4, 10.5]
	 * ArrayUtil.add([2.6, 6.7], 0, -4.8)        = [-4.8, 2.6, 6.7]
	 * ArrayUtil.add([2.9, 6.0, 0.3], 2, 1.0)    = [2.9, 6.0, 1.0, 0.3]
	 * </pre>
	 * 
	 * @param array
	 *            the array to add the element to, may be <code>null</code>
	 * @param index
	 *            the position of the new object
	 * @param element
	 *            the object to add
	 * @return A new array containing the existing elements and the new element
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >
	 *             array.length).
	 */
	public static double[] add(double[] array, int index, double element) {
		return (double[]) add(array, index, new Double(element), Double.TYPE);
	}

	/**
	 * Underlying implementation of add(array, index, element) methods. The last
	 * parameter is the class, which may not equal element.getClass for
	 * primitives.
	 * 
	 * @param array
	 *            the array to add the element to, may be <code>null</code>
	 * @param index
	 *            the position of the new object
	 * @param element
	 *            the object to add
	 * @param clss
	 *            the type of the element being added
	 * @return A new array containing the existing elements and the new element
	 */
	private static Object add(Object array, int index, Object element,
			Class<?> clss) {
		if (array == null) {
			if (index != 0) {
				return null;
				// throw new IndexOutOfBoundsException("Index: " + index
				// + ", Length: 0");
			}
			Object joinedArray = Array.newInstance(clss, 1);
			Array.set(joinedArray, 0, element);
			return joinedArray;
		}
		int length = Array.getLength(array);
		if (index > length || index < 0) {
			return null;
			// throw new IndexOutOfBoundsException("Index: " + index
			// + ", Length: " + length);
		}
		Object result = Array.newInstance(clss, length + 1);
		System.arraycopy(array, 0, result, 0, index);
		Array.set(result, index, element);
		if (index < length) {
			System.arraycopy(array, index, result, index + 1, length - index);
		}
		return result;
	}

	// ---------------------------------------------------------------- insert

	/**
	 * Inserts one array into another.
	 */
	public static <T> T[] insert(T[] dest, T[] src, int offset) {
		return insert(dest, src, offset, null);
	}

	public static <T> T[] insert(T[] dest, T src, int offset) {
		return insert(dest, src, offset, null);
	}

	/**
	 * Inserts one array into another.
	 */
	public static <T> T[] insert(T[] dest, T[] src, int offset,
			Class<?> componentType) {
		if (dest == null || src == null) {
			return null;
		}

		if (componentType == null) {
			componentType = dest.getClass().getComponentType();
		}
		@SuppressWarnings({ "unchecked" })
		T[] temp = (T[]) Array.newInstance(componentType, dest.length
				+ src.length);
		System.arraycopy(dest, 0, temp, 0, offset);
		System.arraycopy(src, 0, temp, offset, src.length);
		System.arraycopy(dest, offset, temp, src.length + offset, dest.length
				- offset);
		return temp;
	}

	public static <T> T[] insert(T[] dest, T src, int offset,
			Class<?> componentType) {
		if (dest == null || src == null) {
			return null;
		}
		if (componentType == null) {
			componentType = dest.getClass().getComponentType();
		}
		@SuppressWarnings({ "unchecked" })
		T[] temp = (T[]) Array.newInstance(componentType, dest.length + 1);
		System.arraycopy(dest, 0, temp, 0, offset);
		temp[offset] = src;
		System.arraycopy(dest, offset, temp, offset + 1, dest.length - offset);
		return temp;
	}

	/**
	 * Inserts one array into another.
	 */
	public static String[] insert(String[] dest, String[] src, int offset) {
		if (dest == null || src == null) {
			return null;
		}
		String[] temp = new String[dest.length + src.length];
		System.arraycopy(dest, 0, temp, 0, offset);
		System.arraycopy(src, 0, temp, offset, src.length);
		System.arraycopy(dest, offset, temp, src.length + offset, dest.length
				- offset);
		return temp;
	}

	/**
	 * Inserts one element into array.
	 */
	public static String[] insert(String[] dest, String src, int offset) {
		if (dest == null || src == null) {
			return null;
		}
		String[] temp = new String[dest.length + 1];
		System.arraycopy(dest, 0, temp, 0, offset);
		temp[offset] = src;
		System.arraycopy(dest, offset, temp, offset + 1, dest.length - offset);
		return temp;
	}

	/**
	 * Inserts one array into another.
	 */
	public static byte[] insert(byte[] dest, byte[] src, int offset) {
		if (dest == null || src == null) {
			return null;
		}
		byte[] temp = new byte[dest.length + src.length];
		System.arraycopy(dest, 0, temp, 0, offset);
		System.arraycopy(src, 0, temp, offset, src.length);
		System.arraycopy(dest, offset, temp, src.length + offset, dest.length
				- offset);
		return temp;
	}

	/**
	 * Inserts one element into array.
	 */
	public static byte[] insert(byte[] dest, byte src, int offset) {
		if (dest == null) {
			return null;
		}
		byte[] temp = new byte[dest.length + 1];
		System.arraycopy(dest, 0, temp, 0, offset);
		temp[offset] = src;
		System.arraycopy(dest, offset, temp, offset + 1, dest.length - offset);
		return temp;
	}

	/**
	 * Inserts one array into another.
	 */
	public static char[] insert(char[] dest, char[] src, int offset) {
		if (dest == null || src == null) {
			return null;
		}
		char[] temp = new char[dest.length + src.length];
		System.arraycopy(dest, 0, temp, 0, offset);
		System.arraycopy(src, 0, temp, offset, src.length);
		System.arraycopy(dest, offset, temp, src.length + offset, dest.length
				- offset);
		return temp;
	}

	/**
	 * Inserts one element into array.
	 */
	public static char[] insert(char[] dest, char src, int offset) {
		if (dest == null) {
			return null;
		}
		char[] temp = new char[dest.length + 1];
		System.arraycopy(dest, 0, temp, 0, offset);
		temp[offset] = src;
		System.arraycopy(dest, offset, temp, offset + 1, dest.length - offset);
		return temp;
	}

	/**
	 * Inserts one array into another.
	 */
	public static short[] insert(short[] dest, short[] src, int offset) {
		if (dest == null || src == null) {
			return null;
		}
		short[] temp = new short[dest.length + src.length];
		System.arraycopy(dest, 0, temp, 0, offset);
		System.arraycopy(src, 0, temp, offset, src.length);
		System.arraycopy(dest, offset, temp, src.length + offset, dest.length
				- offset);
		return temp;
	}

	/**
	 * Inserts one element into array.
	 */
	public static short[] insert(short[] dest, short src, int offset) {
		if (dest == null) {
			return null;
		}
		short[] temp = new short[dest.length + 1];
		System.arraycopy(dest, 0, temp, 0, offset);
		temp[offset] = src;
		System.arraycopy(dest, offset, temp, offset + 1, dest.length - offset);
		return temp;
	}

	/**
	 * Inserts one array into another.
	 */
	public static int[] insert(int[] dest, int[] src, int offset) {
		if (dest == null || src == null) {
			return null;
		}
		int[] temp = new int[dest.length + src.length];
		System.arraycopy(dest, 0, temp, 0, offset);
		System.arraycopy(src, 0, temp, offset, src.length);
		System.arraycopy(dest, offset, temp, src.length + offset, dest.length
				- offset);
		return temp;
	}

	/**
	 * Inserts one element into array.
	 */
	public static int[] insert(int[] dest, int src, int offset) {
		if (dest == null) {
			return null;
		}
		int[] temp = new int[dest.length + 1];
		System.arraycopy(dest, 0, temp, 0, offset);
		temp[offset] = src;
		System.arraycopy(dest, offset, temp, offset + 1, dest.length - offset);
		return temp;
	}

	/**
	 * Inserts one array into another.
	 */
	public static long[] insert(long[] dest, long[] src, int offset) {
		if (dest == null || src == null) {
			return null;
		}
		long[] temp = new long[dest.length + src.length];
		System.arraycopy(dest, 0, temp, 0, offset);
		System.arraycopy(src, 0, temp, offset, src.length);
		System.arraycopy(dest, offset, temp, src.length + offset, dest.length
				- offset);
		return temp;
	}

	/**
	 * Inserts one element into array.
	 */
	public static long[] insert(long[] dest, long src, int offset) {
		if (dest == null) {
			return null;
		}
		long[] temp = new long[dest.length + 1];
		System.arraycopy(dest, 0, temp, 0, offset);
		temp[offset] = src;
		System.arraycopy(dest, offset, temp, offset + 1, dest.length - offset);
		return temp;
	}

	/**
	 * Inserts one array into another.
	 */
	public static float[] insert(float[] dest, float[] src, int offset) {
		if (dest == null || src == null) {
			return null;
		}
		float[] temp = new float[dest.length + src.length];
		System.arraycopy(dest, 0, temp, 0, offset);
		System.arraycopy(src, 0, temp, offset, src.length);
		System.arraycopy(dest, offset, temp, src.length + offset, dest.length
				- offset);
		return temp;
	}

	/**
	 * Inserts one element into array.
	 */
	public static float[] insert(float[] dest, float src, int offset) {
		if (dest == null) {
			return null;
		}
		float[] temp = new float[dest.length + 1];
		System.arraycopy(dest, 0, temp, 0, offset);
		temp[offset] = src;
		System.arraycopy(dest, offset, temp, offset + 1, dest.length - offset);
		return temp;
	}

	/**
	 * Inserts one array into another.
	 */
	public static double[] insert(double[] dest, double[] src, int offset) {
		if (dest == null || src == null) {
			return null;
		}
		double[] temp = new double[dest.length + src.length];
		System.arraycopy(dest, 0, temp, 0, offset);
		System.arraycopy(src, 0, temp, offset, src.length);
		System.arraycopy(dest, offset, temp, src.length + offset, dest.length
				- offset);
		return temp;
	}

	/**
	 * Inserts one element into array.
	 */
	public static double[] insert(double[] dest, double src, int offset) {
		if (dest == null) {
			return null;
		}
		double[] temp = new double[dest.length + 1];
		System.arraycopy(dest, 0, temp, 0, offset);
		temp[offset] = src;
		System.arraycopy(dest, offset, temp, offset + 1, dest.length - offset);
		return temp;
	}

	/**
	 * Inserts one array into another.
	 */
	public static boolean[] insert(boolean[] dest, boolean[] src, int offset) {
		if (dest == null || src == null) {
			return null;
		}
		boolean[] temp = new boolean[dest.length + src.length];
		System.arraycopy(dest, 0, temp, 0, offset);
		System.arraycopy(src, 0, temp, offset, src.length);
		System.arraycopy(dest, offset, temp, src.length + offset, dest.length
				- offset);
		return temp;
	}

	/**
	 * Inserts one element into array.
	 */
	public static boolean[] insert(boolean[] dest, boolean src, int offset) {
		if (dest == null) {
			return null;
		}
		boolean[] temp = new boolean[dest.length + 1];
		System.arraycopy(dest, 0, temp, 0, offset);
		temp[offset] = src;
		System.arraycopy(dest, offset, temp, offset + 1, dest.length - offset);
		return temp;
	}

	// ---------------------------------------------------------------- insertAt

	/**
	 * Inserts one array into another by replacing specified offset.
	 */
	public static <T> T[] insertAt(T[] dest, T[] src, int offset) {
		if (dest == null || src == null) {
			return null;
		}
		return insertAt(dest, src, offset, null);
	}

	/**
	 * Inserts one array into another by replacing specified offset.
	 */

	public static <T> T[] insertAt(T[] dest, T[] src, int offset,
			Class<?> componentType) {
		if (dest == null || src == null) {
			return null;
		}
		if (componentType == null) {
			componentType = dest.getClass().getComponentType();
		}
		@SuppressWarnings({ "unchecked" })
		T[] temp = (T[]) Array.newInstance(componentType, dest.length
				+ src.length - 1);
		System.arraycopy(dest, 0, temp, 0, offset);
		System.arraycopy(src, 0, temp, offset, src.length);
		System.arraycopy(dest, offset + 1, temp, src.length + offset,
				dest.length - offset - 1);
		return temp;
	}

	/**
	 * Inserts one array into another by replacing specified offset.
	 */
	public static String[] insertAt(String[] dest, String[] src, int offset) {
		if (dest == null || src == null) {
			return null;
		}
		String[] temp = new String[dest.length + src.length - 1];
		System.arraycopy(dest, 0, temp, 0, offset);
		System.arraycopy(src, 0, temp, offset, src.length);
		System.arraycopy(dest, offset + 1, temp, src.length + offset,
				dest.length - offset - 1);
		return temp;
	}

	/**
	 * Inserts one array into another by replacing specified offset.
	 */
	public static byte[] insertAt(byte[] dest, byte[] src, int offset) {
		if (dest == null || src == null) {
			return null;
		}
		byte[] temp = new byte[dest.length + src.length - 1];
		System.arraycopy(dest, 0, temp, 0, offset);
		System.arraycopy(src, 0, temp, offset, src.length);
		System.arraycopy(dest, offset + 1, temp, src.length + offset,
				dest.length - offset - 1);
		return temp;
	}

	/**
	 * Inserts one array into another by replacing specified offset.
	 */
	public static char[] insertAt(char[] dest, char[] src, int offset) {
		if (dest == null || src == null) {
			return null;
		}
		char[] temp = new char[dest.length + src.length - 1];
		System.arraycopy(dest, 0, temp, 0, offset);
		System.arraycopy(src, 0, temp, offset, src.length);
		System.arraycopy(dest, offset + 1, temp, src.length + offset,
				dest.length - offset - 1);
		return temp;
	}

	/**
	 * Inserts one array into another by replacing specified offset.
	 */
	public static short[] insertAt(short[] dest, short[] src, int offset) {
		if (dest == null || src == null) {
			return null;
		}
		short[] temp = new short[dest.length + src.length - 1];
		System.arraycopy(dest, 0, temp, 0, offset);
		System.arraycopy(src, 0, temp, offset, src.length);
		System.arraycopy(dest, offset + 1, temp, src.length + offset,
				dest.length - offset - 1);
		return temp;
	}

	/**
	 * Inserts one array into another by replacing specified offset.
	 */
	public static int[] insertAt(int[] dest, int[] src, int offset) {
		if (dest == null || src == null) {
			return null;
		}
		int[] temp = new int[dest.length + src.length - 1];
		System.arraycopy(dest, 0, temp, 0, offset);
		System.arraycopy(src, 0, temp, offset, src.length);
		System.arraycopy(dest, offset + 1, temp, src.length + offset,
				dest.length - offset - 1);
		return temp;
	}

	/**
	 * Inserts one array into another by replacing specified offset.
	 */
	public static long[] insertAt(long[] dest, long[] src, int offset) {
		if (dest == null || src == null) {
			return null;
		}
		long[] temp = new long[dest.length + src.length - 1];
		System.arraycopy(dest, 0, temp, 0, offset);
		System.arraycopy(src, 0, temp, offset, src.length);
		System.arraycopy(dest, offset + 1, temp, src.length + offset,
				dest.length - offset - 1);
		return temp;
	}

	/**
	 * Inserts one array into another by replacing specified offset.
	 */
	public static float[] insertAt(float[] dest, float[] src, int offset) {
		if (dest == null || src == null) {
			return null;
		}
		float[] temp = new float[dest.length + src.length - 1];
		System.arraycopy(dest, 0, temp, 0, offset);
		System.arraycopy(src, 0, temp, offset, src.length);
		System.arraycopy(dest, offset + 1, temp, src.length + offset,
				dest.length - offset - 1);
		return temp;
	}

	/**
	 * Inserts one array into another by replacing specified offset.
	 */
	public static double[] insertAt(double[] dest, double[] src, int offset) {
		if (dest == null || src == null) {
			return null;
		}
		double[] temp = new double[dest.length + src.length - 1];
		System.arraycopy(dest, 0, temp, 0, offset);
		System.arraycopy(src, 0, temp, offset, src.length);
		System.arraycopy(dest, offset + 1, temp, src.length + offset,
				dest.length - offset - 1);
		return temp;
	}

	/**
	 * Inserts one array into another by replacing specified offset.
	 */
	public static boolean[] insertAt(boolean[] dest, boolean[] src, int offset) {
		if (dest == null || src == null) {
			return null;
		}
		boolean[] temp = new boolean[dest.length + src.length - 1];
		System.arraycopy(dest, 0, temp, 0, offset);
		System.arraycopy(src, 0, temp, offset, src.length);
		System.arraycopy(dest, offset + 1, temp, src.length + offset,
				dest.length - offset - 1);
		return temp;
	}

	// ---------------------------------------------------------------- merge

	/**
	 * Merge arrays.
	 */
	public static <T> T[] merge(T[]... arrays) {
		if (arrays == null) {
			return null;
		}
		Class<?> componentType = arrays.getClass().getComponentType()
				.getComponentType();
		int length = 0;
		for (T[] array : arrays) {
			length += array.length;
		}
		@SuppressWarnings({ "unchecked" })
		T[] result = (T[]) Array.newInstance(componentType, length);

		length = 0;
		for (T[] array : arrays) {
			System.arraycopy(array, 0, result, length, array.length);
			length += array.length;
		}
		return result;
	}

	/**
	 * Merge arrays.
	 */
	public static String[] merge(String[]... arrays) {
		if (arrays == null) {
			return null;
		}
		int length = 0;
		for (String[] array : arrays) {
			length += array.length;
		}
		String[] result = new String[length];
		length = 0;
		for (String[] array : arrays) {
			System.arraycopy(array, 0, result, length, array.length);
			length += array.length;
		}
		return result;
	}

	/**
	 * Merge arrays.
	 */
	public static byte[] merge(byte[]... arrays) {
		if (arrays == null) {
			return null;
		}
		int length = 0;
		for (byte[] array : arrays) {
			length += array.length;
		}
		byte[] result = new byte[length];
		length = 0;
		for (byte[] array : arrays) {
			System.arraycopy(array, 0, result, length, array.length);
			length += array.length;
		}
		return result;
	}

	/**
	 * Merge arrays.
	 */
	public static char[] merge(char[]... arrays) {
		if (arrays == null) {
			return null;
		}
		int length = 0;
		for (char[] array : arrays) {
			length += array.length;
		}
		char[] result = new char[length];
		length = 0;
		for (char[] array : arrays) {
			System.arraycopy(array, 0, result, length, array.length);
			length += array.length;
		}
		return result;
	}

	/**
	 * Merge arrays.
	 */
	public static short[] merge(short[]... arrays) {
		if (arrays == null) {
			return null;
		}
		int length = 0;
		for (short[] array : arrays) {
			length += array.length;
		}
		short[] result = new short[length];
		length = 0;
		for (short[] array : arrays) {
			System.arraycopy(array, 0, result, length, array.length);
			length += array.length;
		}
		return result;
	}

	/**
	 * Merge arrays.
	 */
	public static int[] merge(int[]... arrays) {
		if (arrays == null) {
			return null;
		}
		int length = 0;
		for (int[] array : arrays) {
			length += array.length;
		}
		int[] result = new int[length];
		length = 0;
		for (int[] array : arrays) {
			System.arraycopy(array, 0, result, length, array.length);
			length += array.length;
		}
		return result;
	}

	/**
	 * Merge arrays.
	 */
	public static long[] merge(long[]... arrays) {
		if (arrays == null) {
			return null;
		}
		int length = 0;
		for (long[] array : arrays) {
			length += array.length;
		}
		long[] result = new long[length];
		length = 0;
		for (long[] array : arrays) {
			System.arraycopy(array, 0, result, length, array.length);
			length += array.length;
		}
		return result;
	}

	/**
	 * Merge arrays.
	 */
	public static float[] merge(float[]... arrays) {
		if (arrays == null) {
			return null;
		}
		int length = 0;
		for (float[] array : arrays) {
			length += array.length;
		}
		float[] result = new float[length];
		length = 0;
		for (float[] array : arrays) {
			System.arraycopy(array, 0, result, length, array.length);
			length += array.length;
		}
		return result;
	}

	/**
	 * Merge arrays.
	 */
	public static double[] merge(double[]... arrays) {
		if (arrays == null) {
			return null;
		}
		int length = 0;
		for (double[] array : arrays) {
			length += array.length;
		}
		double[] result = new double[length];
		length = 0;
		for (double[] array : arrays) {
			System.arraycopy(array, 0, result, length, array.length);
			length += array.length;
		}
		return result;
	}

	/**
	 * Merge arrays.
	 */
	public static boolean[] merge(boolean[]... arrays) {
		if (arrays == null) {
			return null;
		}
		int length = 0;
		for (boolean[] array : arrays) {
			length += array.length;
		}
		boolean[] result = new boolean[length];
		length = 0;
		for (boolean[] array : arrays) {
			System.arraycopy(array, 0, result, length, array.length);
			length += array.length;
		}
		return result;
	}

	/**
	 * <p>
	 * Removes the element at the specified position from the specified array.
	 * All subsequent elements are shifted to the left (substracts one from
	 * their indices).
	 * </p>
	 * 
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the element on the specified position. The component type of the
	 * returned array is always the same as that of the input array.
	 * </p>
	 * 
	 * <p>
	 * If the input array is <code>null</code>, an IndexOutOfBoundsException
	 * will be thrown, because in that case no valid index can be specified.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.remove(["a"], 0)           = []
	 * ArrayUtil.remove(["a", "b"], 0)      = ["b"]
	 * ArrayUtil.remove(["a", "b"], 1)      = ["a"]
	 * ArrayUtil.remove(["a", "b", "c"], 1) = ["a", "c"]
	 * </pre>
	 * 
	 * @param array
	 *            the array to remove the element from, may not be
	 *            <code>null</code>
	 * @param index
	 *            the position of the element to be removed
	 * @return A new array containing the existing elements except the element
	 *         at the specified position.
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >=
	 *             array.length), or if the array is <code>null</code>.
	 * @since 2.1
	 */
	public static Object[] remove(Object[] array, int index) {
		return (Object[]) remove((Object) array, index);
	}

	/**
	 * <p>
	 * Removes the first occurrence of the specified element from the specified
	 * array. All subsequent elements are shifted to the left (substracts one
	 * from their indices). If the array doesn't contains such an element, no
	 * elements are removed from the array.
	 * </p>
	 * 
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the first occurrence of the specified element. The component type
	 * of the returned array is always the same as that of the input array.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.removeElement(null, "a")            = null
	 * ArrayUtil.removeElement([], "a")              = []
	 * ArrayUtil.removeElement(["a"], "b")           = ["a"]
	 * ArrayUtil.removeElement(["a", "b"], "a")      = ["b"]
	 * ArrayUtil.removeElement(["a", "b", "a"], "a") = ["b", "a"]
	 * </pre>
	 * 
	 * @param array
	 *            the array to remove the element from, may be <code>null</code>
	 * @param element
	 *            the element to be removed
	 * @return A new array containing the existing elements except the first
	 *         occurrence of the specified element.
	 * @since 2.1
	 */
	public static Object[] removeElement(Object[] array, Object element) {
		int index = indexOf(array, element);
		if (index == INDEX_NOT_FOUND) {
			return clone(array);
		}
		return remove(array, index);
	}

	/**
	 * <p>
	 * Removes the element at the specified position from the specified array.
	 * All subsequent elements are shifted to the left (substracts one from
	 * their indices).
	 * </p>
	 * 
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the element on the specified position. The component type of the
	 * returned array is always the same as that of the input array.
	 * </p>
	 * 
	 * <p>
	 * If the input array is <code>null</code>, an IndexOutOfBoundsException
	 * will be thrown, because in that case no valid index can be specified.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.remove([true], 0)              = []
	 * ArrayUtil.remove([true, false], 0)       = [false]
	 * ArrayUtil.remove([true, false], 1)       = [true]
	 * ArrayUtil.remove([true, true, false], 1) = [true, false]
	 * </pre>
	 * 
	 * @param array
	 *            the array to remove the element from, may not be
	 *            <code>null</code>
	 * @param index
	 *            the position of the element to be removed
	 * @return A new array containing the existing elements except the element
	 *         at the specified position.
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >=
	 *             array.length), or if the array is <code>null</code>.
	 * @since 2.1
	 */
	public static boolean[] remove(boolean[] array, int index) {
		return (boolean[]) remove((Object) array, index);
	}

	/**
	 * <p>
	 * Removes the first occurrence of the specified element from the specified
	 * array. All subsequent elements are shifted to the left (substracts one
	 * from their indices). If the array doesn't contains such an element, no
	 * elements are removed from the array.
	 * </p>
	 * 
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the first occurrence of the specified element. The component type
	 * of the returned array is always the same as that of the input array.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.removeElement(null, true)                = null
	 * ArrayUtil.removeElement([], true)                  = []
	 * ArrayUtil.removeElement([true], false)             = [true]
	 * ArrayUtil.removeElement([true, false], false)      = [true]
	 * ArrayUtil.removeElement([true, false, true], true) = [false, true]
	 * </pre>
	 * 
	 * @param array
	 *            the array to remove the element from, may be <code>null</code>
	 * @param element
	 *            the element to be removed
	 * @return A new array containing the existing elements except the first
	 *         occurrence of the specified element.
	 * @since 2.1
	 */
	public static boolean[] removeElement(boolean[] array, boolean element) {
		int index = indexOf(array, element);
		if (index == INDEX_NOT_FOUND) {
			return clone(array);
		}
		return remove(array, index);
	}

	/**
	 * <p>
	 * Removes the element at the specified position from the specified array.
	 * All subsequent elements are shifted to the left (substracts one from
	 * their indices).
	 * </p>
	 * 
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the element on the specified position. The component type of the
	 * returned array is always the same as that of the input array.
	 * </p>
	 * 
	 * <p>
	 * If the input array is <code>null</code>, an IndexOutOfBoundsException
	 * will be thrown, because in that case no valid index can be specified.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.remove([1], 0)          = []
	 * ArrayUtil.remove([1, 0], 0)       = [0]
	 * ArrayUtil.remove([1, 0], 1)       = [1]
	 * ArrayUtil.remove([1, 0, 1], 1)    = [1, 1]
	 * </pre>
	 * 
	 * @param array
	 *            the array to remove the element from, may not be
	 *            <code>null</code>
	 * @param index
	 *            the position of the element to be removed
	 * @return A new array containing the existing elements except the element
	 *         at the specified position.
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >=
	 *             array.length), or if the array is <code>null</code>.
	 * @since 2.1
	 */
	public static byte[] remove(byte[] array, int index) {
		return (byte[]) remove((Object) array, index);
	}

	/**
	 * <p>
	 * Removes the first occurrence of the specified element from the specified
	 * array. All subsequent elements are shifted to the left (substracts one
	 * from their indices). If the array doesn't contains such an element, no
	 * elements are removed from the array.
	 * </p>
	 * 
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the first occurrence of the specified element. The component type
	 * of the returned array is always the same as that of the input array.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.removeElement(null, 1)        = null
	 * ArrayUtil.removeElement([], 1)          = []
	 * ArrayUtil.removeElement([1], 0)         = [1]
	 * ArrayUtil.removeElement([1, 0], 0)      = [1]
	 * ArrayUtil.removeElement([1, 0, 1], 1)   = [0, 1]
	 * </pre>
	 * 
	 * @param array
	 *            the array to remove the element from, may be <code>null</code>
	 * @param element
	 *            the element to be removed
	 * @return A new array containing the existing elements except the first
	 *         occurrence of the specified element.
	 * @since 2.1
	 */
	public static byte[] removeElement(byte[] array, byte element) {
		int index = indexOf(array, element);
		if (index == INDEX_NOT_FOUND) {
			return clone(array);
		}
		return remove(array, index);
	}

	/**
	 * <p>
	 * Removes the element at the specified position from the specified array.
	 * All subsequent elements are shifted to the left (substracts one from
	 * their indices).
	 * </p>
	 * 
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the element on the specified position. The component type of the
	 * returned array is always the same as that of the input array.
	 * </p>
	 * 
	 * <p>
	 * If the input array is <code>null</code>, an IndexOutOfBoundsException
	 * will be thrown, because in that case no valid index can be specified.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.remove(['a'], 0)           = []
	 * ArrayUtil.remove(['a', 'b'], 0)      = ['b']
	 * ArrayUtil.remove(['a', 'b'], 1)      = ['a']
	 * ArrayUtil.remove(['a', 'b', 'c'], 1) = ['a', 'c']
	 * </pre>
	 * 
	 * @param array
	 *            the array to remove the element from, may not be
	 *            <code>null</code>
	 * @param index
	 *            the position of the element to be removed
	 * @return A new array containing the existing elements except the element
	 *         at the specified position.
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >=
	 *             array.length), or if the array is <code>null</code>.
	 * @since 2.1
	 */
	public static char[] remove(char[] array, int index) {
		return (char[]) remove((Object) array, index);
	}

	/**
	 * <p>
	 * Removes the first occurrence of the specified element from the specified
	 * array. All subsequent elements are shifted to the left (substracts one
	 * from their indices). If the array doesn't contains such an element, no
	 * elements are removed from the array.
	 * </p>
	 * 
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the first occurrence of the specified element. The component type
	 * of the returned array is always the same as that of the input array.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.removeElement(null, 'a')            = null
	 * ArrayUtil.removeElement([], 'a')              = []
	 * ArrayUtil.removeElement(['a'], 'b')           = ['a']
	 * ArrayUtil.removeElement(['a', 'b'], 'a')      = ['b']
	 * ArrayUtil.removeElement(['a', 'b', 'a'], 'a') = ['b', 'a']
	 * </pre>
	 * 
	 * @param array
	 *            the array to remove the element from, may be <code>null</code>
	 * @param element
	 *            the element to be removed
	 * @return A new array containing the existing elements except the first
	 *         occurrence of the specified element.
	 * @since 2.1
	 */
	public static char[] removeElement(char[] array, char element) {
		int index = indexOf(array, element);
		if (index == INDEX_NOT_FOUND) {
			return clone(array);
		}
		return remove(array, index);
	}

	/**
	 * <p>
	 * Removes the element at the specified position from the specified array.
	 * All subsequent elements are shifted to the left (substracts one from
	 * their indices).
	 * </p>
	 * 
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the element on the specified position. The component type of the
	 * returned array is always the same as that of the input array.
	 * </p>
	 * 
	 * <p>
	 * If the input array is <code>null</code>, an IndexOutOfBoundsException
	 * will be thrown, because in that case no valid index can be specified.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.remove([1.1], 0)           = []
	 * ArrayUtil.remove([2.5, 6.0], 0)      = [6.0]
	 * ArrayUtil.remove([2.5, 6.0], 1)      = [2.5]
	 * ArrayUtil.remove([2.5, 6.0, 3.8], 1) = [2.5, 3.8]
	 * </pre>
	 * 
	 * @param array
	 *            the array to remove the element from, may not be
	 *            <code>null</code>
	 * @param index
	 *            the position of the element to be removed
	 * @return A new array containing the existing elements except the element
	 *         at the specified position.
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >=
	 *             array.length), or if the array is <code>null</code>.
	 * @since 2.1
	 */
	public static double[] remove(double[] array, int index) {
		return (double[]) remove((Object) array, index);
	}

	/**
	 * <p>
	 * Removes the first occurrence of the specified element from the specified
	 * array. All subsequent elements are shifted to the left (substracts one
	 * from their indices). If the array doesn't contains such an element, no
	 * elements are removed from the array.
	 * </p>
	 * 
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the first occurrence of the specified element. The component type
	 * of the returned array is always the same as that of the input array.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.removeElement(null, 1.1)            = null
	 * ArrayUtil.removeElement([], 1.1)              = []
	 * ArrayUtil.removeElement([1.1], 1.2)           = [1.1]
	 * ArrayUtil.removeElement([1.1, 2.3], 1.1)      = [2.3]
	 * ArrayUtil.removeElement([1.1, 2.3, 1.1], 1.1) = [2.3, 1.1]
	 * </pre>
	 * 
	 * @param array
	 *            the array to remove the element from, may be <code>null</code>
	 * @param element
	 *            the element to be removed
	 * @return A new array containing the existing elements except the first
	 *         occurrence of the specified element.
	 * @since 2.1
	 */
	public static double[] removeElement(double[] array, double element) {
		int index = indexOf(array, element);
		if (index == INDEX_NOT_FOUND) {
			return clone(array);
		}
		return remove(array, index);
	}

	/**
	 * <p>
	 * Removes the element at the specified position from the specified array.
	 * All subsequent elements are shifted to the left (substracts one from
	 * their indices).
	 * </p>
	 * 
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the element on the specified position. The component type of the
	 * returned array is always the same as that of the input array.
	 * </p>
	 * 
	 * <p>
	 * If the input array is <code>null</code>, an IndexOutOfBoundsException
	 * will be thrown, because in that case no valid index can be specified.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.remove([1.1], 0)           = []
	 * ArrayUtil.remove([2.5, 6.0], 0)      = [6.0]
	 * ArrayUtil.remove([2.5, 6.0], 1)      = [2.5]
	 * ArrayUtil.remove([2.5, 6.0, 3.8], 1) = [2.5, 3.8]
	 * </pre>
	 * 
	 * @param array
	 *            the array to remove the element from, may not be
	 *            <code>null</code>
	 * @param index
	 *            the position of the element to be removed
	 * @return A new array containing the existing elements except the element
	 *         at the specified position.
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >=
	 *             array.length), or if the array is <code>null</code>.
	 * @since 2.1
	 */
	public static float[] remove(float[] array, int index) {
		return (float[]) remove((Object) array, index);
	}

	/**
	 * <p>
	 * Removes the first occurrence of the specified element from the specified
	 * array. All subsequent elements are shifted to the left (substracts one
	 * from their indices). If the array doesn't contains such an element, no
	 * elements are removed from the array.
	 * </p>
	 * 
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the first occurrence of the specified element. The component type
	 * of the returned array is always the same as that of the input array.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.removeElement(null, 1.1)            = null
	 * ArrayUtil.removeElement([], 1.1)              = []
	 * ArrayUtil.removeElement([1.1], 1.2)           = [1.1]
	 * ArrayUtil.removeElement([1.1, 2.3], 1.1)      = [2.3]
	 * ArrayUtil.removeElement([1.1, 2.3, 1.1], 1.1) = [2.3, 1.1]
	 * </pre>
	 * 
	 * @param array
	 *            the array to remove the element from, may be <code>null</code>
	 * @param element
	 *            the element to be removed
	 * @return A new array containing the existing elements except the first
	 *         occurrence of the specified element.
	 * @since 2.1
	 */
	public static float[] removeElement(float[] array, float element) {
		int index = indexOf(array, element);
		if (index == INDEX_NOT_FOUND) {
			return clone(array);
		}
		return remove(array, index);
	}

	/**
	 * <p>
	 * Removes the element at the specified position from the specified array.
	 * All subsequent elements are shifted to the left (substracts one from
	 * their indices).
	 * </p>
	 * 
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the element on the specified position. The component type of the
	 * returned array is always the same as that of the input array.
	 * </p>
	 * 
	 * <p>
	 * If the input array is <code>null</code>, an IndexOutOfBoundsException
	 * will be thrown, because in that case no valid index can be specified.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.remove([1], 0)         = []
	 * ArrayUtil.remove([2, 6], 0)      = [6]
	 * ArrayUtil.remove([2, 6], 1)      = [2]
	 * ArrayUtil.remove([2, 6, 3], 1)   = [2, 3]
	 * </pre>
	 * 
	 * @param array
	 *            the array to remove the element from, may not be
	 *            <code>null</code>
	 * @param index
	 *            the position of the element to be removed
	 * @return A new array containing the existing elements except the element
	 *         at the specified position.
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >=
	 *             array.length), or if the array is <code>null</code>.
	 * @since 2.1
	 */
	public static int[] remove(int[] array, int index) {
		return (int[]) remove((Object) array, index);
	}

	/**
	 * <p>
	 * Removes the first occurrence of the specified element from the specified
	 * array. All subsequent elements are shifted to the left (substracts one
	 * from their indices). If the array doesn't contains such an element, no
	 * elements are removed from the array.
	 * </p>
	 * 
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the first occurrence of the specified element. The component type
	 * of the returned array is always the same as that of the input array.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.removeElement(null, 1)      = null
	 * ArrayUtil.removeElement([], 1)        = []
	 * ArrayUtil.removeElement([1], 2)       = [1]
	 * ArrayUtil.removeElement([1, 3], 1)    = [3]
	 * ArrayUtil.removeElement([1, 3, 1], 1) = [3, 1]
	 * </pre>
	 * 
	 * @param array
	 *            the array to remove the element from, may be <code>null</code>
	 * @param element
	 *            the element to be removed
	 * @return A new array containing the existing elements except the first
	 *         occurrence of the specified element.
	 * @since 2.1
	 */
	public static int[] removeElement(int[] array, int element) {
		int index = indexOf(array, element);
		if (index == INDEX_NOT_FOUND) {
			return clone(array);
		}
		return remove(array, index);
	}

	/**
	 * <p>
	 * Removes the element at the specified position from the specified array.
	 * All subsequent elements are shifted to the left (substracts one from
	 * their indices).
	 * </p>
	 * 
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the element on the specified position. The component type of the
	 * returned array is always the same as that of the input array.
	 * </p>
	 * 
	 * <p>
	 * If the input array is <code>null</code>, an IndexOutOfBoundsException
	 * will be thrown, because in that case no valid index can be specified.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.remove([1], 0)         = []
	 * ArrayUtil.remove([2, 6], 0)      = [6]
	 * ArrayUtil.remove([2, 6], 1)      = [2]
	 * ArrayUtil.remove([2, 6, 3], 1)   = [2, 3]
	 * </pre>
	 * 
	 * @param array
	 *            the array to remove the element from, may not be
	 *            <code>null</code>
	 * @param index
	 *            the position of the element to be removed
	 * @return A new array containing the existing elements except the element
	 *         at the specified position.
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >=
	 *             array.length), or if the array is <code>null</code>.
	 * @since 2.1
	 */
	public static long[] remove(long[] array, int index) {
		return (long[]) remove((Object) array, index);
	}

	/**
	 * <p>
	 * Removes the first occurrence of the specified element from the specified
	 * array. All subsequent elements are shifted to the left (substracts one
	 * from their indices). If the array doesn't contains such an element, no
	 * elements are removed from the array.
	 * </p>
	 * 
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the first occurrence of the specified element. The component type
	 * of the returned array is always the same as that of the input array.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.removeElement(null, 1)      = null
	 * ArrayUtil.removeElement([], 1)        = []
	 * ArrayUtil.removeElement([1], 2)       = [1]
	 * ArrayUtil.removeElement([1, 3], 1)    = [3]
	 * ArrayUtil.removeElement([1, 3, 1], 1) = [3, 1]
	 * </pre>
	 * 
	 * @param array
	 *            the array to remove the element from, may be <code>null</code>
	 * @param element
	 *            the element to be removed
	 * @return A new array containing the existing elements except the first
	 *         occurrence of the specified element.
	 * @since 2.1
	 */
	public static long[] removeElement(long[] array, long element) {
		int index = indexOf(array, element);
		if (index == INDEX_NOT_FOUND) {
			return clone(array);
		}
		return remove(array, index);
	}

	/**
	 * <p>
	 * Removes the element at the specified position from the specified array.
	 * All subsequent elements are shifted to the left (substracts one from
	 * their indices).
	 * </p>
	 * 
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the element on the specified position. The component type of the
	 * returned array is always the same as that of the input array.
	 * </p>
	 * 
	 * <p>
	 * If the input array is <code>null</code>, an IndexOutOfBoundsException
	 * will be thrown, because in that case no valid index can be specified.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.remove([1], 0)         = []
	 * ArrayUtil.remove([2, 6], 0)      = [6]
	 * ArrayUtil.remove([2, 6], 1)      = [2]
	 * ArrayUtil.remove([2, 6, 3], 1)   = [2, 3]
	 * </pre>
	 * 
	 * @param array
	 *            the array to remove the element from, may not be
	 *            <code>null</code>
	 * @param index
	 *            the position of the element to be removed
	 * @return A new array containing the existing elements except the element
	 *         at the specified position.
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >=
	 *             array.length), or if the array is <code>null</code>.
	 * @since 2.1
	 */
	public static short[] remove(short[] array, int index) {
		return (short[]) remove((Object) array, index);
	}

	/**
	 * <p>
	 * Removes the first occurrence of the specified element from the specified
	 * array. All subsequent elements are shifted to the left (substracts one
	 * from their indices). If the array doesn't contains such an element, no
	 * elements are removed from the array.
	 * </p>
	 * 
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the first occurrence of the specified element. The component type
	 * of the returned array is always the same as that of the input array.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.removeElement(null, 1)      = null
	 * ArrayUtil.removeElement([], 1)        = []
	 * ArrayUtil.removeElement([1], 2)       = [1]
	 * ArrayUtil.removeElement([1, 3], 1)    = [3]
	 * ArrayUtil.removeElement([1, 3, 1], 1) = [3, 1]
	 * </pre>
	 * 
	 * @param array
	 *            the array to remove the element from, may be <code>null</code>
	 * @param element
	 *            the element to be removed
	 * @return A new array containing the existing elements except the first
	 *         occurrence of the specified element.
	 * @since 2.1
	 */
	public static short[] removeElement(short[] array, short element) {
		int index = indexOf(array, element);
		if (index == INDEX_NOT_FOUND) {
			return clone(array);
		}
		return remove(array, index);
	}

	/**
	 * <p>
	 * Removes the element at the specified position from the specified array.
	 * All subsequent elements are shifted to the left (substracts one from
	 * their indices).
	 * </p>
	 * 
	 * <p>
	 * This method returns a new array with the same elements of the input array
	 * except the element on the specified position. The component type of the
	 * returned array is always the same as that of the input array.
	 * </p>
	 * 
	 * <p>
	 * If the input array is <code>null</code>, an IndexOutOfBoundsException
	 * will be thrown, because in that case no valid index can be specified.
	 * </p>
	 * 
	 * @param array
	 *            the array to remove the element from, may not be
	 *            <code>null</code>
	 * @param index
	 *            the position of the element to be removed
	 * @return A new array containing the existing elements except the element
	 *         at the specified position.
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >=
	 *             array.length), or if the array is <code>null</code>.
	 * @since 2.1
	 */
	private static Object remove(Object array, int index) {
		int length = getLength(array);
		if (index < 0 || index >= length) {
			throw new IndexOutOfBoundsException("Index: " + index
					+ ", Length: " + length);
		}

		Object result = Array.newInstance(array.getClass().getComponentType(),
				length - 1);
		System.arraycopy(array, 0, result, 0, index);
		if (index < length - 1) {
			System.arraycopy(array, index + 1, result, index, length - index
					- 1);
		}

		return result;
	}

	/**
	 * Removes subarray.
	 */
	public static <T> T[] remove(T[] buffer, int offset, int length) {
		return remove(buffer, offset, length, null);
	}

	/**
	 * Removes subarray.
	 */
	public static <T> T[] remove(T[] buffer, int offset, int length,
			Class<?> componentType) {
		if (buffer == null) {
			return null;
		}
		if (componentType == null) {
			componentType = buffer.getClass().getComponentType();
		}
		int len2 = buffer.length - length;
		@SuppressWarnings({ "unchecked" })
		T[] temp = (T[]) Array.newInstance(componentType, len2);
		System.arraycopy(buffer, 0, temp, 0, offset);
		System.arraycopy(buffer, offset + length, temp, offset, len2 - offset);
		return temp;
	}

	/**
	 * Removes subarray.
	 */
	public static String[] remove(String[] buffer, int offset, int length) {
		if (buffer == null) {
			return null;
		}
		int len2 = buffer.length - length;
		String temp[] = new String[len2];
		System.arraycopy(buffer, 0, temp, 0, offset);
		System.arraycopy(buffer, offset + length, temp, offset, len2 - offset);
		return temp;
	}

	/**
	 * Removes subarray.
	 */
	public static byte[] remove(byte[] buffer, int offset, int length) {
		if (buffer == null) {
			return null;
		}
		int len2 = buffer.length - length;
		byte temp[] = new byte[len2];
		System.arraycopy(buffer, 0, temp, 0, offset);
		System.arraycopy(buffer, offset + length, temp, offset, len2 - offset);
		return temp;
	}

	/**
	 * Removes subarray.
	 */
	public static char[] remove(char[] buffer, int offset, int length) {
		if (buffer == null) {
			return null;
		}
		int len2 = buffer.length - length;
		char temp[] = new char[len2];
		System.arraycopy(buffer, 0, temp, 0, offset);
		System.arraycopy(buffer, offset + length, temp, offset, len2 - offset);
		return temp;
	}

	/**
	 * Removes subarray.
	 */
	public static short[] remove(short[] buffer, int offset, int length) {
		if (buffer == null) {
			return null;
		}
		int len2 = buffer.length - length;
		short temp[] = new short[len2];
		System.arraycopy(buffer, 0, temp, 0, offset);
		System.arraycopy(buffer, offset + length, temp, offset, len2 - offset);
		return temp;
	}

	/**
	 * Removes subarray.
	 */
	public static int[] remove(int[] buffer, int offset, int length) {
		if (buffer == null) {
			return null;
		}
		int len2 = buffer.length - length;
		int temp[] = new int[len2];
		System.arraycopy(buffer, 0, temp, 0, offset);
		System.arraycopy(buffer, offset + length, temp, offset, len2 - offset);
		return temp;
	}

	/**
	 * Removes subarray.
	 */
	public static long[] remove(long[] buffer, int offset, int length) {
		if (buffer == null) {
			return null;
		}
		int len2 = buffer.length - length;
		long temp[] = new long[len2];
		System.arraycopy(buffer, 0, temp, 0, offset);
		System.arraycopy(buffer, offset + length, temp, offset, len2 - offset);
		return temp;
	}

	/**
	 * Removes subarray.
	 */
	public static float[] remove(float[] buffer, int offset, int length) {
		if (buffer == null) {
			return null;
		}
		int len2 = buffer.length - length;
		float temp[] = new float[len2];
		System.arraycopy(buffer, 0, temp, 0, offset);
		System.arraycopy(buffer, offset + length, temp, offset, len2 - offset);
		return temp;
	}

	/**
	 * Removes subarray.
	 */
	public static double[] remove(double[] buffer, int offset, int length) {
		if (buffer == null) {
			return null;
		}
		int len2 = buffer.length - length;
		double temp[] = new double[len2];
		System.arraycopy(buffer, 0, temp, 0, offset);
		System.arraycopy(buffer, offset + length, temp, offset, len2 - offset);
		return temp;
	}

	/**
	 * Removes subarray.
	 */
	public static boolean[] remove(boolean[] buffer, int offset, int length) {
		if (buffer == null) {
			return null;
		}
		int len2 = buffer.length - length;
		boolean temp[] = new boolean[len2];
		System.arraycopy(buffer, 0, temp, 0, offset);
		System.arraycopy(buffer, offset + length, temp, offset, len2 - offset);
		return temp;
	}

	/**
	 * <p>
	 * Returns the length of the specified array. This method can deal with
	 * <code>Object</code> arrays and with primitive arrays.
	 * </p>
	 * 
	 * <p>
	 * If the input array is <code>null</code>, <code>0</code> is returned.
	 * </p>
	 * 
	 * <pre>
	 * ArrayUtil.getLength(null)            = 0
	 * ArrayUtil.getLength([])              = 0
	 * ArrayUtil.getLength([null])          = 1
	 * ArrayUtil.getLength([true, false])   = 2
	 * ArrayUtil.getLength([1, 2, 3])       = 3
	 * ArrayUtil.getLength(["a", "b", "c"]) = 3
	 * </pre>
	 * 
	 * @param array
	 *            the array to retrieve the length from, may be null
	 * @return The length of the array, or <code>0</code> if the array is
	 *         <code>null</code>
	 * @throws IllegalArgumentException
	 *             if the object arguement is not an array.
	 * @since 2.1
	 */
	public static int getLength(Object array) {
		if (array == null) {
			return 0;
		}
		return Array.getLength(array);
	}

	// ---------------------------------------------------------------- resize

	/**
	 * Resizes an array.
	 */
	public static <T> T[] resize(T[] buffer, int newSize) {
		return resize(buffer, newSize, null);
	}

	/**
	 * Resizes an array.
	 */
	@SuppressWarnings({ "unchecked" })
	public static <T> T[] resize(T[] buffer, int newSize, Class<?> componentType) {
		if (buffer == null || newSize < 0) {
			return null;
		}
		if (componentType == null) {
			componentType = buffer.getClass().getComponentType();
		}
		T[] temp = (T[]) Array.newInstance(componentType, newSize);
		System.arraycopy(buffer, 0, temp, 0, buffer.length >= newSize ? newSize
				: buffer.length);
		return temp;
	}

	/**
	 * Resizes an array.
	 */
	public static String[] resize(String buffer[], int newSize) {
		if (buffer == null || newSize < 0) {
			return null;
		}
		String temp[] = new String[newSize];
		System.arraycopy(buffer, 0, temp, 0, buffer.length >= newSize ? newSize
				: buffer.length);
		return temp;
	}

	/**
	 * Resizes an array.
	 */
	public static byte[] resize(byte buffer[], int newSize) {
		if (buffer == null || newSize < 0) {
			return null;
		}
		byte temp[] = new byte[newSize];
		System.arraycopy(buffer, 0, temp, 0, buffer.length >= newSize ? newSize
				: buffer.length);
		return temp;
	}

	/**
	 * Resizes an array.
	 */
	public static char[] resize(char buffer[], int newSize) {
		if (buffer == null || newSize < 0) {
			return null;
		}
		char temp[] = new char[newSize];
		System.arraycopy(buffer, 0, temp, 0, buffer.length >= newSize ? newSize
				: buffer.length);
		return temp;
	}

	/**
	 * Resizes an array.
	 */
	public static short[] resize(short buffer[], int newSize) {
		if (buffer == null || newSize < 0) {
			return null;
		}
		short temp[] = new short[newSize];
		System.arraycopy(buffer, 0, temp, 0, buffer.length >= newSize ? newSize
				: buffer.length);
		return temp;
	}

	/**
	 * Resizes an array.
	 */
	public static int[] resize(int buffer[], int newSize) {
		if (buffer == null || newSize < 0) {
			return null;
		}
		int temp[] = new int[newSize];
		System.arraycopy(buffer, 0, temp, 0, buffer.length >= newSize ? newSize
				: buffer.length);
		return temp;
	}

	/**
	 * Resizes an array.
	 */
	public static long[] resize(long buffer[], int newSize) {
		if (buffer == null || newSize < 0) {
			return null;
		}
		long temp[] = new long[newSize];
		System.arraycopy(buffer, 0, temp, 0, buffer.length >= newSize ? newSize
				: buffer.length);
		return temp;
	}

	/**
	 * Resizes an array.
	 */
	public static float[] resize(float buffer[], int newSize) {
		if (buffer == null || newSize < 0) {
			return null;
		}
		float temp[] = new float[newSize];
		System.arraycopy(buffer, 0, temp, 0, buffer.length >= newSize ? newSize
				: buffer.length);
		return temp;
	}

	/**
	 * Resizes an array.
	 */
	public static double[] resize(double buffer[], int newSize) {
		if (buffer == null || newSize < 0) {
			return null;
		}
		double temp[] = new double[newSize];
		System.arraycopy(buffer, 0, temp, 0, buffer.length >= newSize ? newSize
				: buffer.length);
		return temp;
	}

	/**
	 * Resizes an array.
	 */
	public static boolean[] resize(boolean buffer[], int newSize) {
		if (buffer == null || newSize < 0) {
			return null;
		}
		boolean temp[] = new boolean[newSize];
		System.arraycopy(buffer, 0, temp, 0, buffer.length >= newSize ? newSize
				: buffer.length);
		return temp;
	}

	// ---------------------------------------------------------------- convert

	/**
	 * Converts to primitive array.
	 */
	public static byte[] values(Byte[] array) {
		if (array == null) {
			return null;
		}
		byte[] dest = new byte[array.length];
		for (int i = 0; i < array.length; i++) {
			Byte v = array[i];
			if (v != null) {
				dest[i] = v.byteValue();
			}
		}
		return dest;
	}

	/**
	 * Converts to object array.
	 */
	public static Byte[] valuesOf(byte[] array) {
		if (array == null) {
			return null;
		}
		Byte[] dest = new Byte[array.length];
		for (int i = 0; i < array.length; i++) {
			dest[i] = Byte.valueOf(array[i]);
		}
		return dest;
	}

	/**
	 * Converts to primitive array.
	 */
	public static char[] values(Character[] array) {
		if (array == null) {
			return null;
		}
		char[] dest = new char[array.length];
		for (int i = 0; i < array.length; i++) {
			Character v = array[i];
			if (v != null) {
				dest[i] = v.charValue();
			}
		}
		return dest;
	}

	/**
	 * Converts to object array.
	 */
	public static Character[] valuesOf(char[] array) {
		if (array == null) {
			return null;
		}
		Character[] dest = new Character[array.length];
		for (int i = 0; i < array.length; i++) {
			dest[i] = Character.valueOf(array[i]);
		}
		return dest;
	}

	/**
	 * Converts to primitive array.
	 */
	public static short[] values(Short[] array) {
		if (array == null) {
			return null;
		}
		short[] dest = new short[array.length];
		for (int i = 0; i < array.length; i++) {
			Short v = array[i];
			if (v != null) {
				dest[i] = v.shortValue();
			}
		}
		return dest;
	}

	/**
	 * Converts to object array.
	 */
	public static Short[] valuesOf(short[] array) {
		if (array == null) {
			return null;
		}
		Short[] dest = new Short[array.length];
		for (int i = 0; i < array.length; i++) {
			dest[i] = Short.valueOf(array[i]);
		}
		return dest;
	}

	/**
	 * Converts to primitive array.
	 */
	public static int[] values(Integer[] array) {
		if (array == null) {
			return null;
		}
		int[] dest = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			Integer v = array[i];
			if (v != null) {
				dest[i] = v.intValue();
			}
		}
		return dest;
	}

	/**
	 * Converts to object array.
	 */
	public static Integer[] valuesOf(int[] array) {
		if (array == null) {
			return null;
		}
		Integer[] dest = new Integer[array.length];
		for (int i = 0; i < array.length; i++) {
			dest[i] = Integer.valueOf(array[i]);
		}
		return dest;
	}

	/**
	 * Converts to primitive array.
	 */
	public static long[] values(Long[] array) {
		if (array == null) {
			return null;
		}
		long[] dest = new long[array.length];
		for (int i = 0; i < array.length; i++) {
			Long v = array[i];
			if (v != null) {
				dest[i] = v.longValue();
			}
		}
		return dest;
	}

	/**
	 * Converts to object array.
	 */
	public static Long[] valuesOf(long[] array) {
		if (array == null) {
			return null;
		}
		Long[] dest = new Long[array.length];
		for (int i = 0; i < array.length; i++) {
			dest[i] = Long.valueOf(array[i]);
		}
		return dest;
	}

	/**
	 * Converts to primitive array.
	 */
	public static float[] values(Float[] array) {
		if (array == null) {
			return null;
		}
		float[] dest = new float[array.length];
		for (int i = 0; i < array.length; i++) {
			Float v = array[i];
			if (v != null) {
				dest[i] = v.floatValue();
			}
		}
		return dest;
	}

	/**
	 * Converts to object array.
	 */
	public static Float[] valuesOf(float[] array) {
		if (array == null) {
			return null;
		}
		Float[] dest = new Float[array.length];
		for (int i = 0; i < array.length; i++) {
			dest[i] = Float.valueOf(array[i]);
		}
		return dest;
	}

	/**
	 * Converts to primitive array.
	 */
	public static double[] values(Double[] array) {
		if (array == null) {
			return null;
		}
		double[] dest = new double[array.length];
		for (int i = 0; i < array.length; i++) {
			Double v = array[i];
			if (v != null) {
				dest[i] = v.doubleValue();
			}
		}
		return dest;
	}

	/**
	 * Converts to object array.
	 */
	public static Double[] valuesOf(double[] array) {
		if (array == null) {
			return null;
		}
		Double[] dest = new Double[array.length];
		for (int i = 0; i < array.length; i++) {
			dest[i] = Double.valueOf(array[i]);
		}
		return dest;
	}

	/**
	 * Converts to primitive array.
	 */
	public static boolean[] values(Boolean[] array) {
		if (array == null) {
			return null;
		}
		boolean[] dest = new boolean[array.length];
		for (int i = 0; i < array.length; i++) {
			Boolean v = array[i];
			if (v != null) {
				dest[i] = v.booleanValue();
			}
		}
		return dest;
	}

	/**
	 * Converts to object array.
	 */
	public static Boolean[] valuesOf(boolean[] array) {
		if (array == null) {
			return null;
		}
		Boolean[] dest = new Boolean[array.length];
		for (int i = 0; i < array.length; i++) {
			dest[i] = Boolean.valueOf(array[i]);
		}
		return dest;
	}

	/**
	 * Append the given object to the given array, returning a new array
	 * consisting of the input array contents plus the given object.
	 * 
	 * @param array
	 *            the array to append to (can be <code>null</code>)
	 * @param obj
	 *            the object to append
	 * @return the new array (of the same component type; never
	 *         <code>null</code>)
	 */
	public static <A, O extends A> A[] addObjectToArray(A[] array, O obj) {
		Class<?> compType = Object.class;
		if (array != null) {
			compType = array.getClass().getComponentType();
		} else if (obj != null) {
			compType = obj.getClass();
		}
		int newArrLength = (array != null ? array.length + 1 : 1);
		@SuppressWarnings("unchecked")
		A[] newArr = (A[]) Array.newInstance(compType, newArrLength);
		if (array != null) {
			System.arraycopy(array, 0, newArr, 0, array.length);
		}
		newArr[newArr.length - 1] = obj;
		return newArr;
	}

	/**
	 * Convert the given array (which may be a primitive array) to an object
	 * array (if necessary of primitive wrapper objects).
	 * <p>
	 * A <code>null</code> source value will be converted to an empty Object
	 * array.
	 * 
	 * @param source
	 *            the (potentially primitive) array
	 * @return the corresponding object array (never <code>null</code>)
	 * @throws IllegalArgumentException
	 *             if the parameter is not an array
	 */
	public static Object[] toObjectArray(Object source) {
		if (source == null) {
			return null;
		}
		if (!source.getClass().isArray()) {
			throw new IllegalArgumentException("Source is not an array: "
					+ source);
		}

		if (source instanceof Object[]) {
			return (Object[]) source;
		}
		int length = Array.getLength(source);
		if (length == 0) {
			return new Object[0];
		}
		Class<?> wrapperType = Array.get(source, 0).getClass();
		Object[] newArray = (Object[]) Array.newInstance(wrapperType, length);
		for (int i = 0; i < length; i++) {
			newArray[i] = Array.get(source, i);
		}
		return newArray;
	}

}
