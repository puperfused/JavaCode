import java.util.*;

/** Given an integer value n , which represent the length of the binary string, generate all possible binary String of length n 

*/
class Solution {
    public static void generateAllPossibleBinaryString(int n) {
        int arr[] = new int[n];
        generateBinaryStringUtil(arr, 0, n);
    }

    public static void generateBinaryStringUtil(int arr[], int idx, int n) {
        if(idx == n) {
            for(int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        arr[idx] = 0;
        generateBinaryStringUtil(arr, idx+1, n);

        arr[idx] = 1;
        generateBinaryStringUtil(arr, idx+1, n);
    }
}

class GenerateAllBinaryString {
    public static void main(String args[]) {
        int n = 4;
        Solution.generateAllPossibleBinaryString(n);
    }
}