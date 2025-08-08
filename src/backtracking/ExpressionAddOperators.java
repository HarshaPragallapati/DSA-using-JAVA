package backtracking;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    public static void main(String[] args) {
        String num = "232";
        int target = 6;
        List<String> res = addOperators(num, target);
        for (String s : res){
            System.out.println(s);
        }
    }

    private static List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), num, target, 0, 0, 0);
        return result;
    }

    private static void backtrack(List<String> result, StringBuilder path, String num, int target,
                           int index, long evaluated, long prev) {
        if (index == num.length()) {
            if (evaluated == target) {
                result.add(path.toString());
            }
            return;
        }
        int len = path.length();
        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') break;
            String currStr = num.substring(index, i + 1);
            long curr = Long.parseLong(currStr);
            if (index == 0) {
                path.append(currStr);
                backtrack(result, path, num, target, i + 1, curr, curr);
                path.setLength(len);
            } else {
                path.append("+").append(currStr);
                backtrack(result, path, num, target, i + 1, evaluated + curr, curr);
                path.setLength(len);

                path.append("-").append(currStr);
                backtrack(result, path, num, target, i + 1, evaluated - curr, -curr);
                path.setLength(len);

                path.append("*").append(currStr);
                backtrack(result, path, num, target, i + 1,  evaluated - prev + prev * curr,
                        prev * curr);
                path.setLength(len);
            }
        }
    }
}
