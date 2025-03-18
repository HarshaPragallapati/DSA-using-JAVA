package Arrays;

public class LongestSubArraySumPos {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,1,1,3,3};
        int n = nums.length;
        int len = 0;
        int left = 0, right = 0;
        int sum = 0;
        int k = 6;
        while(left <= right && right < n)
        {
            if(sum > k) {
                while (sum > k) {
                    sum -= nums[left];
                    left++;
                }
            }
            sum += nums[right];
            if(sum == k) {
                len = Math.max(len, right - left + 1);
            }
            right++;
        }
        System.out.println(len);
    }
}
