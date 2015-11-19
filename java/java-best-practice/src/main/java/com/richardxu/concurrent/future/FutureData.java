package com.richardxu.concurrent.future;

/**
 * FutureData是Future模式的关键，它实际上是真实数据RealData的代理，封装了获取RealData的等待过程
 * 
 * @author <a href="mailto:463692574@qq.com">许峰</a>
 * @version 1.0
 * @since 2015年11月20日
 */
public class FutureData implements Data {
    protected RealData realData = null;
    protected boolean isReady = false;
    
    public synchronized void setRealData(RealData realData) {
        if (isReady) return ;

        this.realData = realData;
        isReady = true;
        notifyAll();            // RealData已经被注入，通知getResult()
    }

    @Override
    public synchronized String getResult() {    // 会等待RealData构造完成
        while (!isReady) {
            try {
                wait();             // 一直等待，直到RealData被注入
            } catch (Exception e) {
                // 
            }
        }
        return realData.call();    // 由RealData实现
    }

}
