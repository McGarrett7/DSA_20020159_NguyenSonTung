package Week6;

import java.util.Arrays;

public class InsertionSort1 {
    static void insertionSort1(int n, int[] arr) {
        int last = arr[n - 1], i = n - 2;
        for (; (i >= 0) && (arr[i] > last); i--) {
            arr[i + 1] = arr[i];
            printArray(arr);
        }
        arr[i + 1] = last;
        printArray(arr);
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2, 4, 6, 8, 3};
        insertionSort1(5, arr);
    }
}