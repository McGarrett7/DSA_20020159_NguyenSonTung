package Week2;
//import edu.princeton.cs.algs4.StdArrayIO;
import java.util.Scanner;
public class Sum {
    public static void main(String[] args) {
        //In in = new In("F:\\algs4-data\\4Kints.txt"); // tạo luồng đọc từ file
        //int[] a = in.readAllInts();  // đọc toàn bộ file vào mảng a
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (a[i] + a[j] == 0)
                    System.out.println(a[i] +" "+ a[j]);
            }
        }
        //StdArrayIO.print(a); // in mảng ra màn hình
    }
}