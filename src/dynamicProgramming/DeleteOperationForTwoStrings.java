package dynamicProgramming;

public class DeleteOperationForTwoStrings {
    public static void main(String[] args) {
        String word1 = "sea", word2 = "eat";
        System.out.println(minDistance(word1, word2));
    }

    private static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] prev = new int[m + 1];
        for (int ind1 = 1; ind1 <= n; ind1++) {
            int[] curr = new int[m + 1];
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if(word1.charAt(ind1 - 1) == word2.charAt(ind2 - 1)){
                    curr[ind2] =  1 + prev[ind2 - 1];
                }
                else{
                    curr[ind2] = Math.max(prev[ind2], curr[ind2 - 1]);
                }
            }
            prev = curr;
        }
        return n + m - 2 * prev[m];
    }
}
