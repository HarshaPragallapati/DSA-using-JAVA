package dynamicProgramming;

public class MinimumTimeToMakeRopeColorful {
    public static void main(String[] args) {
        String colors = "abaac";
        int[] neededTime = {1,2,3,4,5};
        System.out.println(minCost(colors, neededTime));
    }

    private static int minCost(String colors, int[] neededTime) {
        int minCost = 0;
        for (int i = 1; i < neededTime.length; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)){
                minCost += Math.min(neededTime[i], neededTime[i - 1]);
                neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
            }
        }
        return minCost;
    }
}
