package com.richardxu.gof.simplefactory;

/**
 * 简单工厂类：创建Api对象 
 */
public class Factory {
    public static Api createApi(int condition) {
        Api api = null;
        if (condition == 1) { 
            api = new ImplA();
        } else if (condition == 2) {
            api = new ImplB();
        }
        return api;
    }
}