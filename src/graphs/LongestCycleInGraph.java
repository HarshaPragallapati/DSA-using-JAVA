package graphs;

import java.util.*;

public class LongestCycleInGraph {
    public static void main(String[] args) {
        int[] edges = {3,3,4,2,3};
        System.out.println(longestCycle(edges));
    }

    private static int longestCycle(int[] edges) {
        int n = edges.length;
        int[] inDegree = new int[n];
        for(int edge : edges){
            if (edge != -1){
                inDegree[edge]++;
            }
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0){
                q.offer(i);
            }
        }
        while (!q.isEmpty()){
            int node = q.poll();
            visited[node] = true;
            int neighbor = edges[node];
            if (neighbor != -1){
                if (--inDegree[neighbor] == 0){
                    q.offer(neighbor);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                visited[i] = true;
                int neighbor = edges[i];
                int cnt = 0;
                while (neighbor != i){
                    cnt++;
                    visited[neighbor] = true;
                    neighbor = edges[neighbor];
                }
                res = Math.max(res, cnt);
            }
        }
        return res;
    }
}
