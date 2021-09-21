package Week1;

import java.util.Scanner;
public class Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //int n = Integer.parseInt(args [0]);
        int[] a = new int[n];                   // Khai bao mang
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        new sapXepTangDan(a, n);
        sc.close();
    }
}

