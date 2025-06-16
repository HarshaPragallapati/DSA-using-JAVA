package greedy;

import java.util.Scanner;

public class JumpGame2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int minJumps = jump(nums);
        System.out.println(minJumps);
    }

    private static int jump(int[] nums) {
        int l = 0, r = 0, jumps = 0;
        int n = nums.length;
        while (r < n - 1){
            int farthest = 0;
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            jumps++;
            l = r + 1;
            r = farthest;
        }
        return jumps;
    }
}
