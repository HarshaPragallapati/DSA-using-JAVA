package stringUtils;

import java.util.Scanner;

public class MirrorCharactersOfString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while (T-- != 0){
            String s = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                sb.append((char)('z' - (s.charAt(i) - 'a')));
            }
            System.out.println(sb);
        }
    }
}
