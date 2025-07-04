package dynamicProgramming;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }

    private static int rob(int[] nums) {
        int prev = nums[0], prev2 = 0;
        for (int i = 1; i < nums.length; i++) {
            int pick = nums[i];
            if (i > 1){
                pick += prev2;
            }
            int curr = Math.max(pick, prev);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
