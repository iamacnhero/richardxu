package com.richardxu.algorithm.sort;

/**
 * 希尔排序：先取一个小于n的整数d1作为第一个增量，把文件的全部记录分组。
 * 所有距离为d1的倍数的记录放在同一个组中。先在各组内进行直接插入排序；
 * 然后，取第二个增量d2<d1重复上述的分组和排序，
 * 直至所取的增量dt=1(dt<dt-l<…<d2<d1)，即所有记录放在同一组中进行直接插入排序为止。
 * @author <a href="mailto:richardxu@live.cn">xufeng</a>
 * @date 2014-7-28 下午4:09:17
 *
 */
public class ShellSort<T extends Comparable<T>> {
    private ShellSort() {}

    public static <T extends Comparable<T>> void sort(T[] a) {
        int size = a.length;
        
        // 3x+1 increment sequence: 1, 4, 13, 40, 121, 364, 1093, ...
        int h = 1;
        while (h < size/3) {
            h = 3*h + 1;
        }
        while (h >= 1) {
            // 将数组变为h有序
            for (int i = h; i < size; i++) {
                // 将a[i]插入到a[i-h], a[i-2*h], a[i-3*h]...这中
                for (int j = i; j >=h && less(a[j-h], a[j]); j-=h) {
                    exch(a, j-h, j);
                }
            }
            h /= 3;
            show(a);
        }
    }
    
    /***********************************************************************
     *  Helper sorting functions
     ***********************************************************************/
    // is v > w ?
    private static <T extends Comparable<T>> boolean less(T v, T w) {
        return (v.compareTo(w) > 0);
    }
    
    // exchange a[i] and a[j]
    public static <T> void exch(T[] a, int i, int j) {
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
