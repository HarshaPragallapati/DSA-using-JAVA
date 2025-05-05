package String;

import java.util.Scanner;

public class IsomorphicStrings205 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string 1 (lower case): ");
        String s1 = sc.nextLine();
        System.out.println("Enter string 2 (lower case): ");
        String s2 = sc.nextLine();
        if (checkIsomorphic(s1, s2)){
            System.out.println("Both are isomorphic to each other");
        }
        else {
            System.out.println("Strings are not isomorphic");
        }
    }
    private static boolean checkIsomorphic(String s1, String s2) {
        int[] hash1 = new int[256];
        int[] hash2 = new int[256];
        int n = s1.length();
        int m = s2.length();
        if (n != m){
            return false;
        }
        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (hash1[c1] == 0 && hash2[c2] == 0){
                hash1[c1] = c2;
                hash2[c2] = c1;
            } else if (hash1[c1] != c2 || hash2[c2] != c1) {
                return false;
            }
        }
        return true;
    }
}
