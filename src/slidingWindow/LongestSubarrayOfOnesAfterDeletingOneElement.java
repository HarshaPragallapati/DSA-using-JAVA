package slidingWindow;

public class LongestSubarrayOfOnesAfterDeletingOneElement {
    public static void main(String[] args) {
        int[] nums = {0,1,1,1,0,1,1,0,1};
        System.out.println(longestSubarray(nums));
    }

    private static int longestSubarray(int[] nums) {
        int ans = 0;
        int cnt = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0){
                cnt++;
            }
            while (cnt > 1){
                if (nums[left] == 0) cnt--;
                left++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}
