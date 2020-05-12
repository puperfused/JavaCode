package com.random;

class Solution11 {
    public int shipWithinDays(int[] weights, int D) {
        int len = weights.length;
        if(len == 0) {
            return 0;
        }

        int sum = 0;
        int[] cumsum = new int[len+1];
        int i = 0;
        for(int wt : weights) {
            sum += wt;
            cumsum[i++]= sum;
        }

        if( D == 1) {
            return sum;
        }

        int l = 0, r = sum;
        int ans = 0;
        while(l < r) {
            int mid = (l+r)/2;
            if(check(mid-1, cumsum, weights, D)) {
                ans = mid-1;
                r = mid-1;
            } else if(check(mid, cumsum, weights, D)){
                ans = mid;
                r = mid-1;
            } else {
                l = mid+1;
            }
            //System.out.println("Least ship weight required to ship packages in D days " + ans);
        }

        return ans;
    }

    public boolean check(int mid, int[] cumsum, int[] weights, int D) {
        int sum = 0;
        int i = 0;
        for(i=0; i<weights.length; i++) {
            sum += weights[i];
            if(sum > mid) {
                D--;
                i--;
                sum = 0;
            }
            if(D <= 0) {
                break;
            }
        }

        if(sum <= mid) {
            D--;
        }

        if(D >= 0 && i == weights.length) {
            return true;
        }
        return false;
    }
}

public class CapacityToShip {
    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        int weights[] = {3,2,2,4,1,4};
        int D = 1;
        int ans = solution11.shipWithinDays(weights, D);
        System.out.println("Least ship weight required to ship packages in D days " + ans);
    }
}
