package weeklyContest;

import java.util.HashMap;

public class CountSpecialTriplets {
    public static void main(String[] args) {
        int[] nums = {6,3,6};
        int count = specialTriplets(nums);
        System.out.println(count);
    }

    private static int specialTriplets(int[] nums) {
        final int MOD = 1_000_000_007;
        HashMap<Integer, Integer> lMap = new HashMap<>();
        HashMap<Integer, Integer> rMap = new HashMap<>();
        for (int num : nums){
            rMap.put(num, rMap.getOrDefault(num, 0) + 1);
        }
        long count = 0;
        for (int num : nums) {
            rMap.put(num, rMap.get(num) - 1);
            int left = lMap.getOrDefault(num * 2, 0);
            int right = rMap.getOrDefault(num * 2, 0);
            count = (count + (long) left * right) % MOD;
            lMap.put(num, lMap.getOrDefault(num, 0) + 1);
        }
        return (int) count;
    }
}
