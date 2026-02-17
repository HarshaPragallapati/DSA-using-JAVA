package strings;

import java.util.Arrays;

public class UniqueLength3PalindromicSubsequences {
    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("aabca"));
        System.out.println(countPalindromicSubsequence("adc"));
        System.out.println(countPalindromicSubsequence("bbcbaba"));
    }

    private static int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (first[ch - 'a'] == -1){
                first[ch - 'a'] = i;
            }
            last[ch - 'a'] = i;
        }
        int[][] prefix = new int[n + 1][26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                prefix[i + 1][j] = prefix[i][j];
            }
            prefix[i + 1][s.charAt(i) - 'a']++;
        }
        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            int start = first[i];
            int end = last[i];
            if (start == -1 || end - start < 2) continue;
            for (int j = 0; j < 26; j++) {
                if (prefix[end][j] - prefix[start + 1][j] > 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
