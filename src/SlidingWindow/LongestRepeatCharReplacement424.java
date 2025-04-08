package SlidingWindow;

import java.util.Scanner;

public class LongestRepeatCharReplacement424 {
    public static int RepeatCharReplace(String s, int k){
        int n = s.length();
        int left = 0, right = 0;
        int max = 0, res = 0;
        int[] hash = new int[26];
        while (right < n)
        {
            hash[s.charAt(right) - 'A']++;
            max = Math.max(max, hash[s.charAt(right) - 'A']);
            while (right - left + 1 - max > k)
            {
                hash[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input string: ");
        String str = sc.nextLine();
        System.out.println("Enter k : ");
        int k = sc.nextInt();
        System.out.println(RepeatCharReplace(str, k));
    }
}
