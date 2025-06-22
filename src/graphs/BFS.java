package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(2, 3, 1)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(2)));
        ArrayList<Integer> res = bfs(adj);
        System.out.println(res);
    }

    private static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()){
            Integer node = queue.poll();
            ans.add(node);
            for (Integer num : adj.get(node)){
                if(!visited[num]){
                    queue.add(num);
                    visited[num] = true;
                }
            }
        }
        return ans;
    }
}
