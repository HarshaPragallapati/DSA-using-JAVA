package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplicationsToReachEnd {
    public static void main(String[] args) {
        int[] arr = {2,5,7};
        int start = 3, end = 30;
        System.out.println(minimumMultiplications(arr, start, end));
    }

    private static int minimumMultiplications(int[] arr, int start, int end) {
        final int mod = 100000;
        if (start == end) return 0;
        boolean[] visited = new boolean[mod];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 0));
        visited[start] = true;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int node = p.first;
            int steps = p.second;
            for (int num : arr) {
                int number = (num * node) % mod;
                if (number == end) return steps + 1;
                if (!visited[number]) {
                    visited[number] = true;
                    q.add(new Pair(number, steps + 1));
                }
            }
        }
        return -1;
    }

    private static class Pair{
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
