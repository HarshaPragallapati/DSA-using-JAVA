package trees;

import java.util.ArrayList;
import java.util.List;

public class MaximumNumberOfKDivisibleComponents {

    static int components = 0;

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,2},{1,2},{1,3},{2,4}};
        int[] values = {1,8,1,4,4};
        int k = 6;
        System.out.println(maxKDivisibleComponents(n, edges, values, k));
    }

    private static int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        dfs(0, -1, adj, values, k);
        return components;
    }

    private static long dfs(int node, int parent, List<List<Integer>> adj, int[] values, int k) {
        long sum = values[node];
        for (int edge : adj.get(node)){
            if (edge == parent) continue;
            sum += dfs(edge, node, adj, values, k);
        }
        if (sum % k == 0){
            components++;
            return 0;
        }
        return sum;
    }
}
