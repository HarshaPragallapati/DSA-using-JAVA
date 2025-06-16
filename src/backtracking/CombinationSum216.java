package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum216 {
    public static void main(String[] args) {
        int[] candidates = {1,2,3,4,5,6,7,8,9};
        int k = 3, n = 9;
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, k, n, ans, new ArrayList<>());
        System.out.println(ans);
    }

    private static void findCombinations(int ind, int[] arr,int k, int n, List<List<Integer>> ans, List<Integer> list) {
        if (n == 0 && k == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1]){
                continue;
            }
            if (arr[i] > n){
                break;
            }
            list.add(arr[i]);
            findCombinations(i + 1, arr, k - 1, n - arr[i], ans, list);
            list.removeLast();
        }
    }
}
