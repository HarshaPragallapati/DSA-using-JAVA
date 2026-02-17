package dynamicProgramming;

public class BestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(maxProfit(prices, fee));
    }

    private static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int cash = 0;
        int hold = -prices[0];
        for (int ind = 1; ind < n; ind++) {
            cash = Math.max(cash, prices[ind] - fee + hold);
            hold = Math.max(hold, -prices[ind] + cash);
        }
        return cash;
    }
}
