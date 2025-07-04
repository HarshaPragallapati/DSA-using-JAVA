package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {
    public static void main(String[] args) {
        int[][] edges = {{3,0},{1,0},{2,0}};
        int V = 4;
        ArrayList<Integer> topo = topoSort(V, edges);
        System.out.println(topo);
    }

    private static ArrayList<Integer> topoSort(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]){
                dfs(adj, visited, st, i);
            }
        }
        while (!st.isEmpty()){
            result.add(st.pop());
        }
        return result;
    }

    private static void dfs(List<List<Integer>> adj, boolean[] visited, Stack<Integer> st, int node) {
        visited[node] = true;
        for (int neighbor : adj.get(node)){
            if (!visited[neighbor]){
                dfs(adj, visited, st, neighbor);
            }
        }
        st.push(node);
    }
}
