package graphs;

import java.util.*;

public class CheapestFlightWithinKStops {
    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600}};
        int src = 0;
        int dst = 3;
        int k = 1;
        System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }

    private static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights){
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<Tuple> pq = new LinkedList<>();
        pq.add(new Tuple(0, src, 0));
        while (!pq.isEmpty()){
            Tuple tuple = pq.poll();
            int node = tuple.node;
            int cost = tuple.cost;
            int stops = tuple.stops;
            if(stops > k) continue;
            for (Pair neighbor : adj.get(node)){
                int adjNode = neighbor.first;
                int adjCost = neighbor.second;
                if (dist[adjNode] > cost + adjCost){
                    dist[adjNode] = cost + adjCost;
                    pq.add(new Tuple(dist[adjNode], adjNode, stops + 1));
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}

class Pair{
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Tuple{
    int cost;
    int node;
    int stops;

    public Tuple(int cost, int node, int stops) {
        this.cost = cost;
        this.node = node;
        this.stops = stops;
    }
}
