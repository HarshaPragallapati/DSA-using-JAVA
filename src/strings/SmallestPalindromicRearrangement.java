package strings;

import java.util.SortedMap;
import java.util.TreeMap;

public class SmallestPalindromicRearrangement {
    public static void main(String[] args) {
        String s = "daccad";
        int n = s.length();
        StringBuilder res = new StringBuilder(n);
        SortedMap<Character, Integer> mpp = new TreeMap<>();
        int k = 0;
        if(n % 2 == 0)
        {
            for (int i = 0; i <= n / 2; i++) {
                mpp.put(s.charAt(i), k);
                k++;
            }
            for (int i = 0; i <= k; i++) {
                
            }
        }
    }
}
