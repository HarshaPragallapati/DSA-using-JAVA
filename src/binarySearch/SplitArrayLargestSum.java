package binarySearch;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int k = 2;
        System.out.println(splitArray(nums, k));
    }

    private static int splitArray(int[] nums, int k) {
        int low = 0, high = 0;
        for (int num : nums){
            high += num;
            low = Math.max(low, num);
        }
        while (low <= high){
            int mid = (low + high) / 2;
            int n = findNumberOfSplits(nums, mid);
            if (n > k){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static int findNumberOfSplits(int[] nums, int maxSplit) {
        int count = 1;
        int curr = 0;
        for (int num : nums){
            if (curr + num > maxSplit){
                count++;
                curr = num;
            }
            else {
                curr += num;
            }
        }
        return count;
    }
}
