package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
        System.out.println(printLIS(nums));
    }

    private static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i] > temp.getLast()){
                temp.add(nums[i]);
            }
            else {
                int idx = Collections.binarySearch(temp, nums[i]);
                if (idx < 0){
                    idx = - (idx + 1);
                }
                temp.set(idx, nums[i]);
            }
        }
        return temp.size();
    }

//    private static int lengthOfLIS(int[] nums) {
//        int n = nums.length;
//        int[] dp = new int[n];
//        Arrays.fill(dp, 1);
//        int maxi = 0;
//        for (int ind = 0; ind < n; ind++) {
//            for (int prev = 0; prev < ind; prev++) {
//                if (nums[prev] < nums[ind]){
//                    dp[ind] = Math.max(dp[ind], 1 + dp[prev]);
//                }
//            }
//            maxi = Math.max(maxi, dp[ind]);
//        }
//        return maxi;
//    }

    private static List<Integer> printLIS(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        int[] back = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            back[i] = i;
        }
        int max_ind = 0;
        for (int ind = 0; ind < n; ind++) {
            for (int prev = 0; prev < ind; prev++) {
                if (nums[prev] < nums[ind]){
                    if (dp[prev] + 1 > dp[ind]){
                        dp[ind] = 1 + dp[prev];
                        back[ind] = prev;
                    }
                }
            }
            if (dp[ind] > dp[max_ind]){
                max_ind = ind;
            }
        }
        int i = max_ind;
        List<Integer> res = new ArrayList<>();
        while (back[i] != i){
            res.addFirst(nums[i]);
            i = back[i];
        }
        res.addFirst(nums[i]);
        return res;
    }
}
