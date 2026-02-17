package heaps;

import java.util.PriorityQueue;

public class FinalArrayStateAfterKMultiplicationOperations {
    public static void main(String[] args) {
        int[] nums = {2,1,3,5,6};
        int k = 5, multiplier = 2;
        int[] res = getFinalState(nums, k , multiplier);
        for (int num : res){
            System.out.print(num + " ");
        }
    }

    private static int[] getFinalState(int[] nums, int k, int multiplier) {
        if (multiplier == 1) return nums;
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]){
                return Integer.compare(a[0], b[0]);
            }
            else {
                return Integer.compare(a[1], b[1]);
            }
        });
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        while (k-- > 0){
            int[] curr = pq.poll();
            curr[0] *= multiplier;
            pq.offer(curr);
        }
        while (!pq.isEmpty()){
            int[] temp = pq.poll();
            nums[temp[1]] = temp[0];
        }
        return nums;
    }
}
