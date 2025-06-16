package stringUtils;

import java.util.Scanner;
import java.util.Stack;

public class PrintLexographicallySmallestString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String res = robotWithString(s);
        System.out.println(res);
    }

    private static String robotWithString(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        Stack<Character> st = new Stack<>();
        int minChar = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            st.push(ch);
            freq[ch - 'a']--;
            while (minChar < 26 && freq[minChar] == 0){
                minChar++;
            }
            while (!st.isEmpty() && (st.peek() - 'a') <= minChar){
                result.append(st.pop());
            }
        }
        while (!st.isEmpty()){
            result.append(st.pop());
        }
        return result.toString();
    }
}
