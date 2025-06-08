package Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalindromePartitioning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(partition(s));
    }

    private static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        backtrack(0, s, temp, res);
        return res;
    }

    private static void backtrack(int index, String s, List<String> temp, List<List<String>> res) {
        if (index == s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)){
                temp.add(s.substring(index, i + 1));
                backtrack(i + 1, s, temp, res);
                temp.removeLast();
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start <= end){
            if (s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
