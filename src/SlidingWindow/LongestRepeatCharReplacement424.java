package SlidingWindow;

import java.util.Scanner;

public class LongestRepeatCharReplacement424 {
    public static int RepeatCharReplace(String s, int k){
        int n = s.length();
        int left = 0, right = 0;
        int maxCount = 0, maxLength = 0;
        int[] hash = new int[26];
        while (right < n)
        {
            hash[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, hash[s.charAt(right) - 'A']);
            while (right - left + 1 - maxCount > k)
            {
                hash[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
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
