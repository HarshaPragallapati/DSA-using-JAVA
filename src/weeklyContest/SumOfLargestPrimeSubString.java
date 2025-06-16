package weeklyContest;

import java.util.Scanner;
import java.util.TreeSet;

public class SumOfLargestPrimeSubString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int sum = sumOfLargestPrimes(s);
        System.out.println("Sum of largest prime substrings: " + sum);
    }

    private static int sumOfLargestPrimes(String s) {
        TreeSet<Integer> set = new TreeSet<>((a, b) -> b - a);
        findPrimesFromIndex(s, 0, set);

        System.out.println("Prime substrings (sorted): " + set);

        int sum = 0, count = 0;
        for (int num : set) {
            if (count == 3) break;
            sum += num;
            count++;
        }
        return sum;
    }

    private static void findPrimesFromIndex(String s, int index, TreeSet<Integer> set) {
        if (index == s.length()) return;

        extractAndCheckPrimes(s, index, index + 1, set);
        findPrimesFromIndex(s, index + 1, set);
    }

    private static void extractAndCheckPrimes(String s, int start, int end, TreeSet<Integer> set) {
        if (end > s.length()) return;

        int num = Integer.parseInt(s.substring(start, end));
        if (isPrime(num)) {
            set.add(num);
        }

        extractAndCheckPrimes(s, start, end + 1, set);
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
