package prefixSum;

public class MakeArrayElementsEqualToZero {
    public static void main(String[] args) {
        int[] nums = {1,0,2,0,3};
        System.out.println(countValidSelections(nums));
    }

    private static int countValidSelections(int[] nums) {
        int totalSum = 0;
        int ans = 0;
        for(int num : nums){
            totalSum += num;
        }
        int currSum = 0;
        for (int num : nums){
            currSum += num;
            if(num == 0){
                if(currSum * 2 == totalSum){
                    ans += 2;
                } else if (Math.abs(totalSum - currSum * 2) == 1) {
                    ans += 1;
                }
            }
        }
        return ans;
    }
}
