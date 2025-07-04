package dynamicProgramming;

public class GeeksTraining {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,5},
                {3,1,1},
                {3,3,3}
        };
        System.out.println(maximumPoints(arr));
    }

    private static int maximumPoints(int[][] arr) {
        int[] prev = new int[4];
        int n = arr.length;
        prev[0] = Math.max(arr[0][1], arr[0][2]);
        prev[1] = Math.max(arr[0][0], arr[0][2]);
        prev[2] = Math.max(arr[0][0], arr[0][1]);
        prev[3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2]));
        for (int day = 1; day < n; day++) {
            int[] temp = new int[n];
            for (int last = 0; last < 4; last++) {
                temp[last] = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last){
                        temp[last] = Math.max(temp[last], arr[day][task] + prev[task]);
                    }
                }
            }
            prev = temp;
        }
        return prev[3];
    }
}
