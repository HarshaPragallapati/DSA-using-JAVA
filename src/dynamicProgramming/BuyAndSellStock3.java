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
        int prev = 0, curr = prices[0];
        int max = 0;
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            if (prices[i] - curr > 0){
                if (prices[i] - curr > max){
                    if (max > prev){
                        prev = max;
                    }
                    max = prices[i] - curr;
                } else if (prices[i] - curr > prev) {
                    prev = prices[i] - curr;
                }
            }
            else {
                curr = prices[i];
            }
        }
        return prev + max;
    }
}
