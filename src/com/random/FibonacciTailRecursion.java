import java.util.*;

/**
    a = 0, b = 1, c = a + b, d = b + c, ... , i = val(i-1) + val(i-2) ...
    Tail Recursion = recursion value is computed at the last level call
*/

class Solution {
    public static int fiboTailRecursion(int n, int a, int b) {
        if(n == 0) {
            return a;
        }
        if( n == 1) { 
            return b;
        }
        return fiboTailRecursion(n-1, b, a+b);
    }
}

class FibonacciTailRecursion {
    public static void main(String args[]) {
        int n = 25;
        int ans = Solution.fiboTailRecursion(n, 0, 1);
        System.out.println("Nth fibonacci number where n = " + n + " is " + ans);
    }
}