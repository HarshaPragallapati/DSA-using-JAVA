package greedy;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {
    public static void main(String[] args) {
        int[] arr = {3,2,4,1};
        System.out.println(pancakeSort(arr));
    }

    private static List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for (int ind = arr.length; ind > 1; ind--) {
            int maxIndex = findMaxIndex(arr, ind);
            if (maxIndex == ind - 1){
                continue;
            }
            if (maxIndex != 0){
                reverse(arr, maxIndex);
                res.add(maxIndex);
            }
            reverse(arr, ind);
            res.add(ind);
        }
        return res;
    }

    private static void reverse(int[] arr, int n) {
        int i = 0, j = n - 1;
        while (i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    private static int findMaxIndex(int[] arr, int ind) {
        int maxIndex = 0;
        for (int i = 1; i < ind; i++) {
            if (arr[i] > arr[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
