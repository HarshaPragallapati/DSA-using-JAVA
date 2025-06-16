package greedy;


// Given an array of intervals where intervals[i] = [start i, end i], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
//
//Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.

import java.util.Arrays;
import java.util.Comparator;


public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        int result = eraseOverlapIntervals(intervals);
        System.out.println(result);
    }

    private static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int count = 0;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                count++;
            } else {
                prevEnd = intervals[i][1];
            }
        }
        return count;
    }
}
