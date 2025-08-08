package greedy;

import java.util.TreeMap;

public class DivideArrayIntoSetsOfKConsecutiveNumbers {
    public static void main(String[] args) {
        int[] nums = {3,2,1,2,3,4,3,4,5,9,10,11};
        int k = 3;
        System.out.println(isPossibleDivide(nums, k));
    }

    private static boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) return false;
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for (int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        while (!freq.isEmpty()){
            int first = freq.firstKey();
            for (int i = 0; i < k; i++) {
                int curr = first + i;
                if (!freq.containsKey(curr)){
                    return false;
                }
                freq.put(curr, freq.get(curr) - 1);
                if (freq.get(curr) == 0){
                    freq.remove(curr);
                }
            }
        }
        return true;
    }
}
