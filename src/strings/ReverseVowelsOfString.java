package strings;

public class ReverseVowelsOfString {
    public static void main(String[] args) {
        String s = "IceCreAm";
        System.out.println(reverseVowels(s));
    }

    private static String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int l = 0, r = s.length() - 1;
        while (l < r){
            while (l < r && !isVowel(s.charAt(l))) l++;
            while (l < r && !isVowel(s.charAt(r))) r--;
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        return new String(arr);
    }

    private static boolean isVowel(char ch){
        return "aeiouAEIOU".indexOf(ch) != -1;
    }
}
