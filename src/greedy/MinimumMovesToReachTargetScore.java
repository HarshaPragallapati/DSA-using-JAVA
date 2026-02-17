package greedy;

public class MinimumMovesToReachTargetScore {
    public static void main(String[] args) {
        int target = 10, maxDoubles = 4;
        System.out.println(minMoves(target, maxDoubles));
    }

    private static int minMoves(int target, int maxDoubles) {
        int cnt = 0;
        while(maxDoubles != 0 && target > 1){
            if(target % 2 != 0){
                target--;
                cnt++;
            }
            target /= 2;
            cnt++;
            maxDoubles--;
        }
        return cnt + target - 1;
    }
}
