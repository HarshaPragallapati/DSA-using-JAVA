package dynamicProgramming;

public class MinimumASCIIDeleteForTwoStrings {
    public static void main(String[] args) {
        String s1 = "delete", s2 = "leet";
        System.out.println(minimumDeleteSum(s1, s2));
    }

    private static int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] dp = new int[m + 1];
        for (int j = 0; j < m; j++) {
            dp[j + 1] = dp[j] + s2.charAt(j);
        }
        for (int i = 1; i <= n; i++) {
            int prev = dp[0];
            dp[0] += s1.charAt(i - 1);
            for (int j = 1; j <= m; j++) {
                int temp = dp[j];
                if (s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[j] = prev;
                }
                else {
                    dp[j] = Math.min(s1.charAt(i - 1) + dp[j],
                            s2.charAt(j - 1) + dp[j - 1]);
                }
                prev = temp;
            }
        }
        return dp[m];
    }

//    private static int findMinDeleteSum(String s1, String s2, int i, int j, int[][] dp) {
//        if(i < 0 && j < 0) return 0;
//        if (i < 0){
//            return findCount(s2, j);
//        } else if (j < 0) {
//            return findCount(s1, i);
//        }
//        if (s1.charAt(i) == s2.charAt(j)){
//            dp[i][j] = findMinDeleteSum(s1, s2, i - 1, j - 1, dp);
//        }
//        else {
//            dp[i][j] = Math.min(s1.charAt(i) + findMinDeleteSum(s1, s2, i - 1, j, dp),
//                                s2.charAt(j) + findMinDeleteSum(s1, s2, i, j - 1, dp));
//        }
//        return dp[i][j];
//    }
//
//    private static int findCount(String s1, int ind) {
//        int cnt = 0;
//        for (int i = 0; i <= ind; i++) {
//            cnt += s1.charAt(i);
//        }
//        return cnt;
//    }
}
