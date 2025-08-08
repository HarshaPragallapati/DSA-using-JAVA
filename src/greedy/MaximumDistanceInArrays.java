package greedy;

import java.util.List;

public class MaximumDistanceInArrays {
    public static void main(String[] args) {
        List<List<Integer>> arrays = List.of(
                List.of(1,2,3),
                List.of(4,5),
                List.of(1,2,3)
        );
        System.out.println(maxDistance(arrays));
    }

    private static int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.getFirst().getFirst();
        int max = arrays.getFirst().getLast();
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < arrays.size(); i++) {
            int curMin = arrays.get(i).getFirst();
            int curMax = arrays.get(i).getLast();
            int diff1 = Math.abs(curMax - min);
            int diff2 = Math.abs(max - curMin);
            ans = Math.max(ans, Math.max(diff1, diff2));
            max = Math.max(max, curMax);
            min = Math.min(min, curMin);
        }
        return ans;
    }
}
