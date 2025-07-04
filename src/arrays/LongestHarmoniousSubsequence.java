package arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
    public static void main(String[] args) {
        int[] nums = {1,3,2,2,5,2,3,7};
        System.out.println(findLHS(nums));
    }

    private static int findLHS(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        for (int key : freq.keySet()) {
            if (freq.containsKey(key + 1)) {
                max = Math.max(max, freq.get(key) + freq.get(key + 1));
            }
        }
        return max;
    }
}
