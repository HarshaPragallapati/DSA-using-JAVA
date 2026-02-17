package dynamicProgramming;

import java.util.Arrays;

public class MaxDotProductOfTwoSubsequences {
    public static void main(String[] args) {
        int[] nums1 = {3, -2}, nums2 = {2, -6, 7};
        System.out.println(maxDotProduct(nums1, nums2));
    }

    private static int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] prev = new int[m];
        Arrays.fill(prev, Integer.MIN_VALUE);
        for (int i = 0; i < n; i++) {
            int[] curr = new int[m];
            Arrays.fill(curr, Integer.MIN_VALUE);
            for (int j = 0; j < m; j++) {
                int take = nums1[i] * nums2[j];
                if (i > 0 && j > 0){
                    take += Math.max(0, prev[j - 1]);
                }
                int skip1 = i > 0 ? prev[j] : Integer.MIN_VALUE;
                int skip2 = j > 0 ? curr[j - 1] : Integer.MIN_VALUE;
                curr[j] = Math.max(take, Math.max(skip1, skip2));
            }
            prev = curr;
        }
        return prev[m - 1];
    }

//    private static int findDotProduct(int[] nums1, int[] nums2, int i, int j, int[][] dp) {
//        if (i < 0 || j < 0) return Integer.MIN_VALUE;
//        if (dp[i][j] != Integer.MIN_VALUE) return dp[i][j];
//        int take = nums1[i] * nums2[j] + Math.max(0, findDotProduct(nums1, nums2, i - 1, j - 1, dp));
//        int skip1 = findDotProduct(nums1, nums2, i - 1, j, dp);
//        int skip2 = findDotProduct(nums1, nums2, i, j - 1, dp);
//        return dp[i][j] = Math.max(take, Math.max(skip1, skip2));
//    }
}
