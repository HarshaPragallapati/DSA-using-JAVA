package SlidingWindow;

import java.util.LinkedList;

public class MaxConsecutiveOnes1004 {
    public static void main(String[] args) {
        int nums[] = {1,1,1,0,0,0,1,1,1,1,0};
        int n = nums.length;
        int left = 0;
        int max = 0, count = 0, k = 2;
        for(int right = 0; right < n; right++) {
            if (nums[right] == 0) {
                count++;
            }
            if(count > k) {
                if (nums[left] == 0) {
                    count--;
                }
                left++;
            }
            if(count <= k)
            {
                max = Math.max(max, right - left + 1);
            }
        }
        System.out.println(max);
    }
}
