package Week8;

import java.util.List;
import java.util.PriorityQueue;

public class JesseandCookies {
    public static int cookies(int k, List<Integer> A) {
        PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>();
        int count = 0;
        for(int num : A){
            pqueue.add(num);   //chèn vào cuối pq
        }
        while(pqueue.peek() != null && pqueue.peek() < k && pqueue.size() > 1){
            int m1 = pqueue.poll();     // pt đầu (nhỏ nhất): O(log(n))
            int m2 = pqueue.poll();    //lấy pt đầu (nhỏ thứ 2) và xóa nó: O(log(n))

            int sum = m1 + 2 * m2;
            pqueue.add(sum);
            count++;
        }

        if(pqueue.peek() == null || pqueue.peek() < k){
            return -1;
        }
        return count;

//        int returnVal = 0;
//        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Integer::compareTo);
//        pq.addAll(A);
//        while (true) {
//            if (pq.peek() >= k)
//                return returnVal;
//            if ((pq.size() == 1 && pq.peek() < k))
//                return -1;
//
//            int num1 = pq.poll();
//            int num2 = pq.poll();
//            pq.add(num1 + 2 * num2);
//            returnVal++;
//        }
//    }
//    PriorityQueue<Integer> queue=new PriorityQueue<Integer>();
//
//    for(int i=0;i<A.size();i++){
//        queue.add(A.get(i));
//    }
//    int result=0;
//    while(queue.size()>1){
//        if(queue.peek()>=k){
//            break;
//        }else{
//            int a=queue.poll();
//            int b=queue.poll();
//            int mix=a+(2*b);
//            queue.add(mix);
//            result++;
//        }
//
//    }
//    if(queue.peek()>=k){
//        return result;
//    }else{
//        return -1;
//    }
    }
}

