package stringUtils;

import java.util.HashMap;
import java.util.Scanner;

public class RomanToInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int num = romanToInt(s);
        System.out.println(num);
        sc.close();
    }

    private static int romanToInt(String s) {
        HashMap<Character, Integer> mpp = new HashMap<>();
        mpp.put('I', 1);
        mpp.put('V', 5);
        mpp.put('X', 10);
        mpp.put('L', 50);
        mpp.put('C', 100);
        mpp.put('D', 500);
        mpp.put('M', 1000);
        int sum = 0;
        int prev = 0;
        int curr = 0;
        for(int i = s.length() - 1; i >= 0; i--)
        {
            curr = mpp.get(s.charAt(i));
            if(curr < prev){
                sum -= curr;
            }
            else{
                sum += curr;
            }
            prev = curr;
        }
        return sum;
    }
}
