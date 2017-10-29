package com.richardxu.concurrent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntConsumer;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1,3,4,5};
        // 定义两个IntConsumer接口实例，一个指向标准输出，一个指向标准错误
        IntConsumer outprintln = System.out::println;
        IntConsumer errprintln = System.err::println;
        // 使用接口默认函数IntConsumer.addThen()，将两个IntConsumer进行组合，
        // 组合后，它会依次调用outprintln和errprintln
        Arrays.stream(arr).forEach(outprintln.andThen(errprintln));
    }
}
