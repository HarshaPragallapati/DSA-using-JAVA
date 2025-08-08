package greedy;

import java.util.Arrays;

public class MinimumNoOfMovesToSeatEveryone {
    public static void main(String[] args) {
        int[] seats = {2,2,6,6};
        int[] students = {1,3,2,6};
        System.out.println(minMovesToSeat(seats, students));
    }

    private static int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int ans = 0;
        for (int i = 0; i < seats.length; i++) {
            ans += Math.abs(seats[i] - students[i]);
        }
        return ans;
    }
}
