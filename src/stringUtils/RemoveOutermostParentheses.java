package stringUtils;

import java.util.Scanner;

public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(removeOuterParentheses(s));
    }

    private static String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (open > 0) sb.append(c);
                open++;
            } else {
                if (open > 1) sb.append(c);
                open--;
            }
        }
        return sb.toString();
    }
}
