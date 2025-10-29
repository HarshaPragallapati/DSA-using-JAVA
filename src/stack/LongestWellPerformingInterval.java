package stack;

import java.util.HashMap;
import java.util.Map;

public class LongestWellPerformingInterval {
    public static void main(String[] args) {
        int[] hours = {9,9,6,0,6,6,9};
        System.out.println(longestWPI(hours));
    }

    private static int longestWPI(int[] hours) {
        int n = hours.length;
        for (int i = 0; i < n; i++) {
            hours[i] = hours[i] > 8 ? 1 : -1;
        }
        Map<Integer, Integer> firstSeen = new HashMap<>();
        int ans = 0, prefix = 0;
        for (int i = 0; i < n; i++) {
            prefix += hours[i];
            if (prefix > 0){
                ans = i + 1;
            }
            else {
                firstSeen.putIfAbsent(prefix, i);
                if (firstSeen.containsKey(prefix - 1)){
                    ans = Math.max(ans, i - firstSeen.get(prefix - 1));
                }
            }
        }
        return ans;
    }
}
