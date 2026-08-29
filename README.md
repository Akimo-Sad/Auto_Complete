# Smart Auto-Complete & Keyboard Word Suggestion System

A professional Java-based intelligent auto-complete and keyboard word suggestion engine built using the **Trie** data structure and **Frequency-Based Ranking Algorithms**.

---

## 🌟 Key Features

* **Top 5 Word Suggestions:** Recommends up to 5 relevant words based on the user's typed prefix (similar to smartphone keyboards).
* **Frequency & Ranking Engine:** Prioritizes frequently searched words using a Priority Queue / Max-Heap mechanism.
* **External Dictionary Library:** Reads words and frequency data dynamically from a dedicated dictionary file (`dictionary.txt`).
* **Clean & Modular Architecture:** Follows industry standards by separating data models, algorithm logic, services, and execution logic into clean packages.

---

## 📁 Repository & File Structure

```text
Auto_Complete/
│
├── src/
│   ├── com/autocomplete/
│   │   ├── model/
│   │   │   └── TrieNode.java          # Core Trie node structure definition
│   │   ├── service/
│   │   │   └── AutoCompleteService.java # Handles prefix navigation & dictionary loading
│   │   ├── algorithm/
│   │   │   └── RankingAlgorithm.java   # Top-5 extraction using DFS + PriorityQueue
│   │   └── main/
│   │       └── Main.java               # Application entry point & console driver
│   │
│   └── data/
│       └── dictionary.txt              # Dictionary word library with search frequencies
│
└── README.md                           # Project documentation
