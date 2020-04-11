package com.random;

import java.util.HashMap;

public class Test1 {

    public int[] solution(int[] nums, int target) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int res[] = new int[2];
        for(int i=0; i<nums.length; i++) {
            mp.put(nums[i], i);
        }
        for(int i=0; i<nums.length; i++){
            int var = target - nums[i];
            if(mp.containsKey(var) && (i != mp.get(var))) {
                res[0] = i;
                res[1] = mp.get(var);
                break;
            }
        }
        return res;
    }

    public static void main(String args[]) {
        int nums[] = {1,2,3,4,5};
        Test1 obj = new Test1();
        int ans[] = obj.solution(nums, 6);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
