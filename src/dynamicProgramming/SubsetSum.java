package dynamicProgramming;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        System.out.println(isSubsetSum(arr, sum));
    }

    private static boolean isSubsetSum(int[] arr, int sum) {
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : arr){
            for (int i = sum; i >= num; i--) {
                if (dp[i - num]){
                    dp[i] = true;
                }
            }
        }
        return dp[sum];
    }
}
