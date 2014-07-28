package com.richardxu.algorithm.sort;


/**
 * 选择排序：首先，找到数组中最小的那个元素，其次，将它和数组的第一个元素交换位置。再次，
 * 在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置，如此反复，直到将整个数组排序。
 * 对于长度为N的数组，选择排序需要大约N²/2次比较和N次交换。 
 * 7, 4, 2, 3
 * [2], 7, 4, 3
 * [2, 3], 7, 4
 * [2, 3, 4], 7
 * [2, 3, 4, 7]
 * @author <a href="mailto:richardxu@live.cn">xufeng</a>
 * @date 2014-7-28 上午10:55:54
 *
 */
public class SelectionSort<T extends Comparable<T>> {
    //  无法外部调用构造器
    private SelectionSort() {}
    
    public static <T extends Comparable<T>> void sort(T[] a) {
        int size = a.length;
        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j = i+1; j < size; j++) {
                if (less(a[min], a[j])) min = j;
            }
            exch(a, min, i);
        }
    }
    
    /**********************************************************
     * Helper Sorting functions
     *********************************************************/
    // is v > w ?
    private static <T extends Comparable<T>> boolean less(T v, T w) {
        return ((v.compareTo(w)) > 0);
    }
    
    // exchange a[i] and a[j]
    private static <T> void exch(T[] a, int i, int j) {
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
	    Integer[] a = {7, 4, 2, 3};
        sort(a);
        show(a);
        
        String[] countryList = {"china", "japan", "usa", "russia"};
        sort(countryList);
        show(countryList);
	}
}