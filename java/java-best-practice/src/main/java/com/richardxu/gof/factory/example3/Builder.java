package com.richardxu.gof.factory.example3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xufeng on 17/5/11.
 */
public class Builder {
    private List<Sender> list = new ArrayList<>();

    public void produceMailSender(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new MailSender());
        }
    }
}
