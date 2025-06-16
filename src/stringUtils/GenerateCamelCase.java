package stringUtils;

import java.util.Scanner;

public class GenerateCamelCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String caption = sc.nextLine();
        String res = generateTag(caption);
        System.out.println(res);
    }

    private static String generateTag(String caption) {
        StringBuilder sb = new StringBuilder("#");
        int n = caption.length();
        sb.append(Character.toLowerCase(caption.charAt(0)));
        boolean prevSpace = false;
        for (int i = 1; i < n; i++) {
            char ch = caption.charAt(i);
            if (ch == ' '){
                prevSpace = true;
                continue;
            }
            if (prevSpace){
                prevSpace = false;
                sb.append(Character.toUpperCase(ch));
            }
            else {
                sb.append(Character.toLowerCase(ch));
            }
        }
        if (sb.length() > 100){
            return sb.substring(0, 100);
        }
        return sb.toString();
    }
}
