package Week8;

import java.util.Scanner;

public class JavaStringReverse {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String ans = "Yes";
        for(int i = 0; i < A.length()/2; i++)
            if( A.charAt(i) == A.charAt(A.length() - i - 1)) {
                ans = "Yes";
                } else {
                ans = "No";
                break;
            }
            System.out.println(ans);
    }
}
