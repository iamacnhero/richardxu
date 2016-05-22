package com.richardxu.concurrent.guarded_suspension;

import java.util.concurrent.TimeUnit;

public class ClientThread extends Thread {
    private RequestQueue requestQueue;              // 请求队列

    public ClientThread(RequestQueue requestQueue, String name) {
        super(name);
        this.requestQueue = requestQueue;
    }
    
    public void run() {
        for (int i = 0; i < 10; i++) {
            Request request = new Request("RequestID: " + i + " ThreadName: " + Thread.currentThread().getName());
            requestQueue.addRequest(request);       // 提交请求
            try {
                TimeUnit.MICROSECONDS.sleep(10);    // 客户端请求的速度, 快于服务端处理的速度
            } catch (InterruptedException e) {
                // 
            }
            System.out.println("ClientThread Name is: " + Thread.currentThread().getName());
        }
        System.out.println(Thread.currentThread().getName() + " request end");
    }
    
    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    public void setRequestQueue(RequestQueue requestQueue) {
        this.requestQueue = requestQueue;
    }
}
