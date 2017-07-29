package com.richardxu.concurrentpattern.producer_consumer;

import java.io.Serializable;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int a = 127;
        int b = 10;
        System.out.println( b & a);
    }
}

