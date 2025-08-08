package arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[]  nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }

    private static int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int max = 1;
        for (int it : set){
            if (!set.contains(it - 1)){
                int count = 1;
                while (set.contains(it + 1)){
                    count++;
                    it++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
