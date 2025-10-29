package arrays;

import java.util.*;

public class MaximizeSumOfAtmostKDistinctElements {
    public static void main(String[] args) {
        int[] nums1 = {84, 93, 100, 77, 90};
        int k1 = 3;
        System.out.println(Arrays.toString(maxKDistinct(nums1, k1)));
        int[] nums2 = {84, 93, 100, 77, 93};
        int k2 = 3;
        System.out.println(Arrays.toString(maxKDistinct(nums2, k2)));
        int[] nums3 = {1, 1, 1, 2, 2, 2};
        int k3 = 6;
        System.out.println(Arrays.toString(maxKDistinct(nums3, k3)));
    }

    private static int[] maxKDistinct(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int num : nums){
            set.add(num);
        }
        List<Integer> result = new ArrayList<>();
        for (int num : set){
            if (k == 0) break;
            result.add(num);
            k--;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
