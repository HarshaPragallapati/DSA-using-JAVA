package dynamicProgramming;

import java.util.Scanner;

public class BuyAndSellStock {
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
        int curr = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - curr > 0){
                max = Math.max(max, prices[i] - curr);
            }
            else {
                curr = prices[i];
            }
        }
        return max;
    }
}
