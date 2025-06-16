package slidingWindow;


//76 - leetcode
public class MinWindowSubstring76 {
    public static void main(String[] args) {
        String s = "a";
        String t = "aa";
        int[] hash = new int[256];
        int n = s.length();
        int m = t.length();
        for(int i = 0; i < m; i++)
        {
            hash[t.charAt(i)]++;
        }
        int left = 0, right = 0;
        int count = 0, minLength = Integer.MAX_VALUE, start = -1;
        while (right < n)
        {
            if(hash[s.charAt(right)] > 0)
            {
                count++;
            }
            hash[s.charAt(right)]--;
            while (count == m)
            {
                if(right - left + 1 < minLength)
                {
                    minLength = right - left + 1;
                    start = left;
                }
                hash[s.charAt(left)]++;
                if (hash[s.charAt(left)] > 0)
                {
                    count--;
                }
                left++;
            }
            right++;
        }
        System.out.println(start == -1 ? "" : s.substring(start, start + minLength));
    }
}
