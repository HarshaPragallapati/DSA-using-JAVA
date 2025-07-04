package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BipartiteGraph {
    public static void main(String[] args) {
        int[][] edges = {{0,3},{1,2},{3,2},{0,2}};
        int V = 4;
        System.out.println(isBipartite(edges, V));
    }

    private static boolean isBipartite(int[][] edges, int V) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] color = new int[V];
        Arrays.fill(color, -1);
        for (int i = 0; i < V; i++) {
            if (color[i] == -1){
                if (!dfs(i, 0, color, adj)) return false;
            }
        }
        return true;
    }

    private static boolean dfs(int node, int col, int[] color, List<List<Integer>> adj) {
        color[node] = col;
        for (int neighbor : adj.get(node)){
            if (color[neighbor] == -1){
                if (!dfs(neighbor, 1 - col, color, adj)) return false;
            } else if (color[neighbor] == col) {
                return false;
            }
        }
        return true;
    }
}
