package com.richardxu.algorithm.sort;

import java.util.Random;

/**
 * 快速排序：通过一趟排序将待排记录分割成独立的两部分，其中一部分记录的关键字均比另一部分记录的关键字小，
 * 则可分别对这两部分记录继续进行排序，以达到整个序列有序的目的。
 */
public class QuickSort {
    private QuickSort() {};
    
    private static <T extends Comparable<T>> void shuffle(T[] a) {
        Random random = new Random();
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = i + random.nextInt(N-i);     // between i and N-1
            T temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
    
    public static <T extends Comparable<T>> void sort(T[] a) {
        shuffle(a);     // 消除对输入的依赖，不强制
        sort(a, 0, a.length - 1);
    }
    
    public static <T extends Comparable<T>> void sort(T[] a, int lo, int hi) {
        if (hi <= lo) return ;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }
    
    public static <T extends Comparable<T>> int partition(T[] a, int lo, int hi) {
        // 将数组切分为a[lo .. i-1], a[i], a[i+1 .. hi]
        int i = lo, j = hi + 1;     // 左右扫描指针
        T v = a[lo];        // 切分元素 
        while (true) {
            // 扫描左右，检查扫描是否结束并交换元素
            while (less(v, a[++i]))
                if (i == hi) break;
            
            // find item on hi to swap
            while (less(a[--j], v))
                if (j == lo) break;
            
            // check if pointers cross
            if (i >=  j) break;
            
            exch(a, i, j);
        }
        exch(a, lo, j);     // 把 v = a[j] 放入正确的位置
        return j;           // a[lo .. j-1] <= a[j] <= a[j+1 .. hi] 达成
    }
    
    /***********************************************************************
     *  Helper sorting functions
     ***********************************************************************/
     // is v > w ?
     private static <T extends Comparable<T>> boolean less(T v, T w) {
         return (v.compareTo(w) > 0);
     }
         
     // exchange a[i] and a[j]
     private static <T extends Comparable<T>> void exch(T[] a, int i, int j) {
         T swap = a[i];
         a[i] = a[j];
         a[j] = swap;
     }
     
     public static <T> void show(T[] a) {
         StringBuilder sb = new StringBuilder("");
         for (T i : a) {
             sb.append(i + ", ");
         }
         int len = sb.length();
         sb.delete(len-2, len);
         System.out.println(sb.toString());
     }
     
     public static void main(String[] args) {
         Integer[] a = {7, 4, 2, 3, 15, 12, 16, 21, 18, 19, 30, 21, 23, 17, 13, 14};
         sort(a);
         show(a);
         
         String[] countryList = {"china", "japan", "usa", "russia"};
         sort(countryList);
         show(countryList); 
    }
}
