package dynamicProgramming;

public class WildcardMatching {
    public static void main(String[] args) {
        String s = "abdefcd", p = "ab*cd";
        System.out.println(isMatch(s, p));
    }

    private static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[] prev = new boolean[m + 1];
        boolean[] curr = new boolean[m + 1];
        prev[0] = true;
        for (int j = 1; j <= m; j++) {
            prev[j] = checkAllStars(p, j - 1);
        }
        for (int i = 1; i <= n; i++) {
            curr[0] = false;
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                    curr[j] = prev[j - 1];
                }
                else if (p.charAt(j - 1) == '*'){
                    curr[j] = prev[j] || curr[j - 1];
                }
                else {
                    curr[j] = false;
                }
            }
            prev = curr.clone();
        }
        return prev[m];
    }

    private static boolean checkAllStars(String p, int j) {
        for (int i = 0; i <= j; i++) {
            if (p.charAt(i) != '*'){
                return false;
            }
        }
        return true;
    }
}
