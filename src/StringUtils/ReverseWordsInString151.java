package StringUtils;

public class ReverseWordsInString151 {
    public static void main(String[] args) {
        String s = "a good   example";
        StringBuilder sb = new StringBuilder();
        String[] str = s.trim().split("\\s+");
        for (int i = str.length - 1; i >= 0; i--) {
            sb.append(str[i]);
            if (i != 0) sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
