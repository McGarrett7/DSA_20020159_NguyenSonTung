package Week11;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pairs {
        static int pair(int k, List<Integer> arr) {
            int count = 0;
            Set<Integer> s = new HashSet<Integer>(){{
                for(int i: arr) add(i);                 // thêm phần tử vào mảng băm  | O(N)
            }};

            for (int i : s) {
                if(s.contains(i+k)) {          // vs mỗi giá trị kiểm tra i+k (i-k) có nằm trong Set ko | O(2N)
                    count++;
                }
            }
            return count;
        }
    }

