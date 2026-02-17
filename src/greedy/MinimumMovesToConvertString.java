package greedy;

public class MinimumMovesToConvertString {
    public static void main(String[] args) {
        String s = "XXOX";
        System.out.println(minimumMoves(s));
    }

    private static int minimumMoves(String s) {
        int n = s.length();
        int i = 0;
        int res = 0;
        while (i < n){
            if (s.charAt(i) == 'X'){
                res++;
                i += 3;
            }
            else {
                i++;
            }
        }
        return res;
    }
}
