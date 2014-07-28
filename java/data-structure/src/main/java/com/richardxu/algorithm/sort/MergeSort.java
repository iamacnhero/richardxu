package com.richardxu.algorithm.sort;

/**
 * 归并排序是将两个或两个以上的有序表合并成一个有序表。归并排序法有二路归并排序等。
 * @author <a href="mailto:richardxu@live.cn">xufeng</a>
 * @date 2014-7-28 下午7:32:53
 *
 */
public class MergeSort<T extends Comparable<T>> {
    private MergeSort() {}
    
    // stably merge a[lo .. mid] with a[mid+1 .. hi] using aux[lo .. hi]
    private static <T extends Comparable<T>> void merge(T[] a, T[] aux, int lo, int mid, int hi) {
        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        
        // merge back to a[]
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)                    a[k] = aux[j++];
            else if (j > hi)                a[k] = aux[i++];
            else if (less(aux[i], aux[j]))  a[k] = aux[j++];
            else                            a[k] = aux[i++];
        }
    }
    
    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static <T extends Comparable<T>> void sort(T[] a, T[] aux, int lo, int hi) {
        if (lo >= hi) return ;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
    }
    
    private static <T extends Comparable<T>> boolean less(T v, T w) {
        return (v.compareTo(w) > 0);
    }
    
    private static <T extends Comparable<T>> void show(T[] a) {
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
