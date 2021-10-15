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
//        int N = Integer.parseInt(args[0]);
//        Double[] a = new Double[N];
//        for (int i = 0; i < N; i++)
//            a[i] = StdRandom.uniform();
//        selectionSort(a);
//        for (int i = 0; i < N; i++)
//            System.out.println(a[i]);

        int n = 10;
        Integer[] randArray = new Random().ints(0, 100).limit(n).boxed().toArray(Integer[]::new);
        System.out.println("randArray = " + Arrays.toString(randArray));
        selectionSort(randArray);
        System.out.println("sortedArray = " + Arrays.toString(randArray));
        System.out.println();
    }
}