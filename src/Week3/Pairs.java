package Week3;

import java.util.*;

public class Pairs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;
        long arr[] = new long[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextLong();
        Arrays.sort(arr);
        int i = 0, j = 1;

        while(j < n) {
            long diff = arr[j] - arr[i];

            if (diff == k) {
                count++;
                j++;
            } else if (diff > k) {
                i++;
            } else if (diff < k) {
                j++;
            }
        }
        System.out.println(count);
    }
}