package SlidingWindow;

public class NoOfSubstrings1358 {
    public static void main(String[] args) {
        String s = "abcabc";
        int n = s.length();
        int[] hash = {-1,-1,-1};
        int count = 0;
        for (int i = 0; i < n; i++) {
            hash[s.charAt(i) - 'a'] = i;
            if(hash[0] != -1 && hash[1] != -1 && hash[2] != -1)
            {
                count += Math.min(hash[0], Math.min(hash[1], hash[2])) + 1;
            }
        }
        System.out.println(count);
    }
}
