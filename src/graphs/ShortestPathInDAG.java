package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathInDAG {
    public static void main(String[] args) {
        int[][] edges = {{0,1,2}, {0,2,1}};
        int[] shortest = shortestPath(4, edges.length, edges);
        for (int num : shortest){
            System.out.print(num + " ");
        }
    }

    private static int[] shortestPath(int V, int E, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new int[]{v, wt});
        }
        boolean[] visited = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]){
                dfs(i, adj, visited, st);
            }
        }
        int[] dist = new int[V];
        Arrays.fill(dist, (int) (1e9));
        dist[0] = 0;
        while (!st.isEmpty()){
            int node = st.pop();
            for (int[] it : adj.get(node)){
                int u = it[0];
                int wt = it[1];
                if (dist[node] + wt < dist[u]){
                    dist[u] = dist[node] + wt;  
                }
            }
        }
        for (int i = 0; i < V; i++) {
            if (dist[i] == 1e9) dist[i] = -1;
        }
        return dist;
    }

    private static void dfs(int node, List<List<int[]>> adj, boolean[] visited, Stack<Integer> st) {
        visited[node] = true;
        for (int[] neighbor : adj.get(node)){
            int v = neighbor[0];
            if (!visited[v]){
                dfs(v, adj, visited, st);
            }
        }
        st.push(node);
    }
}
