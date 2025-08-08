package strings;

public class ProcessStringWithSpecialOperations {
    public static void main(String[] args) {
        System.out.println(processStr("a#b%*"));
    }

    private static String processStr(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '*'){
                if (!result.isEmpty()){
                    result.deleteCharAt(result.length() - 1);
                }
            } else if (ch == '#') {
                result.append(result);
            } else if (ch == '%') {
                result.reverse();
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
