package graphs;

import java.util.*;

public class ShortestPathInWeightedUndirectedGraph {
    public static void main(String[] args) {
        int n = 5;
        int m = 6;
        int[][] edges = {{1,2,2},{2,5,5},{2,3,4},{1,4,1},{4,3,3},{3,5,1}};
        List<Integer> result = shortestPath(n, m, edges);
        System.out.println(result);
    }

    private static List<Integer> shortestPath(int n, int m, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges){
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        parent[1] = 1;
        pq.add(new Pair(1, 0));
        while (!pq.isEmpty()){
            Pair current = pq.poll();
            int node = current.node;
            int distance = current.distance;
            for (Pair pair : adj.get(node)){
                int edgeNode = pair.node;
                int edgeWt = pair.distance;
                if (dist[edgeNode] > distance + edgeWt){
                    parent[edgeNode] = node;
                    dist[edgeNode] = distance + edgeWt;
                    pq.add(new Pair(edgeNode, dist[edgeNode]));
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        if (dist[n] == Integer.MAX_VALUE){
            res.add(-1);
            return res;
        }
        int node = n;
        while (parent[node] != node){
            res.add(node);
            node = parent[node];
        }
        res.add(1);
        res.add(dist[n]);
        Collections.reverse(res);
        return res;
    }

    private static class Pair{
        int node;
        int distance;

        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
