package arrays;

public class SumOfVariableLengthSubarrays {
    public static void main(String[] args) {
        int[] nums = {3,1,1,2};
        System.out.println(subarraySum(nums));
    }

    private static int subarraySum(int[] nums) {
        int n = nums.length;
        int sum = nums[0];
        for (int i = 1; i < n; i++) {
            int start = Math.max(0, i - nums[i]);
            nums[i] += nums[i - 1];
            sum += start == 0 ? nums[i] : nums[i] - nums[start - 1];
        }
        return sum;
    }
}
