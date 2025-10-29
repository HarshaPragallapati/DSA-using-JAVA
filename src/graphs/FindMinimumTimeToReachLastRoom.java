package graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMinimumTimeToReachLastRoom {
    public static void main(String[] args) {
        int[][] moveTime = {{0,3,2},{4,6,3}};
        System.out.println(minTimeToReach(moveTime));
    }

    private static int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length;
        int n = moveTime[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));
        pq.add(new State(0, 0, -1, 1));
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while (!pq.isEmpty()){
            State node = pq.poll();
            int r = node.row;
            int c = node.col;
            int time = node.time;
            int nextParity = node.parity == 1 ? 2 : 1;
            for (int i = 0; i < 4; i++) {
                int newR = r + dx[i];
                int newC = c + dy[i];
                if (newR < 0 || newC < 0 || newR >= m || newC >= n) continue;
                int startTime = Math.max(time, moveTime[newR][newC]);
                int newTime = startTime + node.parity;
                if (newTime < dist[newR][newC]){
                    dist[newR][newC] = newTime;
                    pq.add(new State(newR, newC, newTime, nextParity));
                }
            }
            if(dist[m - 1][n - 1] != Integer.MAX_VALUE) return dist[m - 1][n - 1];
        }
        return -1;
    }

    private static class State {
        int row;
        int col;
        int time;
        int parity;

        public State(int row, int col, int time, int parity) {
            this.row = row;
            this.col = col;
            this.time = time;
            this.parity = parity;
        }
    }
}
