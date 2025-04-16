package SlidingWindow;

import java.util.HashMap;

public class SubArrayWithKDiffInt992 {
    public static int AtMost(int[] nums, int k){
        int n = nums.length;
        int[] hash = new int[n + 1];
        int left = 0, right = 0;
        int res = 0;
        while(right < n){
            if(hash[nums[right]] == 0){
                k--;
            }
            hash[nums[right]]++;
            while (k < 0){
                hash[nums[left]]--;
                if (hash[nums[left]] == 0){
                    k++;
                }
                left++;
            }
            res += right - left + 1;
            right++;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,4};
        int k = 1;
        System.out.println("No of sub arrays with " + k + "different characters are: " + (AtMost(nums, k) - AtMost(nums,k - 1)));
    }
}
