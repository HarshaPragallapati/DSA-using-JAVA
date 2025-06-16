package stack;

import java.util.Stack;

public class asteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {-3,2,4,-3,-2,5,6,-9,4,-3,4,-6};
        Stack<Integer> st = new Stack<>();
        int n = asteroids.length;
        int i = n - 1;
        while(i >= 0 && asteroids[i] > 0)
        {
            st.push(asteroids[i]);
            i--;
        }
        while(i >=0 && asteroids[i] < 0)
        {
            st.push(asteroids[i]);
            i--;
        }
        while(i >= 0)
        {
            if(asteroids[i] < 0)
            {
                st.push(asteroids[i]);
                i--;
                continue;
            }
            if(st.isEmpty() || (asteroids[i] > 0 && st.peek() > 0))
            {
                st.push(asteroids[i]);
                i--;
            }
            else
            {
                if(Math.abs(st.peek()) > asteroids[i])
                {
                    i--;
                }
                else if(Math.abs(st.peek()) == asteroids[i]){
                    st.pop();
                    i--;
                }
                else {
                    st.pop();
                }
            }
        }
        while (!st.isEmpty())
        {
            System.out.println(st.pop());
        }
        System.out.println("Finished the program");
    }
}
