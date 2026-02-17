package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mpp = new HashMap<>();
        for (String str : strs){
            int[] freq = new int[26];
            for (int i = 0; i < str.length(); i++) {
                freq[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int num : freq){
                sb.append(num).append("#");
            }
            mpp.computeIfAbsent(sb.toString(), k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(mpp.values());
    }
}
