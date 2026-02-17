package greedy;

import java.util.Arrays;

public class MaximizeHappinessOfSelectedChildren {
    public static void main(String[] args) {
        int[] happiness = {1, 2, 3};
        int k = 2;
        System.out.println(maximumHappinessSum(happiness, k));
    }

    private static long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int i = happiness.length - 1;
        int cnt = 0;
        long res = 0;
        while (k > 0 && i >= 0){
            res += Math.max(0, happiness[i] - cnt);
            k--;
            i--;
            cnt++;
        }
        return res;
    }
}
