package dynamicProgramming;

public class LongestChunkedPalindromeDecomposition {
    public static void main(String[] args) {
        System.out.println(longestDecomposition("ghiabcdefhelloadamhelloabcdefghi"));
        System.out.println(longestDecomposition("merchant"));
        System.out.println(longestDecomposition("antaprezatepzapreanta"));
    }

    private static int longestDecomposition(String text) {
        int l = 0, r = text.length() - 1;
        int window = 1, count = 0;
        while (l < r){
            if (text.substring(l, l + window).equals(text.substring(r, r + window))){
                l += window;
                window = 0;
                count += 2;
            }
            r--;
            window++;
        }
        return l == r ? count + 1 : count;
    }
}
