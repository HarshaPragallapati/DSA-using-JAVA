package slidingWindow;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CountCompleteSubArrays2799 {
    public static void main(String[] args) {
        int[] nums = {5,5,5,5};
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i : nums)
        {
            set.add(i);
        }
        int j = 0, s = set.size(), count = 0;
        for (int i = 0; i < n; i++)
        {
            if (map.getOrDefault(nums[i], 0) == 0)
            {
                s--;
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (s == 0)
            {
                map.put(nums[j], map.get(nums[j]) - 1);
                if (map.get(nums[j]) == 0)
                {
                    s++;
                }
                j++;
            }
            count += j;
        }
        System.out.println(count);
    }
}
