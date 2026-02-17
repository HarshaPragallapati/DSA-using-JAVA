package strings;

import java.util.*;


public class VowelSpellchecker {
    public static void main(String[] args) {
        String[] wordlist = {"KiTe","kite","hare","Hare"};
        String[] queries = {"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};
        System.out.println(Arrays.toString(spellchecker(wordlist, queries)));
    }

    private static String[] spellchecker(String[] wordlist, String[] queries) {
        String[] res = new String[queries.length];
        Set<String> exactWords = new HashSet<>();
        Map<String, String> caseInsensitiveWords = new HashMap<>();
        Map<String, String> vowelInsensitiveWords = new HashMap<>();
        for(String word : wordlist){
            exactWords.add(word);
            String lower = word.toLowerCase();
            caseInsensitiveWords.putIfAbsent(lower, word);
            vowelInsensitiveWords.putIfAbsent(removeVowel(lower).toLowerCase(), word);
        }
        for (int i = 0; i < queries.length; i++){
            String str = queries[i];
            if (exactWords.contains(str)){
                res[i] = str;
            }
            else {
                String lower = str.toLowerCase();
                if (caseInsensitiveWords.containsKey(lower)){
                    res[i] = caseInsensitiveWords.get(lower);
                }
                else {
                    String devoweled = removeVowel(lower);
                    res[i] = vowelInsensitiveWords.getOrDefault(devoweled, "");
                }
            }
        }
        return res;
    }

    private static String removeVowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++){
            char ch = sb.charAt(i);
            sb.append(isVowel(ch) ? '*' : ch);
        }
        return sb.toString();
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
