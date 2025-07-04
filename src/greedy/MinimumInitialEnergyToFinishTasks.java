package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumInitialEnergyToFinishTasks {
    public static void main(String[] args) {
        int[][] tasks = {{1,3},{2,4},{10,11},{10,12},{8,9}};
        System.out.println(minimumEffort(tasks));
    }

    private static int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks,  (a, b) -> {
            int diffA = a[1] - a[0];
            int diffB = b[1] - b[0];
            return Integer.compare(diffB, diffA);
        });
        int total = tasks[0][1];
        int rem = total - tasks[0][0];
        int n = tasks.length;
        for (int i = 1; i < n; i++) {
            int temp = tasks[i][1] - rem;
            if (temp > 0){
                total += temp;
                rem += temp - tasks[i][0];
            }
            else {
                rem -= tasks[i][0];
            }
        }
        return total;

//        Arrays.sort(tasks, Comparator.comparingInt(a -> (a[1] - a[0])));
//        int energy = 0;
//        for (int[] task : tasks) {
//            energy = Math.max(energy + task[0], task[1]);
//        }
//        return energy;
    }
}
