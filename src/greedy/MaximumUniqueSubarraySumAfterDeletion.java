package greedy;

public class MaximumUniqueSubarraySumAfterDeletion {
    public static void main(String[] args) {
        int[] nums = {1,2,-1,-2,1,0,-1};
        System.out.println(maxSum(nums));
    }

    private static int maxSum(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int[] freq = new int[101];
        int sum = 0;
        for (int num : nums){
            largest = Math.max(largest, num);
            if (num < 0) continue;
            freq[num]++;
            if (freq[num] == 1){
                sum += num;
            }
        }
        return largest >= 0 ? sum : largest;
    }
}
