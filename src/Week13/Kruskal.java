package Week13;

import java.util.*;

public class Kruskal {
    static class Edge implements Comparable<Dijkstra.Edge> {
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

        public static int find(int[] uf, int i) {
            int query = i;
            while (query != uf[query]) {
                uf[query] = uf[uf[query]];    // path compression by halving
                query = uf[query];
            }
            return query;
        }

        public static void union(int[] uf, Map<Integer, Integer> hs, int node1, int node2) {
            node1 = find(uf, node1);
            node2 = find(uf, node2);
            if (node1 != node2) {
                if (hs.get(node1) > hs.get(node2)) {
                    uf[node2] = node1;
                    hs.replace(node1, hs.get(node2) + hs.get(node1));
                    hs.remove(node2);
                } else {
                    uf[node1] = node2;
                    hs.replace(node2, hs.get(node2) + hs.get(node1));
                    hs.remove(node1);
                }
            }
        }

        public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
            PriorityQueue<Edge> edges = new PriorityQueue<>();
            for (int i = 0; i < gFrom.size(); i++) {
                edges.add(new Edge(gFrom.get(i) - 1, gTo.get(i) - 1, gWeight.get(i)));
            }
            int[] uf = new int[gNodes];
            HashMap<Integer, Integer> hs = new HashMap<>();
            for (int i = 0; i < gNodes; i++) {
                hs.put(i, 1);
                uf[i] = i;
            }
            int result = 0;
            while (hs.size() > 1) {
                Edge e = edges.remove();
                if (find(uf, e.v1) != find(uf, e.v2)) {
                    result += e.w;
                    union(uf, hs, e.v1, e.v2);
                }
            }
            return result;
        }
    }
}
