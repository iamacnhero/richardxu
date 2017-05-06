package com.richardxu.jdk8.concurrent;


public class UnsafeSequence {
    private int value;
    
    public synchronized int getNext() {
        return value++;
    }
    
    public static void main(String[] args) {
        UnsafeSequence s = new UnsafeSequence();
        for (int i = 0; i < 10; i++) {
            System.out.println(s.getNext());
        }
    }
}
