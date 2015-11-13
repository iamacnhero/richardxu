package com.richardxu.gof.simplefactory;

/**
 * 接口实现A
 */
public class ImplA implements Api {
    public void operation(String s) {
        System.out.println("ImplA s == " + s);
    }
}