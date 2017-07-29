package com.richardxu.concurrentpattern.producer_consumer.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * PCData 的工厂类
 */
public class PCDataFactory implements EventFactory<PCData> {

    @Override
    public PCData newInstance() {
        return new PCData();
    }
}
