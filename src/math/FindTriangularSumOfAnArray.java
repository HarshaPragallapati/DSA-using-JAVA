package math;

public class FindTriangularSumOfAnArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(triangularSum(nums));
    }

    private static int triangularSum(int[] nums) {
        int n = nums.length;
        while (n-- > 1){
            for (int i = 0; i < n; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
        }
        return nums[0];
    }
}
