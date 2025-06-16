package slidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class SlidingWindowMaximum239 {
    public static ArrayList<Integer> maxWindow(int[] arr, int k){
        Deque<Integer> deque = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if(!deque.isEmpty() && deque.peek() == i - k)
            {
                deque.poll();
            }
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i])
            {
                deque.pollLast();
            }
            deque.offer(i);
            if(i >= k - 1)
            {
                list.addLast(arr[deque.peek()]);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int  k = 3;
        System.out.println(maxWindow(arr, k));
    }
}
