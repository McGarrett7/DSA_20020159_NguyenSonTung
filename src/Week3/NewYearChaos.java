package Week3;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class NewYearChaos {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        int count = 0;
        boolean flag = false;
        for (int i = q.size(); i >= 1; i--) {
            if (q.get(i - 1) != i) {
                if((i - 2) >= 0 && q.get(i - 2) == i) {
                    int swap1 = q.get(i - 1);
                    int swap2 = q.get(i - 2);
                    q.set(i - 1, swap2);
                    q.set(i - 2, swap1);
                    count++;
                }
                else if ((i - 3) >= 0 && q.get(i - 3) == i) {
                    int swap1 = q.get(i - 1);
                    int swap2 = q.get(i - 2);
                    int swap3 = q.get(i - 3);
                    q.set(i - 1, swap3);
                    q.set(i - 2, swap1);
                    q.set(i - 3, swap2);
                    count += 2;
                } else {
                    flag = true;
                    break;
                }
            }
        }
            System.out.println(flag?"Too chaotic":count);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] qTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> q = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qTemp[i]);
                q.add(qItem);
            }

            Result.minimumBribes(q);
        }

        bufferedReader.close();
    }
}
