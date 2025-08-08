package bitManipulation;

import java.util.Arrays;

public class TriplesWithBitwiseAndEqualToZero {
    public static void main(String[] args) {
        int[] nums = {2,1,3};
        System.out.println(countTriplets(nums));
    }

    private static int countTriplets(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int[] freq = new int[max + 1];
        for (int a : nums){
            for (int b : nums){
                freq[a & b]++;
            }
        }
        int res = 0;
        for (int num : nums){
            for (int i = 0; i <= max; i++) {
                if ((i & num) == 0){
                    res += freq[i];
                }
            }
        }
        return res;
    }
}
