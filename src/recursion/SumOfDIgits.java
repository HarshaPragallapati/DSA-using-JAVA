package recursion;

public class SumOfDIgits {
    public static void main(String[] args) {
        int num = 97300193;
        int sum = calculateSum(num);
        System.out.println(sum);
    }

    private static int calculateSum(int n) {
        if (n <= 0) return 0;
        return n % 10 + calculateSum(n/10);
    }
}
