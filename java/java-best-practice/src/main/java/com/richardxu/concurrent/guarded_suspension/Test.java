package com.richardxu.concurrent.guarded_suspension;

public class Test {
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();     // 请求队列
        for (int i = 0; i < 10; i++) {
            // 服务器进程开启
            new ServerThread(requestQueue, "ServerThread" + i).start();
        }
        
        for (int i = 0; i < 10; i++) {
            // 请求进程开启
            new ClientThread(requestQueue, "ClientThread" + i).start();
        }
    }
}