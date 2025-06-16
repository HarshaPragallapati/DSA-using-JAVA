package arrays;

public class ZeroArrayTransformation {
    public static void main(String[] args) {
        int[] nums = {2,2,2};
        int[][] queries = {{0,2},{0,2},{0,2}};
        boolean b = isZero(nums, queries, nums.length);
        System.out.println(b);
    }

    private static boolean isZero(int[] nums, int[][] queries, int n) {
        int[] maxDec = new int[n + 1];

        for (int[] q : queries) {
            int l = q[0], r = q[1];
            maxDec[l]++;
            maxDec[r + 1]--;
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += maxDec[i];
            maxDec[i] = sum;
            if(nums[i] > maxDec[i]) return false;
        }

        // for (int i = 0; i < n; i++) {
        //     if (nums[i] > maxDec[i]) {
        //         return false;
        //     }
        // }
        return true;
    }
}
