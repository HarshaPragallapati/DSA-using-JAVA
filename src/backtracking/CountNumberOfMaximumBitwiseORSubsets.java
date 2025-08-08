package backtracking;

public class CountNumberOfMaximumBitwiseORSubsets {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5};
        System.out.println(countMaxOrSubsets(nums));
    }

    private static int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for (int num : nums){
            maxOr |= num;
        }
        return countSubsetsWithMaxOr(nums, 0, maxOr, 0);
    }

    private static int countSubsetsWithMaxOr(int[] nums, int ind, int maxOr, int currOr) {
        if (ind == nums.length) {
            return currOr == maxOr ? 1 : 0;
        }
        int take = countSubsetsWithMaxOr(nums, ind + 1, maxOr, currOr | nums[ind]);
        int notTake = countSubsetsWithMaxOr(nums, ind + 1, maxOr, currOr);
        return take + notTake;
    }
}
