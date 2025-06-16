package greedy;

public class Candy {
    public static void main(String[] args) {
        int[] ratings = {1,0,2};
        int minCandies = candy(ratings);
        System.out.println(minCandies);
    }

    private static int candy(int[] ratings) {
        int sum = 1, i = 1, n = ratings.length;
        while (i < n){
            if (ratings[i] == ratings[i - 1]){
                sum++;
                i++;
                continue;
            }
            int peak = 1;
            while (i < n && ratings[i] > ratings[i - 1]){
                peak++;
                sum += peak;
                i++;
            }
            int down = 0;
            while (i < n && ratings[i] < ratings[i - 1]){
                down++;
                sum += down;
                i++;
            }
            down++;
            if (down > peak){
                sum += down - peak;
            }
        }
        return sum;
    }
}
