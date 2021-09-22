package Week3;

import static java.lang.Math.sin;
import java.util.Scanner;
class Sin {

    static void cal_sin(float n)
    {
        float accuracy = (float) 0.0001, denominator, sinx, sinval;

        // Converting degrees to radian
        n = n * (float)(3.142 / 180.0);

        float x1 = n;

        // maps the sum along the series
        sinx = n;

        // holds the actual value of sin(n)
        sinval = (float)sin(n);
        int i = 1;
        do
        {
            denominator = 2 * i * (2 * i + 1);
            x1 = -x1 * n * n / denominator;
            sinx = sinx + x1;
            i = i + 1;
        } while (accuracy <= sinval - sinx);
        System.out.println(sinx);
    }

// Main function


    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        //float n = sc.nextFloat();
        float n = Float.parseFloat(args[0]);
        cal_sin(n);
    }
}
