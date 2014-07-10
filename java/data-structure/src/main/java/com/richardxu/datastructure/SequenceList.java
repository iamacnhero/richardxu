package com.richardxu.datastructure;

import java.util.Arrays;

/**
 * 数组实现的顺序线性表 (非线程安全的实现)
 * @author xufeng
 *
 * @param <T>
 */
public class SequenceList<T> {
	private int DEFAULT_SIZE = 16;
	private int capacity;	// 数据长度
	private Object[] elementData;	// 定义一个数组用于保存顺序线性表的长度
	private int size = 0;	// 保存线性表中元素的当前个数
	
	public SequenceList() {		// 默认构造函数：创建空线性表
		capacity = DEFAULT_SIZE;
		elementData = new Object[capacity];
	}
	
	public SequenceList(T element) {	// 以一个初始化元素创建顺序线性表
		this();
		elementData[0] = element;
		size++;
	}
	
	/**
	 * 以指定长度的数组创建顺序线性表
	 * @param element
	 * @param initSize
	 */
	public SequenceList(T element, int initSize) {
		capacity = 1;
		while (capacity < initSize) {	// 把 capacity 设为大于 initSize 的最小的2的n次方
			capacity <<= 1;
		}
		elementData = new Object[capacity];
		size++;
	}
	
	public int length() {	// 获取线性表的大小
		return size;
	}
		
	public T get(int i) {	// 获取索引为i处的元素 
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		return (T) elementData[i];
	}
	
	public int locate(T element) {		// 查找指定元素的索引
		for (int i = 0; i < size; i++) {
			if (elementData[i].equals(element))
				return i;
		}
		return -1;
	}
	
	public void insert(T element, int index) {		// 向指定位置插入一个元素
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("索引越界");
		}
		ensureCapacity(size + 1);
		System.arraycopy(elementData, index, elementData, index+1, size-index);	// 将指定索引之后的所有元素向后移动一格
		elementData[index] = element;
		size++;
	}
	
	public void add(T element) {	// 添加元素
		insert(element, size);
	}
	
	public void ensureCapacity(int minCapacity) {
		// 如果数组的原有长度小于当前需要的长度
		if ( capacity < minCapacity ) {
			// 不断地将 capacity * 2，直到 capacity 大于 minCapacity
			while (capacity < minCapacity) {
				capacity <<= 1;
			}
			elementData = Arrays.copyOf(elementData, capacity);
		}
	}
	
	public T delete(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("索引越界");
		}
		T oldValue = (T) elementData[index];
		int numMoved = size - index - 1;
		if (numMoved > 0) {
			System.arraycopy(elementData, index+1, elementData, index, numMoved);
		}
		// 清空最后一个元素
		elementData[--size] = null;
		return oldValue;
	}
	
	public T remove() {		// 删除最后一个元素
		return delete(size-1);
	}
	
	public boolean empty() {
		return size == 0;
	}
	
	public void clear() {	// 清空线性表
		Arrays.fill(elementData, null);
		size = 0;
	}
	
	public String toString() {
		if (size == 0) {
			return "[]";
		} else {
			StringBuilder sb = new StringBuilder("[");
			for (int i=0; i<size; i++) {
				sb.append(elementData[i].toString() + ", ");
			}
			int len = sb.length();
			return sb.delete(len-2, len).append("]").toString();
		}
	}
	
	public static void main(String[] args) {
		SequenceList<String> l = new SequenceList<String>();
		l.add("aaa");
		l.add("bbb");
		l.add("ccc");
		l.insert("dddd", 1);
		l.delete(2);
		System.out.println(l.toString());
		System.out.println(l.locate("ccc"));
		
	}
}
