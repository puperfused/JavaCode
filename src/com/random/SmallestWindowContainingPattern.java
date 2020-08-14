import java.util.*;

/** Given two strings str and pattern, find the smalleset window in str that contains all the characters of the pattern, order of the character doesnt matter
    Approach:
    Store the frequency of characters in pattern in an array say hashPat
    Iterate through the string str, and store the characters frequency in str in another array say hashStr
    While storing in hashStr keep increasing the count for match with hashPat
    if count becomes equal to length of the pattern , then try to minimize the window by removing the extra character from begining or start
    keep the track of minimumLengthSoFar while iterating over str
*/
class Solution {
    public static String findMinLengthWindowContainingPatternCharacters(String str, String pattern) {

        int strLen = str.length();
        int patLen = pattern.length();
        int hashPat[] = new int[256];
        int hashStr[] = new int[256];
        Arrays.fill(hashPat, 0);
        Arrays.fill(hashStr, 0);

        for(int i=0; i<patLen; i++) {
            hashPat[pattern.charAt(i)]++;
        }

        int start = 0, minimumLengthSoFar = Integer.MAX_VALUE, start_idx = -1;
        int count = 0;
        for(int i=0; i<strLen; i++) {

            hashStr[str.charAt(i)]++;
            if(hashPat[str.charAt(i)]!=0 && hashStr[str.charAt(i)] <= hashPat[str.charAt(i)]) {
                count++;
            }

            if(count == patLen) {
                while(hashStr[str.charAt(start)] > hashPat[str.charAt(start)] || hashPat[str.charAt(start)] == 0) {
                    if(hashStr[str.charAt(start)] > hashPat[str.charAt(start)]) {
                        hashStr[str.charAt(start)]--;
                    }
                    start++;
                }

                int currentWindowLen = (i - start + 1);
                //System.out.println("currentWindowLen = " + currentWindowLen);
                if(minimumLengthSoFar > currentWindowLen) {
                    minimumLengthSoFar = currentWindowLen;
                    start_idx = start;
                }
            }
        }

        System.out.println("minimumLengthSoFar = " + minimumLengthSoFar);
        if(start_idx == -1) {
            return "";
        }

        String windowStr = str.substring(start_idx, start_idx + minimumLengthSoFar);
        return windowStr;
    }
}

class SmallestWindowContainingPattern {
    public static void main(String args[]) {
        String pattern = "scar";
        String str = "sracing car is car racing";
        String resultWindowStr = Solution.findMinLengthWindowContainingPatternCharacters(str, pattern);
        System.out.println("Smallest window containing all the characters of the given pattern " + resultWindowStr);
    }
}