package graphs;

public class NumOfOperationsToMakeNetworkConnected {
    public static void main(String[] args) {
        int n = 4;
        int[][] connections = {{0,1},{0,2},{1,2}};
        System.out.println(makeConnected(n, connections));
    }

    private static int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        int components = n;
        for (int[] conn : connections) {
            int u = find(conn[0], parent);
            int v = find(conn[1], parent);
            if (u != v) {
                if (rank[u] < rank[v]) {
                    parent[u] = v;
                } else if (rank[u] > rank[v]) {
                    parent[v] = u;
                } else {
                    parent[v] = u;
                    rank[u]++;
                }
                components--;
            }
        }
        return components - 1;
    }

    private static int find(int node, int[] parent) {
        if (parent[node] != node) {
            parent[node] = find(parent[node], parent);
        }
        return parent[node];
    }
}
