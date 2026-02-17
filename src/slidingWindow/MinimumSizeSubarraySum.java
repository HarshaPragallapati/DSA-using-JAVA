package slidingWindow;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target, nums));
    }

    private static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minSize = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target){
                minSize = Math.min(minSize, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}
