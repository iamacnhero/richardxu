package com.richardxu.concurrentpattern.producer_consumer.disruptor;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * Created by xufeng on 17/7/29.
 */
public class Producer {
    // 生产者需要一个RingBuffer的引用，也就是环形缓冲区
    private final RingBuffer<PCData> ringBuffer;

    public Producer(RingBuffer<PCData> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    // 将数据推入缓冲区
    public void pushData(ByteBuffer bb) {
        // 得到下一个可用的序列号
        long sequence = ringBuffer.next();
        try {
            // get the entry in the Disruptor for the sequence
            PCData event = ringBuffer.get(sequence);
            // 将 PCData 的数据设为期望值，这个值最终会传递给消费者
            event.setIntData(bb.getInt(0));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 数据发布：只有发布后的数据才会真正被消费者看见
            ringBuffer.publish(sequence);
        }
    }
}