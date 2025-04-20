package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum39 {
    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        System.out.println(ans);
    }

    private static void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> list) {
        if (ind == arr.length){
            if (target == 0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if (arr[ind] <= target){
            list.add(arr[ind]);
            findCombinations(ind, arr, target - arr[ind], ans, list);
            list.removeLast();
        }
        findCombinations(ind + 1, arr, target, ans, list);
    }
}
