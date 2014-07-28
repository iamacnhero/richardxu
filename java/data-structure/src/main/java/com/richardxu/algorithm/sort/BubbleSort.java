package com.richardxu.algorithm.sort;

/**
 * 在算法执行的时候，最大的数据项总是“冒泡”到数组的顶端，故称为“冒泡”排序。
 * 冒泡的方法是从前往后的冒泡，越大的值越往后；也可以从后向前冒泡，把越小的值冒泡到前面。
 * 7, 4, 2, 3
 * 4, 2, 3, 7
 * 2, 3, 4, 7
 * @author <a href="mailto:richardxu@live.cn">xufeng</a>
 */
public class BubbleSort<T extends Comparable<T>> {
    
    public static <T extends Comparable<T>> void sort(T[] a) { // 顺序, 向后冒泡
        boolean flag = true;
        int length = a.length;
        while (flag) {
            flag = false;
            for (int i = 0; i < length - 1; i++) {  // 用length-1，如果用length, 下面的length+1会溢出
                if (less(a[i], a[i+1])) {
                    exch(a, i, i + 1);
                    flag = true;
                }
            }
        }
    }
    
    public static <T extends Comparable<T>> void forwardSort(T[] a) {  // 顺序, 向前冒泡
        boolean flag = true;
        int length = a.length;
        while (flag) {
            flag = false;
            for (int i = length-2; i >= 0; i--) {   // 用length-1，如果用length, 下面的length+1会溢出
                if (a[i].compareTo(a[i + 1]) > 0) {
                    exch(a, i, i + 1);
                    flag = true;
                }
            }
        }
    }
    
    public static <T extends Comparable<T>> void descendingSort(T[] a) {   // 倒序, 向后冒泡
        boolean flag = true;
        int len = a.length;
        while (flag) {
            flag = false;
            for (int i=1; i<len; i++) {
                if (less(a[i], a[i-1])) {
                    exch(a, i-1, i);
                    flag = true;
                }
            }
        }
    }   

    // is v > w ?
    private static <T extends Comparable<T>> boolean less(T v, T w) {
        return ((v.compareTo(w)) > 0);
    }
    
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
        descendingSort(a);
        show(a);
        
        String[] countryList = {"china", "japan", "usa", "russia"};
        sort(countryList);
        show(countryList);
        descendingSort(countryList);
        show(countryList);
	}

}
