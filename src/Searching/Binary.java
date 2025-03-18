package Searching;

import java.util.Arrays;
import java.util.Scanner;

public class Binary {
    static char nextGreatestLetter(char[] letters, char target) {
        int start = 0, end = letters.length-1,i;
        while(start <= end)
        {
            int mid = (start+end)/2;
            if(target < letters[mid])
            {
                end = mid-1;
            }
            else if(target > letters[mid])
            {
                start = mid+1;
            }
            else
            {
                end = mid;
                start = end + 1;
                if (letters[end] != letters[start])
                {
                    break;
                }
                else{
                    while((letters[end] == letters[start]) && (start<letters.length)){
                        start++;
                    }
                }
            }
        }
        return start >= letters.length?letters[0]:letters[start];

    }
    public static void main(String[] args) {
        char[] arr = {'a','b','c','e','e'};
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char target = str.charAt(0);
        char ch = nextGreatestLetter(arr, target);
        System.out.println(ch);
    }


}
