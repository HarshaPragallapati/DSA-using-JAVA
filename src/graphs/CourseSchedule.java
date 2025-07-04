package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0},{0,1}};
        System.out.println(canFinish(numCourses, prerequisites));
    }

    private static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites){
            adj.get(edge[1]).add(edge[0]);
        }
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++){
            for (int it : adj.get(i)){
                inDegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        // ArrayList<Integer> result = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0){
                q.add(i);
            }
        }
        while (!q.isEmpty()){
            int node = q.poll();
            // result.add(node);
            count++;
            for (int it : adj.get(node)){
                inDegree[it]--;
                if (inDegree[it] == 0){
                    q.add(it);
                }
            }
        }
        return count == numCourses;
    }
}
