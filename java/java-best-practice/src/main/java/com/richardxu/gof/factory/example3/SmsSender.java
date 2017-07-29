package com.richardxu.gof.factory.example3;

/**
 * Created by xufeng on 17/5/10.
 */
public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("smsSender!");
    }
}
