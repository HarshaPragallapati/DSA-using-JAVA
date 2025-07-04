package binarySearch;

public class AllocateMinimumPages {
    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        int k = 2;
        int minPages = findPages(arr, k);
        System.out.println(minPages);
    }

    private static int findPages(int[] arr, int k) {
        if (k > arr.length) return -1;
        int low = 0, high = 0;
        for (int num : arr){
            high += num;
            low = Math.max(low, num);
        }
        while (low <= high){
            int mid = (low + high) / 2;
            int students = findStudents(arr, mid);
            if (students > k){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static int findStudents(int[] arr, int maxPages) {
        int count = 1;
        int curr = 0;
        for (int num : arr) {
            if (curr + num > maxPages) {
                count++;
                curr = num;
            } else {
                curr += num;
            }
        }
        return count;
    }
}
