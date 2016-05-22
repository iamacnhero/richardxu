package com.richardxu.concurrent.guarded_suspension;

public class Request {
    private String name;
    private Data response;          // 请求的返回值 
    
    public synchronized Data getResponse() {
        return response;
    }
    
    public synchronized void setResponse(Data response) {
        this.response = response;
    }

    public Request(String name) { // 模拟请求内容
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Request [name=" + name + "]";
    }
}
