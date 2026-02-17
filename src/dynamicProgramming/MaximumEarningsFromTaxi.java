package dynamicProgramming;

import java.util.*;

public class MaximumEarningsFromTaxi {
    public static void main(String[] args) {
        int n = 5;
        int[][] rides = {{2, 6, 4}, {1, 5, 1}};
        System.out.println(maxTaxiEarnings(n, rides));
    }

    private static long maxTaxiEarnings(int n, int[][] rides) {
        List<int[]>[] adj = new ArrayList[n + 1];
        long[] dp = new long[n + 2];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] r : rides){
            adj[r[0]].add(r);
        }
        for (int i = n - 2; i >= 1; i--) {
            long ans = dp[i + 1];
            for (int[] r : adj[i]){
                long profit = r[1] - i - r[2];
                ans = Math.max(ans, profit + dp[r[1]]);
            }
            dp[i] = ans;
        }
        return dp[1];
    }

//    private static long dfs(int i, int n, List<int[]>[] adj, long[] dp) {
//        if (i > n) return 0;
//        if (dp[i] != -1) return dp[i];
//        long ans = dfs(i + 1, n, adj, dp);
//        for (int[] r : adj[i]){
//            long profit = r[1] - i - r[2];
//            ans = Math.max(ans, profit + dfs(r[1], n, adj, dp));
//        }
//        return dp[i] = ans;
//    }
}
