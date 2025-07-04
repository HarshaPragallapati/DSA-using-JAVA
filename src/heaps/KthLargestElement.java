package heaps;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest(nums, k));
    }

    private static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            if (pq.size() == k) {
                if (num > pq.peek()) {
                    pq.poll();
                    pq.add(num);
                }
            } else {
                pq.add(num);
            }
        }
        return pq.peek();
    }
}
