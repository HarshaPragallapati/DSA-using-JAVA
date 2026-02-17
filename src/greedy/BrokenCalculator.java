package greedy;

public class BrokenCalculator {
    public static void main(String[] args) {
        int startValue = 2, target = 3;
        System.out.println(brokenCalc(startValue, target));
    }

    private static int brokenCalc(int startValue, int target) {
        int ops = 0;
        while (target > startValue){
            if (target % 2 == 0){
                target /= 2;
            }
            else {
                target += 1;
            }
            ops++;
        }
        return ops + startValue - target;
    }
}
