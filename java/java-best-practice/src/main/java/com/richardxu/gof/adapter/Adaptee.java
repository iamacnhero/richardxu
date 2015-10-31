package com.richardxu.gof.adapter;

// 已经存在的类，需要被适配
public class Adaptee {
    public void specificRequest() {
        System.out.println("已经存在的类，需要被适配的方法");
    }
}