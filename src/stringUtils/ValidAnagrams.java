package stringUtils;

import java.util.Scanner;

public class ValidAnagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string 1 (lower case): ");
        String s1 = sc.nextLine();
        System.out.println("Enter string 2 (lower case): ");
        String s2 = sc.nextLine();
        if (checkAnagram(s1, s2)){
            System.out.println("Both are anagrams of each other");
        }
        else {
            System.out.println("Strings are not anagrams");
        }
    }

    private static boolean checkAnagram(String s1, String s2) {
        int[] hash = new int[26];
        int n = s1.length();
        int m = s2.length();
        if (n != m){
            return false;
        }
        for (int i = 0; i < n; i++) {
            hash[s1.charAt(i) - 'a']++;
            hash[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (hash[i] != 0){
                return false;
            }
        }
        return true;
    }
}
