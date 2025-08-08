package slidingWindow;

import java.util.ArrayList;
import java.util.List;

public class RescheduleMeetingsForMaximumFreeTime {
    public static void main(String[] args) {
        int eventTime = 12;
        int k = 1;
        int[] startTime = {0,2,9};
        int[] endTime = {1,4,10};
        System.out.println(maxFreeTime(eventTime, k, startTime, endTime));
    }

    private static int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        List<Integer> gaps = new ArrayList<>();
        int prev = 0;
        for (int i = 0; i < n; i++) {
            gaps.add(startTime[i] - prev);
            prev = endTime[i];
        }
        gaps.add(eventTime - prev);
        int len = k + 1;
        int sum = 0;
        for(int i = 0; i < len; i++){
            sum += gaps.get(i);
        }
        int ans = sum;
        for(int i = 1; i + len - 1 < gaps.size(); i++){
            sum -= gaps.get(i - 1);
            sum += gaps.get(i + len - 1);
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
