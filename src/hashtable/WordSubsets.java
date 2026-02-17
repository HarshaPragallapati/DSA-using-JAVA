package hashtable;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {
    public static void main(String[] args) {
        String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] words2 = {"e", "o"};
        System.out.println(wordSubsets(words1, words2));
    }

    private static List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxFreq = new int[26];
        for (String word : words2){
            int[] hash = new int[26];
            for (int i = 0; i < word.length(); i++) {
                hash[word.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], hash[i]);
            }
        }
        List<String> res = new ArrayList<>();
        for (String word : words1){
            int[] temp = new int[26];
            for (int i = 0; i < word.length(); i++) {
                temp[word.charAt(i) - 'a']++;
            }
            boolean isUniversal = true;
            for (int i = 0; i < 26; i++) {
                if (temp[i] < maxFreq[i]){
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal){
                res.add(word);
            }
        }
        return res;
    }
}
