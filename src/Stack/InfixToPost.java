package Stack;
import java.util.Stack;
public class InfixToPost {
    static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "a+b*(c^d-e)^(f+g*h)-i";
        Stack<Character> st = new Stack<>();
        String res = new String();
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch))
            {
                res += ch;
            }
            else if(ch == '(')
            {
                st.push(ch);
            }
            else if(ch == ')')
            {
                while(!st.isEmpty() && st.peek()!='(')
                {
                    res += st.pop();
                }
                st.pop();
            }
            else
            {
                while(!st.isEmpty() && Prec(ch) <= Prec(st.peek()))
                {
                    res += st.pop();
                }
                st.push(ch);
            }
        }
        while(!st.isEmpty())
        {
            res += st.pop();
        }
        System.out.println(res);
    }
}
