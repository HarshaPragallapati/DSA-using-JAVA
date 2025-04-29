package SlidingWindow;

import java.util.Scanner;

public class ScoreLessThanK {
    public static void main(String[] args) {
        /*
         the score of an array is defined as the product of its sum and its length.
        For example, the score of [1, 2, 3, 4, 5] is (1 + 2 + 3 + 4 + 5) * 5 = 75.
        Given a positive integer array and an integer k, return the number of non-empty sub arrays of nums whose score is strictly less than k.
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int count = 0;
        int sum = 0;
        int left = 0, right = 0;
        int ind = 0;
        while (right < n){
            sum += arr[right];
            ind = right - left + 1;
            while (sum * ind >= k){
                sum -= arr[left];
                left++;
                ind--;
            }
            count += ind;
            right++;
        }
        System.out.println(count);
    }
}
