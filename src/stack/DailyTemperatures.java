package stack;

import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(dailyTemperatures(temperatures).toString());
    }

    private static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]){
                st.pop();
            }
            int cnt = st.isEmpty() ? 0 : st.peek() - i;
            st.push(i);
            res[i] = cnt;
        }
        return res;
    }
}
