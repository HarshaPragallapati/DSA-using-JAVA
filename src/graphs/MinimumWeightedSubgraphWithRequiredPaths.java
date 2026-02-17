package graphs;

import java.util.*;

public class MinimumWeightedSubgraphWithRequiredPaths {
    public static void main(String[] args) {
        int n = 6, src1 = 0, src2 = 1, dest = 5;
        int[][] edges = {
                {0, 2, 2},
                {0, 5, 6},
                {1, 0, 3},
                {1, 4, 5},
                {2, 1, 1},
                {2, 3, 3},
                {2, 3, 4},
                {3, 4, 2},
                {4, 5, 1}
        };
        System.out.println(minimumWeight(n, edges, src1, src2, dest));
    }

    private static long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        List<List<int[]>> adj = new ArrayList<>();
        List<List<int[]>> revAdj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            revAdj.add(new ArrayList<>());
        }
        for (int[] edge : edges){
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new int[]{v, w});
            revAdj.get(v).add(new int[]{u, w});
        }
        long[] dist1 = dijkstra(n, adj, src1);
        long[] dist2 = dijkstra(n, adj, src2);
        long[] distD = dijkstra(n, revAdj, dest);
        long res = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dist1[i] == Long.MAX_VALUE || dist2[i] == Long.MAX_VALUE || distD[i] == Long.MAX_VALUE){
                continue;
            }
            res = Math.min(res, dist1[i] + dist2[i] + distD[i]);
        }
        return res == Long.MAX_VALUE ? -1 : res;
    }

    private static long[] dijkstra(int n, List<List<int[]>> adj, int src) {
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[src] = 0;
        pq.offer(new long[]{src, 0});
        while (!pq.isEmpty()){
            long[] curr = pq.poll();
            int node = (int) curr[0];
            long wt = curr[1];
            if (wt > dist[node]) continue;
            for (int[] neighbor : adj.get(node)){
                 int neighNode = neighbor[0];
                 int neighWt = neighbor[1];
                 if (dist[neighNode] > wt + neighWt){
                     dist[neighNode] = wt + neighWt;
                     pq.offer(new long[]{neighNode, dist[neighNode]});
                 }
            }
        }
        return dist;
    }
}
