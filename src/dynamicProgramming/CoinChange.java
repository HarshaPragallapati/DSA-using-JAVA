package dynamicProgramming;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    private static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int coin : coins){
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];


//        int n = coins.length;
//        int[] prev = new int[amount + 1];
//        for (int i = 0; i <= amount; i++) {
//            if (i % coins[0] == 0){
//                prev[i] = i / coins[0];
//            }
//            else {
//                prev[i] = (int) (1e9);
//            }
//        }
//        for (int ind = 1; ind < n; ind++) {
//            int[] curr = new int[amount + 1];
//            for (int sum = 0; sum <= amount; sum++) {
//                int notTake = prev[sum];
//                int take = (int) (1e9);
//                if(coins[ind] <= sum){
//                    take = curr[sum - coins[ind]] + 1;
//                }
//                curr[sum] = Math.min(take, notTake);
//            }
//            prev = curr;
//        }
//        return prev[amount] >= 1e9 ? -1 : prev[amount];
    }
}
