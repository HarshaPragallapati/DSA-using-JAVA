package arrays;

public class RemoveDuplicatesFromSortedArray2 {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(arr));
    }

    private static int removeDuplicates(int[] arr) {
        int i = 0;
        for (int num : arr){
            if (i < 2 || num != arr[i - 2]){
                i++;
                arr[i] = num;
            }
        }
        return i + 1;
    }
}
