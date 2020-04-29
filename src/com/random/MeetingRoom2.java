package com.random;

import java.util.*;

class Solution6 {
    public int findSolution(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval, Interval t1) {
                return interval.start - t1.start;
            }
        });
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        for(int i=0; i<intervals.length; i++) {
            mp.put(intervals[i].start, mp.getOrDefault(intervals[i].start, 0)+1 );
            mp.put(intervals[i].end, mp.getOrDefault(intervals[i].end, 0)-1);
        }
        int result = 0;
        int ans = 1;
        for(Map.Entry entry : mp.entrySet() ) {
            result += (int) entry.getValue();
            ans = Math.max(result, ans);
        }
        return ans;
    }
}
public class MeetingRoom2 {
    public static void main(String args[]) {
        Solution6 sol = new Solution6();
        Interval val1 = new Interval(0, 30);
        Interval val2 = new Interval(5, 20);
        Interval val3 = new Interval(15, 20);
        Interval[] intervals = new Interval[]{val1, val2, val3};
        int ans = sol.findSolution(intervals);
        System.out.println(ans);
    }
}
