package greedy;

import java.util.Arrays;

public class PartitionArraySuchThatMaxDifferenceIsK {
    public static void main(String[] args) {
        int[] nums = {3,6,1,2,5};
        int k = 1;
        int count = partitionArray(nums, k);
        System.out.println(count);
    }

    private static int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt = 0;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] - prev > k){
                cnt++;
                prev = nums[i];
            }
        }
        return cnt + 1;
    }
}
