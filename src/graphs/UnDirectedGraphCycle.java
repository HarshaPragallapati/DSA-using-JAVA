package graphs;

import java.util.ArrayList;
import java.util.List;

public class UnDirectedGraphCycle {
    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{1,2},{2,3}};
        boolean ans = isCycle(4, edges);
        System.out.println(ans);
    }

    private static boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]){
                if (dfs(i, -1, visited, adj)) return true;
            }
        }
        return false;
    }

    private static boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;
        for (int it : adj.get(node)){
            if (!visited[it]){
                if (dfs(it, node, visited, adj)) return true;
            }
            else if(it != parent) return true;
        }
        return false;
    }
}
