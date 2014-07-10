package com.richardxu.utils;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class ListUtils {
    
    /**
     * 反转数组
     * @param p
     * @return
     */
    public static <T> T[] reverseArr(T[] p) {
        int length = p.length;
        for (int i = 0; i < length / 2; i++) {
            T temp = p[i];
            p[i] = p[length - i - 1];
            p[length - i - 1] = temp;
        }
        return p;
    }
    
    /**
     * 反转列表
     * @param lists
     * @return
     */
    public static <T> List<T> reverse(List<T> lists) {
        int len = lists.size();
        int middle = len / 2;
        for (int i = 0; i < middle; i++) {
            T temp = lists.get(len - i - 1);
            lists.set(len - i - 1, lists.get(i));
            lists.set(i, temp);
        }
        return lists;
    }

    @Test
    public void testReverse() {
        List<String> countrys = Arrays.asList("China", "Japan", "America", "Russia", "Germany");
        System.out.println(reverse(countrys));
    }
}
