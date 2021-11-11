package Week9;

import java.util.*;

public class JavaHashSet {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String [] pair_left = new String[n];
        String [] pair_right = new String[n];

        for (int i = 0; i < n; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        HashSet<String> pairs = new HashSet<String>(n);
        for(int i = 0; i < n; i++)
        {
            pairs.add(pair_left[i] + " " + pair_right[i]);    //O(1)
            System.out.println(pairs.size());
        }
    }
}