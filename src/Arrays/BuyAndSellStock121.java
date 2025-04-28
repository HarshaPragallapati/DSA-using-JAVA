package Arrays;

public class BuyAndSellStock121 {
    public static void main(String[] args) {
        int[] prices = {7,2,5,1,5,3,6,4,7};
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
        System.out.println(max);
    }
}
