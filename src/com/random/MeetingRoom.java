package com.random;

import java.util.Arrays;
import java.util.Comparator;

class Interval {
    int start;
    int end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution5 {
    public boolean findSolution(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval t1, Interval t2) {
                return t1.start - t2.start;
            }
        });
        for(int i=0; i<intervals.length-1;  i++) {
            if(intervals[i].end > intervals[i+1].start) {
                return false;
            }
        }
        return true;
    }
}

public class MeetingRoom {
    public static void main(String args[]) {
        Solution5 sol = new Solution5();
        Interval val1 = new Interval(0, 30);
        Interval val2 = new Interval(5, 10);
        Interval val3 = new Interval(15, 20);
        Interval[] intervals = new Interval[]{val1, val2, val3};
        boolean ans = sol.findSolution(intervals);
        System.out.println(ans);
    }
}
