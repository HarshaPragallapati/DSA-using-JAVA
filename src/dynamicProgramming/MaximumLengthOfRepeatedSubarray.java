package dynamicProgramming;

public class MaximumLengthOfRepeatedSubarray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 2, 1}, nums2 = {3, 2, 1, 4, 7};
        System.out.println(findLength(nums1, nums2));
    }

    private static int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ahead = new int[m + 1];
        int max = 0;
        for (int i = n - 1; i >=  0; i--) {
            int[] curr = new int[m + 1];
            for (int j = m - 1; j >= 0; j--) {
                if (nums1[i] == nums2[j]){
                    curr[j] = 1 + ahead[j + 1];
                    max = Math.max(max, curr[j]);
                }
            }
            ahead = curr;
        }
        return max;
    }
}
