package com.richardxu.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.richardxu.lib.StdIn;

/**
 * <p>
 * 用可变数组实现的堆栈, 当底层的数组满的时候，增大1.5倍，
 * 将底层数组的数据不到四分之一的时候，缩小一半.
 * The <em>push</em> and <em>pop</em> operations take constant amortized time.
 * The <em>size</em>, <em>peek</em>, and <em>is-empty</em> operations takes
 * constant time in the worst case.
 * </p> 
 * @author <a href="mailto:richardxu@live.cn">xufeng</a>
 *
 */
@SuppressWarnings("unchecked")
public class ResizingArrayStack<E> implements Iterable<E> {
    private E[] elementData;      // array of elements
    private int size;   // number of elements on stack
    
    // 初始化一个空栈
    public ResizingArrayStack() {
        elementData = (E[]) new Object[2];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    // 构造一个临时数组对底层数组进行扩容
    private void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = elementData[i];
        }
        elementData = temp;
    }
    
    // 将添加的新元素放到数组尾部, 即栈顶
    public void push(E element) {
        if (size == elementData.length) {
            int oldCapacity = elementData.length;       // 增大1.5倍
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            resize(newCapacity);
        }
        elementData[size++] = element;
    }

    // 从数组尾部, 即栈顶取出元素
    public E pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        E element = elementData[size - 1];     // 取最后一个元素
        elementData[size - 1] = null;       // to avoid loitering
        size--;
        // 收缩数组大小, 如果需要的话
        if (size > 0 && size == elementData.length/4)
            resize(elementData.length / 4);
        return element;
    }
    
    // 返回最新入队的元素(数组尾部元素)
    public E peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return elementData[size - 1];
    }
    
    @Override
    public Iterator<E> iterator() {
        return new ReverseArrayIterator();
    }
    
    private class ReverseArrayIterator implements Iterator<E> {
        private int i;

        public ReverseArrayIterator() { i = size; }
        
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public E next() {   // 按数组下标的反方向循环输出所有栈元素
            if (!hasNext()) throw new NoSuchElementException();
            return elementData[--i];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    
    public static void main(String[] args) {
        ResizingArrayStack<String> s = new ResizingArrayStack<String>();
        while (!StdIn.isEmpty()) {
            String element = StdIn.readString();
            if (!element.equals("-")) s.push(element);
            else if (!s.isEmpty()) {
                System.out.println(s.pop());
                System.out.println("(" + s.size() + " left on stack)");
            }
        }
    }
}
