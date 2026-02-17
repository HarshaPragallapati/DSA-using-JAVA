package dynamicProgramming;

import java.util.Scanner;

public class BuyAndSellStock3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        int max = maxProfit(prices);
        System.out.println(max);
    }

    private static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] ahead = new int[2][3];
        for (int ind = n - 1; ind >= 0; ind--) {
            int[][] curr = new int[2][3];
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap < 3; cap++) {
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

//    private static int maxProfit(int[] prices) {
//        int buy1 = Integer.MIN_VALUE, sell1 = 0;
//        int buy2 = Integer.MIN_VALUE, sell2 = 0;
//        for (int price : prices) {
//            buy1 = Math.max(buy1, -price);
//            sell1 = Math.max(sell1, buy1 + price);
//            buy2 = Math.max(buy2, sell1 - price);
//            sell2 = Math.max(sell2, buy2 + price);
//        }
//        return sell2;
//    }
}
