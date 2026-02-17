package arrays;

import java.util.List;

public class AdjacentIncreasingSubarrayDetection2 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(2,5,7,8,9,2,3,4,3,1);
        System.out.println(maxIncreasingSubarrays(nums));
    }

    private static int maxIncreasingSubarrays(List<Integer> nums) {
        int res = 1;
        int n = nums.size();
        int prev = 0;
        int curr = 1;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)){
                curr++;
            }
            else {
                prev = curr;
                curr = 1;
            }
            int temp = curr / 2 >= prev ? curr / 2 : Math.min(prev, curr);
            res = Math.max(res, temp);
        }
        return res;
    }
}
