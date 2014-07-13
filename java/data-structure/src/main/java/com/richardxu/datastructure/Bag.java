package com.richardxu.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.richardxu.lib.StdIn;
import com.richardxu.lib.StdOut;

/**
 *  <tt>Bag</tt> 类是表示一组无序数据的集合, 不支持删除元素. 它支持插入和迭代一组无序数据.
 *  <p>
 *  <em>add</em>, <em>isEmpty</em>, 和 <em>size</em> 操作的耗时都是常数级.
 *  迭代花费的时间与元素数目成正比例关系.
 *  <p>
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class Bag<E> implements Iterable<E> {
    private int size;              // number of elements in bag
    private Node<E> first;   // beginning of bag
    
    // helper linked list class
    private static class Node<E> {
        private E item;
        private Node<E> next;
    }
    
    /**
     * Initializes an empty bag.
     */
    public Bag() {
        first = null;   // 初始元素为空, 接收到新元素后, 不停替换为新元素, 老元素后移
        size = 0;
    }
    
    /**
     * Is this bag empty?
     * @return true if this bag is empty; false otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }
    
    /**
     * Returns the number of items in this bag.
     * @return the number of items in this bag.
     */
    public int size() {
        return size;
    }
    
    /**
     * Adds the item to this bag.
     * Bag 接收到新元素后, 不停替换first为新元素, 原来first指向的老元素不断后移
     * @param item the item to add to this bag
     */
    public void add(E item) {
        Node<E> oldFirst = first;
        first = new Node<E>();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    
    /* Returns an iterator that iterates over the items in the bag in arbitrary order.
     * @return an iterator that iterates over the items in the bag in arbitrary order.
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
    
    public static void main(String[] args) {
        Bag<String> bags = new Bag<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();    
            if (item.equals("quit"))
                break;
            bags.add(item);
        }       
        
        StdOut.println("Size of bags = " + bags.size());
        for (String s : bags) {
            StdOut.println(s);
        }
    }
}
