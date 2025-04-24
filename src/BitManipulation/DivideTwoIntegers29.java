package BitManipulation;

public class DivideTwoIntegers29 {
    private static int performDivision(int dividend, int divisor){
        if (dividend == divisor) return 1;
        boolean sign = true;
        if (dividend <= 0 && divisor > 0) sign = false;
        else if (dividend >= 0 && divisor < 0) sign = false;
        long quotient = 0;
        long n = Math.abs((long) dividend);
        long m = Math.abs((long) divisor);
        while (n >= m){
            int count = 0;
            while (n >= (m << count + 1)){
                count++;
            }
            quotient += 1L << count;
            n = n - (m << count);
        }
        if (quotient == (1L << 31) && sign){
            return Integer.MAX_VALUE;
        }
        if (quotient == (1L << 31) && !sign){
            return Integer.MIN_VALUE;
        }
        return (int) (sign ? quotient : -quotient);
    }
    public static void main(String[] args) {
        System.out.println(performDivision(Integer.MIN_VALUE, -1));
    }
}
