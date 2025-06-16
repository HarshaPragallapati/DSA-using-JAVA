package stringUtils;
// count no of substrings starting with same start and end character

import java.util.Scanner;

public class CountSubString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int count = findCount(s);
        System.out.println(count);
    }

    private static int findCount(String s) {
        int[] hash = new int[26];
        for(char c : s.toCharArray()){
            hash[c - 'a']++;
        }
        int cnt = 0;
        for(int i = 0; i < 26; i++){
            if(hash[i] > 0){
                cnt += hash[i] * (hash[i] + 1) / 2;
            }
        }
        return cnt;
    }
}
