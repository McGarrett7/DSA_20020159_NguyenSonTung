package Week7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuickSortInPlace {
    public static void quickSort(List<Integer> arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int pivot = hi;
        int index = lo;
        for (int i = lo; i < pivot; i++) {
            if (arr.get(i) < arr.get(pivot)) {
                Integer temp = arr.get(i);
                arr.set(i, arr.get(index));
                arr.set(index, temp);
                index++;
            }
        }
        Integer temp = arr.get(pivot);
        arr.set(pivot, arr.get(index));
        arr.set(index, temp);
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
        quickSort(arr, lo, index - 1);
        quickSort(arr, index + 1, hi);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            Integer newInt = Integer.valueOf(scanner.nextInt());
            arr.add(newInt);
        }
        scanner.close();
        quickSort(arr, 0, n - 1);
    }

}
