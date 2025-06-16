package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PermutationsTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[n];
        findPermutations(nums, ans, new ArrayList<>(), used);
        System.out.println(ans);
    }

    private static void findPermutations(int[] nums, List<List<Integer>> ans, List<Integer> list, boolean[] used) {
        if(list.size() == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i]) continue;
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            findPermutations(nums, ans, list, used);
            list.removeLast();
            used[i] = false;
        }
    }
}
