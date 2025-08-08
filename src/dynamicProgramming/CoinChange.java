package dynamicProgramming;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    private static int coinChange(int[] coins, int amount) {
        int[] minCoins = new int[1];
        minCoins[0] = Integer.MAX_VALUE;
        findMinCoins(coins, amount, coins.length - 1, minCoins, 0);
        return minCoins[0] == Integer.MAX_VALUE ? -1 : minCoins[0];
    }

    private static void findMinCoins(int[] coins, int amount, int ind, int[] minCoins, int count) {
        if (ind < 0) return;
        if (amount == 0){
            minCoins[0] = Math.min(minCoins[0], count);
            return;
        }
        if (coins[ind] <= amount){
            findMinCoins(coins, amount - coins[ind], ind, minCoins, count + 1);
        }
        findMinCoins(coins, amount, ind - 1, minCoins, count);
    }
}
