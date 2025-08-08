package arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllLonelyNumbersInTheArray {
    public static void main(String[] args) {
        int[] nums = {10,6,5,8};
        List<Integer> res = findLonely(nums);
        System.out.println(res);
    }

    private static List<Integer> findLonely(int[] nums) {
        int MAX = (int) 1e6;
        List<Integer> ans = new ArrayList<>();
        int[] freq = new int[MAX + 1];
        for (int num : nums){
            freq[num]++;
        }
        for (int num : nums){
            if (freq[num] == 1){
                boolean leftAbsent = (num == 0 || freq[num - 1] == 0);
                boolean rightAbsent = (num == MAX || freq[num + 1] == 0);
                if (leftAbsent && rightAbsent) {
                    ans.add(num);
                }
            }
        }
        return ans;
    }
}
