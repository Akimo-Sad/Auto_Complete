package com.autocomplete.service;

import com.autocomplete.algorithm.RankingAlgorithm;
import com.autocomplete.model.TrieNode;
import java.io.*;
import java.util.*;

public class AutoCompleteService {
    private final TrieNode root;

    public AutoCompleteService() {
        this.root = new TrieNode();
    }

    public void insert(String word, int frequency) {
        TrieNode current = root;
        for (char ch : word.toLowerCase().toCharArray()) {
            current.getChildren().putIfAbsent(ch, new TrieNode());
            current = current.getChildren().get(ch);
        }
        current.setEndOfWord(true);
        current.incrementFrequency(frequency);
    }

    public void loadDictionary(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                if (parts.length >= 1) {
                    String word = parts[0];
                    int freq = parts.length > 1 ? Integer.parseInt(parts[1]) : 1;
                    insert(word, freq);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading dictionary file: " + e.getMessage());
        }
    }

    public List<String> suggestTop5(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toLowerCase().toCharArray()) {
            if (!current.getChildren().containsKey(ch)) {
                return Collections.emptyList();
            }
            current = current.getChildren().get(ch);
        }
        return RankingAlgorithm.getTopSuggestions(current, prefix, 5);
    }
}
