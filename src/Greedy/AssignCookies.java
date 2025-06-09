package Greedy;
import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1};
        int result = findContentChildren(g, s);
        System.out.println(result);
    }

    private static int findContentChildren(int[] g, int[] s) {
        int m = s.length;
        int n = g.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for (int j = 0; j < m && i < n; j++) {
            if (s[j] >= g[i]){
                i++;
            }
        }
        return i;
    }
}
