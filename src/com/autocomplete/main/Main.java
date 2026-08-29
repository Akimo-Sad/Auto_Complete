package com.autocomplete.main;

import com.autocomplete.service.AutoCompleteService;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AutoCompleteService service = new AutoCompleteService();
        
        // Load dictionary dataset
        service.loadDictionary("src/data/dictionary.txt");

        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Keyboard Auto-Complete Suggestion System ===");
        System.out.println("Type prefix to get top 5 word suggestions (Type 'exit' to quit):");

        while (true) {
            System.out.print("\nType input: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            List<String> suggestions = service.suggestTop5(input);
            System.out.println("Top 5 Suggestions: " + suggestions);
        }

        scanner.close();
    }
}
