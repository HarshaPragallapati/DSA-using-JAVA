package stack;

import java.util.Stack;

public class ReverseSubstringsBetweenEachPairOfParetheses {
    public static void main(String[] args) {
        System.out.println(reverseParentheses("(u(love)i)"));
        System.out.println(reverseParentheses("(ed(et(oc))el)"));
    }

    private static String reverseParentheses(String s) {
        Stack<StringBuilder> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '('){
                st.push(sb);
                sb = new StringBuilder();
            } else if (ch == ')') {
                StringBuilder temp = sb.reverse();
                sb = st.pop();
                sb.append(temp);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
