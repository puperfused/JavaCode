package com.random;

import java.util.*;

class Solution117 {
    public static String solve(List<Character> first, List<Character> second, String str, int m) {
        HashMap<Character, List<Integer>> mp = new HashMap<>();
        int len = str.length();
        for(int i=0; i<len; i++) {
            List<Integer> list = mp.getOrDefault(str.charAt(i), new ArrayList<>());
            list.add(i);
            mp.put(str.charAt(i), list);
        }
        for(int i=0; i<m; i++) {
            char firstChar = first.get(i);
            char secondChar = second.get(i);
            List<Integer> firstList = mp.get(firstChar);
            List<Integer> secondList = mp.get(secondChar);
            if(firstList != null && secondList != null) {
                mp.put(firstChar, secondList);
                mp.put(secondChar, firstList);
                continue;
            }

            if(firstList != null) {
                mp.put(secondChar, new ArrayList<>(firstList));
            }

            if(secondList != null) {
                mp.put(firstChar, new ArrayList<>(secondList));
            }
        }

        char[] out = new char[len];
        for(Map.Entry entry : mp.entrySet()) {
            char key = (char)entry.getKey();
            List<Integer> list = (List<Integer>)entry.getValue();
            for(int idx : list) {
                out[idx] = key;
            }
        }

        String ans = new String(out);
        //System.out.println(ans);
        return ans;
    }
}

class MutualSub {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int m = scan.nextInt();
        //System.out.println(m);
        List<Character> first = new ArrayList<>();
        scan.nextLine();
        for(int i=0; i<m; i++) {
            char[] input = scan.nextLine().toCharArray();
            first.add(input[0]);
        }
        m = scan.nextInt();
        scan.nextLine();
        List<Character> second = new ArrayList<>();
        for(int i=0; i<m; i++) {
            char[] input = scan.nextLine().toCharArray();
            second.add(input[0]);
        }
        String ans = Solution117.solve(first, second, str, m);
        System.out.println("Resulting string " + ans);
    }
}