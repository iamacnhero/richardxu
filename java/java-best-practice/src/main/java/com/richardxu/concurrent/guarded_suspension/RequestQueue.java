package com.richardxu.concurrent.guarded_suspension;

import java.util.LinkedList;

public class RequestQueue {
    private LinkedList<Request> queue = new LinkedList<Request>();
    public synchronized Request getRequest() {
        while (queue.size() == 0) {
            try {
                wait();                 // 等待直到有新的Request加入
            } catch (InterruptedException e) {
                // 
            }
        }
        return queue.remove();
    }
    
    public synchronized void addRequest(Request request) {
        queue.add(request);             // 加入新的Request请求
        notifyAll();                    // 通过getRequest()方法
    }
}