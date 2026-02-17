package slidingWindow;

import java.util.Arrays;

public class MinDifferenceBetweenHighestAndLowestOfKScores {
    public static void main(String[] args) {
        int[] nums = {9, 4, 1, 7};
        int k = 2;
        System.out.println(minimumDifference(nums, k));
    }

    private static int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int i = 0, j = k - 1;
        while (j < n){
            minDiff = Math.min(minDiff, nums[j++] - nums[i++]);
        }
        return minDiff;
    }
}
