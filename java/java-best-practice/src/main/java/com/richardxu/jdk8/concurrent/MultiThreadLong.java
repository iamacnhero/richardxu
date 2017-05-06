package com.richardxu.jdk8.concurrent;

public class MultiThreadLong {
    
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + "...");
            }
        };
        t1.start();
    }
}
