package strings;

public class CountNumberOfVowelStringsInRange {
    public static void main(String[] args) {
        String[] words = {"are","amy","u"};
        int left = 0, right = 2;
        System.out.println(vowelStrings(words, left, right));
    }

    private static int vowelStrings(String[] words, int left, int right) {
        int cnt = 0;
        for (int i = left; i <= right; i++) {
            String s = words[i];
            if (isVowel(s.charAt(0)) && isVowel(s.charAt(s.length() - 1))){
                cnt++;
            }
        }
        return cnt;
    }

    private static boolean isVowel(char ch){
        return "aeiou".indexOf(ch) != -1;
    }
}
