package com.autocomplete.algorithm;

import com.autocomplete.model.TrieNode;
import java.util.*;

public class RankingAlgorithm {

    public static class WordRecommendation {
        public String word;
        public int frequency;

        public WordRecommendation(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }
    }

    public static List<String> getTopSuggestions(TrieNode root, String prefix, int limit) {
        PriorityQueue<WordRecommendation> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(a -> a.frequency)
        );

        dfs(root, new StringBuilder(prefix), minHeap, limit);

        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(0, minHeap.poll().word);
        }
        return result;
    }

    private static void dfs(TrieNode current, StringBuilder currentWord, PriorityQueue<WordRecommendation> minHeap, int limit) {
        if (current.isEndOfWord()) {
            minHeap.offer(new WordRecommendation(currentWord.toString(), current.getFrequency()));
            if (minHeap.size() > limit) {
                minHeap.poll();
            }
        }

        for (Map.Entry<Character, TrieNode> entry : current.getChildren().entrySet()) {
            currentWord.append(entry.getKey());
            dfs(entry.getValue(), currentWord, minHeap, limit);
            currentWord.deleteCharAt(currentWord.length() - 1);
        }
    }
}
