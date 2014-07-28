package com.richardxu.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.richardxu.lib.StdIn;
import com.richardxu.lib.StdOut;

/**
 *  <tt>Queue</tt> 类表示一个先入先出(first-in-first-out, FIFO)的队列
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
public class Queue<E> implements Iterable<E> {
    private int size;       // number of elements on queue
    private Node<E> first;  // begging of queue
    private Node<E> last;   // end of queue

    // helper linked list class
    private static class Node<E> {
        private E item;
        private Node<E> next;
    }
    
    /**
     * Initializes an empty queue.
     */
    public Queue() {
        first = null;
        last = null;
        size = 0;
    }
    
    /**
     * Is this queue empty?
     * @return true if this queue is empty; false otherwise
     */
    public boolean isEmpty() {
        // return first == null;
        return size == 0;
    }
    
    /**
     * Returns the number of items in this queue.
     * @return the number of items in this queue.
     */
    public int size() {
        return size;
    }
    
    /**
     * Returns the item least recently added to this queue.
     * @return the item least recently added to this queue
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    public E peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return first.item;
    }
    
    /**
     * Adds the item to this queue
     * @param item the item to add
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
     * Removes and returns the item on this queue that was least recently added.
     * @return the item on this queue that was least recently added
     * @throws java.util.NoSuchElementException if this queue is empty
     */
    public E dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        E item = first.item;
        first = first.next;
        size--;
        if (isEmpty()) last = null; // to avoid loitering
        return item;
    }
    
    /**
     * @return the sequence of items in FIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (E item : this) {
            s.append(item + " ");
        }
        return s.toString();
    }
    
    /* Returns an iterator that iterates over the items in this queue in FIFO order.
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    public Iterator<E> iterator() {
        return new ListIterator<E>(first);
    }
    
    // an iterator, doesn't implement remove() since it's optional
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
    
    /**
     * Unit tests the <tt>Queue</tt> data type.
     */
    public static void main(String[] args) {
        Queue<String> q = new Queue<String>();
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
