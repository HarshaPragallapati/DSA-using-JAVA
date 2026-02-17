package graphs;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SwimInRisingWater {
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}};
        System.out.println(swimInWater(grid));
    }

    private static int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        visited[0][0] = true;
        pq.add(new int[]{0, 0, grid[0][0]});
        int[] dr = {-1,0,1,0};
        int[] dc = {0,-1,0,1};
        while (!pq.isEmpty()){
            int[] node  = pq.poll();
            int r = node[0];
            int c = node[1];
            int level = node[2];
            if(r == n - 1 && c == n - 1) return level;
            for (int i = 0; i < 4; i++) {
                int newR = r + dr[i];
                int newC = c + dc[i];
                if (newR < n && newR >= 0 && newC < n && newC >= 0 && !visited[newR][newC]){
                    visited[newR][newC] = true;
                    pq.add(new int[]{newR, newC, Math.max(level, grid[newR][newC])});
                }
            }
        }
        return -1;
    }
}
