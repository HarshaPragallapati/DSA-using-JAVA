package dynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJump {
    public static void main(String[] args) {
        int[] stones = {0,1,3,5,6,8,12,17};
        System.out.println(canCross(stones));
    }

    private static boolean canCross(int[] stones) {
        int n = stones.length;
        Map<Integer, Integer> stoneIndex = new HashMap<>();
        Set<Integer>[] dp = new HashSet[n];
        for (int i = 0; i < n; i++) {
            stoneIndex.put(stones[i], i);
            dp[i] = new HashSet<>();
        }
        dp[0].add(0);
        for (int i = 0; i < n; i++) {
            for (int k : dp[i]){
                for (int jump = k - 1; jump <= k + 1; jump++) {
                    if (jump <= 0) continue;
                    int nextPos = stones[i] + jump;
                    if (stoneIndex.containsKey(nextPos)){
                        int nextInd = stoneIndex.get(nextPos);
                        dp[nextInd].add(jump);
                    }
                }
            }
        }
        return !dp[n - 1].isEmpty();
    }
}
