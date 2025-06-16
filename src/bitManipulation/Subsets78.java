package bitManipulation;

import java.util.ArrayList;
import java.util.List;

public class Subsets78 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = findSubsets(nums);
        System.out.println("Subsets are: " + result);
    }

    private static List<List<Integer>> findSubsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int num = 0; num < Math.pow(2, n); num++) {
            List<Integer> lst = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if((num & (1 << i)) != 0){
                    lst.add(nums[i]);
                }
            }
            ans.add(lst);
        }
        return ans;
    }
}
