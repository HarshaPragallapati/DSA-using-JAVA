package strings;

public class KarpRabin {

    private static final int d = 256;   // Alphabet size (ASCII)
    private static final int q = 101;   // A prime number for modulus

    public static void main(String[] args) {
        String text = "abbccadd";
        String pattern = "bcca";
        int index = search(text, pattern);
        System.out.println(index);
    }

    private static int search(String text, String pattern) {
        int m = pattern.length();
        int n = text.length();
        int patternHash = 0;  // hash value for pattern
        int textHash = 0;     // hash value for text
        int h = 1;

        // The value of h would be "pow(d, m-1)%q"
        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        // Calculate the hash value of pattern and first window of text
        for (int i = 0; i < m; i++) {
            patternHash = (d * patternHash + pattern.charAt(i)) % q;
            textHash = (d * textHash + text.charAt(i)) % q;
        }

        // Slide the pattern over text
        for (int i = 0; i <= n - m; i++) {
            // Check the hash values
            if (patternHash == textHash) {
                // Double-check characters
                if (text.substring(i, i + m).equals(pattern)) {
                    return i;
                }
            }

            // Calculate hash for next window
            if (i < n - m) {
                textHash = (d * (textHash - text.charAt(i) * h) + text.charAt(i + m)) % q;

                // We might get negative value of textHash, converting it to positive
                if (textHash < 0) {
                    textHash = (textHash + q);
                }
            }
        }

        return -1;
    }
}
