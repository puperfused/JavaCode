import java.util.*;

/**
 *  Given an array having the negative and positive level of energy, starting from the 0th index you have to reach end index
 *  Such that you run out of energy, or at any given index your energy should be at least 1.
 */
class Solution {
    public static int findMinimumEnergy(int[] arr) {
        int len = arr.length;
        if(len == 0) {
            return 0;
        }
        int flag = 0;
        int sum=0,minEnergy = 0;
        for(int i=0; i<len; i++) {
            sum += arr[i];
            if(sum <= 0) {
                minEnergy += (Math.abs(sum) + 1);
                sum = 1;
                flag = 1;
            }
        }

        return flag == 0 ? 1 : minEnergy;
    }
}

class MinimumEnergy {
    public static void main(String args[]) {
        int[] arr = {1, 2, -4, 4, -4, 5};
        int ans = Solution.findMinimumEnergy(arr);
        System.out.println("Minimum energy required = " + ans);
    }
}