package dynamicProgramming;

public class FindTheMaximumLengthOfGoodSubsequence {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1, 3};
        int k = 2;
        System.out.println(maximumLength(nums, k));
    }

    private static int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int[][] ahead = new int[n + 1][k + 1];
        for (int ind = n - 1; ind >= 0; ind--) {
            int[][] curr = new int[n + 1][k + 1];
            for (int lastIndex = -1; lastIndex < n; lastIndex++) {
                for (int changes = 0; changes <= k; changes++) {
                    int best = ahead[lastIndex + 1][changes];
                    int newChanges = changes;
                    if (lastIndex != -1 && nums[ind] != nums[lastIndex]){
                        newChanges++;
                    }
                    if (newChanges <= k){
                        best = Math.max(best, 1 + ahead[ind + 1][newChanges]);
                    }
                    curr[lastIndex + 1][changes] = best;
                }
            }
            ahead = curr;
        }
        return ahead[0][0];
    }
}
