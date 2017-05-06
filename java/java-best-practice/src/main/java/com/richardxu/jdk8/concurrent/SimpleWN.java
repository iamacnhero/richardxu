package com.richardxu.jdk8.concurrent;

public class SimpleWN {
    final static Object obj = new Object();
    
    public static class T1 extends Thread {
        public void run() {
            synchronized (obj) {
                System.out.println(System.currentTimeMillis() + ": T1 start!");
                try {
                    System.out.println(System.currentTimeMillis() + ": T1 wait for obj");
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ": T1 end!");
            }
        }
    }
    
    public static class T2 extends Thread {
        public void run() {
            synchronized (obj) {
                System.out.println(System.currentTimeMillis() + ": T2 start! notify one thread!");
                obj.notify();
                System.out.println(System.currentTimeMillis() + ": T2 end!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        t2.start();
    }
}
