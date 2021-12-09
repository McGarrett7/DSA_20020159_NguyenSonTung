package Week13;

import java.util.*;

public class Prim {
    public static int prims(int n, List<List<Integer>> edges, int start) {
        Collections.sort(edges, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(2).compareTo(o2.get(2));
            }
        });
        List<Integer> isChecked = new ArrayList<>();
        List<List<Integer>> group = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int result = 0;
        int count = 0;
        int size = edges.size();
        int pos1 = 0;
        int pos2 = 0;
        boolean check;
        for (int i = 0; i < size; i++) {
            int start1 = edges.get(i).get(0);
            int dest = edges.get(i).get(1);
            check = true;
            if (!isChecked.contains(dest) || !isChecked.contains(start1)) {
                result += edges.get(i).get(2);
                isChecked.add(start1);
                isChecked.add(dest);
                count += 1;
                for (int k = 0; k < group.size(); k++) {
                    if (group.get(k).contains(start1)) {
                        group.get(k).add(dest);
                        check = false;
                        break;
                    } else if (group.get(k).contains(dest)) {
                        group.get(k).add(start1);
                        check = false;
                        break;
                    }
                }
                if (check) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(start1);
                    temp.add(dest);
                    group.add(temp);
                }
            } else {
                for (int k = 0; k < group.size(); k++) {
                    if (group.get(k).contains(start1) && group.get(k).contains(dest)) {
                        check = false;
                        break;
                    } else if (group.get(k).contains(start1)) {
                        pos1 = k;
                    } else if (group.get(k).contains(dest)) {
                        pos2 = k;
                    }
                }
                if (check) {
                    queue.add(edges.get(i).get(2));
                    List<Integer> temp = new ArrayList<>(group.get(pos1));
                    temp.addAll(group.get(pos2));
                    if (pos1 < pos2) {
                        group.remove(pos1);
                        group.remove(pos2 - 1);
                    } else {
                        group.remove(pos1);
                        group.remove(pos2);
                    }
                    group.add(temp);
                }
            }
        }
        while (count < n - 1) {
            result += queue.remove();
            count += 1;
        }
        return result;
    }


//    public static class Pair{
//        int v,w;
//        Pair(int v,int w){
//            this.v=v;
//            this.w=w;
//        }
//    }
//
//
//    public static int prims(int n, List<List<Integer>> edges, int start) {
//        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.w-b.w);
//        ArrayList<ArrayList<ArrayList<Integer>>> ls= new ArrayList<ArrayList<ArrayList<Integer>>>();
//        for(int i=0;i<=n;i++){
//            ls.add(new ArrayList<ArrayList<Integer>>());
//        }
//        for(List<Integer> e:edges){
//            int u=e.get(0);
//            int v=e.get(1);
//            int w=e.get(2);
//            ArrayList<Integer> t1=new ArrayList<>();
//            ArrayList<Integer> t2=new ArrayList<>();
//            t1.add(v);
//            t1.add(w);
//            t2.add(u);
//            t2.add(w);
//            ls.get(u).add(t1);
//            ls.get(v).add(t2);
//        }
//        boolean vis[]=new boolean[n+1];
//        pq.add(new Pair(start,0));
//        int sum=0;
//        while(!pq.isEmpty()){
//            Pair p=pq.poll();
//            if(!vis[p.v]){
//                vis[p.v]=true;
//                sum+=p.w;
//            }
//            for(ArrayList<Integer> adj:ls.get(p.v)){
//                if(!vis[adj.get(0)]){
//                    pq.add(new Pair(adj.get(0),adj.get(1)));
//                }
//            }
//        }
//        return sum;
//    }
}
