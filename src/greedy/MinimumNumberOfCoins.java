package greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinimumNumberOfCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        List<Integer> result = minPartition(target);
        System.out.println(result);
    }

    private static List<Integer> minPartition(int target) {
        int[] denominations = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        int n = denominations.length;
        List<Integer> res = new ArrayList<>();
        for (int i = n - 1; i >= 0 && target != 0; i--) {
            while (denominations[i] <= target){
                target -= denominations[i];
                res.add(denominations[i]);
            }
        }
        return res;
    }
}
