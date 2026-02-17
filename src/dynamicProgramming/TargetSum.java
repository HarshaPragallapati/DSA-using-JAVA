package dynamicProgramming;

public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        System.out.println(findTargetSumWays(nums, target));
    }

    private static int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        int n = nums.length;
        for (int num : nums){
            total += num;
        }
        if (target > total || target < -total) return 0;
        int[] next = new int[2 * total + 1];
        next[total + target] = 1;
        for (int ind = n - 1; ind >= 0; ind--) {
            int[] curr = new int[2 * total + 1];
            for (int sum = -total; sum <= total; sum++) {
                int shifted = sum + total;
                int plus = 0, minus = 0;
                if(sum + nums[ind] <= total && sum + nums[ind] >= -total){
                    plus = next[total + sum + nums[ind]];
                }
                if (sum - nums[ind] <= total && sum - nums[ind] >= -total){
                    minus = next[total + sum - nums[ind]];
                }
                curr[shifted] = plus + minus;
            }
            next = curr;
        }
        return next[total];


//        memoization
//        for (int[] num : dp){
//            Arrays.fill(num, -1);
//        }
//        return solve(0, 0, nums, target, total, dp);
    }

//    private static int solve(int ind, int sum, int[] nums, int target, int total, int[][] dp) {
//        if (ind == nums.length){
//            return sum == target ? 1 : 0;
//        }
//        int shifted = sum + total;
//        if (dp[ind][shifted] != -1){
//            return dp[ind][shifted];
//        }
//        int plus = solve(ind + 1, sum + nums[ind], nums, target, total, dp);
//        int minus = solve(ind + 1, sum - nums[ind], nums, target, total, dp);
//        return dp[ind][shifted] = plus + minus;
//    }
}
