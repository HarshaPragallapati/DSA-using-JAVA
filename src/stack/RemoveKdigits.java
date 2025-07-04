package stack;

import java.util.Stack;

public class RemoveKdigits {
    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3));
        System.out.println(removeKdigits("10200", 1));
        System.out.println(removeKdigits("10", 2));
    }

    private static String removeKdigits(String num, int k) {
        int n = num.length();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < n){
            char ch = num.charAt(i++);
            while (k > 0 && !sb.isEmpty() && sb.charAt(sb.length() - 1) > ch){
                k--;
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(ch);
        }
        while (k-- > 0){
            sb.deleteCharAt(sb.length() - 1);
        }
        int l = 0;
        while (l < sb.length() && sb.charAt(l) == '0') {
            l++;
        }
        sb.delete(0, l);
        return !sb.isEmpty() ? sb.toString() : "0";
    }
}
