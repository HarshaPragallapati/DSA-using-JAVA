package dynamicProgramming;

public class BuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        int n = prices.length;
        int[] ahead = new int[2];
        int[] ahead2 = new int[2];
        for (int ind = n - 1; ind >= 0; ind--) {
            int[] curr = new int[2];
            for (int buy = 0; buy < 2; buy++) {
                if (buy == 0){
                    curr[buy] = Math.max(ahead[0], -prices[ind] + ahead[1]);
                }
                else {
                    curr[buy] = Math.max(ahead[1], prices[ind] + ahead2[0]);
                }
            }
            ahead2 = ahead;
            ahead = curr;
        }
        return ahead[0];
    }
}
