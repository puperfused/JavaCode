import java.util.*;

class Solution {
    public static int findMinimumSizeSubarray(int[] arr, int sum) {
        int len = arr.length;
        if(len == 0) {
            return 0;
        }

        int left = 0, currentSum = 0;
        int minSize = Integer.MAX_VALUE;
        for(int i=0; i<len; i++) {
            currentSum += arr[i];
            if(currentSum >= sum) {
                while(currentSum >= sum) {
                    minSize = Math.min(minSize, (i - left + 1));
                    currentSum -= arr[left++];
                }
                
            }
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}

class MinimumSizeSumSubarray {
    public static void main(String args[]) {
        int arr[] = {2,3,1,2,4,3};
        int S = 234;
        int ans = Solution.findMinimumSizeSubarray(arr, S);
        System.out.println("Minimum Size Subarray with sum at least S = " + ans);
    }
}