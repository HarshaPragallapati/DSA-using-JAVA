package prefixSum;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] res = productExceptSelf(nums);
        System.out.println(res.toString());
    }

    private static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = 1;
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        int temp = 1;
        for (int i = n - 1; i >= 0; i--) {
            pre[i] *= temp;
            temp *= nums[i];
        }
        return pre;
    }
}
