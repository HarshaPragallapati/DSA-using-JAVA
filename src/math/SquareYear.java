package math;

import java.util.Scanner;

public class SquareYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- != 0){
            String s = sc.next();
            int val = Integer.parseInt(s);
            int root = (int) Math.sqrt(val);
            if (root * root == val) {
                int a = root / 2;
                int b = root - a;
                System.out.println(a + " " + b);
            } else {
                System.out.println("-1");
            }
        }
    }
}
