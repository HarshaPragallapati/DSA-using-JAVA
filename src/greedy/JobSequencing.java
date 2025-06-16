package greedy;

import java.util.ArrayList;
import java.util.List;

public class JobSequencing {
    public static void main(String[] args) {
        int[] deadline = {4, 1, 1, 1};
        int[] profit = {20, 10, 40, 30};
        ArrayList<Integer> list = jobSequencing(deadline, profit);
        System.out.println(list);
    }

    static class Job {
        int deadline, profit;
        Job(int d, int p) {
            deadline = d;
            profit = p;
        }
    }

    private static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        List<Job> jobs = new ArrayList<>();
        int maxDeadline = 0;

        for (int i = 0; i < n; i++) {
            jobs.add(new Job(deadline[i], profit[i]));
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }

        jobs.sort((a, b) -> b.profit - a.profit);

        boolean[] slot = new boolean[maxDeadline + 1];
        int count = 0, totalProfit = 0;

        for (Job job : jobs) {
            for (int j = job.deadline; j >= 1; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    count++;
                    totalProfit += job.profit;
                    break;
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(count);
        res.add(totalProfit);
        return res;
    }
}
