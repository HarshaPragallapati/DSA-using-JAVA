package Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Combinations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(combine(n, k));
    }

    private static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        backtrack(1, n , k, comb, res);
        return res;
    }

    private static void backtrack(int index, int n, int k, List<Integer> comb, List<List<Integer>> res) {
        if (comb.size() == k){
            res.add(new ArrayList<>(comb));
            return;
        }
        for (int i = index; i <= n; i++) {
            comb.add(i);
            backtrack(i + 1, n , k, comb, res);
            comb.removeLast();
        }
    }
}
