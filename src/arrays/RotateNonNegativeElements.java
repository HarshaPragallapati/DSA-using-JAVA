package arrays;

import java.util.ArrayList;
import java.util.List;

public class RotateNonNegativeElements {
    public static void main(String[] args) {
        int[] nums = {1, -2, 3, -4};
        int k = 3;
        int[] res = rotateElements(nums, k);
    }

    private static int[] rotateElements(int[] nums, int k) {
        int n = nums.length;
        List<Integer> pos = new ArrayList<>();
        for (int num : nums){
            if (num >= 0) pos.add(num);
        }
        int m = pos.size();
        if (m == 0 || m == 1) return nums;
        k = k % m;
        reverse(pos, 0, k - 1);
        reverse(pos, k, m - 1);
        reverse(pos, 0, m - 1);
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                nums[i] = pos.get(j++);
            }
        }
        return nums;
    }

    private static void reverse(List<Integer> arr, int start, int end){
        while (start < end){
            int temp = arr.get(end);
            arr.set(end, arr.get(start));
            arr.set(start, temp);
            start++;
            end--;
        }
    }
}
