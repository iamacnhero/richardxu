package com.richardxu.utils;

import java.util.Arrays;

import com.richardxu.lib.Counter;
import com.richardxu.lib.StdRandom;



public class Test {
    
    public static void main(String[] args) {
        Integer T = 5;
        int SIDES = 6;
        Counter[] rolls = new Counter[SIDES + 1];
        for (int i = 0; i <= SIDES; i++) {
            rolls[i] = new Counter(i + "'s");
        }
        
        for (int i = 0; i < T; i++) {
            int result = StdRandom.uniform(1, SIDES + 1);
            rolls[result].increment();
        }
        
        System.out.println(Arrays.toString(rolls));
    }
}
