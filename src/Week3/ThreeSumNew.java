package Week3;

import java.util.Arrays;

public class ThreeSumNew {
    public static void printAll(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        int j, k;

        for (int i = 0; i < n - 2; i++) {
            j = i + 1; // index of the first element in the remaining elements
            k = n - 1; // index of the last element
            while (j < k) {
                if (a[i] + a[j] + a[k] == 0) {
                    System.out.println(a[i] + ", " + a[j] + ", " + a[k]);
                    j++;
                    k--;
                } else if (a[i] + a[j] + a[k] < 0) {
                    j++;
                } else { // A[i] + A[l] + A[r] > 0
                    k--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, -7, -3, 5, -8, 9};
        printAll(a);
    }
}
