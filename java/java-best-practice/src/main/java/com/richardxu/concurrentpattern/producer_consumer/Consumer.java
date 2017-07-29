package com.richardxu.concurrentpattern.producer_consumer;

import com.richardxu.concurrentpattern.producer_consumer.disruptor.PCData;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue<PCData> queue;        // 内存缓冲区
    private static final int SLEEP_TIME = 1000;

    public Consumer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("start consumer, threadId = " + Thread.currentThread().getId());
        Random random = new Random();

        try {
            while (true) {
                PCData data = queue.take();         // 提取数据
                if (null != data) {
                    int re = data.getData() * data.getData();   // 计算平方
                    System.out.println(MessageFormat.format("{0} * {1} = {2}",
                            data.getData(), data.getData(), re));
                    Thread.sleep(random.nextInt(SLEEP_TIME));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
