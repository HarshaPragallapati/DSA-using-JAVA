package arrays;

import java.util.List;

public class AdjacentIncreasingSubarrayDetection {
    public static void main(String[] args) {
        List<Integer> nums = List.of(2,5,7,8,9,2,3,4,3,1);
        int k = 3;
        System.out.println(hasIncreasingSubarrays(nums, k));
    }

    private static boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int prev = 0;
        int curr = 1;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i - 1)){
                curr++;
            }
            else {
                prev = curr;
                curr = 1;
            }
            if (curr >= 2 * k || (prev >= k && curr >= k)){
                return true;
            }
        }
        return false;
    }
}
