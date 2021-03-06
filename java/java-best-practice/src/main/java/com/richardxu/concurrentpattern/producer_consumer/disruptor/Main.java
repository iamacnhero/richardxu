package com.richardxu.concurrentpattern.producer_consumer.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SleepingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Executor executor = Executors.newCachedThreadPool();
        PCDataFactory factory = new PCDataFactory();
        // 指定环大小，必须为2的整数次幂
        int bufferSize = 1024;
        Disruptor<PCData> disruptor = new Disruptor<PCData>(
                factory, bufferSize, executor, ProducerType.MULTI, new SleepingWaitStrategy());
        disruptor.handleEventsWithWorkerPool(
                new Consumer(), new Consumer(), new Consumer());
        disruptor.start();

        RingBuffer<PCData> ringBuffer = disruptor.getRingBuffer();
        Producer producer = new Producer(ringBuffer);
        ByteBuffer bb = ByteBuffer.allocate(8);
        for (int i = 0; true; i++) {
            bb.putInt(0, i);
            producer.pushData(bb);
            System.out.println("add data " + i);
            Thread.sleep(100);
        }
    }
}
