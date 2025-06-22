package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int minutes = orangesRotting(grid);
        System.out.println(minutes);
    }

    private static int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1){
                    fresh++;
                }
                if (grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
            }
        }
        if (fresh == 0) return 0;
        int count = 0;
        int minTime = 0;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int j = 0; j < 4; j++) {
                    int x = curr[0] + dx[j];
                    int y = curr[1] + dy[j];
                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || grid[x][y] == 2) continue;
                    grid[x][y] = 2;
                    q.offer(new int[]{x, y});
                    count++;
                }
            }
            if (!q.isEmpty()){
                minTime++;
            }
        }
        return count == fresh ? minTime : -1;
    }
}
