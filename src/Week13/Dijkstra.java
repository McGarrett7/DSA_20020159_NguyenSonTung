package Week13;

import java.util.*;

public class Dijkstra {
    static class Edge implements Comparable<Edge> {
        int v1;
        int v2;
        int w;

        public Edge(int v1, int v2, int w) {
            this.v1 = v1;
            this.v2 = v2;
            this.w = w;
        }

        @Override
        public int compareTo(Dijkstra.Edge o) {
            return Integer.compare(this.w, o.w);
        }

        public int other(int v) {
            if (v == v1) {
                return v2;
            } else {
                return v1;
            }
        }

        static ArrayList<List<Edge>> graph(int n, List<List<Integer>> edges) {
            ArrayList<List<Edge>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (List<Integer> l : edges) {
                int v1 = 0;
                int v2 = 0;
                int w = 0;
                for (Integer input : l) {
                    v1 = v2;
                    v2 = w;
                    w = input;
                }
                v1--;
                v2--;
                Edge newEdge = new Edge(v1, v2, w);
                graph.get(v1).add(newEdge);
                graph.get(v2).add(newEdge);
            }
            return graph;
        }


        public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
            // Write your code here
            ArrayList<List<Edge>> graph = graph(n, edges);
            Queue<Integer> q = new ArrayDeque<>();
            HashMap<Integer, Integer> hm = new HashMap<>();
            s = s - 1;
            hm.put(s, 0);
            q.add(s);
            while (!q.isEmpty()) {
                int query = q.remove();
                for (Edge e : graph.get(query)) {
                    int v = e.other(query);
                    int dist = hm.get(query) + e.w;
                    if (hm.containsKey(v)) {
                        if (hm.get(v) > dist) {
                            hm.replace(v, dist);
                            q.add(v);
                        }
                    } else {
                        hm.put(v, dist);
                        q.add(v);
                    }
                }
            }
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (hm.containsKey(i)) {
                    if (hm.get(i) != 0) {
                        result.add(hm.get(i));
                    }
                } else {
                    result.add(-1);
                }
            }
            return result;
        }
    }
}