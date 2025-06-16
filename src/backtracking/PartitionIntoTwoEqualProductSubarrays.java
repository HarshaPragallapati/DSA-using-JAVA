package backtracking;

public class PartitionIntoTwoEqualProductSubarrays {
    public static void main(String[] args) {
        int[] nums = {3,1,6,8,4};
        int target = 24;
        System.out.println(checkEqualPartitions(nums, target));
    }

    private static boolean checkEqualPartitions(int[] nums, int target) {
        int n = nums.length;
        long totalProduct = 1;
        for (int num : nums) {
            totalProduct *= num;
        }
        if (totalProduct != (long) target * target) return false;
        int size = 1 << n;
        for (int mask = 1; mask < size - 1; mask++) {
            long prod1 = 1, prod2 = 1;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    prod1 *= nums[i];
                    if (prod1 > target) break;
                } else {
                    prod2 *= nums[i];
                    if (prod2 > target) break;
                }
            }

            if (prod1 == target && prod2 == target) {
                return true;
            }
        }

        return false;
    }
}
