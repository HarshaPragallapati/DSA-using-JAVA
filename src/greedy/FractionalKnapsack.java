package greedy;

import java.util.Arrays;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] values = {10, 20, 30};
        int[] weights = {5, 10, 15};
        int capacity = 100;
        double maxvalues = fractionalKnapsack(values, weights, capacity);
        System.out.println(maxvalues);
    }

    private static double fractionalKnapsack(int[] values, int[] weights, int capacity) {
        int n = values.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (i, j) -> {
            double r1 = (double) values[i] / weights[i];
            double r2 = (double) values[j] / weights[j];
            return Double.compare(r2, r1);
        });

        double maxValue = 0;
        for (int num : indices) {
            if (weights[num] <= capacity){
                maxValue += values[num];
                capacity -= weights[num];
            }
            else {
                maxValue += (double) values[num] / weights[num] * capacity ;
                break;
            }
        }
        return maxValue;
    }
}
