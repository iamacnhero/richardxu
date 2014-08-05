package com.richardxu.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.richardxu.lib.StdIn;

/**
 * ResizingArrayQueue 表示一个先进先出(FIFO)的队列,
 * 支持<em>enqueue</em>和<em>dequeue</em>操作，以及peek操作(取出第一个元素)等等。
 * 底层采用可变数组实现，当底层的数组满的时候，增大1.5倍，
 * 将底层数组的数据不到四分之一的时候，缩小一半.
 * @author <a href="mailto:richardxu@live.cn">xufeng</a>
 *
 */
@SuppressWarnings("unchecked")
public class ResizingArrayQueue<E> implements Iterable<E> {
    private E[] elementData;    // 队列元素        
    private int size;           // 队列元素数
    private int first = 0;      // 第一个元素索引
    private int last = 0;       // index of next available slot

    public ResizingArrayQueue() {
        elementData = (E[]) new Object[2];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    // 构造一个临时数组对底层数组进行扩容
    private void resize(int max) {
        E[] temp = (E[]) new Object[max];
        for (int i = 0; i < size; i++) {
            temp[i] = elementData[(first + i) % elementData.length];
            // temp[0] = elementData[(0 + 0) % 2]
            // temp[1] = elementData[(0 + 1) % 2]
        }
        elementData = temp;
        first = 0;
        last = size;
    }
    
    // 入队，将数据放入数组尾部
    public void enqueue(E element) {
        if (size == elementData.length) {
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            resize(newCapacity);
        }
        elementData[last++] = element;      // 添加数据
        if (last == elementData.length)
            last = 0;                       // wrap around
        size++;
    }
    
    // 出队
    public E dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        E element = elementData[first];
        elementData[first] = null;        // to avoid loitering
        size--;
        first++;
        if (first == elementData.length) first = 0;     // wrap around
        // 收缩数组大小, 如果需要的话
        if (size > 0 && size == elementData.length / 4) resize(elementData.length / 2);
        return element;
    }
    
    // 返回最新添加的元素(数组第一个元素)
    public E peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return elementData[first];
    }
    
    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }
    
    public class ArrayIterator implements Iterator<E> {
        private int i = 0;
        
        @Override
        public boolean hasNext() { return i < size; }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E element = elementData[(i + first) % elementData.length];
            i++;
            return element;
        }

        @Override
        public void remove() { throw new UnsupportedOperationException(); }
    }
    
    public static void main(String[] args) {
        ResizingArrayQueue<String> q = new ResizingArrayQueue<String>();
        while (!StdIn.isEmpty()) {
            String element = StdIn.readString();
            if (!element.equals("-")) q.enqueue(element);
            else if (!q.isEmpty()) {
                System.out.println(q.dequeue() + " ");
                System.out.println("(" + q.size() + " left on queue)");
            }
        }
    }

}
