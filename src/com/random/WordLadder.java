package com.random;

import javafx.util.Pair;

import java.util.*;

class Solution4 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> mp = new HashMap<>();
        int len = beginWord.length();
        wordList.forEach(
                word -> {
                    for(int i=0; i<len ; i++) {
                        String newWord = word.substring(0, i) + '*' + word.substring(i+1, len);
                        List<String> combinations = mp.getOrDefault(newWord, new ArrayList<>());
                        combinations.add(word);
                        mp.put(newWord, combinations);
                    }
                }
        );

        // Queue having pair for word and the corresponding level
        Queue<Pair<String,Integer>> queue = new LinkedList<>();
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        queue.add(new Pair(beginWord, 1));
        while(!queue.isEmpty()) {
            Pair<String, Integer> node = queue.poll();
            String word = node.getKey();
            int level = node.getValue();
            for(int i=0; i<len; i++) {
                String newWord = word.substring(0,i) + '*' + word.substring(i+1, len);

                for(String adjacentWord : mp.getOrDefault(newWord, new ArrayList<>())) {
                    if(adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    if(!visited.containsKey(adjacentWord)) {
                        queue.add(new Pair(adjacentWord, level + 1));
                        visited.put(adjacentWord, true);
                    }
                }
            }
        }
        return 0;
    }
}

public class WordLadder {
    public static void main(String args[]) {
        Solution4 solution4 = new Solution4();

    }
}
