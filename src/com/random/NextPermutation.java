package com.random;

class Solution1 {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len-1;
        while(i-1>=0 && nums[i]>=nums[i-1]) {
            i--;
        }
        if(i>=0) {
            int j=len-1;
            while(j>i && nums[i]<=nums[j]) {
                j--;
            }
            swap(nums, i, j);
            reverse(nums, i+1, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while(i<j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}

public class NextPermutation {
    public static void main(String args[]) {
        int nums[] = {1, 2, 3};
        Solution1 sol = new Solution1();
        sol.nextPermutation(nums);
        for(int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
