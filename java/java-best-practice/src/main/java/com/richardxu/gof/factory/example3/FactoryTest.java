package com.richardxu.gof.factory.example3;

/**
 * Created by xufeng on 17/5/10.
 */
public class FactoryTest {
    public static void main(String[] args) {
        Sender sender = new SendMailFactory().produce();
        sender.send();
    }
}
