package weeklyContest;

import java.util.ArrayList;

public class MakeArrayNonDecreasing20_04 {
    public static void main(String[] args) {
        int[] nums = {4,2,5,3,5};
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : nums) {
            if (result.isEmpty() || num >= result.getLast()){
                result.add(num);
            }
        }
        System.out.println(result.size());
    }
}