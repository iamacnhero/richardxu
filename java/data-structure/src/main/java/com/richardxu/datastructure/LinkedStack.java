package com.richardxu.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.richardxu.lib.StdIn;
import com.richardxu.lib.StdOut;

/**
 *  <tt>Stack</tt> 类展示了一个后进先出(last-in-first-out, LIFO)的堆，使用单链表实现。
 *  它支持常见的 <em>push</em> 和 <em>pop</em> 操作, 同时也包含了 peeking 顶元素,
 *  检测堆是否为空, 以及按LIFO顺序迭代所有元素的方法.
 *  <p>
 *  <em>push</em>, <em>pop</em>, <em>peek</em>, <em>size</em>, 和 <em>is-empty</em>
 *  操作在最坏情况下耗时都是常数级.
 *  <p>
 *  @author <a href="mailto:richardxu@live.cn">xufeng</a>
 *  
 */
public class LinkedStack<E> implements Iterable<E> {
    private int size;       // size of the stack
    private Node<E> first;  // top of stack
    
    // 单链表辅助类
    private static class Node<E> {
        private E item;
        private Node<E> next;
    }
    
    /**
     * 初始化一个空栈
     */
    public LinkedStack() {
        first = null;   // 栈顶为空
        size = 0;
    }
    
    public boolean isEmpty() {
        // return first == null;
        return size == 0;
    }
    
    public int size() {
        return size;
    }

    /**
     * 将新添加的元素放到栈顶，然后next指向原来的栈顶元素
     */
    public void push(E item) {
        Node<E> oldfirst = first;
        first = new Node<E>();
        first.item = item;
        first.next = oldfirst;
        size++;
    }
    
    /**
     * 从栈顶取出并删除元素
     */
    public E pop() {
        if (isEmpty()) 
            throw new NoSuchElementException("Stack underflow");
        E item = first.item;    // save item to return
        first = first.next;     // delete first node
        size--;
        return item;            // return the saved item
    }
    
    /**
     * 返回最新入队的元素
     */
    public E peek() {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow");
        return first.item;
    }
    
    /* 
     * Returns a string representation of this stack.
     * @return the sequence of items in the stack in LIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (E item : this) {
            s.append(item + " ");
        }
        return s.toString();
    }
    
    public Iterator<E> iterator() {
        return new ListIterator<E>(first);
    }
    
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;
        
        public ListIterator(Node<Item> first) {
            current = first;
        }
        
        public boolean hasNext() { return current != null; }
        public void remove() { throw new UnsupportedOperationException(); }
        
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    
    public static void main(String[] args) {
        LinkedStack<String> s = new LinkedStack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty())
                StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size()+ " left on stack.");
    }
}
