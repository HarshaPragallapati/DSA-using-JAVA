package dynamicProgramming;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths(3, 2));
    }

    private static int uniquePaths(int m, int n) {
        int[] prev = new int[n];
        Arrays.fill(prev, 1);
        for (int i = 1; i < m; i++) {
            int count = 1;
            for (int j = 1; j < n; j++) {
                count += prev[j];
                prev[j] = count;
            }
        }
        return prev[n - 1];
    }
}
