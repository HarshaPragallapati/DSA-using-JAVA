package arrays;

public class NextPermutation31 {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 7, 5, 0};
        int pivot = -1;
        int n = arr.length;
        for(int i = n - 2; i >= 0; i--){
            if(arr[i] < arr[i + 1]){
                pivot = i;
                break;
            }
        }
        if (pivot == -1){
            reverse(arr, 0, n -1);
            return;
        }
        for (int i = n - 1; i > pivot; i--) {
            if (arr[i] > arr[pivot]){
                int temp = arr[i];
                arr[i] = arr[pivot];
                arr[pivot] = temp;
                break;
            }
        }
        reverse(arr, pivot + 1, n - 1);
        for (int num : arr){
            System.out.print(num + " ");
        }
    }
    static void reverse(int[] arr, int start, int end){
        while(start >= 0 && end >= 0 && start<= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
