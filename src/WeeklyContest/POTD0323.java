/*
Problem Statement:
You are given three integers p, q, and r.  Your task is to make all three numbers equal by applying the following operation any number of times:

Choose any two numbers and increase them by 1 while decreasing the third number by 1.

Find the minimum number of moves required, if impossible, -1.

Input:
The first line contains t (1 ≤ t ≤ 10⁴) -- test cases.
Each of the next t lines contains three integers p, q, r.

Output:
For each test case, print a single integer — the minimum number of moves. If it's impossible, print -1.

Constraints:
1 ≤ t ≤ 10⁴
1 ≤ p ≤ q ≤ r ≤ 10⁹

Input:
4
1 2 3
4 4 4
3 2 6
1 1 7

output:
-1
0
-1
3

Explanation:
1 1 7
choose (1, 1) -> 2 2 6
choose (2, 2) -> 3 3 5
choose (3, 3) -> 4 4 4

3 is the min no.of moves required to make all three numbers equal.
 */

package WeeklyContest;

import java.util.Scanner;

public class POTD0323 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long p = sc.nextLong();
        long q = sc.nextLong();
        long r = sc.nextLong();
        long minCount;
        long s = p+q+r;
        if((p!=q && q!=r) || (p-q)%2!=0 || (q-r)%2!=0)
        {
            minCount = -1;
        }
        else if(p == q && q == r ){
            minCount = 0;
        }
        else {
            if(p != q)
            {
                minCount = (long) Math.ceil(Math.abs(p-q)/2);
            }
            else
            {
                minCount = (long) Math.ceil(Math.abs(q-r)/2);
            }
        }
        System.out.println(minCount);
    }
}