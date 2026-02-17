package greedy;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }

    private static int longestPalindrome(String s) {
        int n = s.length();
        int[] freq = new int[58];
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'A']++;
        }
        boolean hasOdd = false;
        int cnt = 0;
        for (int i = 0; i < 58; i++) {
            if (freq[i] % 2 == 0){
                cnt += freq[i];
            }
            else {
                cnt += freq[i] - 1;
                hasOdd = true;
            }
        }
        return hasOdd ? cnt + 1 : cnt;
    }
}
