package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoSneakyNumbersOfDigitville {
    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 4, 3, 4, 6, 0, 9, 5, 8, 2};
        System.out.println(Arrays.toString(getSneakyNumbers(nums)));
    }

    private static int[] getSneakyNumbers(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int[] res = new int[2];
        int idx = 0;
        for(int num : nums){
            if(!seen.add(num)){
                res[idx++] = num;
                if(idx == 2) break;
            }
        }
        return res;
    }
}
