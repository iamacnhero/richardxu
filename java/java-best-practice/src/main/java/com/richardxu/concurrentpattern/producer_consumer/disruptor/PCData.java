package com.richardxu.concurrentpattern.producer_consumer.disruptor;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 任务数据
 */
public class PCData {
    private int intData;  // 数据

    public void setIntData(int intData) {
        this.intData = intData;
    }

    public PCData() {
    }

    public PCData(int intData) {
        this.intData = intData;
    }

    public PCData(String intData) {
        this.intData = Integer.valueOf(intData);
    }

    public int getData() {
        return intData;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }

}
