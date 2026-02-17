package dynamicProgramming;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        int[] val = {10, 40, 50, 70};
        int[] wt = {1, 3, 4, 5};
        int capacity = 8;
        System.out.println(knapSack(val, wt, capacity));
    }

    private static int knapSack(int[] val, int[] wt, int capacity) {
        int n = val.length;
        int[] prev = new int[capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            prev[i] = (i / wt[0]) * val[0];
        }
        for (int ind = 1; ind < n; ind++) {
            int[] curr = new int[capacity + 1];
            for (int cap = 0; cap <= capacity; cap++) {
                int notTake = prev[cap];
                int take = 0;
                if(wt[ind] <= cap){
                    take = val[ind] + curr[cap - wt[ind]];
                }
                curr[cap] = Math.max(take, notTake);
            }
            prev = curr;
        }
        return prev[capacity];
    }
}
