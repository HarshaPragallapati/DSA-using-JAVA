package dynamicProgramming;

public class HouseRobber5 {
    public static void main(String[] args) {
        int[] nums = {10, 1, 3, 9}, colors = {1, 1, 1, 2};
        System.out.println(rob(nums, colors));
    }

    private static long rob(int[] nums, int[] colors) {
        int n = nums.length;
        long take = nums[0];
        long skip = 0;
        for (int i = 1; i < n; i++) {
            long newTake;
            if(colors[i] == colors[i - 1]){
                newTake = nums[i] + skip;
            }
            else {
                newTake = nums[i] + Math.max(take, skip);
            }
            skip = Math.max(take, skip);
            take = newTake;
        }
        return Math.max(take, skip);
    }
}
