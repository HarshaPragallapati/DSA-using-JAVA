package Greedy;

import java.util.HashMap;

public class RabbitsInForest781 {
    public static void main(String[] args) {
        int[] answers = {1, 1, 2};
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int total = 0;
        for(int num : answers){
            if(!mpp.containsKey(num) || mpp.get(num) == num + 1){
                mpp.put(num, 1);
                total += num + 1;
            }
            else{
                mpp.put(num, mpp.get(num) + 1);
            }
        }
        System.out.println(total);
    }
}
