package weeklyContest;

public class Score20_04 {
    public static void main(String[] args) {
        String[] instructions = {"jump","add","add","jump","add","jump"};
        int[] values = {2,1,3,1,-2,-3};
        long score = 0;
        int i = 0;
        int n = values.length;
        int[] hash = new int[n];
        while(i < n && i >= 0){
            if (hash[i] == 1){
                break;
            }
            else {
                if(instructions[i].equals("add")){
                    score += values[i];
                    hash[i]++;
                }
                else
                {
                    hash[i]++;
                    i += values[i];
                    continue;
                }
            }
            i++;
        }
        System.out.println(score);
    }
}
