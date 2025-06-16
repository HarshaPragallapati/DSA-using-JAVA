package bitManipulation;

public class MinimumBitFlipsToConvertNumber2220 {
    public static void main(String[] args) {
        int start = 3, goal = 4;
        int n = start ^ goal;
        int count = 0;
        while(n != 0){
            n = n & n - 1;
            count++;
        }
        System.out.println(count);
    }
}
