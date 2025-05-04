package String;

import java.util.Scanner;

public class FirstUniqueCharacterOfString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string (lower case): ");
        String s = sc.nextLine();
        int[] hash = new int[26];
        for(int i = 0; i < s.length(); i++){
            hash[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s.length(); i++){
            if(hash[s.charAt(i) - 'a'] == 1){
                System.out.println("First unique character is at: " + i);
                return;
            }
        }
        System.out.println("No unique characters found");
    }
}
