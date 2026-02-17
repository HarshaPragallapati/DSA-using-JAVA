package dynamicProgramming;

public class NumberOfSmoothDescentPeriodsOfStock {
    public static void main(String[] args) {
        int[] prices = {3, 2, 1, 4};
        System.out.println(getDescentPeriods(prices));
    }

    private static long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long cnt = 1;
        int prev = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] - prices[i - 1] == -1){
                cnt += i - prev + 1;
            }
            else {
                cnt++;
                prev = i;
            }
        }
        return cnt;
    }
}
