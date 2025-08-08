package slidingWindow;

public class FruitIntoBaskets {
    public static void main(String[] args) {
        int[] fruits = {1,2,3,2,2};
        System.out.println(totalFruit(fruits));
    }

    private static int totalFruit(int[] fruits) {
        int n = fruits.length;
        int[] freq = new int[n];
        int k = 2; // No of baskets
        int left = 0;
        int ans = 0;
        for (int right = 0; right < n; right++) {
            if (freq[fruits[right]] == 0){
                k--;
            }
            freq[fruits[right]]++;
            while (k < 0){
                freq[fruits[left]]--;
                if (freq[fruits[left]] == 0){
                    k++;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
