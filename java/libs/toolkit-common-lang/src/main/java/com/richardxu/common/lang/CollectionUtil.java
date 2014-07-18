/**
 * 
 */
package com.richardxu.common.lang;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.WeakHashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 有关集合处理的工具类。
 * 
 * <p>
 * 这个类中的每个方法都可以“安全”地处理 <code>null</code> ，而不会抛出
 * <code>NullPointerException</code>。
 * </p>
 * 
 * @author <a href="mailto:xuc@iphonele.com">saga67</a>
 * @version create on 2011-5-17 下午03:32:25
 */
public class CollectionUtil {

	public CollectionUtil() {

	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* 常用的集合 */
	/*
	 * ==========================================================================
	 * ==
	 */

	/**
	 * 获取<code>ArrayList</code>实例
	 * 
	 * @param <E>
	 * @return <code>ArrayList</code>实例
	 */
	public static <E> ArrayList<E> getArrayList() {
		return new ArrayList<E>();
	}

	/**
	 * 获取<code>ArrayList</code>实例
	 * 
	 * @param <E>
	 * @param initialCapacity
	 *            初始化容量
	 * @return <code>ArrayList</code>实例
	 */
	public static <E> ArrayList<E> getArrayList(int initialCapacity) {
		return new ArrayList<E>(initialCapacity);
	}

	/**
	 * 获取<code>ArrayList</code>实例
	 * 
	 * @param <E>
	 * @param collection
	 *            集合 @see Collection
	 * @return <code>ArrayList</code>实例
	 */
	public static <E> ArrayList<E> getArrayList(
			Collection<? extends E> collection) {
		return new ArrayList<E>(collection);
	}

	/**
	 * 获取<code>LinkedList</code>实例
	 * 
	 * @param <E>
	 * @param collection
	 *            集合 @see Collection
	 * @return <code>LinkedList</code>实例
	 */
	public static <E> LinkedList<E> getLinkedList() {
		return new LinkedList<E>();
	}

	/**
	 * 获取<code>LinkedList</code>实例
	 * 
	 * @param <E>
	 * @return <code>LinkedList</code>实例
	 */
	public static <E> LinkedList<E> getLinkedList(
			Collection<? extends E> collection) {
		return new LinkedList<E>(collection);
	}

	/**
	 * 获取<code>HashSet</code>实例
	 * 
	 * @param <E>
	 * @return <code>HashSet</code>实例
	 */
	public static <E> HashSet<E> getHashSet() {
		return new HashSet<E>();
	}

	/**
	 * 获取<code>HashSet</code>实例
	 * 
	 * @param <E>
	 * @param initialCapacity
	 *            初始化容量
	 * @return <code>HashSet</code>实例
	 */
	public static <E> HashSet<E> getHashSet(int initialCapacity) {
		return new HashSet<E>(initialCapacity);
	}

	/**
	 * 获取<code>HashSet</code>实例
	 * 
	 * @param <E>
	 * @param collection
	 *            集合 @see Collection
	 * @return <code>HashSet</code>实例
	 */
	public static <E> HashSet<E> getHashSet(Collection<? extends E> collection) {
		return new HashSet<E>(collection);
	}

	/**
	 * 获取<code>HashSet</code>实例
	 * 
	 * @param <E>
	 * @param initialCapacity
	 *            初始化容量
	 * @param loadFactor
	 *            加载因子
	 * @return <code>HashSet</code>实例
	 */
	public static <E> HashSet<E> getHashSet(int initialCapacity,
			float loadFactor) {
		return new HashSet<E>(initialCapacity, loadFactor);
	}

	/**
	 * 获取<code>LinkedHashSet</code>实例
	 * 
	 * @param <E>
	 * @return <code>LinkedHashSet</code>实例
	 */
	public static <E> LinkedHashSet<E> getLinkedHashSet() {
		return new LinkedHashSet<E>();
	}

	/**
	 * 获取<code>LinkedHashSet</code>实例
	 * 
	 * @param <E>
	 * @param initialCapacity
	 *            初始化容量
	 * @return <code>LinkedHashSet</code>实例
	 */
	public static <E> LinkedHashSet<E> getLinkedHashSet(int initialCapacity) {
		return new LinkedHashSet<E>(initialCapacity);
	}

	/**
	 * 获取<code>TreeSet</code>实例
	 * 
	 * @param <E>
	 * @return <code>TreeSet</code>实例
	 */
	public static <E> TreeSet<E> getTreeSet() {
		return new TreeSet<E>();
	}

	/**
	 * 获取<code>TreeSet</code>实例
	 * 
	 * @param <E>
	 * @param collection
	 *            集合 @see Collection
	 * @return <code>TreeSet</code>实例
	 */
	public static <E> TreeSet<E> getTreeSet(Collection<? extends E> collection) {
		return new TreeSet<E>(collection);
	}

	/**
	 * 获取<code>TreeSet</code>实例
	 * 
	 * @param <E>
	 * @param comparator
	 *            比较器 @see Comparator
	 * @return <code>TreeSet</code>实例
	 */
	public static <E> TreeSet<E> getTreeSet(Comparator<? super E> comparator) {
		return new TreeSet<E>(comparator);
	}

	/**
	 * 获取<code>TreeSet</code>实例
	 * 
	 * @param <E>
	 * @param set
	 *            排序的散列 @see SortedSet
	 * @return <code>TreeSet</code>实例
	 */
	public static <E> TreeSet<E> getTreeSet(SortedSet<E> set) {
		return new TreeSet<E>(set);
	}

	public static <E extends Enum<E>> EnumSet<E> getEnumSet(Collection<E> c) {
		return EnumSet.copyOf(c);
	}

	public static <E extends Enum<E>> EnumSet<E> getEnumSet(Class<E> elementType) {
		return EnumSet.allOf(elementType);
	}

	/**
	 * 获取<code>HashMap</code>实例
	 * 
	 * @param <K>
	 * @param <V>
	 * @return <code>HashMap</code>实例
	 */
	public static <K, V> HashMap<K, V> getHashMap() {
		return new HashMap<K, V>();
	}

	/**
	 * 获取<code>HashMap</code>实例
	 * 
	 * @param <K>
	 * @param <V>
	 * @param initialCapacity
	 *            初始化容量
	 * @return <code>HashMap</code>实例
	 */
	public static <K, V> HashMap<K, V> getHashMap(int initialCapacity) {
		return new HashMap<K, V>(initialCapacity);
	}

	/**
	 * 获取<code>HashMap</code>实例
	 * 
	 * @param <K>
	 * @param <V>
	 * @param map
	 *            映射表 @see Map
	 * @return <code>HashMap</code>实例
	 */
	public static <K, V> HashMap<K, V> getHashMap(
			Map<? extends K, ? extends V> map) {
		return new HashMap<K, V>(map);
	}

	/**
	 * 获取<code>HashMap</code>实例
	 * 
	 * @param <K>
	 * @param <V>
	 * @param initialCapacity
	 *            初始化容量
	 * @param loadFactor
	 *            加载因子
	 * @return <code>HashMap</code>实例
	 */
	public static <K, V> HashMap<K, V> getHashMap(int initialCapacity,
			float loadFactor) {
		return new HashMap<K, V>(initialCapacity, loadFactor);
	}

	/**
	 * 获取<code>LinkedHashMap</code>实例
	 * 
	 * @param <K>
	 * @param <V>
	 * @return <code>LinkedHashMap</code>实例
	 */
	public static <K, V> LinkedHashMap<K, V> getLinkedHashMap() {
		return new LinkedHashMap<K, V>();
	}

	/**
	 * 获取<code>LinkedHashMap</code>实例
	 * 
	 * @param <K>
	 * @param <V>
	 * @param initialCapacity
	 *            初始化容量
	 * @return <code>LinkedHashMap</code>实例
	 */
	public static <K, V> LinkedHashMap<K, V> getLinkedHashMap(
			int initialCapacity) {
		return new LinkedHashMap<K, V>(initialCapacity);
	}

	/**
	 * 获取<code>LinkedHashMap</code>实例
	 * 
	 * @param <K>
	 * @param <V>
	 * @param map
	 *            映射表 @see Map
	 * @return <code>HashMap</code>实例
	 */
	public static <K, V> LinkedHashMap<K, V> getLinkedHashMap(
			Map<? extends K, ? extends V> map) {
		return new LinkedHashMap<K, V>(map);
	}

	/**
	 * 获取<code>LinkedHashMap</code>实例
	 * 
	 * @param <K>
	 * @param <V>
	 * @param initialCapacity
	 *            初始化容量
	 * @param loadFactor
	 *            加载因子
	 * @return <code>LinkedHashMap</code>实例
	 */
	public static <K, V> LinkedHashMap<K, V> getLinkedHashMap(
			int initialCapacity, float loadFactor) {
		return new LinkedHashMap<K, V>(initialCapacity, loadFactor);
	}

	/**
	 * 获取<code>TreeMap</code>实例
	 * 
	 * @param <K>
	 * @param <V>
	 * @return <code>TreeMap</code>实例
	 */
	public static <K, V> TreeMap<K, V> getTreeMap() {
		return new TreeMap<K, V>();
	}

	/**
	 * 获取<code>TreeMap</code>实例
	 * 
	 * @param <K>
	 * @param <V>
	 * @param comparator
	 *            比较器 @see Comparator
	 * @return <code>TreeMap</code>实例
	 */
	public static <K, V> TreeMap<K, V> getTreeMap(
			Comparator<? super K> comparator) {
		return new TreeMap<K, V>(comparator);
	}

	/**
	 * 获取<code>TreeMap</code>实例
	 * 
	 * @param <K>
	 * @param <V>
	 * @param map
	 *            映射表 @see Map
	 * @return <code>TreeMap</code>实例
	 */
	public static <K, V> TreeMap<K, V> getTreeMap(
			Map<? extends K, ? extends V> map) {
		return new TreeMap<K, V>(map);
	}

	/**
	 * 获取<code>TreeMap</code>实例
	 * 
	 * @param <K>
	 * @param <V>
	 * @param map
	 *            排序的映射表 @see Map
	 * @return <code>TreeMap</code>实例
	 */
	public static <K, V> TreeMap<K, V> getTreeMap(SortedMap<K, ? extends V> map) {
		return new TreeMap<K, V>(map);
	}

	/**
	 * 获取<code>WeakHashMap</code>实例
	 * 
	 * @param <K>
	 * @param <V>
	 * @return <code>WeakHashMap</code>实例
	 */
	public static <K, V> WeakHashMap<K, V> getWeakHashMap() {
		return new WeakHashMap<K, V>();
	}

	/**
	 * 获取<code>WeakHashMap</code>实例
	 * 
	 * @param <K>
	 * @param <V>
	 * @param initialCapacity
	 *            初始化容量
	 * @return <code>WeakHashMap</code>实例
	 */
	public static <K, V> WeakHashMap<K, V> getWeakHashMap(int initialCapacity) {
		return new WeakHashMap<K, V>(initialCapacity);
	}

	/**
	 * 获取<code>WeakHashMap</code>实例
	 * 
	 * @param <K>
	 * @param <V>
	 * @param map
	 *            映射表 @see Map
	 * @return <code>WeakHashMap</code>实例
	 */
	public static <K, V> WeakHashMap<K, V> getWeakHashMap(
			Map<? extends K, ? extends V> map) {
		return new WeakHashMap<K, V>(map);
	}

	/**
	 * 获取<code>WeakHashMap</code>实例
	 * 
	 * @param <K>
	 * @param <V>
	 * @param initialCapacity
	 *            初始化容量
	 * @param loadFactor
	 *            加载因子
	 * @return <code>WeakHashMap</code>实例
	 */
	public static <K, V> WeakHashMap<K, V> getWeakHashMap(int initialCapacity,
			float loadFactor) {
		return new WeakHashMap<K, V>(initialCapacity, loadFactor);
	}

	/**
	 * 获取<code>IdentityHashMap</code>实例
	 * 
	 * @param <K>
	 * @param <V>
	 * @return <code>IdentityHashMap</code>实例
	 */
	public static <K, V> IdentityHashMap<K, V> getIdentityHashMap() {
		return new IdentityHashMap<K, V>();
	}

	/**
	 * 获取<code>IdentityHashMap</code>实例
	 * 
	 * @param <K>
	 * @param <V>
	 * @param initialCapacity
	 *            初始化容量
	 * @return <code>IdentityHashMap</code>实例
	 */
	public static <K, V> IdentityHashMap<K, V> getIdentityHashMap(
			int initialCapacity) {
		return new IdentityHashMap<K, V>(initialCapacity);
	}

	/**
	 * 获取<code>IdentityHashMap</code>实例
	 * 
	 * @param <K>
	 * @param <V>
	 * @param map
	 *            映射表 @see Map
	 * @return <code>IdentityHashMap</code>实例
	 */
	public static <K, V> IdentityHashMap<K, V> getIdentityHashMap(
			Map<? extends K, ? extends V> map) {
		return new IdentityHashMap<K, V>(map);
	}

	public static <K extends Enum<K>, V> EnumMap<K, V> getEnumMap(
			Class<K> keyType) {
		return new EnumMap<K, V>(keyType);
	}

	public static <K extends Enum<K>, V> EnumMap<K, V> getEnumMap(
			Map<K, ? extends V> map) {
		return new EnumMap<K, V>(map);
	}

	/**
	 * 获取<code>PriorityQueue</code>实例
	 * 
	 * @param <E>
	 * @return <code>PriorityQueue</code>实例
	 */
	public static <E> PriorityQueue<E> getPriorityQueue() {
		return new PriorityQueue<E>();
	}

	/**
	 * 获取<code>PriorityQueue</code>实例
	 * 
	 * @param <E>
	 * @param initialCapacity
	 *            初始化容量
	 * @return <code>PriorityQueue</code>实例
	 */
	public static <E> PriorityQueue<E> getPriorityQueue(int initialCapacity) {
		return new PriorityQueue<E>(initialCapacity);
	}

	/**
	 * 获取<code>PriorityQueue</code>实例
	 * 
	 * @param <E>
	 * @param collection
	 *            集合 @see Collection
	 * @return <code>PriorityQueue</code>实例
	 */
	public static <E> PriorityQueue<E> getPriorityQueue(
			Collection<? extends E> collection) {
		return new PriorityQueue<E>(collection);
	}

	/**
	 * 获取<code>PriorityQueue</code>实例
	 * 
	 * @param <E>
	 * @param initialCapacity
	 *            初始化容量
	 * @param comparator
	 *            比较器 @see Comparator
	 * @return <code>PriorityQueue</code>实例
	 */
	public static <E> PriorityQueue<E> getPriorityQueue(int initialCapacity,
			Comparator<? super E> comparator) {
		return new PriorityQueue<E>(initialCapacity, comparator);
	}

	/**
	 * 获取<code>PriorityQueue</code>实例
	 * 
	 * @param <E>
	 * @param queue
	 *            队列 @see PriorityQueue
	 * @return <code>PriorityQueue</code>实例
	 */
	public static <E> PriorityQueue<E> getPriorityQueue(
			PriorityQueue<? extends E> queue) {
		return new PriorityQueue<E>(queue);
	}

	/**
	 * 获取<code>PriorityQueue</code>实例
	 * 
	 * @param <E>
	 * @param set
	 *            排序的散列 @see SortedSet
	 * @return <code>PriorityQueue</code>实例
	 */
	public static <E> PriorityQueue<E> getPriorityQueue(
			SortedSet<? extends E> set) {
		return new PriorityQueue<E>(set);
	}

	/**
	 * 获取<code>ArrayDeque</code>实例
	 * 
	 * @param <E>
	 * @return <code>ArrayDeque</code>实例
	 */
	public static <E> ArrayDeque<E> getArrayQueue() {
		return new ArrayDeque<E>();
	}

	/**
	 * 获取<code>ArrayDeque</code>实例
	 * 
	 * @param <E>
	 * @param collection
	 *            集合 @see Collection
	 * @return <code>ArrayDeque</code>实例
	 */
	public static <E> ArrayDeque<E> getArrayQueue(
			Collection<? extends E> collection) {
		return new ArrayDeque<E>(collection);
	}

	/**
	 * 获取<code>ArrayDeque</code>实例
	 * 
	 * @param <E>
	 * @param initialCapacity
	 *            初始化容量
	 * @return <code>ArrayDeque</code>实例
	 */
	public static <E> ArrayDeque<E> getArrayQueue(int initialCapacity) {
		return new ArrayDeque<E>(initialCapacity);
	}

	/**
	 * 获取<code>ArrayDeque</code>实例
	 * 
	 * @param <E>
	 * @return <code>ArrayDeque</code>实例
	 */
	public static <E> ArrayDeque<E> getArrayDeque() {
		return new ArrayDeque<E>();
	}

	/**
	 * 获取<code>ArrayDeque</code>实例
	 * 
	 * @param <E>
	 * @param collection
	 *            集合 @see Collection
	 * @return <code>ArrayDeque</code>实例
	 */
	public static <E> ArrayDeque<E> getArrayDeque(
			Collection<? extends E> collection) {
		return new ArrayDeque<E>(collection);
	}

	/**
	 * 获取<code>ArrayDeque</code>实例
	 * 
	 * @param <E>
	 * @param initialCapacity
	 *            初始化容量
	 * @return <code>ArrayDeque</code>实例
	 */
	public static <E> ArrayDeque<E> getArrayDeque(int initialCapacity) {
		return new ArrayDeque<E>(initialCapacity);
	}

	/**
	 * 获取<code>BitSet</code>实例
	 * 
	 * @param <E>
	 * @return <code>BitSet</code>实例
	 */
	public static <E> BitSet getBitSet() {
		return new BitSet();
	}

	/**
	 * 获取<code>BitSet</code>实例
	 * 
	 * @param <E>
	 * @param initialCapacity
	 *            初始化容量
	 * @return <code>BitSet</code>实例
	 */
	public static <E> BitSet getBitSet(int initialCapacity) {
		return new BitSet();
	}

	/**
	 * 判断<code>Map</code>是否为<code>null</code>或空<code>{}</code>
	 * 
	 * @param map
	 * @see Map
	 * @return 如果为空, 则返回<code>true</code>
	 */
	public static boolean isEmpty(Map<?, ?> map) {
		return (map == null) || (map.size() == 0);
	}

	/**
	 * 判断<code>Collection</code>是否为<code>null</code>或空数组<code>[]</code>。
	 * 
	 * @param collection
	 * @see Collection
	 * @return 如果为空, 则返回<code>true</code>
	 */
	public static boolean isEmpty(Collection<?> collection) {
		return (collection == null) || (collection.size() == 0);
	}

	/**
	 * 判断Map是否不为<code>null</code>和空<code>{}</code>
	 * 
	 * @param map
	 * @return 如果不为空, 则返回<code>true</code>
	 */
	public static boolean isNotEmpty(Map<?, ?> map) {
		return (map != null) && (map.size() > 0);
	}

	/**
	 * 判断Collection是否不为<code>null</code>和空数组<code>[]</code>。
	 * 
	 * @param collection
	 * @return 如果不为空, 则返回<code>true</code>
	 */
	public static boolean isNotEmpty(Collection<?> collection) {
		return (collection != null) && (collection.size() > 0);
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* 枚举集合 */
	/*
	 * ==========================================================================
	 * ==
	 */

	/*
	 * ==========================================================================
	 * ==
	 */
	/* 控制并发的集合 */
	/*
	 * ==========================================================================
	 * ==
	 */
	/**
	 * 获取<code>ConcurrentMap</code>实例
	 * 
	 * @param <K>
	 * @param <V>
	 * @return <code>ConcurrentMap</code>实例
	 */
	public static <K, V> ConcurrentMap<K, V> getConcurrentMap() {
		return new ConcurrentHashMap<K, V>();
	}

	/**
	 * 获取<code>ConcurrentMap</code>实例
	 * 
	 * @param <K>
	 * @param <V>
	 * @param initialCapacity
	 *            初始化容量
	 * @return <code>ConcurrentMap</code>实例
	 */
	public static <K, V> ConcurrentMap<K, V> getConcurrentMap(
			int initialCapacity) {
		return new ConcurrentHashMap<K, V>(initialCapacity);
	}

	/**
	 * 获取<code>ConcurrentMap</code>实例
	 * 
	 * @param <K>
	 * @param <V>
	 * @param map
	 *            映射表 @see Map
	 * @return <code>ConcurrentMap</code>实例
	 */
	public static <K, V> ConcurrentMap<K, V> getConcurrentMap(
			Map<? extends K, ? extends V> map) {
		return new ConcurrentHashMap<K, V>(map);
	}

	/**
	 * 获取<code>ConcurrentMap</code>实例
	 * 
	 * @param <K>
	 * @param <V>
	 * @param initialCapacity
	 *            初始化容量
	 * @param loadFactor
	 *            加载因子
	 * @return <code>ConcurrentMap</code>实例
	 */
	public static <K, V> ConcurrentMap<K, V> getConcurrentMap(
			int initialCapacity, float loadFactor) {
		return new ConcurrentHashMap<K, V>(initialCapacity, loadFactor);
	}

	/**
	 * 获取<code>ConcurrentSkipListMap</code>实例
	 * 
	 * @param <K>
	 * @param <V>
	 * @return <code>ConcurrentSkipListMap</code>实例
	 */
	public static <K, V> ConcurrentSkipListMap<K, V> getConcurrentSkipListMap() {
		return new ConcurrentSkipListMap<K, V>();
	}

	/**
	 * 获取<code>ConcurrentSkipListMap</code>实例
	 * 
	 * @param <K>
	 * @param <V>
	 * @param comparator
	 *            比较器 @see Comparator
	 * @return <code>ConcurrentSkipListMap</code>实例
	 */
	public static <K, V> ConcurrentSkipListMap<K, V> getConcurrentSkipListMap(
			Comparator<? super K> comparator) {
		return new ConcurrentSkipListMap<K, V>(comparator);
	}

	/**
	 * 获取<code>ConcurrentSkipListMap</code>实例
	 * 
	 * @param <K>
	 * @param <V>
	 * @param map
	 *            映射表 @see Map
	 * @return <code>ConcurrentSkipListMap</code>实例
	 */
	public static <K, V> ConcurrentSkipListMap<K, V> getConcurrentSkipListMap(
			Map<? extends K, ? extends V> map) {
		return new ConcurrentSkipListMap<K, V>(map);
	}

	/**
	 * 获取<code>ConcurrentSkipListMap</code>实例
	 * 
	 * @param <K>
	 * @param <V>
	 * @param map
	 *            排序的映射表 @see SortedMap
	 * @return <code>ConcurrentSkipListMap</code>实例
	 */
	public static <K, V> ConcurrentSkipListMap<K, V> getConcurrentSkipListMap(
			SortedMap<? extends K, ? extends V> map) {
		return new ConcurrentSkipListMap<K, V>(map);
	}

	/**
	 * 获取<code>ConcurrentSkipListSet</code>实例
	 * 
	 * @param <K>
	 * @param <V>
	 * @return <code>ConcurrentSkipListSet</code>实例
	 */
	public static <E> ConcurrentSkipListSet<E> getConcurrentSkipListSet() {
		return new ConcurrentSkipListSet<E>();
	}

	/**
	 * 获取<code>ConcurrentSkipListSet</code>实例
	 * 
	 * @param <K>
	 * @param <V>
	 * @param collection
	 *            集合 @see Collection
	 * @return <code>ConcurrentSkipListSet</code>实例
	 */
	public static <E> ConcurrentSkipListSet<E> getConcurrentSkipListSet(
			Collection<? extends E> collection) {
		return new ConcurrentSkipListSet<E>(collection);
	}

	/**
	 * 获取<code>ConcurrentSkipListSet</code>实例
	 * 
	 * @param <K>
	 * @param <V>
	 * @param comparator
	 *            比较器 @see Comparator
	 * @return <code>ConcurrentSkipListSet</code>实例
	 */
	public static <E> ConcurrentSkipListSet<E> getConcurrentSkipListSet(
			Comparator<? super E> comparator) {
		return new ConcurrentSkipListSet<E>(comparator);
	}

	/**
	 * 获取<code>ConcurrentSkipListSet</code>实例
	 * 
	 * @param <K>
	 * @param <V>
	 * @param set
	 *            可排序的散列 @see SortedSet
	 * @return <code>ConcurrentSkipListSet</code>实例
	 */
	public static <E> ConcurrentSkipListSet<E> getConcurrentSkipListSet(
			SortedSet<E> set) {
		return new ConcurrentSkipListSet<E>(set);
	}

	/**
	 * 获取<code>ConcurrentLinkedQueue</code>实例
	 * 
	 * @param <E>
	 * @return <code>ConcurrentLinkedQueue</code>实例
	 */
	public static <E> Queue<E> getConcurrentLinkedQueue() {
		return new ConcurrentLinkedQueue<E>();
	}

	/**
	 * 获取<code>ConcurrentLinkedQueue</code>实例
	 * 
	 * @param <E>
	 * @param collection
	 *            集合 @see Collection
	 * @return <code>ConcurrentLinkedQueue</code>实例
	 */
	public static <E> Queue<E> getConcurrentLinkedQueue(
			Collection<? extends E> collection) {
		return new ConcurrentLinkedQueue<E>(collection);
	}

	/**
	 * 获取<code>CopyOnWriteArrayList</code>实例
	 * 
	 * @param <E>
	 * @return <code>CopyOnWriteArrayList</code>实例
	 */
	public static <E> CopyOnWriteArrayList<E> getCopyOnWriteArrayList() {
		return new CopyOnWriteArrayList<E>();
	}

	/**
	 * 获取<code>CopyOnWriteArrayList</code>实例
	 * 
	 * @param <E>
	 * @param collection
	 *            集合 @see Collection
	 * 
	 * @return <code>CopyOnWriteArrayList</code>实例
	 */
	public static <E> CopyOnWriteArrayList<E> getCopyOnWriteArrayList(
			Collection<? extends E> collection) {
		return new CopyOnWriteArrayList<E>();
	}

	/**
	 * 获取<code>CopyOnWriteArrayList</code>实例
	 * 
	 * @param <E>
	 * @param toCopyIn
	 *            创建一个保存给定数组的副本的数组
	 * 
	 * @return <code>CopyOnWriteArrayList</code>实例
	 */
	public static <E> CopyOnWriteArrayList<E> getCopyOnWriteArrayList(
			E[] toCopyIn) {
		return new CopyOnWriteArrayList<E>(toCopyIn);
	}

	/**
	 * 获取<code>CopyOnWriteArraySet</code>实例
	 * 
	 * @param <E>
	 * @return <code>CopyOnWriteArraySet</code>实例
	 */
	public static <E> CopyOnWriteArraySet<E> getCopyOnWriteArraySet() {
		return new CopyOnWriteArraySet<E>();
	}

	/**
	 * 获取<code>CopyOnWriteArraySet</code>实例
	 * 
	 * @param <E>
	 * @param collection
	 *            集合 @see Collection
	 * 
	 * @return <code>CopyOnWriteArraySet</code>实例
	 */
	public static <E> CopyOnWriteArraySet<E> getCopyOnWriteArraySet(
			Collection<? extends E> collection) {
		return new CopyOnWriteArraySet<E>();
	}

	public static <E> BlockingQueue<E> getLinkedBlockingQueue() {
		return new LinkedBlockingQueue<E>();
	}

	public static <E> BlockingQueue<E> getLinkedBlockingQueue(int capacity) {
		return new LinkedBlockingQueue<E>(capacity);
	}

	public static <E> BlockingQueue<E> getLinkedBlockingQueue(
			Collection<? extends E> collection) {
		return new LinkedBlockingQueue<E>(collection);
	}

	// ========this is the Java Collection failings====================//

	public static <K, V> Map<K, V> synchronizedHashMap() {
		return Collections.synchronizedMap(new HashMap<K, V>());
	}

	/*
	 * ==========================================================================
	 * ==
	 */
	/* 来点实际的 */
	/*
	 * ==========================================================================
	 * ==
	 */

	/** Constant to avoid repeated object creation */
	private static Integer INTEGER_ONE = new Integer(1);

	/**
	 * Returns a {@link Collection} containing the union of the given
	 * {@link Collection}s.
	 * <p>
	 * The cardinality of each element in the returned {@link Collection} will
	 * be equal to the maximum of the cardinality of that element in the two
	 * given {@link Collection}s.
	 * 
	 * @param a
	 *            the first collection, must not be null
	 * @param b
	 *            the second collection, must not be null
	 * @return the union of the two collections
	 * @see Collection#addAll
	 */
	public static <E> Collection<E> union(final Collection<E> a,
			final Collection<E> b) {
		if (a == null) {
			return b;
		}

		if (b == null) {
			return a;
		}

		List<E> list = getArrayList();
		Map<E, Integer> mapa = getCardinalityMap(a);
		Map<E, Integer> mapb = getCardinalityMap(b);
		Set<E> elts = getHashSet(a);
		elts.addAll(b);
		for (E e : elts) {
			for (int i = 0, m = Math.max(getFreq(e, mapa), getFreq(e, mapb)); i < m; i++) {
				list.add(e);
			}
		}
		return list;
	}

	/**
	 * Returns a {@link Map} mapping each unique element in the given
	 * {@link Collection} to an {@link Integer} representing the number of
	 * occurrences of that element in the {@link Collection}.
	 * <p>
	 * Only those elements present in the collection will appear as keys in the
	 * map.
	 * 
	 * @param coll
	 *            the collection to get the cardinality map for, must not be
	 *            null
	 * @return the populated cardinality map
	 */
	public static <E> Map<E, Integer> getCardinalityMap(final Collection<E> coll) {
		if (coll == null) {
			return null;
		}
		Map<E, Integer> count = getHashMap();
		for (E e : coll) {
			Integer c = count.get(e);
			if (c == null) {
				count.put(e, INTEGER_ONE);
			} else {
				count.put(e, new Integer(c.intValue() + 1));
			}

		}

		return count;
	}

	private static final <E> int getFreq(final E obj,
			final Map<E, Integer> freqMap) {
		Integer count = freqMap.get(obj);
		if (count != null) {
			return count.intValue();
		}
		return 0;
	}

	/**
	 * Returns a {@link Collection} containing the intersection of the given
	 * {@link Collection}s.
	 * <p>
	 * The cardinality of each element in the returned {@link Collection} will
	 * be equal to the minimum of the cardinality of that element in the two
	 * given {@link Collection}s.
	 * 
	 * @param a
	 *            the first collection, must not be null
	 * @param b
	 *            the second collection, must not be null
	 * @return the intersection of the two collections
	 * @see Collection#retainAll
	 * @see #containsAny
	 */
	public static <E> Collection<E> intersection(final Collection<E> a,
			final Collection<E> b) {
		if (a == null || b == null) {
			return null;
		}
		List<E> list = getArrayList();
		Map<E, Integer> mapa = getCardinalityMap(a);
		Map<E, Integer> mapb = getCardinalityMap(b);
		Set<E> elts = getHashSet(a);
		elts.addAll(b);
		for (E e : elts) {
			for (int i = 0, m = Math.min(getFreq(e, mapa), getFreq(e, mapb)); i < m; i++) {
				list.add(e);
			}
		}

		return list;
	}

	/**
	 * Returns a {@link Collection} containing the exclusive disjunction
	 * (symmetric difference) of the given {@link Collection}s.
	 * <p>
	 * The cardinality of each element <i>e</i> in the returned
	 * {@link Collection} will be equal to
	 * <tt>max(cardinality(<i>e</i>,<i>a</i>),cardinality(<i>e</i>,<i>b</i>)) - min(cardinality(<i>e</i>,<i>a</i>),cardinality(<i>e</i>,<i>b</i>))</tt>.
	 * <p>
	 * This is equivalent to
	 * <tt>{@link #subtract subtract}({@link #union union(a,b)},{@link #intersection intersection(a,b)})</tt>
	 * or
	 * <tt>{@link #union union}({@link #subtract subtract(a,b)},{@link #subtract subtract(b,a)})</tt>.
	 * 
	 * @param a
	 *            the first collection, must not be null
	 * @param b
	 *            the second collection, must not be null
	 * @return the symmetric difference of the two collections
	 */
	public static <E> Collection<E> disjunction(final Collection<E> a,
			final Collection<E> b) {
		if (a == null || b == null) {
			return null;
		}
		List<E> list = getArrayList();
		Map<E, Integer> mapa = getCardinalityMap(a);
		Map<E, Integer> mapb = getCardinalityMap(b);
		Set<E> elts = getHashSet(a);
		elts.addAll(b);
		for (E e : elts) {
			for (int i = 0, m = ((Math.max(getFreq(e, mapa), getFreq(e, mapb))) - (Math
					.min(getFreq(e, mapa), getFreq(e, mapb)))); i < m; i++) {
				list.add(e);
			}
		}

		return list;
	}

	/**
	 * Returns a new {@link Collection} containing <tt><i>a</i> - <i>b</i></tt>.
	 * The cardinality of each element <i>e</i> in the returned
	 * {@link Collection} will be the cardinality of <i>e</i> in <i>a</i> minus
	 * the cardinality of <i>e</i> in <i>b</i>, or zero, whichever is greater.
	 * 
	 * @param a
	 *            the collection to subtract from, must not be null
	 * @param b
	 *            the collection to subtract, must not be null
	 * @return a new collection with the results
	 * @see Collection#removeAll
	 */
	public static <E> Collection<E> subtract(final Collection<E> a,
			final Collection<E> b) {
		if (a == null || b == null) {
			return null;
		}
		List<E> list = getArrayList(a);
		for (E e : list) {
			list.remove(e);
		}

		return list;
	}

	/**
	 * Returns <code>true</code> iff at least one element is in both
	 * collections.
	 * <p>
	 * In other words, this method returns <code>true</code> iff the
	 * {@link #intersection} of <i>coll1</i> and <i>coll2</i> is not empty.
	 * 
	 * @param coll1
	 *            the first collection, must not be null
	 * @param coll2
	 *            the first collection, must not be null
	 * @return <code>true</code> iff the intersection of the collections is
	 *         non-empty
	 * 
	 * @see #intersection
	 */
	public static <E> boolean containsAny(final Collection<E> coll1,
			final Collection<E> coll2) {
		if (coll1 == null || coll2 == null) {
			return false;
		}
		if (coll1.size() < coll2.size()) {
			for (E e : coll1) {
				if (coll2.contains(e)) {
					return true;
				}
			}
		} else {
			for (E e : coll2) {
				if (coll1.contains(e)) {
					return true;
				}
			}

		}
		return false;
	}

	/**
	 * Returns <tt>true</tt> iff <i>a</i> is a sub-collection of <i>b</i>, that
	 * is, iff the cardinality of <i>e</i> in <i>a</i> is less than or equal to
	 * the cardinality of <i>e</i> in <i>b</i>, for each element <i>e</i> in
	 * <i>a</i>.
	 * 
	 * @param a
	 *            the first (sub?) collection, must not be null
	 * @param b
	 *            the second (super?) collection, must not be null
	 * @return <code>true</code> iff <i>a</i> is a sub-collection of <i>b</i>
	 * @see #isProperSubCollection
	 * @see Collection#containsAll
	 */
	public static <E> boolean isSubCollection(final Collection<E> a,
			final Collection<E> b) {
		if (a == null || b == null) {
			return false;
		}
		Map<E, Integer> mapa = getCardinalityMap(a);
		Map<E, Integer> mapb = getCardinalityMap(b);
		for (E e : a) {
			if (getFreq(e, mapa) > getFreq(e, mapb)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Returns <tt>true</tt> iff <i>a</i> is a <i>proper</i> sub-collection of
	 * <i>b</i>, that is, iff the cardinality of <i>e</i> in <i>a</i> is less
	 * than or equal to the cardinality of <i>e</i> in <i>b</i>, for each
	 * element <i>e</i> in <i>a</i>, and there is at least one element <i>f</i>
	 * such that the cardinality of <i>f</i> in <i>b</i> is strictly greater
	 * than the cardinality of <i>f</i> in <i>a</i>.
	 * <p>
	 * The implementation assumes
	 * <ul>
	 * <li><code>a.size()</code> and <code>b.size()</code> represent the total
	 * cardinality of <i>a</i> and <i>b</i>, resp.</li>
	 * <li><code>a.size() < Integer.MAXVALUE</code></li>
	 * </ul>
	 * 
	 * @param a
	 *            the first (sub?) collection, must not be null
	 * @param b
	 *            the second (super?) collection, must not be null
	 * @return <code>true</code> iff <i>a</i> is a <i>proper</i> sub-collection
	 *         of <i>b</i>
	 * @see #isSubCollection
	 * @see Collection#containsAll
	 */
	public static <E> boolean isProperSubCollection(final Collection<E> a,
			final Collection<E> b) {
		if (a == null || b == null) {
			return false;
		}
		return (a.size() < b.size()) && isSubCollection(a, b);
	}

	/**
	 * Adds an element to the collection unless the element is null.
	 * 
	 * @param collection
	 *            the collection to add to, must not be null
	 * @param object
	 *            the object to add, if null it will not be added
	 * @return true if the collection changed
	 * @throws NullPointerException
	 *             if the collection is null
	 */
	public static <E> boolean addIgnoreNull(Collection<E> collection, E object) {
		return (object == null ? false : collection.add(object));
	}

	/**
	 * Adds all elements in the iteration to the given collection.
	 * 
	 * @param collection
	 *            the collection to add to, must not be null
	 * @param iterator
	 *            the iterator of elements to add, must not be null
	 * @throws NullPointerException
	 *             if the collection or iterator is null
	 */
	public static <E> void addAll(Collection<E> collection, Iterator<E> iterator) {
		if (collection == null || iterator == null) {
			return;
		}

		while (iterator.hasNext()) {
			collection.add(iterator.next());
		}
	}

	/**
	 * Adds all elements in the enumeration to the given collection.
	 * 
	 * @param collection
	 *            the collection to add to, must not be null
	 * @param enumeration
	 *            the enumeration of elements to add, must not be null
	 * @throws NullPointerException
	 *             if the collection or enumeration is null
	 */
	public static <E> void addAll(Collection<E> collection,
			Enumeration<E> enumeration) {
		if (collection == null || enumeration == null) {
			return;
		}

		while (enumeration.hasMoreElements()) {
			collection.add(enumeration.nextElement());
		}
	}

	/**
	 * Adds all elements in the array to the given collection.
	 * 
	 * @param collection
	 *            the collection to add to, must not be null
	 * @param elements
	 *            the array of elements to add, must not be null
	 * @throws NullPointerException
	 *             if the collection or array is null
	 */
	public static <E> void addAll(Collection<E> collection, E[] elements) {
		if (collection == null || elements == null) {
			return;
		}
		for (E e : elements) {
			collection.add(e);
		}
	}

	/**
	 * Returns the <code>index</code>-th value in <code>object</code>, throwing
	 * <code>IndexOutOfBoundsException</code> if there is no such element or
	 * <code>IllegalArgumentException</code> if <code>object</code> is not an
	 * instance of one of the supported types.
	 * <p>
	 * The supported types, and associated semantics are:
	 * <ul>
	 * <li>Map -- the value returned is the <code>Map.Entry</code> in position
	 * <code>index</code> in the map's <code>entrySet</code> iterator, if there
	 * is such an entry.</li>
	 * <li>List -- this method is equivalent to the list's get method.</li>
	 * <li>Array -- the <code>index</code>-th array entry is returned, if there
	 * is such an entry; otherwise an <code>IndexOutOfBoundsException</code> is
	 * thrown.</li>
	 * <li>Collection -- the value returned is the <code>index</code>-th object
	 * returned by the collection's default iterator, if there is such an
	 * element.</li>
	 * <li>Iterator or Enumeration -- the value returned is the
	 * <code>index</code>-th object in the Iterator/Enumeration, if there is
	 * such an element. The Iterator/Enumeration is advanced to
	 * <code>index</code> (or to the end, if <code>index</code> exceeds the
	 * number of entries) as a side effect of this method.</li>
	 * </ul>
	 * 
	 * @param object
	 *            the object to get a value from
	 * @param index
	 *            the index to get
	 * @return the object at the specified index
	 * @throws IndexOutOfBoundsException
	 *             if the index is invalid
	 * @throws IllegalArgumentException
	 *             if the object type is invalid
	 */
	public static Object get(Object object, int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException("Index cannot be negative: "
					+ index);
		}
		if (object instanceof Map) {
			Map<?, ?> map = (Map<?, ?>) object;
			Iterator<?> iterator = map.entrySet().iterator();
			return get(iterator, index);
		} else if (object instanceof List) {
			return ((List<?>) object).get(index);
		} else if (object instanceof Object[]) {
			return ((Object[]) object)[index];
		} else if (object instanceof Iterator) {
			Iterator<?> it = (Iterator<?>) object;
			while (it.hasNext()) {
				index--;
				if (index == -1) {
					return it.next();
				} else {
					it.next();
				}
			}
			throw new IndexOutOfBoundsException("Entry does not exist: "
					+ index);
		} else if (object instanceof Collection) {
			Iterator<?> iterator = ((Collection<?>) object).iterator();
			return get(iterator, index);
		} else if (object instanceof Enumeration) {
			Enumeration<?> it = (Enumeration<?>) object;
			while (it.hasMoreElements()) {
				index--;
				if (index == -1) {
					return it.nextElement();
				} else {
					it.nextElement();
				}
			}
			throw new IndexOutOfBoundsException("Entry does not exist: "
					+ index);
		} else if (object == null) {
			throw new IllegalArgumentException("Unsupported object type: null");
		} else {
			try {
				return Array.get(object, index);
			} catch (IllegalArgumentException ex) {
				throw new IllegalArgumentException("Unsupported object type: "
						+ object.getClass().getName());
			}
		}
	}

	/**
	 * Gets the size of the collection/iterator specified.
	 * <p>
	 * This method can handles objects as follows
	 * <ul>
	 * <li>Collection - the collection size
	 * <li>Map - the map size
	 * <li>Array - the array size
	 * <li>Iterator - the number of elements remaining in the iterator
	 * <li>Enumeration - the number of elements remaining in the enumeration
	 * </ul>
	 * 
	 * @param object
	 *            the object to get the size of
	 * @return the size of the specified collection
	 * @throws IllegalArgumentException
	 *             thrown if object is not recognised or null
	 * @since Commons Collections 3.1
	 */
	public static int size(Object object) {
		int total = 0;
		if (object instanceof Map) {
			total = ((Map<?, ?>) object).size();
		} else if (object instanceof Collection) {
			total = ((Collection<?>) object).size();
		} else if (object instanceof Object[]) {
			total = ((Object[]) object).length;
		} else if (object instanceof Iterator) {
			Iterator<?> it = (Iterator<?>) object;
			while (it.hasNext()) {
				total++;
				it.next();
			}
		} else if (object instanceof Enumeration) {
			Enumeration<?> it = (Enumeration<?>) object;
			while (it.hasMoreElements()) {
				total++;
				it.nextElement();
			}
		} else if (object == null) {
			throw new IllegalArgumentException("Unsupported object type: null");
		} else {
			try {
				total = Array.getLength(object);
			} catch (IllegalArgumentException ex) {
				throw new IllegalArgumentException("Unsupported object type: "
						+ object.getClass().getName());
			}
		}
		return total;
	}

	/**
	 * Checks if the specified collection/array/iterator is empty.
	 * <p>
	 * This method can handles objects as follows
	 * <ul>
	 * <li>Collection - via collection isEmpty
	 * <li>Map - via map isEmpty
	 * <li>Array - using array size
	 * <li>Iterator - via hasNext
	 * <li>Enumeration - via hasMoreElements
	 * </ul>
	 * <p>
	 * Note: This method is named to avoid clashing with
	 * {@link #isEmpty(Collection)}.
	 * 
	 * @param object
	 *            the object to get the size of, not null
	 * @return true if empty
	 * @throws IllegalArgumentException
	 *             thrown if object is not recognised or null
	 */
	public static boolean sizeIsEmpty(Object object) {
		if (object instanceof Collection) {
			return ((Collection<?>) object).isEmpty();
		} else if (object instanceof Map) {
			return ((Map<?, ?>) object).isEmpty();
		} else if (object instanceof Object[]) {
			return ((Object[]) object).length == 0;
		} else if (object instanceof Iterator) {
			return !((Iterator<?>) object).hasNext();
		} else if (object instanceof Enumeration) {
			return !((Enumeration<?>) object).hasMoreElements();
		} else if (object == null) {
			throw new IllegalArgumentException("Unsupported object type: null");
		} else {
			try {
				return Array.getLength(object) == 0;
			} catch (IllegalArgumentException ex) {
				throw new IllegalArgumentException("Unsupported object type: "
						+ object.getClass().getName());
			}
		}
	}

	/**
	 * Reverses the order of the given array.
	 * 
	 * @param array
	 *            the array to reverse
	 */
	public static <E> void reverseArray(E[] array) {
		if (ArrayUtil.isEmpty(array)) {
			return;
		}
		int i = 0;
		int j = array.length - 1;
		E tmp;

		while (j > i) {
			tmp = array[j];
			array[j] = array[i];
			array[i] = tmp;
			j--;
			i++;
		}
	}

	/**
	 * Check whether the given Collection contains the given element instance.
	 * <p>
	 * Enforces the given instance to be present, rather than returning
	 * <code>true</code> for an equal element as well.
	 * 
	 * @param collection
	 *            the Collection to check
	 * @param element
	 *            the element to look for
	 * @return <code>true</code> if found, <code>false</code> else
	 */
	public static boolean containsInstance(Collection<?> collection,
			Object element) {
		if (collection != null) {
			for (Object candidate : collection) {
				if (candidate == element) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Check whether the given Iterator contains the given element.
	 * 
	 * @param iterator
	 *            the Iterator to check
	 * @param element
	 *            the element to look for
	 * @return <code>true</code> if found, <code>false</code> else
	 */
	public static boolean contains(Iterator<?> iterator, Object element) {
		if (iterator != null) {
			while (iterator.hasNext()) {
				Object candidate = iterator.next();
				if (ObjectUtil.equalsEx(candidate, element)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Check whether the given Enumeration contains the given element.
	 * 
	 * @param enumeration
	 *            the Enumeration to check
	 * @param element
	 *            the element to look for
	 * @return <code>true</code> if found, <code>false</code> else
	 */
	public static boolean contains(Enumeration<?> enumeration, Object element) {
		if (enumeration != null) {
			while (enumeration.hasMoreElements()) {
				Object candidate = enumeration.nextElement();
				if (ObjectUtil.equalsEx(candidate, element)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Return the first element in '<code>candidates</code>' that is contained
	 * in '<code>source</code>'. If no element in '<code>candidates</code>' is
	 * present in '<code>source</code>' returns <code>null</code>. Iteration
	 * order is {@link Collection} implementation specific.
	 * 
	 * @param source
	 *            the source Collection
	 * @param candidates
	 *            the candidates to search for
	 * @return the first present object, or <code>null</code> if not found
	 */
	public static Object findFirstMatch(Collection<?> source,
			Collection<?> candidates) {
		if (isEmpty(source) || isEmpty(candidates)) {
			return null;
		}
		for (Object candidate : candidates) {
			if (source.contains(candidate)) {
				return candidate;
			}
		}
		return null;
	}

	/**
	 * Find a single value of the given type in the given Collection.
	 * 
	 * @param collection
	 *            the Collection to search
	 * @param type
	 *            the type to look for
	 * @return a value of the given type found if there is a clear match, or
	 *         <code>null</code> if none or more than one such value found
	 */
	@SuppressWarnings("unchecked")
	public static <T> T findValueOfType(Collection<?> collection, Class<T> type) {
		if (isEmpty(collection)) {
			return null;
		}
		T value = null;
		for (Object element : collection) {
			if (type == null || type.isInstance(element)) {
				if (value != null) {
					// More than one value found... no clear single value.
					return null;
				}
				value = (T) element;
			}
		}
		return value;
	}

	/**
	 * Find a single value of one of the given types in the given Collection:
	 * searching the Collection for a value of the first type, then searching
	 * for a value of the second type, etc.
	 * 
	 * @param collection
	 *            the collection to search
	 * @param types
	 *            the types to look for, in prioritized order
	 * @return a value of one of the given types found if there is a clear
	 *         match, or <code>null</code> if none or more than one such value
	 *         found
	 */
	public static Object findValueOfType(Collection<?> collection,
			Class<?>[] types) {
		if (isEmpty(collection) || ArrayUtil.isEmpty(types)) {
			return null;
		}
		for (Class<?> type : types) {
			Object value = findValueOfType(collection, type);
			if (value != null) {
				return value;
			}
		}
		return null;
	}

	/**
	 * Determine whether the given Collection only contains a single unique
	 * object.
	 * 
	 * @param collection
	 *            the Collection to check
	 * @return <code>true</code> if the collection contains a single reference
	 *         or multiple references to the same instance, <code>false</code>
	 *         else
	 */
	public static boolean hasUniqueObject(Collection<?> collection) {
		if (isEmpty(collection)) {
			return false;
		}
		boolean hasCandidate = false;
		Object candidate = null;
		for (Object elem : collection) {
			if (!hasCandidate) {
				hasCandidate = true;
				candidate = elem;
			} else if (candidate != elem) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Marshal the elements from the given enumeration into an array of the
	 * given type. Enumeration elements must be assignable to the type of the
	 * given array. The array returned will be a different instance than the
	 * array given.
	 */
	public static <A, E extends A> A[] toArray(Enumeration<E> enumeration,
			A[] array) {
		if (enumeration == null || array == null) {
			return null;
		}
		List<A> elements = CollectionUtil.getArrayList();
		while (enumeration.hasMoreElements()) {
			elements.add(enumeration.nextElement());
		}
		return elements.toArray(array);
	}

	public static <A, E extends A> A[] toArray(Iterator<E> iterator, A[] array) {
		if (iterator == null || array == null) {
			return null;
		}
		List<A> elements = CollectionUtil.getArrayList();
		while (iterator.hasNext()) {
			elements.add(iterator.next());
		}
		return elements.toArray(array);
	}

	/** SorterTemplate with custom {@link Comparator} */
	private static <T> SorterTemplate getSorter(final List<T> list,
			final Comparator<? super T> comp) {
		if (list == null || comp == null) {
			return null;
		}

		if (!(list instanceof RandomAccess))
			throw new IllegalArgumentException(
					"CollectionUtil can only sort random access lists in-place.");
		return new SorterTemplate() {
			@Override
			protected void swap(int i, int j) {
				Collections.swap(list, i, j);
			}

			@Override
			protected int compare(int i, int j) {
				return comp.compare(list.get(i), list.get(j));
			}

			@Override
			protected void setPivot(int i) {
				pivot = list.get(i);
			}

			@Override
			protected int comparePivot(int j) {
				return comp.compare(pivot, list.get(j));
			}

			private T pivot;
		};
	}

	/** Natural SorterTemplate */
	private static <T extends Comparable<? super T>> SorterTemplate getSorter(
			final List<T> list) {
		if (list == null) {
			return null;
		}

		if (!(list instanceof RandomAccess))
			throw new IllegalArgumentException(
					"CollectionUtil can only sort random access lists in-place.");
		return new SorterTemplate() {
			@Override
			protected void swap(int i, int j) {
				Collections.swap(list, i, j);
			}

			@Override
			protected int compare(int i, int j) {
				return list.get(i).compareTo(list.get(j));
			}

			@Override
			protected void setPivot(int i) {
				pivot = list.get(i);
			}

			@Override
			protected int comparePivot(int j) {
				return pivot.compareTo(list.get(j));
			}

			private T pivot;
		};
	}

	/**
	 * Sorts the given random access {@link List} using the {@link Comparator}.
	 * The list must implement {@link RandomAccess}. This method uses the quick
	 * sort algorithm, but falls back to insertion sort for small lists.
	 * 
	 * @throws IllegalArgumentException
	 *             if list is e.g. a linked list without random access.
	 */
	public static <T> void quickSort(List<T> list, Comparator<? super T> comp) {
		if (list == null || comp == null) {
			return;
		}
		final int size = list.size();
		if (size <= 1)
			return;
		getSorter(list, comp).quickSort(0, size - 1);
	}

	/**
	 * Sorts the given random access {@link List} in natural order. The list
	 * must implement {@link RandomAccess}. This method uses the quick sort
	 * algorithm, but falls back to insertion sort for small lists.
	 * 
	 * @throws IllegalArgumentException
	 *             if list is e.g. a linked list without random access.
	 */
	public static <T extends Comparable<? super T>> void quickSort(List<T> list) {
		if (list == null) {
			return;
		}
		final int size = list.size();
		if (size <= 1)
			return;
		getSorter(list).quickSort(0, size - 1);
	}

	// mergeSorts:

	/**
	 * Sorts the given random access {@link List} using the {@link Comparator}.
	 * The list must implement {@link RandomAccess}. This method uses the merge
	 * sort algorithm, but falls back to insertion sort for small lists.
	 * 
	 * @throws IllegalArgumentException
	 *             if list is e.g. a linked list without random access.
	 */
	public static <T> void mergeSort(List<T> list, Comparator<? super T> comp) {
		if (list == null || comp == null) {
			return;
		}
		final int size = list.size();
		if (size <= 1)
			return;
		getSorter(list, comp).mergeSort(0, size - 1);
	}

	/**
	 * Sorts the given random access {@link List} in natural order. The list
	 * must implement {@link RandomAccess}. This method uses the merge sort
	 * algorithm, but falls back to insertion sort for small lists.
	 * 
	 * @throws IllegalArgumentException
	 *             if list is e.g. a linked list without random access.
	 */
	public static <T extends Comparable<? super T>> void mergeSort(List<T> list) {
		if (list == null) {
			return;
		}
		final int size = list.size();
		if (size <= 1)
			return;
		getSorter(list).mergeSort(0, size - 1);
	}

	// insertionSorts:

	/**
	 * Sorts the given random access {@link List} using the {@link Comparator}.
	 * The list must implement {@link RandomAccess}. This method uses the
	 * insertion sort algorithm. It is only recommended to use this algorithm
	 * for partially sorted small lists!
	 * 
	 * @throws IllegalArgumentException
	 *             if list is e.g. a linked list without random access.
	 */
	public static <T> void insertionSort(List<T> list,
			Comparator<? super T> comp) {
		if (list == null || comp == null) {
			return;
		}
		final int size = list.size();
		if (size <= 1)
			return;
		getSorter(list, comp).insertionSort(0, size - 1);
	}

	/**
	 * Sorts the given random access {@link List} in natural order. The list
	 * must implement {@link RandomAccess}. This method uses the insertion sort
	 * algorithm. It is only recommended to use this algorithm for partially
	 * sorted small lists!
	 * 
	 * @throws IllegalArgumentException
	 *             if list is e.g. a linked list without random access.
	 */
	public static <T extends Comparable<? super T>> void insertionSort(
			List<T> list) {
		if (list == null) {
			return;
		}
		final int size = list.size();
		if (size <= 1)
			return;
		getSorter(list).insertionSort(0, size - 1);
	}

	public static abstract class SorterTemplate {

		private static final int MERGESORT_THRESHOLD = 12;
		private static final int QUICKSORT_THRESHOLD = 7;

		/**
		 * Implement this method, that swaps slots {@code i} and {@code j} in
		 * your data
		 */
		protected abstract void swap(int i, int j);

		/**
		 * Compares slots {@code i} and {@code j} of you data. Should be
		 * implemented like
		 * <code><em>valueOf(i)</em>.compareTo(<em>valueOf(j)</em>)</code>
		 */
		protected abstract int compare(int i, int j);

		/**
		 * Implement this method, that stores the value of slot {@code i} as
		 * pivot value
		 */
		protected abstract void setPivot(int i);

		/**
		 * Implements the compare function for the previously stored pivot
		 * value. Should be implemented like
		 * <code>pivot.compareTo(<em>valueOf(j)</em>)</code>
		 */
		protected abstract int comparePivot(int j);

		/**
		 * Sorts via stable in-place InsertionSort algorithm (ideal for small
		 * collections which are mostly presorted).
		 */
		public final void insertionSort(int lo, int hi) {
			for (int i = lo + 1; i <= hi; i++) {
				for (int j = i; j > lo; j--) {
					if (compare(j - 1, j) > 0) {
						swap(j - 1, j);
					} else {
						break;
					}
				}
			}
		}

		/**
		 * Sorts via in-place, but unstable, QuickSort algorithm. For small
		 * collections falls back to {@link #insertionSort(int,int)}.
		 */
		public final void quickSort(final int lo, final int hi) {
			if (hi <= lo)
				return;
			// from Integer's Javadocs: ceil(log2(x)) = 32 -
			// numberOfLeadingZeros(x - 1)
			quickSort(lo, hi,
					(Integer.SIZE - Integer.numberOfLeadingZeros(hi - lo)) << 1);
		}

		private void quickSort(int lo, int hi, int maxDepth) {
			// fall back to insertion when array has short length
			final int diff = hi - lo;
			if (diff <= QUICKSORT_THRESHOLD) {
				insertionSort(lo, hi);
				return;
			}

			// fall back to merge sort when recursion depth gets too big
			if (--maxDepth == 0) {
				mergeSort(lo, hi);
				return;
			}

			final int mid = lo + (diff >>> 1);

			if (compare(lo, mid) > 0) {
				swap(lo, mid);
			}

			if (compare(mid, hi) > 0) {
				swap(mid, hi);
				if (compare(lo, mid) > 0) {
					swap(lo, mid);
				}
			}

			int left = lo + 1;
			int right = hi - 1;

			setPivot(mid);
			for (;;) {
				while (comparePivot(right) < 0)
					--right;

				while (left < right && comparePivot(left) >= 0)
					++left;

				if (left < right) {
					swap(left, right);
					--right;
				} else {
					break;
				}
			}

			quickSort(lo, left, maxDepth);
			quickSort(left + 1, hi, maxDepth);
		}

		/**
		 * Sorts via stable in-place MergeSort algorithm For small collections
		 * falls back to {@link #insertionSort(int,int)}.
		 */
		public final void mergeSort(int lo, int hi) {
			final int diff = hi - lo;
			if (diff <= MERGESORT_THRESHOLD) {
				insertionSort(lo, hi);
				return;
			}

			final int mid = lo + (diff >>> 1);

			mergeSort(lo, mid);
			mergeSort(mid, hi);
			merge(lo, mid, hi, mid - lo, hi - mid);
		}

		private void merge(int lo, int pivot, int hi, int len1, int len2) {
			if (len1 == 0 || len2 == 0) {
				return;
			}
			if (len1 + len2 == 2) {
				if (compare(pivot, lo) < 0) {
					swap(pivot, lo);
				}
				return;
			}
			int first_cut, second_cut;
			int len11, len22;
			if (len1 > len2) {
				len11 = len1 >>> 1;
				first_cut = lo + len11;
				second_cut = lower(pivot, hi, first_cut);
				len22 = second_cut - pivot;
			} else {
				len22 = len2 >>> 1;
				second_cut = pivot + len22;
				first_cut = upper(lo, pivot, second_cut);
				len11 = first_cut - lo;
			}
			rotate(first_cut, pivot, second_cut);
			final int new_mid = first_cut + len22;
			merge(lo, first_cut, new_mid, len11, len22);
			merge(new_mid, second_cut, hi, len1 - len11, len2 - len22);
		}

		private void rotate(int lo, int mid, int hi) {
			int lot = lo;
			int hit = mid - 1;
			while (lot < hit) {
				swap(lot++, hit--);
			}
			lot = mid;
			hit = hi - 1;
			while (lot < hit) {
				swap(lot++, hit--);
			}
			lot = lo;
			hit = hi - 1;
			while (lot < hit) {
				swap(lot++, hit--);
			}
		}

		private int lower(int lo, int hi, int val) {
			int len = hi - lo;
			while (len > 0) {
				final int half = len >>> 1, mid = lo + half;
				if (compare(mid, val) < 0) {
					lo = mid + 1;
					len = len - half - 1;
				} else {
					len = half;
				}
			}
			return lo;
		}

		private int upper(int lo, int hi, int val) {
			int len = hi - lo;
			while (len > 0) {
				final int half = len >>> 1, mid = lo + half;
				if (compare(val, mid) < 0) {
					len = half;
				} else {
					lo = mid + 1;
					len = len - half - 1;
				}
			}
			return lo;
		}
	}
}
