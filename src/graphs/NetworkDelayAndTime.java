package graphs;

import java.util.*;

public class NetworkDelayAndTime {
    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;
        System.out.println(networkDelayTime(times, n, k));
    }

    private static int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : times){
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.second));
        pq.add(new Pair(k, 0));
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.first;
            int time = current.second;
            if (visited[node]) continue;
            visited[node] = true;
            for (Pair neighbor : adj.get(node)) {
                int neighNode = neighbor.first;
                int neighTime = neighbor.second;
                if (!visited[neighNode] && dist[neighNode] > time + neighTime) {
                    dist[neighNode] = time + neighTime;
                    pq.add(new Pair(neighNode, dist[neighNode]));
                }
            }
        }
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }
        return maxTime;
    }
}
