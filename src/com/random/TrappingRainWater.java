package com.random;

class TrapSolution {
    public int solution(int[] nums) {
        int len = nums.length;
        int leftMax[] = new int[len];
        leftMax[0] = nums[0];
        for(int i=1; i<len; i++) {
            leftMax[i] = Math.max(leftMax[i-1],nums[i]);
        }
        int rightMax=nums[len-1];
        int result = 0;
        for(int i=len-2; i>=0; i--) {
            rightMax = Math.max(rightMax, nums[i]);
            result += Math.min(leftMax[i],rightMax) - nums[i];

        }
        return result;
    }
}
public class TrappingRainWater {
    public static void main(String args[]) {
        int nums[] = {3, 0, 2, 0, 4};
        int ans = new TrapSolution().solution(nums);
        System.out.println(ans);
    }
}
