package StringUtils;

import java.util.Scanner;

public class MostFrequentVowelAndConsonant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int freq = maxFreq(s);
        System.out.println(freq);
    }

    private static int maxFreq(String s) {
        int[] hash = new int[26];
        int vowel = 0, consonant = 0;
        for (char c : s.toCharArray()) {
            hash[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (i == 0 || i == 4 || i == 8 || i == 14 || i == 20)
            {
                vowel = Math.max(vowel, hash[i]);
            }
            else{
                consonant = Math.max(consonant, hash[i]);
            }
        }
        return vowel + consonant;
    }
}
