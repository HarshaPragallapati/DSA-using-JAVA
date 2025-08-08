package strings;

import java.util.*;

public class PartitionString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<String> res = partitionString(s);
        System.out.println(res);
    }

    private static List<String> partitionString(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        sb.append(s.charAt(0));
        Set<String> set = new HashSet<>();
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            if (!set.contains(sb.toString())){
                set.add(sb.toString());
                result.add(sb.toString());
                sb.setLength(0);
            }
            sb.append(c);
        }
        if (!set.contains(sb.toString())){
            result.add(sb.toString());
        }
        return result;
    }
}



