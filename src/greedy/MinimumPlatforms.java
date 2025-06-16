package greedy;

import java.util.Arrays;

public class MinimumPlatforms {
    public static void main(String[] args) {
        int[] arrival = {1000, 935, 1100};
        int[] departure = {1200, 1240, 1130};
        int minPlatforms = findPlatform(arrival, departure);
        System.out.println(minPlatforms);
    }

    private static int findPlatform(int[] arr, int[] dep) {
        int n = dep.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int reqPlatforms = 1, result = 1;
        int i = 1, j = 0;
        while (i < n && j < n){
            if (arr[i] <= dep[j]){
                reqPlatforms++;
                i++;
            }else {
                reqPlatforms--;
                j++;
            }
            result = Math.max(result, reqPlatforms);
        }
        return result;
    }
}
