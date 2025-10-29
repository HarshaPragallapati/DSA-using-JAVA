package strings;

public class LongestContiguousSequenceOfOnesThanZeroes {
    public static void main(String[] args) {
        String s = "110100010";
        System.out.println(checkZeroOnes(s));
    }

    private static boolean checkZeroOnes(String s) {
        int maxOnes = 0, maxZeroes = 0;
        int oneCount = 0, zeroCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '0'){
                oneCount = 0;
                zeroCount++;
                maxZeroes = Math.max(maxZeroes, zeroCount);
            }
            else {
                zeroCount = 0;
                oneCount++;
                maxOnes = Math.max(maxOnes, oneCount);
            }
        }
        return maxOnes > maxZeroes;
    }
}
