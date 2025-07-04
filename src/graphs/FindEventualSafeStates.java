package graphs;

import java.util.*;

public class FindEventualSafeStates {
    public static void main(String[] args) {
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        List<Integer> result = eventualSafeNodes(graph);
        System.out.println(result);
    }

    private static List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> revAdj = new ArrayList<>();
        int V = graph.length;
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            revAdj.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            for (int edge : graph[i]){
                revAdj.get(edge).add(i);
                inDegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0){
                q.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            for (int it : revAdj.get(node)){
                if (--inDegree[it] == 0){
                    q.add(it);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
