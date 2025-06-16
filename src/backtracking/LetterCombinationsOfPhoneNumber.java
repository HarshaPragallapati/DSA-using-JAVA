package backtracking;

import java.util.*;

public class LetterCombinationsOfPhoneNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String digits = sc.nextLine();
        System.out.println(letterCombinations(digits));
    }

    private static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        findCombinations(new StringBuilder(), digits, 0, result, mapping);
        return result;
    }

    private static void findCombinations(StringBuilder curr, String digits, int index, List<String> result, String[] mapping) {
        if (index == digits.length()){
            result.add(curr.toString());
            return;
        }
        String s = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            curr.append(ch);
            findCombinations(curr, digits, index + 1, result, mapping);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
