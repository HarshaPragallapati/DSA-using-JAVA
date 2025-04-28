package Arrays;

public class PeakElement162 {
    public static void main(String[] args) {
        int[] arr = {1,2,1,3,5,6,4};
        System.out.println(findPeak(arr));
    }
    static int findPeak(int[] arr){
        int low = 0, high = arr.length - 1;
        if (arr[0] > arr[1]){
            return 0;
        }
        if (arr[high] > arr[high - 1]){
            return high;
        }
        low++;
        high--;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
            {
                return mid;
            } else if (arr[mid] > arr[mid - 1]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
