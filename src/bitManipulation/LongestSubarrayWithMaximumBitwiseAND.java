package bitManipulation;

public class LongestSubarrayWithMaximumBitwiseAND {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,2,2};
        System.out.println(longestSubarray(nums));
    }

    private static int longestSubarray(int[] nums) {
        int max = 0;
        for (int num : nums){
            max = Math.max(max, num);
        }
        int count = 0, ans = 0;
        for (int num : nums){
            if (num == max){
                count++;
            }
            else {
                count = 0;
            }
            ans = Math.max(count, ans);
        }
        return ans;
    }
}
