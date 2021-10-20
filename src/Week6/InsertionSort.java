package Week6;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdArrayIO;

public class InsertionSort {

    public static void insertionSort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1])) {
                    exch(a, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        //String[] a = StdIn.readAllStrings();
        In in = new In("F:\\algs4-data\\4Kints.txt");      // tạo luồng đọc từ file
        int[] a = in.readAllInts();                             // đọc toàn bộ file vào mảng a
        long start = System.currentTimeMillis();
        // xử lý dữ liệu trong mảng a
        //InsertionSort.insertionSort(a);

        long end = System.currentTimeMillis();
        long time = end - start;                               // thời gian chạy bằng end - start
        StdArrayIO.print(a);
        System.out.print(time);
    }
}

