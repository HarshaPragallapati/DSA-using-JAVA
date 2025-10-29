package greedy;

import java.util.*;

public class HandOfStraights {
    public static void main(String[] args) {
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;
        System.out.println(isNStraightHand(hand, groupSize));
    }

    private static boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        Map<Integer, Integer> mpp = new HashMap<>();
        for (int num : hand){
            mpp.put(num, mpp.getOrDefault(num, 0));
        }
        List<Integer> keys = new ArrayList<>(mpp.keySet());
        Collections.sort(keys);
        for (int num : keys){
            int freq = mpp.get(num);
            if (freq > 0){
                for (int i = 0; i < groupSize; i++) {
                    int curr = num + i;
                    if (mpp.get(curr) < freq){
                        return false;
                    }
                    mpp.put(curr, mpp.get(curr) - freq);
                }
            }
        }
        return true;
    }
}
