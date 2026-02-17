package graphs;

import java.util.ArrayList;
import java.util.List;

public class PossibleBipartition {
    public static void main(String[] args) {
        int n = 4;
        int[][] dislikes = {{1,2},{1,3},{2,4}};
        System.out.println(possibleBipartition(n, dislikes));
    }

    private static boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] d : dislikes){
            adj.get(d[0]).add(d[1]);
            adj.get(d[1]).add(d[0]);
        }
        int[] color = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0){
                if (!dfs(adj, i, 1, color)) return false;
            }
        }
        return true;
    }

    private static boolean dfs(List<List<Integer>> adj, int node, int c, int[] color) {
        color[node] = c;
        for (int neigh : adj.get(node)){
            if (color[neigh] == 0){
                if (!dfs(adj, neigh, -c, color)) return false;
            } else if (color[neigh] == c) {
                return false;
            }
        }
        return true;
    }
}
