package com.richardxu.concurrent.guarded_suspension;

public class Request {
    private String name;

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
