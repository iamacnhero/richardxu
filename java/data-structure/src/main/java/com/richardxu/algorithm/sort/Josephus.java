package com.richardxu.algorithm.sort;

import java.util.Arrays;
import java.util.Scanner;

import com.richardxu.lib.Stopwatch;

/**
 * 约瑟夫环问题:
 * 由m个人围成一个首尾相连的圈报数，
 * 人第1个人开始，从1开始报数，报到n的人出局，
 * 剩下的人继续从1开始报数，直到所有的人都出局为止。
 * 对于给定的m和n，求出所有人的出局顺序。
 * @author <a href="mailto:richardxu@live.cn">xufeng</a>
 * @date 2014-8-3 下午3:23:22
 *
 */
public class Josephus {
    private static int count = 0;   // 定义数到的人的编号
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入人数: ");
        int personNum = scanner.nextInt();
        System.out.println("请输入出局号码：");
        int outNum = scanner.nextInt();
        
        Stopwatch timer = new Stopwatch();
        sortP(personNum, outNum);
        System.out.println("所用总时间：" + timer.elapsedTime());
    }
    
    private static void sortP(int personNum, int outNum) {
        if (personNum == 1)         // 特殊情况
            System.out.println(personNum);
        else
            f1(personNum, outNum);
    }
    
    private static void f1(int personNum, int outNum) {
        int[] arr = new int[personNum];
        for (int i = 0; i < personNum; i++) {       // 循环执行n(总人数)次，排出出局次序
            for (int j = 0; j < outNum; j++) {
                count++;        // 每数1人count加1
                measure(i, arr);        // 判断count是否已在数组中
                if (count > personNum) {
                    count = 1;      // 若count大于总人数将其置1
                    measure(i, arr);    // 继续执行判断
                }
            }
            arr[i] = count;     // 将出局人序号保存到数组
        }
        System.out.println("出局顺序为：" + Arrays.toString(arr));
        System.out.println("最后出局人为：" + arr[personNum - 1]);
    }
    
    private static void measure(int j, int[] arr) {
        for (int i = 0; i < j; i++) {
            for (int k = 0; k < j; k++) {
                if (count == arr[k])
                    count++;
            }
        }
    }
    
    
}
