package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CourseSchedule3 {
    public static void main(String[] args) {
        int[][] courses = {{100,200}, {200,1300}, {1000,1250}, {2000,3200}};
        System.out.println(scheduleCourse(courses));
    }

    private static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int total = 0;
        for (int[] course : courses){
            int duration = course[0];
            int lastTime = course[1];
            total += duration;
            pq.add(duration);
            if (total > lastTime){
                total -= pq.poll();
            }
        }
        return pq.size();
    }
}
