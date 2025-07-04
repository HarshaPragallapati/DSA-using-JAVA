package graphs;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraphCycle {
    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{1,2},{2,0},{2,3}};
        int V = 4;
        System.out.println(isCyclic(V, edges));
    }

    private static boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[1];
            int v = edge[0];
            adj.get(u).add(v);
        }
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfsCheck(adj, visited, pathVisited, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfsCheck(List<List<Integer>> adj, boolean[] visited, boolean[] pathVisited, int node) {
        visited[node] = true;
        pathVisited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfsCheck(adj, visited, pathVisited, neighbor)) {
                    return true;
                }
            } else if (pathVisited[neighbor]) {
                return true;
            }
        }
        pathVisited[node] = false;
        return false;
    }
}
