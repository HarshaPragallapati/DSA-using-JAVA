package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInGridWithObstaclesElimination {
    public static void main(String[] args) {
        int[][] grid = {{0,0,0}, {1,1,0}, {0,0,0}, {0,1,1}, {0,0,0}};
        int k = 1;
        System.out.println(shortestPath(grid, k));
    }

    private static int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 1 && n == 1) return 0;
        boolean[][][] visited = new boolean[m][n][k + 1];
        visited[0][0][0] = true;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Quadraple> q = new LinkedList<>();
        q.add(new Quadraple(0, 0, 0, 0));
        while (!q.isEmpty()){
            Quadraple node = q.poll();
            for (int i = 0; i < 4; i++) {
                int newR = node.row + dx[i];
                int newC = node.col + dy[i];
                if (newR >= m || newR < 0 || newC >= n || newC < 0) continue;
                int obstacles = node.obstacles + grid[newR][newC];
                if (obstacles > k) continue;
                if (newR == m - 1 && newC == n - 1) return node.steps + 1;
                if (!visited[newR][newC][obstacles]){
                    visited[newR][newC][obstacles] = true;
                    q.add(new Quadraple(newR, newC, obstacles, node.steps + 1));
                }
            }
        }
        return -1;
    }

    private static class Quadraple{
        int row;
        int col;
        int obstacles;
        int steps;

        public Quadraple(int row, int col, int obstacles, int steps) {
            this.row = row;
            this.col = col;
            this.obstacles = obstacles;
            this.steps = steps;
        }
    }
}
