package dynamicProgramming;

public class MinimumFallingPathSum {
    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(minFallingPathSum(matrix));
    }

    private static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] dp = new int[n];
        int[] curr = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = matrix[n - 1][i];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int down = dp[j];
                int sw = j - 1 >= 0 ? dp[j - 1] : Integer.MAX_VALUE;
                int se = j + 1 < n ? dp[j + 1] : Integer.MAX_VALUE;
                curr[j] = matrix[i][j] + Math.min(down, Math.min(sw, se));
            }
            dp = curr.clone();
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[i]);
        }
        return ans;
    }
}
