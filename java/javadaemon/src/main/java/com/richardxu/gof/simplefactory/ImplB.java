package com.richardxu.gof.simplefactory;

/**
 * 接口实现B
 */
public class ImplB implements Api{
    public void operation(String s) {
        System.out.println("ImplB s == " + s);        
    }
}