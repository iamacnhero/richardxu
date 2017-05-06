package com.richardxu.jdk8.concurrent;

public class StopThreadUnsafe {
    public static User u = new User();
    
    public static class User {
        private int id;
        private String name;
        public User() {
            id = 0;
            name = "0";
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        
        @Override
        public String toString() {
            return "User [id=" + id + ", name=" + name + "]";
        }
    }
    
    public static class ChangeObjectThread extends Thread {
        volatile boolean stop = false;
        
        public void stopIt() {
            stop = true;
        }
        
        @Override
        public void run() {
            while (true) {
                if (stop) {
                    System.out.println("exit by stop");
                    break;
                }
                synchronized (u) {
                    int v = (int) (System.currentTimeMillis()/1000);
                    u.setId(v);
                    
                    // do something else
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    u.setName(String.valueOf(v));
                }
                Thread.yield();
            }
        }
    }
    
    public static class ReadObjectThread extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (u) {
                    if (u.getId() != Integer.parseInt(u.getName())) {
                        System.out.println(u.toString());
                    }
                }
                Thread.yield();
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Interrupted!");
                        break;
                    }
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted when sleep");
                        Thread.currentThread().interrupt();
                    }
                    Thread.yield();
                }
            }
        };
        t1.start();
        Thread.sleep(200);
        t1.interrupt();
    }
}
