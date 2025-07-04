package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInUndirectedWithUnitEdges {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(1, 3)),
                        new ArrayList<>(Arrays.asList(0, 2)),
                        new ArrayList<>(Arrays.asList(1, 6)),
                        new ArrayList<>(Arrays.asList(0, 4)),
                        new ArrayList<>(Arrays.asList(3, 5)),
                        new ArrayList<>(Arrays.asList(4, 6)),
                        new ArrayList<>(Arrays.asList(2, 5, 7, 8)),
                        new ArrayList<>(Arrays.asList(6, 8)),
                        new ArrayList<>(Arrays.asList(7, 6))
                )
        );
        int[] shortest = shortestPath(adj, 0);
        for (int num : shortest){
            System.out.print(num + " ");
        }
    }

    private static int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int V = adj.size();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbor : adj.get(node)) {
                if (dist[neighbor] == Integer.MAX_VALUE) {
                    dist[neighbor] = dist[node] + 1;
                    q.add(neighbor);
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }

        return dist;
    }
}
