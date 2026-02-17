package greedy;

import java.util.Arrays;

public class AppleRedistributionIntoBoxes {
    public static void main(String[] args) {
        int[] apple = {1, 3, 2}, capacity = {4, 3, 1, 5, 2};
        System.out.println(minimumBoxes(apple, capacity));
    }

    private static int minimumBoxes(int[] apple, int[] capacity) {
        int n = capacity.length;
        int total = 0;
        for (int num : apple){
            total += num;
        }
        Arrays.sort(capacity);
        int boxes = 0;
        for (int i = n - 1; i >= 0; i--) {
            total -= capacity[i];
            boxes++;
            if (total <= 0){
                return boxes;
            }
        }
        return boxes;
    }
}
