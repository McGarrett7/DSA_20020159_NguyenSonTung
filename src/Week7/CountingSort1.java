package Week7;

import java.util.*;

public class CountingSort1 {
    public static List<Integer> countingSort(List<Integer> arr) {
        ArrayList<Integer> count = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            count.add(0);
        }
        for (int i = 0; i < arr.size(); i++) {
            count.set(arr.get(i), count.get(arr.get(i)) + 1);  //set(int index, Object element) gán pt vào chỉ số
        }
        return count;
    }
}

