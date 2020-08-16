package com.random;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Solution12 {

    // Complete the mutualSubstitutions function below.
    static String mutualSubstitutions(String s, List<Character> subFirst, List<Character> subSecond) {
        if (s == null || s.length() == 0 ||
                subFirst == null || subSecond == null ||
                subFirst.isEmpty() || subSecond.isEmpty()) {
            return s;
        }
        int i, j;
        int len = subFirst.size();
        int strlen = s.length();
        String temp = "";
        char swap[] = new char[26];
        for (i = 0; i < 26; i++) {
            swap[i] = (char) (i + 97);
        }

        for (j = 0; j < len; j++) {
            char a = subFirst.get(j);
            char b = subSecond.get(j);
            System.out.println("a = " + a  + " b = " + b + " swap a = " + (int) (a - 97) + " swap b = " + (int) (b - 97));
            //char temp1 = swap[(int) (a - 97)];
            swap[(int) (a - 97)] = b;
            swap[(int) (b - 97)] = a;
            for (i = 0; i < 26; i++) {
                System.out.print(swap[i] + " ");
            }
            System.out.println();
        }

        for (i = 0; i < 26; i++) {
            System.out.print(swap[i] + " ");
        }
        System.out.println();

        for (i = 0; i < strlen; i++) {
            char curr = s.charAt(i);
            char rep = swap[(int) (curr - 97)];
            temp += rep;
        }
        return temp;
    }

}

public class MutualSubstitution {
    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        List<Character> subFirst = new ArrayList<>();
        List<Character> subSecond = new ArrayList<>();
        String str = "coder";

        subFirst.add('c'); //subFirst.add('j'); subFirst.add('a');
        subSecond.add('o'); //subSecond.add('z'); subSecond.add('k');
        String result = solution12.mutualSubstitutions(str, subFirst, subSecond);
        System.out.println("Result " + result);
    }
}
