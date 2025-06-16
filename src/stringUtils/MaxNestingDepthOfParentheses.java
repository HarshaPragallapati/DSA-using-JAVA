package stringUtils;

import java.util.Scanner;

public class MaxNestingDepthOfParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(maxDepth(s));
    }
    private static int maxDepth(String s) {
        int cnt = 0, max = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                cnt++;
                max = Math.max(max, cnt);
            }
            else if(s.charAt(i) == ')'){
                cnt--;
            }
        }
        return max;
    }
}
