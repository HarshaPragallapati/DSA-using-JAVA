package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateParentheses22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> list = new ArrayList<>();
        char[] current = new char[2 * n];
        generateParen(0, 0, n, list, current, 0);
        System.out.println(list);
    }

    private static void generateParen(int left, int right, int n, List<String> list, char[] current, int pos) {
        if (pos == 2 * n) {
            list.add(new String(current));
            return;
        }
        if (left < n) {
            current[pos] = '(';
            generateParen(left + 1, right, n, list, current, pos + 1);
        }
        if (right < left) {
            current[pos] = ')';
            generateParen(left, right + 1, n, list, current, pos + 1);
        }
    }
}
