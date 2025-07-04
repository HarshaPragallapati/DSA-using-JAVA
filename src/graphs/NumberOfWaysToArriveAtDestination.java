package graphs;

import java.util.*;

public class NumberOfWaysToArriveAtDestination {
    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {
                {0, 6, 7},
                {0, 1, 2},
                {1, 2, 3},
                {1, 3, 3},
                {6, 3, 3},
                {3, 5, 1},
                {6, 5, 1},
                {2, 5, 1},
                {0, 4, 5},
                {4, 6, 2}
        };
        System.out.println(countPaths(n, roads));
    }

    private static int countPaths(int n, int[][] roads) {
        final int mod = (int) (1e9 + 7);
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            adj.get(road[0]).add(new Pair(road[1], road[2]));
            adj.get(road[1]).add(new Pair(road[0], road[2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.second));
        pq.add(new Pair(0, 0));
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        int[] ways = new int[n];
        ways[0] = 1;
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.first;
            long time = current.second;
            if (time > dist[node]) continue;
            for (Pair neighbor : adj.get(node)) {
                int neighNode = neighbor.first;
                long neighTime = neighbor.second;
                if (dist[neighNode] > time + neighTime) {
                    dist[neighNode] = time + neighTime;
                    pq.add(new Pair(neighNode, dist[neighNode]));
                    ways[neighNode] = ways[node];
                } else if (dist[neighNode] == time + neighTime) {
                    ways[neighNode] = (ways[neighNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n - 1];
    }

    private static class Pair{
        int first;
        long second;

        public Pair(int first, long second) {
            this.first = first;
            this.second = second;
        }
    }
}
