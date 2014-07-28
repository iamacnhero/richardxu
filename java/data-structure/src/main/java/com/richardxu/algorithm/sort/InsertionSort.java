package com.richardxu.algorithm.sort;

/**
 * 直接插入排序(Straight Insertion Sort) 的基本操作是将一个记录插入到已经排好序的表序表中，从而得到一个新的有序表
 * 7, 4, 2, 3
 * [7], 4, 2, 3
 * [4, 7], 2, 3
 * [2, 4, 7], 3
 * [2, 3, 4, 7]
 * @author <a href="mailto:richardxu@live.cn">xufeng</a>
 */
public class InsertionSort<T extends Comparable<T>> {
    private InsertionSort() {}
    
	public static <T extends Comparable<T>> void sort(T[] a) {
	    int size = a.length;
	    for (int i = 0; i< size; i++) {
	        for (int j = i; j > 0 && less(a[j-1], a[j]); j--) {
                exch(a, j-1, j);
            }
        }
	}
	
	/***********************************************************************
	 *  Helper sorting functions
	 ***********************************************************************/	
	// is v > w ?
    private static <T extends Comparable<T>> boolean less(T v, T w) {
        return (v.compareTo(w) > 0);
    }	
    
    // exchange a[i] and [j]
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