package Week7;

import java.util.*;

public class QuickSort1 {
    public static List<Integer> quickSort(List<Integer> arr) {
        List<Integer> list = new ArrayList<Integer>();
        int left = 0, equal = 0, right = 0;
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(0) > arr.get(i)) {
                list.add(left, arr.get(i));             //left < p (pt đầu tiên)
                left++;
                equal++;
                right++;
            } else if (arr.get(0) > arr.get(i)) {
                list.add(right, arr.get(i));
                right++;
            } else {
                list.add(equal, arr.get(i));
                equal++;
                right++;
            }
        }
        list.add(left, arr.get(0));
        return list;
    }

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<Integer>();
        array.add(3);
        array.add(2);
        array.add(4);
        array.add(5);
        array.add(7);

        System.out.print(quickSort(array));
    }
}
