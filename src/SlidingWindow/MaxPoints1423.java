package SlidingWindow;

public class MaxPoints1423 {
    public static void main(String[] args) {
        int[] arr = {9,7,7,9,7,7,9};
        int n = arr.length;
        int k = 7;
        int[] preSum = new int[n];
        preSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = arr[i] + preSum[i-1];
        }
        if(preSum[k-1] > preSum[n-1] - preSum[n-k-1])
        {
            System.out.println(preSum[k-1]);
        }
        else
        {
            System.out.println(preSum[n-1] - preSum[n-k-1]);
        }
    }
}
