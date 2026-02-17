package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public static void main(String[] args) {
        int[] nums = {1,2,4,3,6,12};
        System.out.println(largestDivisibleSubset(nums));
    }

    private static List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] back = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            back[i] = i;
        }
        int max_ind = 0;
        for (int ind = 0; ind < n; ind++) {
            for (int prev = 0; prev < ind; prev++) {
                if (nums[ind] % nums[prev] == 0){
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
