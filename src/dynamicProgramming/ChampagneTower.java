package dynamicProgramming;

public class ChampagneTower {
    public static void main(String[] args) {
        int poured = 100000009, query_row = 33, query_glass = 17;
        System.out.println(champagneTower(poured, query_row, query_glass));
    }

    private static double champagneTower(int poured, int query_row, int query_glass) {
        double[] prev = new double[101];
        prev[0] = poured;
        for (int i = 0; i < query_row; i++) {
            double[] curr = new double[101];
            for (int j = 0; j <= i; j++) {
                if (prev[j] > 1){
                    double overflow = (prev[j] - 1) / 2;
                    curr[j] += overflow;
                    curr[j + 1] += overflow;
                }
            }
            prev = curr;
        }
        return Math.min(1, prev[query_glass]);
    }
}
