package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class DivideArrayIntoArraysWithMaxDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int[][] arr = divideArray(nums, k);
        for (int[] num : arr){
            System.out.print(num[0] + " ");
            System.out.print(num[1] + " ");
            System.out.println(num[2] + " ");
        }
    }

    private static int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] arr = new int[n / 3][3];
        int i = 0;
        for (int j = 0; j <= n - 3; j += 3) {
            if(nums[j + 2] - nums[j] > k){
                return new int[][]{};
            }
            arr[i][0] = nums[j];
            arr[i][1] = nums[j + 1];
            arr[i][2] = nums[j + 2];
            i++;
        }
        return arr;
    }
}
