package dynamicProgramming;

public class CoinChange2 {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(change(amount, coins));
    }

    private static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int coin : coins){
            for(int i = coin; i <= amount; i++){
                int notTake = dp[i];
                int take = dp[i - coin];
                dp[i] = take + notTake;
            }
        }
        return dp[amount];
    }
}
