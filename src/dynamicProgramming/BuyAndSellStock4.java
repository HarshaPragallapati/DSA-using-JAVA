package dynamicProgramming;

public class BuyAndSellStock4 {
    public static void main(String[] args) {
        int k = 2;
        int[] prices = {3, 2, 6, 5, 0, 3};
        System.out.println(maxProfit(k, prices));
    }

    private static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] ahead = new int[2][k];
        for (int ind = n - 1; ind >= 0; ind--) {
            int[][] curr = new int[2][k];
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap <= k; cap++) {
                    if (buy == 0){
                        curr[buy][cap] = Math.max(-prices[ind] + ahead[1][cap],
                                ahead[0][cap]);
                    }
                    else {
                        curr[buy][cap] = Math.max(prices[ind] + ahead[0][cap - 1],
                                ahead[1][cap]);
                    }
                }
            }
            ahead = curr;
        }
        return ahead[0][2];
    }
}
