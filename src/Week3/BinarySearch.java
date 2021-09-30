package Week3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BinarySearch {
    public static int binarySearch(int[] a, int number) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (a[mid] == number) {
                return mid;
            } else if (a[mid] < number) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    public static int rBinarySearch(int[] a, int low, int high, int x) {
        if (high >= low) {                               // right >= left
            int mid = low + (high - low) / 2;

            if (a[mid] == x) {
                return mid;
            } else if (x < a[mid]) {
                return rBinarySearch(a, low, mid - 1, x);
            } else {
                return rBinarySearch(a, mid + 1, high, x);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int n = 10;
        int[] randArray = new Random().ints(0, 100).limit(n).toArray();
        Arrays.sort(randArray);
        System.out.println("randArray = " + Arrays.toString(randArray));
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int input = sc.nextInt();
            int result = binarySearch(randArray, input);
            if (result == -1) {
                System.out.println("-1");
            } else {
                System.out.println("Element found at index " + result);
            }
        }
    }
}