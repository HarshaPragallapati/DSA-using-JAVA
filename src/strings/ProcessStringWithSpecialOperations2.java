package strings;

import java.util.ArrayList;
import java.util.List;

public class ProcessStringWithSpecialOperations2 {
    public static void main(String[] args) {
        System.out.println(processStr("a#b%*", 1));
    }

    private static char processStr(String s, long k) {
        List<Long> lengths = new ArrayList<>();
        lengths.add(0L);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            long currLen = lengths.get(lengths.size() - 1);
            if (ch >= 'a' && ch <= 'z') {
                currLen += 1;
            } else if (ch == '*') {
                if (currLen > 0) currLen -= 1;
            } else if (ch == '#') {
                currLen *= 2;
                if (currLen > k) currLen = k + 1;
            } else if (ch == '%') {
            }

            lengths.add(currLen);
        }

        if (lengths.get(lengths.size() - 1) <= k) return '.';

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            long prevLen = lengths.get(i);
            if (ch >= 'a' && ch <= 'z') {
                if (k == prevLen) return ch;
            } else if (ch == '*') {
                if (prevLen < lengths.get(i + 1)) {
                    k++;
                }
            } else if (ch == '#') {
                if (k >= prevLen) {
                    k -= prevLen;
                }
            } else if (ch == '%') {
                k = prevLen - 1 - k;
            }
        }

        return '.';
    }
}
