package Week7;

import java.util.List;

public class FindTheMedian {
    private static int partition(List<Integer> arr, int lo, int hi) {
        if (lo >= hi) {
            return lo;
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
        if (index < arr.size() / 2) {
            return partition(arr, index + 1, hi);
        } else {
            return partition(arr, lo, index - 1);
        }
    }

    public static int findMedian(List<Integer> arr) {
        // Write your code here
        int index = partition(arr, 0, arr.size() - 1);
        return arr.get(index);
    }

}
