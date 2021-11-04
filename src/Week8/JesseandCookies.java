package Week8;

import java.util.List;
import java.util.PriorityQueue;

public class JesseandCookies {
    public static int cookies(int k, List<Integer> A) {
        PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>();
        int count = 0;
        for(int num : A){
            pqueue.add(num);
        }
        while(pqueue.peek() != null && pqueue.peek() < k && pqueue.size()>1){
            int smallest = pqueue.poll();
            int smaller = pqueue.poll();

            int sum = smallest + 2 * smaller;
            pqueue.add(sum);
            count++;
        }

        if(pqueue.peek() == null || pqueue.peek()<k){
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

