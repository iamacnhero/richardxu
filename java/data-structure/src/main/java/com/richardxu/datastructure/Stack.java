package com.richardxu.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.richardxu.lib.StdIn;
import com.richardxu.lib.StdOut;

/**
 *  <tt>Stack</tt> 类展示了一个后进先出(last-in-first-out, LIFO)的堆.
 *  它支持常见的 <em>push</em> 和 <em>pop</em> 操作, 同时也包含了 peeking 顶元素,
 *  检测堆是否为空, 以及按LIFO顺序迭代所有元素的方法.
 *  <p>
 *  <em>push</em>, <em>pop</em>, <em>peek</em>, <em>size</em>, 和 <em>is-empty</em>
 *  操作在最坏情况下耗时都是常数级.
 *  <p>
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class Stack<E> implements Iterable<E> {
    private int size;       // size of the stack
    private Node<E> first;  // top of stack
    
    // helper linked list class
    private static class Node<E> {
        private E item;
        private Node<E> next;
    }
    
    /**
     * Initializes an empty stack.
     */
    public Stack() {
        first = null;
        size = 0;
    }
    
    /**
     * Is this stack empty?
     * @return true if this stack is empty; false otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }
    
    /**
     * Returns the number of items in the stack.
     * @return the number of items in the stack.
     */
    public int size() {
        return size;
    }

    /**
     * Add the item to this stack.
     * @param item the item to add
     */
    public void push(E item) {
        Node<E> oldfirst = first;
        first = new Node<E>();
        first.item = item;
        first.next = oldfirst;
        size++;
    }
    
    /**
     * Removes and returns the item most recently added to this stack.
     * @return the item most recently added
     * @throws java.util.NoSuchElementException if this stack is empty
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
     * Returns (but does not remove) the item most recently added to this stack.
     * @return the item mose recently added to this stack
     * @throws java.util.NoSuchElementException if this stack is empty
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
    
    /* 
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     * @return an iterator to this stack that iterates through the items in LIFO order.
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
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    
    /**
     * Unit tests the <tt>Stack</tt> data type.
     */
    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();
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
