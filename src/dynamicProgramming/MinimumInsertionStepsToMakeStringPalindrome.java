package dynamicProgramming;

public class MinimumInsertionStepsToMakeStringPalindrome {
    public static void main(String[] args) {
        System.out.println(minInsertions("leetcode"));
    }

    private static int minInsertions(String s) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        int[] prev = new int[n + 1];
        for (int ind1 = 1; ind1 <= n; ind1++) {
            int[] curr = new int[n + 1];
            for (int ind2 = 1; ind2 <= n; ind2++) {
                if(s.charAt(ind1 - 1) == rev.charAt(ind2 - 1)){
                    curr[ind2] =  1 + prev[ind2 - 1];
                }
                else{
                    curr[ind2] = Math.max(prev[ind2], curr[ind2 - 1]);
                }
            }
            prev = curr;
        }
        return n - prev[n];
    }
}
