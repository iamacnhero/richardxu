package com.richardxu.datastructure;

import java.util.Iterator;

import com.richardxu.lib.StdIn;
import com.richardxu.lib.StdOut;

public class Stack<Item> implements Iterable<Item> {
	private Node first; // 栈顶(最近添加的元素)
	private int N; // 元素数量

	private class Node { // 定义了结点的嵌套类
		Item item;
		Node next;
	}
	
	/**
	 * 创建一个空栈
	 */
	public Stack() {
        first = null;
        N = 0;
    }

	public boolean isEmpty() {
		return first == null;	// 或 N == 0
	}

	public int size() {
		return N;
	}

	public void push(Item item) { // 向栈顶添加元素
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}

	public Item pop() { // 向栈顶删除元素
		if (isEmpty()) throw new RuntimeException("Stack underflow");
		Item item = first.item;	// save item to return
		first = first.next;	// delete first node
		N--;
		return item;	// return the saved item
	}
	
	public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }

	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	// an iterator, doesn't implement remove() since it's optional
	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		public boolean hasNext() {	return current != null;}
		public void remove() {throw new UnsupportedOperationException();	}

		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	public static void main(String[] args) {
/*		Stack<String> s = new Stack<String>();
		s.push("China");
		s.push("USA");
		s.push("Japan");
		s.pop();
		for (String string : s) {
			System.out.println(string);
		}*/
		
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			/*String s = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";*/
			if (s.equals("(")) ;
			else if (s.equals("+"))		ops.push(s);
			else if (s.equals("-"))    ops.push(s);
			else if (s.equals("*"))    ops.push(s);
			else if (s.equals("/"))    ops.push(s);
			else if (s.equals("sqrt")) ops.push(s);
			else if (s.equals(")")) {
				String op = ops.pop();
				double v = vals.pop();
				if (op.equals("+")) v = vals.pop() + v;
				else if (op.equals("-")) v = vals.pop() - v;
				else if (op.equals("*")) v = vals.pop() * v;
				else if (op.equals("/")) v = vals.pop() / v;
				else if (op.equals("sqrt")) v = Math.sqrt(v);
				vals.push(v);
			}
			else vals.push(Double.parseDouble(s));
		}
		StdOut.println(vals.pop());
	}

}