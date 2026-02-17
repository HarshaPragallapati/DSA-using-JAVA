package dynamicProgramming;

import java.util.Arrays;

public class PathsInMatrixWhoseSumIsDivisibleByK {

    static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        int[][] grid = {{5,2,4}, {3,0,5}, {0,7,2}};
        int k = 3;
        System.out.println(numberOfPaths(grid, k));
    }

    private static int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] prev = new int[n][k];
        prev[n - 1][grid[m - 1][n - 1] % k] = 1;
        for (int r = m - 1; r >= 0; r--) {
            int[][] curr = new int[n][k];
            for (int c = n - 1; c >= 0; c--) {
                for (int rem = 0; rem < k; rem++) {
                    if (prev[c][rem] == 0) continue;
                    if (r > 0){
                        int newRem = (grid[r - 1][c] + rem) % k;
                        curr[c][newRem] = (curr[c][newRem] + prev[c][rem]) % MOD;
                    }
                    if (c > 0){
                        int newRem = (grid[r][c - 1] + rem) % k;
                        prev[c - 1][newRem] = (prev[c - 1][newRem] + prev[c][rem]) % MOD;
                    }
                }
            }
            if(r > 0){
                prev = curr;
            }
        }
        return prev[0][0];
    }
}
