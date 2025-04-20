package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class CombinationSum40 {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        System.out.println(ans);
    }

    private static void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> list) {
        if (target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1]){
                continue;
            }
            if (arr[i] > target){
                break;
            }
            list.add(arr[i]);
            findCombinations(i + 1, arr, target - arr[i], ans, list);
            list.removeLast();
        }
    }
}
