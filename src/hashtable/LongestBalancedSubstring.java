package hashtable;

public class LongestBalancedSubstring {
    public static void main(String[] args) {
        String s = "zzabccy";
        System.out.println(longestBalanced(s));
    }

    private static int longestBalanced(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;
                if (isBalanced(freq)){
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    private static boolean isBalanced(int[] freq) {
        int target = 0;
        for (int f : freq){
            if (f == 0) continue;
            if (target == 0){
                target = f;
            } else if (f != target) {
                return false;
            }
        }
        return true;
    }
}
