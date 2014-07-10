package com.richardxu.utils;

import com.richardxu.lib.StdOut;
import com.richardxu.lib.StdRandom;
import com.richardxu.lib.VisualAccumulator;

public class Test {
    
    public static void main(String[] args) {
        int T = Integer.parseInt("2000");
        VisualAccumulator a = new VisualAccumulator(T, 1.0);
        for (int i = 0; i < T; i++) {
            a.addDataValue(StdRandom.random());
        }
        StdOut.println(a);
    }
}
