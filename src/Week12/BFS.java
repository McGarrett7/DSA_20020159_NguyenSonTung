package Week12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        // m number of edges, n number of nodes, s: node start
        List<List<Integer>> adj = new ArrayList<>();   // Adjacency Lists
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>());    // Create a graph

        for(int i = 0; i < m; i++)
            addEdge(adj, edges.get(i).get(0)-1, edges.get(i).get(1)-1);

        int dist[] = new int[n];
        for(int i = 0; i < n; i++)
            dist[i] = Integer.MAX_VALUE;

        bfsShortestDist(adj, dist, s-1);

        for(int i = 0; i < n; i++)
            if(dist[i] == Integer.MAX_VALUE) dist[i] = -1;    // node is unreachable

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++)
            if(i != s - 1)
                //  the distances to nodes in increasing node number order, not including the start node
                ans.add(dist[i]);
        return ans;
    }

    static void addEdge(List<List<Integer>> adj, int v, int w){   // Add edges to the graph
        adj.get(v).add(w);
        adj.get(v).add(w);
    }

    static void bfsShortestDist(List<List<Integer>> adj, int dist[], int s){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);       // Root node is added to the top of queue
        dist[s] = 0;

        while(q.size() > 0){
            int temp = q.poll();

            for(int neighbor : adj.get(temp)){
                if(dist[temp] + 6 < dist[neighbor]) {     // current neighbor has not been visited
                    dist[neighbor] = dist[temp] + 6;
                    q.add(neighbor);
                }
            }
        }
    }
}
