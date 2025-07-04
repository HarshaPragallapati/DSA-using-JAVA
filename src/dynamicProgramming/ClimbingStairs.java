package dynamicProgramming;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(4));
    }

    private static int climbStairs(int n) {
        if(n == 1) return 1;
        int prev = 1, prev2 = 1;
        int curr;
        for(int i = 2; i <= n; i++){
            curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
