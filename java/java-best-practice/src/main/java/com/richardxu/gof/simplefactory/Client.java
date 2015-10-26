package com.richardxu.gof.simplefactory;

public class Client {
    public static void main(String[] args) {
        Api api = Factory.createApi(1);
        api.operation("使用简单工厂");
        
        api = ConfigurableFactory.createApi();
        api.operation("使用可配置的简单工厂");
    }
}