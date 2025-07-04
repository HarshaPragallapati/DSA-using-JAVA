package graphs;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    public static void main(String[] args) {
        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(minimumEffortPath(heights));
    }

    private static int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;
        PriorityQueue<Tuple> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        pq.add(new Tuple(0, 0, 0));
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!pq.isEmpty()){
            Tuple tuple = pq.poll();
            int distance = tuple.distance;
            int r = tuple.row;
            int c = tuple.col;
            if (r == n - 1 && c == m - 1){
                return distance;
            }
            for (int i = 0; i < 4; i++) {
                int newR = r + dx[i];
                int newC = c + dy[i];
                if (newR >= 0 && newC >= 0 && newR < n && newC < m){
                    int newEffort = Math.max(Math.abs(heights[r][c] - heights[newR][newC]), distance);
                    if (newEffort < dist[newR][newC]){
                        dist[newR][newC] = newEffort;
                        pq.add(new Tuple(newEffort, newR, newC));
                    }
                }
            }
        }
        return 0;
    }

    private static class Tuple {
        int distance;
        int row;
        int col;

        public Tuple(int distance, int row, int col) {
            this.distance = distance;
            this.row = row;
            this.col = col;
        }
    }
}
