package strings;

public class DecodeTheMessage {
    public static void main(String[] args) {
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        System.out.println(decodeMessage(key, message));
    }

    private static String decodeMessage(String key, String message) {
        char[] mapping = new char[26];
        boolean[] seen = new boolean[26];
        int mappedChar = 0;
        for (char ch : key.toCharArray()) {
            if (ch == ' ') continue;
            int idx = ch - 'a';
            if (!seen[idx]) {
                mapping[idx] = (char) ('a' + mappedChar);
                seen[idx] = true;
                mappedChar++;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char ch : message.toCharArray()) {
            if (ch == ' ') {
                ans.append(' ');
            } else {
                ans.append(mapping[ch - 'a']);
            }
        }
        return ans.toString();
    }
}
