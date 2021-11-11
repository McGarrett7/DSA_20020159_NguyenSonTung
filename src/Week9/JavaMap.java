package Week9;

import java.util.*;

class JavaMap{
    public static void main(String []argh) {
        Map people = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for(int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            in.nextLine();
            people.put(name, phone);      //O(N)
        }
        while(in.hasNext()) {             //kt nếu vòng lặp có pt tiếp theo ko
            String s = in.nextLine();
            if(people.containsKey(s))
                System.out.println(s + "=" + people.get(s));
            else
                System.out.println("Not found");
        }
    }
}
