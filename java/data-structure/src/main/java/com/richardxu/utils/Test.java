package com.richardxu.utils;

import com.richardxu.datastructure.Bag;
import com.richardxu.lib.StdIn;
import com.richardxu.lib.StdOut;

public class Test {
    
    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<Double>();
        while (!StdIn.isEmpty()) {
            double item = StdIn.readDouble();
            if (((int) item) == 0000)
                break;
            numbers.add(StdIn.readDouble());
        }
        int len = numbers.size();
        double sum = 0.0;
        for (Double d : numbers) {
            sum += d;
        }
        double mean = sum / len;
        System.out.printf("Mean: %.2f\n", mean);
        
        sum = 0.0;
        for (Double d : numbers) {
            sum += (d - mean) * (d - mean);
        }
        double std = Math.sqrt(sum / (len - 1));
        System.out.printf("Std dev: %.2f", std);
    }
}
