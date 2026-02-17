package dynamicProgramming;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    private static String longestPalindrome(String s) {
        int n = s.length();
        int start = 0;
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                int l = i;
                int r = i + j;
                while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)){
                    int currLen = r - l + 1;
                    if (currLen > maxLen){
                        start = l;
                        maxLen = currLen;
                    }
                    l--;
                    r++;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
