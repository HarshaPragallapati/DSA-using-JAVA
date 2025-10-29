package math;

public class RangeAddition {
    public static void main(String[] args) {
        int m = 3, n = 3;
        int[][] ops = {{2, 2}, {3, 3}};
        System.out.println(maxCount(m, n, ops));
    }

    private static int maxCount(int m, int n, int[][] ops) {
        int minRow = m;
        int minCol = n;
        for (int[] op : ops) {
            minRow = Math.min(minRow, op[0]);
            minCol = Math.min(minCol, op[1]);
        }
        return minRow * minCol;
    }
}