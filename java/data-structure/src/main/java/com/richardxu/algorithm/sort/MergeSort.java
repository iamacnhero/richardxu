package com.richardxu.algorithm.sort;

/**
 * 归并排序是将两个或两个以上的有序表合并成一个有序表。归并排序法有二路归并排序等。
 * @author <a href="mailto:richardxu@live.cn">xufeng</a>
 * @date 2014-7-28 下午7:32:53
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MergeSort<T extends Comparable<T>> {
    private MergeSort() {}
    
    private static Comparable[] aux; // 归并所需的辅助数组
    
    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];     // 一次性分配空间
        sort(a, 0, a.length - 1);
    }
    
    private static <T extends Comparable<T>> void sort(T[] a, int lo, int hi) {
        // 将数组a[lo..hi]排序
        if (hi <= lo) return ;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);       // 将左半边排序
        sort(a, mid+1, hi);     // 将右半边排序
        merge(a, lo, mid, hi);  // 归并结果
    }
    
    // 将a[lo..mid]和a[mid+1..hi]归并
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k]; 
        }
        
        for (int k = lo; k <= hi; k++) {    // 归并到a[lo..hi]
            if      (i > mid)              a[k] = aux[j++]; // 左半边用尽(取右半边的元素)
            else if (j > hi)               a[k] = aux[i++]; // 右半边用尽(取左半边的元素)
            else if (less(aux[i], aux[j])) a[k] = aux[j++]; // 左半边的当前元素大于右半边的当前元素(取右半边的元素)
            else                           a[k] = aux[i++]; // 右半边的当前元素大于等于左半边的当前元素(取左半边的元素)
        }
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
