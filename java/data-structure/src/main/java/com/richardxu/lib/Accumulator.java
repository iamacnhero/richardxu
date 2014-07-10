package com.richardxu.lib;

public class Accumulator {
    private double total;
    private int N;
    
    /**
     * 添加一个新的数据值
     * @param val
     */
    public void addDataValue(double val) {
        N++;
        total += val;
    }
    
    /**
     * 平均值
     * @return
     */
    public double mean() {
        return total / N;
    }
    
    @Override
    public String toString() {
        return "Mean (" + N + " values): "
                + String.format("%7.5f", mean());
    }
    
}
