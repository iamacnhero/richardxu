package com.richardxu.concurrent.future;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class RealData implements Callable<String> {
    private String para;
    public RealData(String para) {
        this.para = para;
    }
    
    public String call() {
        // RealData的构造可能很慢，需要用户等待很久，这里使用sleep模拟
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(para);
            try {
                TimeUnit.MICROSECONDS.sleep(100);
            } catch (Exception e) {
                // 
            }
        }
        return sb.toString();
    }
    
}
