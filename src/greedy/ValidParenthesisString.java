package greedy;

public class ValidParenthesisString {
    public static void main(String[] args) {
        String s = "(*))";
        System.out.println(checkValidString(s));
    }

    private static boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch == '('){
                minOpen++;
                maxOpen++;
            } else if (ch == ')') {
                minOpen--;
                maxOpen--;
            } else {
                minOpen--;
                maxOpen++;
            }
            if (maxOpen < 0) return false;
            minOpen = Math.max(0, minOpen);
        }
        return minOpen == 0;
    }
}
