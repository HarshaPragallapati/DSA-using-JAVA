package recursion;

public class CountGoodNumbers {
    public static void main(String[] args) {
        System.out.println(countGoodNumbers(1));
        System.out.println(countGoodNumbers(4));
        System.out.println(countGoodNumbers(50));
    }

    private static int countGoodNumbers(int n) {
        final long MOD = 1_000_000_007;
        long evenPos = (n + 1) / 2;
        long oddPos = n / 2;
        long evenWays = modPow(5, evenPos, MOD);
        long oddWays = modPow(5, oddPos, MOD);
        return (int)((evenWays * oddWays) % MOD);
    }

    private static long modPow(long base, long exp, long mod){
        long result = 1;
        base %= mod;
        while (exp > 0){
            if ((exp & 1) == 1){
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}
