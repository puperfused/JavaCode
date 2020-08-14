import java.util.*;

class Solution {
    public static double findAngleBetweenHourAndMinuteHand(int hour, int minute) {

        if( hour > 24 || minute > 60 || hour < 0 || minute < 0) {
            System.out.println("Invalid Input");
            return 0.0;
        }

        if(hour == 12) {
            hour = 0;
        }

        if(minute == 60) {
            minute = 0;
            hour++;
            if(hour > 12) {
                hour = hour - 12;
            }
        }

        double hourDistance = (hour*60 + minute) * 0.5;
        double minuteDistance = (minute * 6.0);
        double angle = Math.abs(hourDistance - minuteDistance);
        angle = Math.min(angle, 360.0 - angle);
        return angle;
    }
}

class HourMinAngle {
    public static void main(String args[]) {
        int hour = 13;
        int minute = 60;
        double angle = Solution.findAngleBetweenHourAndMinuteHand(hour, minute);
        System.out.println("Angle between the hour and minute hand = " + angle);
    }
}