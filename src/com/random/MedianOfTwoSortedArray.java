package com.random;

import java.util.Scanner;

class Solution13 {
    public double Solution(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int len = m;
            m = n;
            n = len;
        }
        int iMin = 0, iMax = m, midIdx = (m+n+1)/2;
        while(iMin <= iMax) {
            int i = (iMin+iMax)/2;   // iteration over nums1 array
            int j = midIdx - i;       // iteration over nums2 array
            if(i>iMin && nums1[i-1] > nums2[j]) {   // decrease iMax
                iMax = i-1;
            } else if (i<iMax && nums2[j-1] > nums1[i]) {    //increase iMin
                iMin = i+1;
            } else {                    //found the element
                int maxLeft = 0;
                if(i==0) {
                    maxLeft = nums2[j-1];
                }else if(j==0){
                    maxLeft = nums1[i-1];
                }else {
                    maxLeft = Math.max(nums1[i-1], nums2[j-1]);
                }
                if((m+n)%2 == 1) {
                    return maxLeft*1.0;
                }

                int minRight = 0;
                if(i==m) {
                    minRight = nums2[j];
                } else if(j==n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i],nums2[j]);
                }
                return (maxLeft+minRight)/2.0;
            }
        }
        return 0.0;
    }
}
public class MedianOfTwoSortedArray {
    public static void main(String args[]) {
        int n, m;
        /*Scanner scan = new Scanner(System.in);
        m = scan.nextInt();
        n = scan.nextInt();
        int nums1[] = new int[m];
        int nums2[] = new int[n];*/
        m=2; n=1;
        int nums1[] = {1,2};
        int nums2[] = {3,4};
        /*for(int i=0; i< m; i++) {
            int x = scan.nextInt();
            nums1[i]=x;
        }
        for(int i=0; i< n; i++) {
            int x = scan.nextInt();
            nums2[i]=x;
        }*/
        double ans = new Solution13().Solution(nums1, nums2);
        System.out.println("Median = " + ans);
    }
}
