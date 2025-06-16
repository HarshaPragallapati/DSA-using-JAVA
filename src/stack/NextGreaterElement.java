package stack;

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        for(int i = 2 * n - 1; i >= 0; i--)
        {
            while(!st.isEmpty() && st.peek() <= nums[i % n])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                res[i % n] = -1;
            }
            else
            {
                res[i % n] = st.peek();
            }
            st.push(nums[i % n]);
        }
        for (int i : res)
        {
            System.out.print(i + " ");
        }
    }
}


