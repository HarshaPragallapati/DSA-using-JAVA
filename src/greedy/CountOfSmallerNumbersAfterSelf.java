package greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        int[] nums = {6,1,3,4,8,2};
        int[] ans = smallerNumbersThanCurrent(nums);
        for (int num : ans){
            System.out.print(num + " ");
        }
    }

    private static int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(sorted[i], i);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = map.get(nums[i]);
        }
        return res;
    }
}
