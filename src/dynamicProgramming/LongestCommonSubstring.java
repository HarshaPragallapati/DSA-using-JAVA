package dynamicProgramming;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "ABCDGH", s2 = "ACDGHR";
        System.out.println(longestCommonSubstr(s1, s2));
    }

    private static int longestCommonSubstr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int maxi = 0;
        int[] prev = new int[m + 1];
        for (int ind1 = 1; ind1 <= n; ind1++) {
            int[] curr = new int[m + 1];
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if(s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)){
                    curr[ind2] =  1 + prev[ind2 - 1];
                    maxi = Math.max(maxi, curr[ind2]);
                }
                else {
                    curr[ind2] = 0;
                }
            }
            prev = curr;
        }
        return maxi;
    }
}
