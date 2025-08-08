package dynamicProgramming;

public class HouseRobber2 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }

    private static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(robLinear(nums, 0, n - 2), robLinear(nums, 1, n - 1));
    }

    private static int robLinear(int[] nums, int start, int end){
        int prev = nums[start], prev2 = 0;
        for (int i = start + 1; i <= end; i++) {
            int pick = nums[i];
            if (i - 2 >= start){
                pick += prev2;
            }
            int curr = Math.max(pick, prev);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
