package com.richardxu.algorithm.string;

public class ForceMatch {
    /**
     * 暴力模式匹配(Java的String类型的indexOf()方法使用的就是暴力子字符串查找算法)
     * @param text 主串
     * @param pattern 模式串
     * @return 如果找到，返回在主串中第一个字符出现的下标，否则为-1
     */
    public static int indexOf(String text, String pattern) {
        char[] t = text.toCharArray();
        char[] p = pattern.toCharArray();
        
        int i = 0;  // 主串的位置
        int j = 0;  // 模式串的位置
        while (i<t.length && j<p.length) {
            if (t[i] == p[j]) {     // 当两个字符相同，就比较下一个
                i++;
                j++;
            } else {
                // 如果不匹配，i回溯, j 归 0, 继续下一轮匹配 
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == p.length)  // 完整匹配了pattern，返回匹配到的位置
            return i - j;
        else    // 没有匹配，返回-1
            return -1;
    }
    
    public static void main(String[] args) {
        String text = "chinachina";
        String pattern = "ch";
        
        System.out.println(indexOf(text, pattern));
        
        pattern = "thi";
        text = "this is china";
        
        System.out.println(indexOf(text, pattern));
    }
}
