package greedy;

public class LemonadeChange {
    public static void main(String[] args) {
        int[] bills = {5,5,5,10,20};
        boolean hasChange = lemonadeChange(bills);
        System.out.println(hasChange);
    }

    private static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int num : bills){
            if (num == 5){
                five++;
            }
            else if (num == 10){
                if (five == 0) return false;
                five--;
                ten++;
            }
            else {
                if (five > 0 && ten > 0){
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
