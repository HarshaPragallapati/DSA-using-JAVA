package dynamicProgramming;

public class PartitionArrayToMinimizeSumDifference {
    public static void main(String[] args) {
        int[] nums = {2,-1,0,4,-2,-9};
        System.out.println(minimumDifference(nums));
    }

    private static int minimumDifference(int[] nums) {
        int totalSum = 0;
        for (int num : nums){
            totalSum += num;
        }
        int n = nums.length;
        boolean[] prev = new boolean[totalSum + 1];
        for (int i = 0; i < n; i++) {
            prev[0] = true;
        }
        if (nums[0] <= totalSum){
            prev[nums[0]] = true;
        }
        for (int ind = 1; ind < n; ind++) {
            boolean[] curr = new boolean[totalSum + 1];
            curr[0] = true;
            for (int target = 1; target <= totalSum; target++) {
                boolean notTake = prev[target];
                boolean take = false;
                if (nums[ind] <= target){
                    take = prev[target - nums[ind]];
                }
                curr[target] = take || notTake;
            }
            prev = curr.clone();
        }
        int minSum = Integer.MAX_VALUE;
        for (int s = 0; s <= totalSum; s++) {
            if (prev[s]){
                int s2 = totalSum - s;
                minSum = Math.min(minSum, Math.abs(s2 - s));
            }
        }
        return minSum;
    }
}
