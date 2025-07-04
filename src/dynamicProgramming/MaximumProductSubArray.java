package dynamicProgramming;

public class MaximumProductSubArray {
    public static void main(String[] args) {
        int[] nums = {2, 3, 2, -2, 4, -3};
        int max = maxProduct(nums);
        System.out.println(max);
    }

    private static int maxProduct(int[] nums) {
        int prev = 0, suff = 0;
        int ans = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (prev == 0) prev = 1;
            if (suff == 0) suff = 1;
            prev *= nums[i];
            suff *= nums[n - i -1];
            ans = Math.max(ans, Math.max(prev, suff));
        }
        return ans;
    }
}


