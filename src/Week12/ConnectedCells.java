package Week12;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConnectedCells {

//    static int[][] dir = new int[][] {{0,1},{1,0},{-1,0},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
//
//    public static int connectedCell(List<List<Integer>> matrix) {
//        Set<String> visited = new HashSet();
//        int size = 0;
//        int max = 0;
//
//        // From each filled cell, find the largest region from that cell
//        for(int i = 0; i < matrix.size(); i++) {
//            for(int j = 0; j < matrix.get(0).size(); j++) {
//                if(matrix.get(i).get(j) == 1) {
//                    dfs(matrix, i, j, visited);
//                    max = Math.max(visited.size() - size, max);
//                    size = visited.size();
//                }
//            }
//        }
//        return max;
//    }
//
//    public static void dfs(List<List<Integer>> matrix, int i, int j, Set<String> visited) {
//        if(i < 0 || j < 0 || i == matrix.size() || j == matrix.get(0).size()
//                || visited.contains(i + ":" + j) || matrix.get(i).get(j) == 0) {
//            return;
//        }
//        visited.add(i + ":" + j);
//        for(int[] d : dir) {
//            int x = i + d[0];
//            int y = j + d[1];
//            dfs(matrix, x, y, visited);
//        }
//    }

    public static int connectedCell(List<List<Integer>> matrix) {
        int max = 0;

        // From each filled cell, find the largest region from that cell
        for(int i = 0; i < matrix.size(); i++) {
            for(int j = 0; j < matrix.get(0).size(); j++) {
                if(matrix.get(i).get(j) == 1) {
                    int temp[] = {0};
                    dfs(matrix, i, j, temp);
                    max = Math.max(max, temp[0]);
                }
            }
        }
        return max;
    }

    static void dfs(List<List<Integer>> matrix, int i, int j, int c[]) {
        if(i >= matrix.size() || i < 0 || j >= matrix.get(0).size() || j < 0) return;
        if(matrix.get(i).get(j) == 0) return;

        matrix.get(i).set(j, 0);       // Make row zero
        c[0]++;

        dfs(matrix, i, j + 1, c);
        dfs(matrix, i, j - 1, c);
        dfs(matrix, i + 1, j, c);
        dfs(matrix, i - 1, j,  c);
        dfs(matrix, i - 1, j + 1,  c);
        dfs(matrix, i + 1, j + 1,  c);
        dfs(matrix, i + 1, j - 1,  c);
        dfs(matrix, i - 1, j - 1,  c);
    }
}
