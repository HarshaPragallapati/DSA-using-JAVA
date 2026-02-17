package greedy;

import java.util.Arrays;

public class MaximumUnitsOnATruck {
    public static void main(String[] args) {
        int[][] boxTypes = {{1,3},{2,2},{3,1}};
        int truckSize = 4;
        System.out.println(maximumUnits(boxTypes, truckSize));
    }

    private static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int res = 0;
        for (int[] box : boxTypes){
            int take = Math.min(box[0], truckSize);
            res += take * box[1];
            truckSize -= take;
            if (truckSize == 0) break;
        }
        return res;
    }
}
