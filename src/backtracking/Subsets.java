package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        findSubsets(0, n, nums, result, new ArrayList<>());
        System.out.println("Subsets are: " + result);
    }

    private static void findSubsets(int ind, int n, int[] nums, List<List<Integer>> ans, List<Integer> list) {
        if (ind == n ){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[ind]);
        findSubsets(ind + 1, n, nums, ans, list);
        list.removeLast();
        findSubsets(ind + 1, n, nums, ans, list);
    }
}
