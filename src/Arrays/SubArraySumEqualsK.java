package Arrays;

import java.util.HashMap;
import java.util.Scanner;

public class SubArraySumEqualsK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of elements:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter k = ");
        int k = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int preSum = 0;
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            preSum += arr[i];
            int rem = preSum - k;
            count += map.getOrDefault(rem, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        System.out.println(count);
    }
}
