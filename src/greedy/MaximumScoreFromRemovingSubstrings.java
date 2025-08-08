package greedy;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumScoreFromRemovingSubstrings {
    public static void main(String[] args) {
        String s = "cdbcbbaaabab";
        int x= 4;
        int y = 5;
        System.out.println(maximumGain(s, x, y));
    }

    private static int maximumGain(String s, int x, int y) {
        int res = 0;
        char[] letters = s.toCharArray();
        int n = letters.length;
        char a = 'a', b = 'b';
        int aCnt = 0, bCnt = 0;
        if (x < y) {
            int tmp = x;
            x = y;
            y = tmp;
            a = 'b';
            b = 'a';
        }
        for (int i = 0; i < n; i++) {
            if (letters[i] == a) {
                aCnt++;
            } else if (letters[i] == b) {
                if (aCnt > 0) {
                    aCnt--;
                    res += x;
                } else {
                    bCnt++;
                }
            } else {
                res += Math.min(aCnt, bCnt) * y;
                aCnt = 0;
                bCnt = 0;
            }
        }
        if (aCnt!= 0) {
            res += Math.min(aCnt, bCnt) * y;
        }
        return res;


//        if (x > y){
//            return removeAndScore(s, "ab", x, "ba", y);
//        }
//        return removeAndScore(s, "ba", y, "ab", x);
    }

//    private static int removeAndScore(String s, String firstPair, int firstPoints, String secondPair, int secondPoints) {
//        StringBuilder rem = new StringBuilder();
//        int totalScore = 0;
//        totalScore += removePair(s, firstPair, firstPoints, rem);
//        StringBuilder dummy = new StringBuilder();
//        totalScore += removePair(rem.toString(), secondPair, secondPoints, dummy);
//        return totalScore;
//    }
//
//    private static int removePair(String s, String pair, int points, StringBuilder result) {
//        Deque<Character> stack = new ArrayDeque<>();
//        int score = 0;
//        char first = pair.charAt(0), second = pair.charAt(1);
//        for (char ch : s.toCharArray()){
//            if (!stack.isEmpty() && stack.peek() == first && ch == second){
//                stack.pop();
//                score += points;
//            }
//            else {
//                stack.push(ch);
//            }
//        }
//        while (!stack.isEmpty()){
//            result.insert(0, stack.pop());
//        }
//        return score;
//    }
}
