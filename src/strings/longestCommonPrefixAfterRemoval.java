package strings;

public class longestCommonPrefixAfterRemoval {
    public static void main(String[] args) {
        String[] words = {"jump","run","run","jump","run"};
        int[] res = longestCommonPrefix(words);
    }

    private static int[] longestCommonPrefix(String[] words) {
        int n = words.length;
        if (n == 1){
            return new int[]{0};
        }
        int[] lcp = new int[n - 1];
        int[] prefixMax = new int[n - 1];
        int[] suffixMax = new int[n - 1];
        int[] result = new int[n];
        for (int i = 0; i < n - 1; i++) {
            lcp[i] = commonPrefixLength(words[i], words[i + 1]);
        }
        prefixMax[0] = lcp[0];
        for (int i = 1; i < n - 1; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], lcp[i]);
        }
        suffixMax[n - 2] = lcp[n - 2];
        for (int i = n - 3; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], lcp[i]);
        }
        for (int i = 0; i < n; i++) {
            int maxLcp = 0;
            if (i - 2 >= 0){
                maxLcp = prefixMax[i - 2];
            }
            if (i + 1 < n - 1){
                maxLcp = Math.max(maxLcp, suffixMax[i + 1]);
            }
            if (i - 1 >= 0 && i + 1 < n){
                maxLcp = Math.max(maxLcp, commonPrefixLength(words[i - 1], words[i + 1]));
            }
            result[i] = maxLcp;
        }
        return result;
    }

    private static int commonPrefixLength(String a, String b) {
        int len = Math.min(a.length(), b.length());
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) return i;
        }
        return len;
    }
}
