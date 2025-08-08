package slidingWindow;

public class MaximumErasureValue {
    public static void main(String[] args) {
        int[] nums = {4,2,4,5,6};
        System.out.println(maximumUniqueSubarray(nums));
    }

    private static int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int[] freq = new int[(int) (1e4) + 1];
        int l = 0;
        int ans = 0;
        int sum = 0;
        for (int r = 0; r < n; r++) {
            while (freq[nums[r]] != 0){
                freq[nums[l]]--;
                sum -= nums[l];
                l++;
            }
            freq[nums[r]]++;
            sum += nums[r];
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
