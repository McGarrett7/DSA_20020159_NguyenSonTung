package Week1;

import java.util.Scanner;
import java.util.Vector;
import java.util.Collections;
public class Ex1930 {
    public static void main(String[] args) {
        Vector<Double> v = new Vector<>();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        //Generate random double value from a to b
        for (int i=1; i<=5; i++){
            double random_double = Math.random() * (b - a + 1) + a;
            System.out.println(random_double);
            // Using the add() method
            v.add(random_double);
        }
        //Max(Min) number in vector
        Object max = Collections.max(v);
        Object min = Collections.min(v);
        System.out.println(max);
        System.out.println(min);
    }
}