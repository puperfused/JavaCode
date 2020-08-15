import java.util.*;

class Solution {
    public static char findFirstNonRepeatingCharacterInString(String input) {
        int len = input.length();
        HashMap<Character,Integer> mp = new HashMap<>();
        for(int i=0; i<len; i++) {
            char ch = input.charAt(i);
            mp.put(ch, mp.getOrDefault(ch, 0)+1);
        }

        for(int i=0; i<len; i++) {
            char ch = input.charAt(i);
            if(mp.get(ch) == 1) {
                return ch;
            }
        }
        // if no such character return !
        return '!';
    }
}

class FirstNonRepeatingChar {
    public static void main(String args[]) {
        String input = "racecar";
        char ch = Solution.findFirstNonRepeatingCharacterInString(input);
        System.out.println("First Non Repeating Character = " + ch);
    }
}