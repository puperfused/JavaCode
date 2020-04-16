package com.random;

class Solution2 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        int ans = binarySearch(nums, target, left, right);
        return ans;
    }

    public int binarySearch(int[] nums, int target, int left, int right) {
        int mid = (left + right)/2;

        if(left>right) {
            return -1;
        }

        if(nums[mid] == target) {
            return mid;
        }

        if(nums[left] < nums[mid]) {   //Left part is sorted
            if(target > nums[left] && target < nums[mid]) {
                return binarySearch(nums, target, left, mid);
            }
        }
        //Else right part is sorted and target lies in right part
        return binarySearch(nums, target, mid+1, right);
    }
}

public class SearchInSortedRotatedArray {
    public static void main(String args[]) {
        Solution2 sol = new Solution2();
        int arr[] = {4,5,6,7,0,1,2};
        int target = 3;
        int ans = sol.search(arr, target);
        System.out.println(ans);
    }
}
