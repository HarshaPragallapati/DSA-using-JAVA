package dynamicProgramming;

public class PerfectSumProblem {
    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 10, 6, 8};
        int target = 10;
        System.out.println(perfectSum(nums, target));
    }

    private static int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int[] prev = new int[target + 1];
        prev[0] = 1;
        for (int ind = 0; ind < n; ind++) {
            int[] cur = new int[target + 1];
            cur[0] = 1;
            for (int s = 0; s <= target; s++) {
                int notTaken = prev[s];
                int taken = 0;
                if (nums[ind] <= s) {
                    taken = prev[s - nums[ind]];
                }
                cur[s] = notTaken + taken ;
            }
            prev = cur;
        }
        return prev[target];
    }
}
