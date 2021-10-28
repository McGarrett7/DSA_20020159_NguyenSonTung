package Week7;

import java.util.*;

public class QuickSort1 {
    public static List<Integer> quickSort(List<Integer> arr) {
        List<Integer> array = new ArrayList<Integer>();
        int lo = 0;
        int eq = 0;
        int hi = 0;
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(0) > arr.get(i)) {
                array.add(lo, arr.get(i));
                lo++;
                eq++;
                hi++;
            } else if (arr.get(0) > arr.get(i)) {
                array.add(hi, arr.get(i));
                hi++;
            } else {
                array.add(eq, arr.get(i));
                eq++;
                hi++;
            }
        }
        array.add(lo, arr.get(0));
        return array;
    }

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<Integer>();
        array.add(3);
        array.add(2);
        array.add(4);
        array.add(5);
        array.add(7);

        quickSort(array);
    }
}
