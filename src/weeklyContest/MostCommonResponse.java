package weeklyContest;

import java.util.*;

public class MostCommonResponse {
    public static String mostCommonResponse(List<List<String>> responses) {
        Map<String, Integer> countMap = new HashMap<>();

        for (List<String> day : responses) {
            Set<String> uniqueResponses = new HashSet<>(day); // remove duplicates within each day
            for (String response : uniqueResponses) {
                countMap.put(response, countMap.getOrDefault(response, 0) + 1);
            }
        }

        int maxFreq = 0;
        String result = "";

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            String response = entry.getKey();
            int freq = entry.getValue();

            if (freq > maxFreq || (freq == maxFreq && response.compareTo(result) < 0)) {
                maxFreq = freq;
                result = response;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<String>> responses = new ArrayList<>();
        responses.add(Arrays.asList("good", "ok", "good"));
        responses.add(Arrays.asList("ok", "bad"));
        responses.add(Arrays.asList("bad","notsure"));
        responses.add(Arrays.asList("great","good"));

        System.out.println(mostCommonResponse(responses)); // Output: "good"
    }
}
