package com.richardxu.concurrentpattern.producer_consumer.disruptor;

import com.lmax.disruptor.WorkHandler;

/**
 * Created by xufeng on 17/7/29.
 */
public class Consumer implements WorkHandler<PCData> {

    @Override
    public void onEvent(PCData pcData) throws Exception {
        // 计算平方, 接下来可以存储之
        System.out.println(
                Thread.currentThread().getId() + ": " + pcData.getData() + "'s square: " + pcData.getData() * pcData.getData());
    }
}
