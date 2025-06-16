package arrays;

import java.util.HashMap;

public class LongestSubArraySumPosNeg {
    public static void main(String[] args) {
        int[] arr = {10, -10, 20, 30};
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int len = 0;
        int n = arr.length;
        int k = 5;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if(!map.containsKey(sum))
            {
                map.put(sum, i);
            }
            if(sum == k)
            {
                len = Math.max(len, i+1);
            }
            int rem = sum - k;
            if(map.containsKey(rem)) {
                len = Math.max(len, i - map.get(rem));
            }
        }
        System.out.println(len);
    }
}
