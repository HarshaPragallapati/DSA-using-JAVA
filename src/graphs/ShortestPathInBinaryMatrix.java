package graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    private static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0)
            return -1;
        if (n == 1) return 1;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<Triplet> q = new LinkedList<>();
        dist[0][0] = 1;
        q.add(new Triplet(1, 0 , 0));
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        while (!q.isEmpty()){
            Triplet trip = q.poll();
            int distance = trip.first;
            int r = trip.second;
            int c = trip.third;
            for (int i = 0; i < 8; i++) {
                int newRow = r + dx[i];
                int newCol = c + dy[i];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0 && distance + 1 < dist[newRow][newCol]){
                    dist[newRow][newCol] = distance + 1;
                    if (newRow == n - 1 && newCol == n - 1){
                        return distance + 1;
                    }
                    q.add(new Triplet(distance + 1, newRow, newCol));
                }
            }
        }
        return -1;
    }

    private static class Triplet{
        int first;
        int second;
        int third;

        public Triplet(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
}
