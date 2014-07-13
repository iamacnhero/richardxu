package com.richardxu.utils;

import com.richardxu.datastructure.Stack;

public class Test {
    
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(3);
        stack.push(5);
        stack.push(6);
        for (Integer i : stack) {
            System.out.println(i);
        }
        
    }
}