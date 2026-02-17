package dynamicProgramming;

public class NthTribonacciNumber {
    public static void main(String[] args) {
        System.out.println(tribonacci(4));
        System.out.println(tribonacci(25));
    }

    private static int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int prev = 1, prev2 = 1, prev3 = 0;
        for (int i = 3; i <= n; i++) {
            int curr = prev + prev2 + prev3;
            prev3 = prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
