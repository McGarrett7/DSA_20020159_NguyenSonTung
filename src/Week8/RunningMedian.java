package Week8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class RunningMedian {

    public static List<Double> runningMedian(List<Integer> a) {
        //Cơ chế chia dãy thành 2 nửa: min nửa sau va max nửa trước
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        List<Double> result = new ArrayList<>();
        for (int b : a) {
            result.add(getMedianAndAddNumber(maxPQ, minPQ, b));
        }
        return result;
    }

    public static double getMedianAndAddNumber(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int num) {
        double med = 0.0;

        if (maxHeap.size() == minHeap.size()) {

            if (minHeap.size() == 0 || minHeap.peek() < num) {
                minHeap.add(num);
                //cân đối 2 dãy max và min
                maxHeap.add(minHeap.remove());   //xóa print các bước thêm phía trc vào pq
            } else {
                maxHeap.add(num);
            }
            med = maxHeap.peek() * 1.0;  //pt min trong maxHeap nhưng max trong maxPQ
        } else {
            if (minHeap.size() == 0 || maxHeap.peek() > num) {
                maxHeap.add(num);
                minHeap.add(maxHeap.remove());
            } else {
                minHeap.add(num);
            }
            med = (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        return med;
    }
}

//    public static List<Double> runningMedian(List<Integer> a) {
//        List<Double> medians=new ArrayList<>();
//        PriorityQueue<Integer> lowers=new PriorityQueue<Integer>(new Comparator<Integer>(){
//            public int compare(Integer a, Integer b){
//                return -1*a.compareTo(b);
//            }
//        });
//        PriorityQueue<Integer> highers=new PriorityQueue<Integer>();
//        for(int i :a){
//            addNumber(i,lowers,highers);
//            rebalance(lowers,highers);
//            medians.add(getMedians(lowers,highers));
//        }
//
//        return medians;
//    }
//    public static void addNumber(int num ,PriorityQueue<Integer> lowers,PriorityQueue<Integer> highers )
//    {
//        if(lowers.size()==0 || num<lowers.peek() ){
//            lowers.add(num);
//        }else{
//            highers.add(num);
//        }
//    }
//
//    public static void rebalance(PriorityQueue<Integer> lowers,PriorityQueue<Integer> highers ){
//        PriorityQueue<Integer> big=lowers.size()>highers.size()?lowers:highers;
//        PriorityQueue<Integer> small=lowers.size()>highers.size()?highers:lowers;
//
//        if(big.size()-small.size()>=2){
//            small.add(big.poll());
//        }
//
//    }
//
//    public static double getMedians(PriorityQueue<Integer> lowers,PriorityQueue<Integer> highers ){
//        PriorityQueue<Integer> big=lowers.size()>highers.size()?lowers:highers;
//        PriorityQueue<Integer> small=lowers.size()>highers.size()?highers:lowers;
//
//        if(big.size()==small.size()){
//            return ((double)big.peek()+small.peek())/2;
//        }else{
//            return big.peek();
//        }
//    }

