package Week7;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class IntroTutorial {

    public static int introTutorial(int V, List<Integer> arr) {
        int l = 0, r = arr.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr.get(mid) == V) {
                return mid;
            } else if (arr.get(mid) < V) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println( Collections.binarySearch(list, 1));
    }
}

