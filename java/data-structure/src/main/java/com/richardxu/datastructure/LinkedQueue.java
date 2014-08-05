package com.richardxu.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.richardxu.lib.StdIn;
import com.richardxu.lib.StdOut;

/**
 *  <tt>Queue</tt> 类表示一个先入先出(first-in-first-out, FIFO)的队列，使用单链表实现。
 *  它支持 <em>入队(enqueue)</em> 和 <em>出队(dequeue)</em>
 *  操作, 同时支持获取首元素(peeking)的操作,
 *  测试队列是否非空, 和按照FIFO顺序迭代数据元素.
 *  <p>
 *  在最糟的情况下, <em>enqueue</em>, <em>dequeue</em>, <em>peek</em>, <em>size</em>, 以及 <em>is-empty</em>
 *  操作耗时都在常数级.
 *  <p>
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class LinkedQueue<E> implements Iterable<E> {
    private int size;       // 队列元素数
    private Node<E> first;  // 队列首结点
    private Node<E> last;   // 队列尾结点

    private static class Node<E> {
        private E item;
        private Node<E> next;
    }
    
    /**
     * 初始化一个空队列.
     */
    public LinkedQueue() {
        first = null;
        last = null;
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
     * 返回最新添加的元素(第一个元素)
     */
    public E peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }
    
    /**
     * 入队
     */
    public void enqueue(E item) {
       Node<E> oldlast = last;
       last = new Node<E>();
       last.item = item;
       last.next = null;
       if (isEmpty()) 
           first = last;
       else 
           oldlast.next = last;
       size++;
    }
    
    /**
     * 出队
     */
    public E dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        E item = first.item;
        first = first.next;
        size--;
        if (isEmpty()) last = null; // to avoid loitering
        return item;
    }
    
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
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    
    public static void main(String[] args) {
        LinkedQueue<String> q = new LinkedQueue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) 
                q.enqueue(item);
            else if (!q.isEmpty())
                StdOut.print(q.dequeue() + " ");
        }
        StdOut.println("(" + q.size() + " left on queue.");
    }

}
