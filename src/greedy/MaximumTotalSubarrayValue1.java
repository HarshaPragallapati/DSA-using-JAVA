package greedy;

public class MaximumTotalSubarrayValue1 {
    public static void main(String[] args) {
        int[] nums = {4, 2, 5, 1};
        int k = 3;
        System.out.println(maxTotalValue(nums, k));
    }

    private static long maxTotalValue(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int num : nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return (long) (max - min) * k;
    }
}
