package stringUtils;

public class FindTheOriginalTypedString {
    public static void main(String[] args) {
        System.out.println(possibleStringCount("abbcccc"));
        System.out.println(possibleStringCount("abcd"));
    }

    private static int possibleStringCount(String word) {
        int count = 1;
        for(int i = 1; i < word.length(); i++){
            if(word.charAt(i) == word.charAt(i - 1)){
                count++;
            }
        }
        return count;
    }
}
