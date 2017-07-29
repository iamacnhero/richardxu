package com.richardxu.gof.factory.example3;

/**
 * Created by xufeng on 17/5/11.
 */
public class SendSmsFactory implements Provider {
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
