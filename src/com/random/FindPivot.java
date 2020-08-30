package com.random;

class FindPivot {
    // Find the pivot
    // The perform binary search in the appropriate sub-array
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        if (nums[pivot] == target) {
            return pivot;
        }
        else if (target <= nums[nums.length - 1]) {
            return binarySearch(nums, pivot, nums.length - 1, target);
        }
        else {
            return binarySearch(nums, 0, pivot - 1, target);
        }
    }

    // This function finds the pivot around which the array is rotated
    private int findPivot(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            // If we falls in the non-decreasing sub-array, the the pivot is the left most item
            if (nums[mid] > nums[left] && nums[mid] < nums[right]) return left;

            // 2 cases where the pivot is at the [mid] position or next to it
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) return mid + 1;
            if (mid == left || nums[mid] < nums[mid - 1]) return mid;

            // Otherwise keep searching for the pivot, the same way as binary search
            if (nums[mid] < nums[left]) right = mid - 1;
            else
                left = mid + 1;

        }

        return left;
    }

    // Normal binary search, used when we have found the pivot
    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return nums[left] == target ? left : -1;
    }
}
