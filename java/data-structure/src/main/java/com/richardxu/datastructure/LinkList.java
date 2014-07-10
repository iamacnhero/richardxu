package com.richardxu.datastructure;


/**
 * 单链表(每个结点只保留一个指向下一元素的指针)
 * @author xufeng
 *
 * @param <T>
 */
public class LinkList<T> {
	// 定义一个内部类，Node实例代表链表的结点
	private class Node {
		private T data;	// 保存结点的数据
		private Node next;	// 指向下个结点的指针
		
		public Node() {		// 无参数的构造器
		}
		public Node(T data, Node next) {	// 初始化全部属性的构造器
			this.data = data;
			this.next = next;
		}
	}
	
	// 链表的头结点
	private Node head;
	// 链表的尾结点
	private Node tail;
	// 结点数
	private int size;
	
	public LinkList() {		// 创建空链表
		head = null;
		tail = null;
	}
	
	public LinkList(T element) {	// 以指定元素创建只有一个元素的链表
		head = new Node(element, null);
		tail = head;
		size++;
	}
	
	public int length() {	// 返回链表的长度
		return size;
	}
	
	public T get(int index) {	// 返回索引为index处的元素
		return getNodeByIndex(index).data;
	}
	
	public Node getNodeByIndex(int index) {	// 根据索引index获取指定位置的结点
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("索引越界");
		}
		// 从 head 结点开始
		Node current = head;
		for (int i = 0; i < size && current != null; i++, current=current.next) {
			if (i == index) {
				return current;
			}
		}
		return null;
	}
	
	public int locate(T element) {		// 查找指定元素的索引
		Node current = head;	// 从头结点开始搜索
		for (int i = 0; i < size && current != null; i++, current = current.next) {
			if (current.data.equals(element)) 
				return i;
		}
		return -1;
	}
	
	public void insert(T element, int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("索引越界");
		}
		if (head == null) {		// 如果是空链表
			add(element);
		} else {
			if (index == 0) {	// 当index=0时，在链表头处插入
				addAtHeader(element);
			} else {
				Node prev = getNodeByIndex(index);
				prev.next = new Node(element, prev.next);
				size++;
			}
		}
	}
	
	public void add(T element) {	// 尾插法：将新结点插入到表尾上
		if (head == null) {		// 只有一个结点，head, tail都 指向该结点
			head = new Node(element, null);
			tail = head;
		} else {
			Node newNode = new Node(element, null);
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}
	
	public void addAtHeader(T element) {	// 头插法：将新结点插入到表头上
		head = new Node(element, head);
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
		if (index == 0) {	// 如果要删除的是head结点
			del = head;
			head = head.next;
		} else {
			Node prev = getNodeByIndex(index-1);
			del = prev.next;
			prev.next = del.next;
			del.next = null;
		}
		size--;
		return del.data;
	}
	
	public T remove() {		// 删除线性表中最后一个元素
		return delete(size-1);
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
	
	public static void main(String[] args) {
		LinkList<String> l = new LinkList<String>();
		l.add("aaa");
		l.add("bbb");
		l.add("ccc");
		l.insert("dddd", 1);
		l.delete(2);
		System.out.println(l.toString());
		System.out.println(l.locate("ccc"));
	}
	
}
