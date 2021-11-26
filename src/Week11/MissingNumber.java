package Week11;

import java.util.*;

public class MissingNumber {
    public static List<Integer> missingNumbers1(List<Integer> arr, List<Integer> brr) {

        List<Integer> result = new ArrayList<>();
        int[] array = new int[10001];

        // Decrement the value in the array for the corresponding item we read
        // This indicates that that particular index is missing this number of times in brr
        // eg : consider input arr -> [7,2,5,3,5,3] brr -> [7,2,5,4,6,3,5,3]
        // we scan 7 and in 7th index in array we decrement its value so that array[7] = -1 ,
        // which means 7 is missing 1 times in brr
        for (int i = 0; i < arr.size(); i++) {
            int item = arr.get(i);
            array[item]--;
        }

        // similarly whenever we scan an item in brr , increment its value for the corresponding item in array
        // eg : after end of previous for loop , 7 is missing one times in brr.
        // now we found 7 in brr, so increment its corresponding index so that 7 is missing 0 times in brr
        for (int i = 0; i < brr.size(); i++) {
            int item = brr.get(i);
            array[item]++;
        }

        // if an element's value in array is >0 , it means that element is missing
        for (int i = 0; i < 10001; i++) {
            if (array[i] > 0) {
                result.add(i);
            }
        }
        return result;
    }

    public static List<Integer> missingNumbers2(List<Integer> arr, List<Integer> brr) {    //O(N)
        Hashtable<Integer, Integer> hashTable = new Hashtable<>();
        for(int i : brr){
            if(hashTable.containsKey(i)){
                hashTable.put(i, hashTable.get(i)+1);
            } else {
                hashTable.put(i, 1);
            }
        }
        for(int i : arr){
            if(hashTable.get(i) == 1){
                hashTable.remove(i);
            } else {
                hashTable.put(i, hashTable.get(i)-1);
            }
        }
        List<Integer> list = new ArrayList<>(hashTable.keySet()); //convert hashtable keys to a list
        Collections.sort(list);
        return list;
}

    public static List<Integer> missingNumbers3(List<Integer> arr, List<Integer> brr) {    //O(N)
        for (int i : arr) {
            Integer a = i;
            brr.remove(a);
        }
        Collections.sort(brr);
        List<Integer> ans = new ArrayList<>(new LinkedHashSet<>(brr));
        return ans;
    }
}
