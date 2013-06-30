package com.xufeng.datastructure;

/**
 * 双向链表(每个结点都有prev, next两个指针域)的实现 (实现的有问题！) 
 * @author xufeng
 *
 */
public class DualLinkList<T> {
	private class Node {
		private T data;	// 保存结点的数据
		private Node prev;	// 上个结点的引用
		private Node next;	// 下个结点的引用
		public Node() {
			
		}
		public Node(T data, Node prev, Node next) {		// 初始化全部属性的构造器
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}
	
	private Node head;	// 保存该链表的头结点
	private Node tail;	// 保存该链表的尾结点
	private int size;
	
	public DualLinkList() {		// 创建空链表
		head = null;
		tail = null;
	}
	
	public DualLinkList(T element) {	// 以指定元素来创建空链表，该链表只有一个元素
		head = new Node(element, null, null);
		tail = head;	// 只有一个结点，head, tail 都指向该结点
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public T get(int index) {	// 获取链式线性表中索引为index处的元素
		return getNodeByIndex(index).data;
	}
	
	private Node getNodeByIndex(int index) {	// 根据索引index获取指定位置的结点
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("索引越界");
		}
		if (index <= size / 2) {	// 从head 结点开始
			Node current = head;
			for (int i = 0; i < size/2 && current != null; i++, current=current.next) {
				if (i == index) {
					return current;
				}
			}
		} else {	// 从 tail 结点开始搜索
			Node current = tail;
			for (int i = size-1; i > size/2 && current != null; i--, current=current.next) {
				if (i == index) {
					return current;
				}
			}
		}
		return null;
	}
	
	public int locate(T element) {	// 查找线性表中指定元素的索引
		Node current = head;
		for (int i = 0; i < size && current != null; i++, current=current.next) {
			if (current.data.equals(element))
				return i;
		}
		return -1;
	}
	
	public void insert(T element, int index) {		// 向线性链表的指定位置插入一个元素
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("数组越界");
		}
		if (head == null) {		// 如果还是空链表
			add(element);
		} else {
			if (index == 0) {	 // 当index为0时，也就是在链表头处插入
				addAtHeader(element);
			} else {
				Node prev = getNodeByIndex(index - 1);	// 获取插入点的前一个结点
				Node next = prev.next;	// 获取插入点的节点
				Node newNode = new Node(element, prev, next);	// 让新结点的next引用指向next结点，prev引用指向prev结点
				prev.next = newNode;	// 让prev的next指向新结点
				next.prev = newNode;	// 让next的prev指向新结点
				size++;
			}
		}
	}
	
	private void add(T element) {	// 尾插法为链表添加新结点
		if (head == null) {		// 如果该链表是空链表
			head = new Node(element, null, null);
			tail = head;
		} else {
			Node newNode = new Node(element, tail, null);	// 创建新结点，新结点的prev指向原tail结点
			tail.next = newNode;	// 让尾结点的next指向新增的结点
			tail = newNode;	// 让新结点作为尾结点
		}
		size++;
	}
	
	public void addAtHeader(T element) {	// 采用头插法向链表添加新结点
		head = new Node(element, null, head);	// 创建新结点，让新结点的next指向原来的head，并以新节点作为新的head
		if (tail == null) {		// 如果插入之前是空链表
			tail = head;
		}
		size++;
	}
	
	public T delete(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("索引越界");
		}
		Node del = null;
		if (index == 0) {	//如果被删除的是head结点
			del = head;
			head = head.next;
			head.prev = null;	// 释放新的head结点的prev引用
		} else {
			Node prev = getNodeByIndex(index - 1);	// 获取删除点的前一个结点
			del = prev.next;	// 获取将要被删除的结点
			prev.next = del.next;	// 将被删除结点的next指向被删除结点的下一个结点
			if (del.next != null) {
				del.next.prev = prev;
			}
			// 将被删除结点的prev, next引用赋为null
			del.prev = null;
			del.next = null;
		}
		size--;
		return del.data;
	}
	
	public T remove() {		// 删除线性表中最后一个元素
		return delete(size - 1);
	}
	
	public boolean empty() {
		return size == 0;
	}
	
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public String toString() {	
		// 链表为空链表时
		if (empty()) {
			return "[]";
		} else {
			StringBuilder sb = new StringBuilder("[");
			for (Node current = head; current != null; current = current.next) {
				sb.append(current.data.toString() + ", ");
			}
			int len = sb.length();
			return sb.delete(len-2, len).append("]").toString();
		}
	}
	
	public String reverseToString() {
		if (empty()) {
			return "[]";
		} else {
			StringBuilder sb = new StringBuilder("[");
			for (Node current = tail; current != null; current = current.prev) {
				sb.append(current.data.toString() + ", ");
			}
			int len = sb.length();
			return sb.delete(len-2, len).append("]").toString();
		}
	}
	
	public static void main(String[] args) {
		DualLinkList<String> list = new DualLinkList<String>();
		list.insert("aaa", 0);
		System.out.println(list);
		list.add("bbb");
		System.out.println(list);
		list.insert("ccc", 0);
		System.out.println(list);
		list.insert("ddd", 1);
		System.out.println(list);
		list.delete(2);
		System.out.println(list);
		System.out.println(list.locate("ccc"));
		System.out.println(list);
		list.remove();
		System.out.println(list);
		list.delete(0);
		System.out.println(list);
	}
}
