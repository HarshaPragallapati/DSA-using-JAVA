package strings;

public class DeleteCharactersToMakeFancyString {
    public static void main(String[] args) {
        System.out.println(makeFancyString("aaabaaaa"));
    }

    private static String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            }
            else {
                count = 1;
            }
            if (count <= 2) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
