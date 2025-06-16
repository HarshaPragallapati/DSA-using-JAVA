package recursion;

import java.util.Scanner;

public class CountAndSay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = recursiveCount(n, 1, "1");
        System.out.println(s);
    }

    private static String recursiveCount(int n, int ind, String s) {
        if (ind == n) return s;
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else {
                sb.append(count).append(s.charAt(i));
                count = 1;
            }
        }

        return recursiveCount(n, ind + 1, sb.toString());
    }
}
