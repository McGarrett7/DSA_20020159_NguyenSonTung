package Week5;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    public static void selectionSort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, min, i);
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
        int n = 10;
        Integer[] randArray = new Random().ints(0, 100).limit(n).boxed().toArray(Integer[]::new);
        //Integer[] arr = { 0, 1, 3, 2, 4, 5, 6, 9, 8, 7 };
        System.out.println("randArray = " + Arrays.toString(randArray));
        long start = System.currentTimeMillis();
        selectionSort(randArray);
        long end = System.currentTimeMillis();
        System.out.println("sortedArray = " + Arrays.toString(randArray) + " ");
        long time = end - start;
        System.out.println();
        System.out.println(time);
    }
}