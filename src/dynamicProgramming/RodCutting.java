package dynamicProgramming;

public class RodCutting {
    public static void main(String[] args) {
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(price));
    }

    private static int cutRod(int[] price) {
        int n = price.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i * price[0];
        }
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= n; target++) {
                int notTake = dp[target];
                int take = 0;
                if(ind + 1 <= target){
                    take = price[ind] + dp[target - ind - 1];
                }
                dp[target] = Math.max(take, notTake);
            }
        }
        return dp[n];
    }

//    memoization ->
//    private static int maxPrice(int ind, int[] price, int target, int[][] dp) {
//        if (ind == 0){
//            return target * price[0];
//        }
//        if (dp[ind][target] != 0){
//            return dp[ind][target];
//        }
//        int notTake = maxPrice(ind - 1, price, target, dp);
//        int take = 0;
//        if(ind + 1 <= target){
//            take = price[ind] + maxPrice(ind, price, target - ind - 1, dp);
//        }
//        return dp[ind][target] = Math.max(take, notTake);
//    }
}
