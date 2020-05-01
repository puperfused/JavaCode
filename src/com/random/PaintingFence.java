package com.random;

import java.util.Scanner;

/**
 *  Given a fence with n posts and k colors, find out the number of ways of painting the fence such that at most 2 adjacent posts have the same color.
 *  Since answer can be large return it modulo 10^9 + 7.
 */

class Solution7 {
    public int noOfWays(int n, int k, int md) {
        if( n == 0) {
            return 1;
        }
        if( n == 1) {
            return k;
        }
        // if second fence is to be colored by same color as of first
        int same = k;
        // if second fence is to be colored by different color from first
        int diff = k*(k-1);
        // To track the total number of ways
        int total = (k + (k*(k-1))%md)%md;
        // For third fence two cases are as follows
        /**
         *  1) if third fence is to be colored by same color as of 2nd, then first fence must be of different color so
         *     no of ways of coloring fence(3) == no of ways of coloring(2) such that, its color is different from fence (1) which means the variable 'diff' is the answer for 'same' in case of this
         *  2) if third fence is to be colored by different color, then
         *     no of ways of coloring fence(3) == no of ways of coloring(2) * (k-1)
         */
        for(int i = 3; i <= n; i++) {
            same = diff;
            diff = (total*(k-1))%md;
            total = (same + diff) % md;
        }
        return total%md;
    }
}

public class PaintingFence {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        Solution7 solution7 = new Solution7();
        int md = (int)1e9+7;
        int ways = solution7.noOfWays(n, k, md);
        System.out.println(ways);
    }
}
