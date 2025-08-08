package greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumNumberOfEventsThatCanBeAttended {
    public static void main(String[] args) {
        int[][] events = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(maxEvents(events));
    }

    private static int maxEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> {
            if (a[0] != b[0]){
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });
        int attended = 0, day = 1, i = 0;
        int lastDay = 0;
        for (int[] event : events) {
            lastDay = Math.max(lastDay, event[1]);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (day <= lastDay){
            // Add all events starting today
            while (i < n && events[i][0] == day){
                pq.offer(events[i][1]);
                i++;
            }
            // Remove events that have already ended
            while (!pq.isEmpty() && pq.peek() < day){
                pq.poll();
            }
            // Attend the event that ends the earliest
            if (!pq.isEmpty()){
                pq.poll();
                attended++;
            }
            day++;
        }
        return attended;
    }
}
