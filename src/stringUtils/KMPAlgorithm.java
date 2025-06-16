package stringUtils;

import java.util.Scanner;

public class KMPAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text string: ");
        String text = sc.nextLine();
        System.out.println("Enter the pattern to search: ");
        String pattern = sc.nextLine();
        int index = kmpSearch(text, pattern);
        System.out.println("First occurrence at index: " + index);
    }

    public static int kmpSearch(String text, String pattern) {
        if (pattern.length() > text.length()) return -1;
        int[] lps = new int[pattern.length()];
        computeLPS(pattern, lps);
        int i = 0; // Index for text
        int j = 0; // Index for pattern

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == pattern.length()) {
                    return i - j; // Match found
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1]; // Skip using LPS
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

    private static void computeLPS(String pattern, int[] lps) {
        int len = 0;
        int i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                lps[i] = ++len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; // Move back in LPS
                } else {
                    i++;
                }
            }
        }
    }
}