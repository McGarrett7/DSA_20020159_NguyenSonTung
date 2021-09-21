package Week1;

import java.util.Scanner;
public class Ex14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        if (a % b == 0 || b % a == 0) {
            System.out.println("true");
        }
        if (a % b != 0 && b % a != 0) {
            System.out.println("false");
        }
    }
}

