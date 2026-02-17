package dynamicProgramming;

public class PartitionsWithGivenDifference {
    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 4};
        int diff = 3;
        System.out.println(countPartitions(arr, diff));
    }

    private static int countPartitions(int[] arr, int diff) {
        int n = arr.length;
        int total = 0;
        for (int num : arr){
            total += num;
        }
        if (total - diff < 0 || (total - diff) % 2 == 1){
            return 0;
        }
        int target = (total - diff) / 2;
        int[] prev = new int[target + 1];
        if (arr[0] == 0){
            prev[0] = 2;
        }
        else {
            prev[0] = 1;
            if (arr[0] <= target){
                prev[arr[0]] = 1;
            }
        }
        for (int ind = 1; ind < n; ind++) {
            int[] curr = new int[target + 1];
            for (int sum = 0; sum <= target; sum++) {
                int notTake = prev[sum];
                int take = 0;
                if(arr[ind] <= sum){
                    take = prev[sum - arr[ind]];
                }
                curr[sum] = take + notTake;
            }
            prev = curr;
        }
        return prev[target];
    }
}
