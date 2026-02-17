package graphs;

import java.util.Arrays;

public class MinimumCostToConvertString {
    public static void main(String[] args) {
        String source = "abcd", target = "acbe";
        char[] original = {'a','b','c','c','e','d'};
        char[] changed = {'b', 'c', 'b', 'e', 'b', 'e'};
        int[] cost = {2, 5, 5, 1, 2, 20};
        System.out.println(minimumCost(source, target, original, changed, cost));
    }

    private static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = source.length();
        int[][] dist = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (dist[i][k] < Integer.MAX_VALUE){
                    for (int j = 0; j < 26; j++) {
                        if (dist[k][j] < Integer.MAX_VALUE){
                            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                        }
                    }
                }
            }
        }
        long total = 0;
        for (int i = 0; i < n; i++) {
            int s = source.charAt(i) - 'a';
            int t = target.charAt(i) - 'a';
            if (dist[s][t] == Integer.MAX_VALUE) return -1;
            total += dist[s][t];
        }
        return total;
    }
}
