package graphs;

import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {
        String[] words = {"baa", "abcd", "abca", "cab", "cad"};
        System.out.println(findOrder(words));
    }

    private static String findOrder(String[] words) {
        boolean[] present = new boolean[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                present[c - 'a'] = true;
            }
        }
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i], s2 = words[i + 1];
            int len = Math.min(s1.length(), s2.length());
            boolean found = false;
            for (int j = 0; j < len; j++) {
                char c1 = s1.charAt(j), c2 = s2.charAt(j);
                if (c1 != c2) {
                    adj.get(c1 - 'a').add(c2 - 'a');
                    found = true;
                    break;
                }
            }
            if (!found && s1.length() > s2.length()) return "";
        }
        return topoSort(adj, present);
    }

    private static String topoSort(List<List<Integer>> adj, boolean[] present) {
        int[] inDegree = new int[26];
        for (int u = 0; u < 26; u++) {
            for (int v : adj.get(u)) {
                inDegree[v]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (present[i] && inDegree[i] == 0) q.add(i);
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            sb.append((char)(u + 'a'));
            count++;
            for (int v : adj.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) q.add(v);
            }
        }
        // If not all present characters are visited, there's a cycle
        int totalChars = 0;
        for (boolean b : present) if (b) totalChars++;

        return count == totalChars ? sb.toString() : "";
    }
}
