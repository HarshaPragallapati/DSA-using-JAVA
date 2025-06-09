package Greedy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class NMeetingsInOneRoom {
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        int maxValue = maxMeetings(start, end);
        System.out.println(maxValue);
    }

    private static int maxMeetings(int[] start, int[] end) {
        int n = end.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (i, j) -> {
            if (end[i] != end[j])
                return Integer.compare(end[i], end[j]);
            else
                return Integer.compare(start[i], start[j]);
        });
        int prevEndTime = -1, count = 0;
        for (int i = 0; i < n; i++) {
            if (start[indices[i]] > prevEndTime){
                count++;
                prevEndTime = end[indices[i]];
            }
        }
        return count;
    }
}
