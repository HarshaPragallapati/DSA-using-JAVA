package hashtable;

import java.util.HashSet;
import java.util.Set;

public class LongestBalancedSubarray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,2};
        System.out.println(longestBalanced(nums));
    }

    private static int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> odds = new HashSet<>();
            Set<Integer> evens = new HashSet<>();
            for (int j = i; j < n; j++) {
                if ((nums[j] & 1) == 0){
                    evens.add(nums[j]);
                }
                else {
                    odds.add(nums[j]);
                }
                if (evens.size() == odds.size()){
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
}
