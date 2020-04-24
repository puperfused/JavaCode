package com.random;

import javafx.util.Pair;

import java.util.*;

class Solution4 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //Map to store the intermediate nodes or combinations
        HashMap<String, List<String>> mp = new HashMap<>();
        int len = beginWord.length();

        //Pre Process the intermediate nodes
        wordList.forEach(
                //Find the all the combinations for each word "word"
                word -> {
                    for(int i=0; i<len; i++) {
                        String newWord = word.substring(0,i) + '*' + word.substring(i+1, len);
                        // Map this newWord with possible word in wordList with key as newWord
                        List<String> combinationList = mp.getOrDefault(newWord, new ArrayList<>());
                        // Add word to the map with key as newWord in the list of values
                        combinationList.add(word);
                        mp.put(newWord, combinationList);
                    }
                }
        );

        // Take of Queue of Pair<Node, Level> , where node refers to a particular node
        // return the level if the match found, as it would represent shortest path
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        //Push the first node that is beginWord and do the BFS
        queue.add(new Pair<>(beginWord, 1));
        // Maintain a map for visited node to avoid visiting already traversed node
        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        while(!queue.isEmpty()) {
            //Pop the nodes from the queue and traverse all the adjacent nodes of it and push it in the queue , Just like normal BFS
            Pair<String, Integer> node = queue.poll();
            String word = node.getKey();
            int level = node.getValue();
            // Generate all the combinations for word, and traverse the list mapped to each combinations,
            // which could be the possible adjacent node for word
            for(int i=0; i<len; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i+1, len);
                for(String adjacentWord: mp.getOrDefault(newWord, new ArrayList<>())) {
                    if(adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    if(!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        queue.add(new Pair<>(adjacentWord, level + 1));
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
