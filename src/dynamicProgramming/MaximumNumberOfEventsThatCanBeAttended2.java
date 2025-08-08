package dynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumNumberOfEventsThatCanBeAttended2 {
    public static void main(String[] args) {
        int[][] events = {{1,2,4},{3,4,3},{2,3,1}};
        int k = 2;
        System.out.println(maxValue(events, k));
    }

    private static int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));
        // dp[i][j] = max value using first i events with j picks
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            int value = events[i - 1][2];
            // Find last event ending before current start using binary search
            int lastNonConflict = findLastNonConflict(events, i - 1);
            for (int j = 1; j <= k; j++) {
                // Skip current
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                // Take current + value from last compatible event
                dp[i][j] = Math.max(dp[i][j], value + dp[lastNonConflict + 1][j - 1]);
            }
        }
        return dp[n][k];
    }

    private static int findLastNonConflict(int[][] events, int curr) {
        int low = 0, high = curr - 1, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (events[mid][1] < events[curr][0]) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
