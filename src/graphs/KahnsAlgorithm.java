package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnsAlgorithm {
    public static void main(String[] args) {
        int[][] edges = {{3,0},{1,0},{2,0}};
        int V = 4;
        ArrayList<Integer> topo = kahns(V, edges);
        System.out.println(topo);
    }

    private static ArrayList<Integer> kahns(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++){
            for (int it : adj.get(i)){
                inDegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0){
                q.add(i);
            }
        }
        while (!q.isEmpty()){
            int node = q.poll();
            result.add(node);
            for (int it : adj.get(node)){
                inDegree[it]--;
                if (inDegree[it] == 0){
                    q.add(it);
                }
            }
        }
        return result;
    }
}
