package com.richardxu.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <tt>ResizingArrayBag</tt> 类表示一个无序集合。 
 * 支持插入和迭代。底层采用可变数组实现。
 * @author <a href="mailto:richardxu@live.cn">xufeng</a>
 */
@SuppressWarnings("unchecked")
public class ResizingArrayBag<E> implements Iterable<E> {
    private E[] elementData;
    private int size = 0;
    
    public ResizingArrayBag() {
        elementData = (E[]) new Object[2];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    private void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = elementData[i];
        }
        elementData = temp;
    }
    
    public void add(E element) {
        if (size == elementData.length) {
            int oldCapacity = elementData.length;       // 增大1.5倍
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            resize(newCapacity);
        }
        elementData[size++] = element;
    }
    
    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<E> {
        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            return elementData[i++];
        }

        @Override
        public void remove() { 
            throw new UnsupportedOperationException();
        }
    }
    
    public static void main(String[] args) {
        ResizingArrayBag<String> countryList = new ResizingArrayBag<String>();
        countryList.add("china");
        countryList.add("russia");
        countryList.add("poland");
        countryList.add("japan");
        for (String country : countryList) {
            System.out.println(country);
        }
    }
}
