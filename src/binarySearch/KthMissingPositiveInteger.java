package binarySearch;

public class KthMissingPositiveInteger {
    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        int k = 5;
        int num = findKthMissing(arr, k);
        System.out.println(num);
    }

    private static int findKthMissing(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return high + k + 1;
    }
}
