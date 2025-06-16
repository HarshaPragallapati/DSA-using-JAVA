package binarySearch;

public class MinimumNoOfDaysForMBoquets1482 {
    public static void main(String[] args) {
        int[] bloomDay = {1,10,3,10,2};
        int m = 3, k = 2;
        if (bloomDay.length < (long) m * k){
            System.out.println(-1);
            return;
        }
        int minDays = Search(bloomDay, m, k);
        System.out.println(minDays);
    }

    private static int Search(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int num : bloomDay){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int low = min, high = max;
        while (low < high){
            int mid = low + (high - low) / 2;
            if(calculateDays(bloomDay, m, k, mid)){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }

        return low;
    }

    private static boolean calculateDays(int[] bloomDay, int m, int k, int n) {
        int cnt = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= n){
                cnt++;
                if (cnt == k){
                    m--;
                    cnt = 0;
                }
            }
            else {
                cnt = 0;
            }
            if (m == 0){
                return true;
            }
        }
        return false;
    }
}
