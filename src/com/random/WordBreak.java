package com.random;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class SolutionWordBreak {
    public boolean wordBreak(String word, List<String> wordList) {
        int len = word.length();
        HashSet<String> dict = new HashSet<>();
        for(int i=0; i < wordList.size(); i++) {
            dict.add(wordList.get(i));
        }
        return helper(word, dict);
    }

    public boolean helper(String word, HashSet<String> dict) {
        int len = word.length();

        if(len == 0) {
            return true;
        }
        for(int i=1; i<=len; i++) {
            if(dict.contains(word.substring(0, i)) && helper(word.substring(i, len), dict)) {
                return true;
            }
        }
        return false;
    }
}

public class WordBreak {
    public static void main(String args[]) {
        SolutionWordBreak solutionWordBreak = new SolutionWordBreak();
        List<String> dict = new ArrayList<>() {
            {
                add("apple"); add("pen");
            }
        };
        String word = "applepenapple";
        System.out.println(solutionWordBreak.wordBreak(word, dict));
    }
}
