package greedy;

import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {
    public static void main(String[] args) {
        int[] nums = {1,4,8,15};
        int k = 11;
        System.out.println(maxFrequency(nums, k));
    }

    private static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        long total = 0;
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            total += nums[right];
            while ((long) nums[right] * (right - left + 1) - total > k){
                left++;
                total -= nums[left];
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
