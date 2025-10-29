package bitManipulation;

public class SmallestNumberWithAllSetBits {
    public static void main(String[] args) {
        System.out.println(smallestNumber(5));
        System.out.println(smallestNumber(19));
        System.out.println(smallestNumber(66));
    }

    private static int smallestNumber(int n) {
        if (n < 1)
            return 0;
         return Integer.highestOneBit(n) * 2 - 1;

         // Approach 2
         // int power = (int) Math.floor(Math.log(n) / Math.log(2));
         // return (int) (Math.pow(2, power) - 1);
    }
}
