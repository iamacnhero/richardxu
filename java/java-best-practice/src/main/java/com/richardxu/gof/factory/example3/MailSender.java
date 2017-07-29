package com.richardxu.gof.factory.example3;

import akka.io.Udp;

/**
 * Created by xufeng on 17/5/10.
 */
public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("mailSender!");
    }
}
