package Arrays;

import java.util.Scanner;

public class CountSubarrays3392 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int cnt = compute(nums);
        System.out.println(cnt);
    }

    private static int compute(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] == 2 * (nums[i - 1] + nums[i + 1]))
            {
                count++;
            }
        }
        return count;
    }
}
