package heaps;

import java.util.*;

public class LargestSumSubsequenceOfLengthK {
    public static void main(String[] args) {
        int[] nums = {2,1,3,3};
        int k = 2;
        int[] res = maxSubsequence(nums, k);
        for (int num : res){
            System.out.print(num + " ");
        }
    }

    private static int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]
        );
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i], i});
            if (pq.size() > k){
                pq.poll();
            }
        }
        List<int[]> selected = new ArrayList<>(pq);
        selected.sort(Comparator.comparingInt(a -> a[1]));
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = selected.get(i)[0];
        }
        return result;
    }
}
