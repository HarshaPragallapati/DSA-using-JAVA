package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{5,18}};
        int[][] result = merge(intervals);
        for (int[] num : result){
            System.out.println(num[0] + " " + num[1]);
        }
    }

    private static int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int prevStart = intervals[0][0], prevEnd = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] <= prevEnd){
                prevEnd = Math.max(prevEnd, intervals[i][1]);
            }
            else{
                result.add(new int[]{prevStart, prevEnd});
                prevStart = intervals[i][0];
                prevEnd = intervals[i][1];
            }
        }
        result.add(new int[]{prevStart, prevEnd});
        return result.toArray(new int[result.size()][]);
    }
}
