package com.richardxu.concurrent.guarded_suspension;

import java.util.concurrent.TimeUnit;

public class ServerThread extends Thread {
    private RequestQueue requestQueue; // 请求队列

    public ServerThread(RequestQueue requestQueue, String name) {
        super(name);
        this.requestQueue = requestQueue;
    }
    
    public void run() {
        while(true) {
            final Request request = requestQueue.getRequest();          // 得到请求
            try {
                TimeUnit.MICROSECONDS.sleep(100);                       // 模拟请求处理耗时
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " handles " + request);
        }
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    public void setRequestQueue(RequestQueue requestQueue) {
        this.requestQueue = requestQueue;
    }

}
