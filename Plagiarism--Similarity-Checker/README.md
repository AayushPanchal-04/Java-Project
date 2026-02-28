# 🔍 Smart Plagiarism Similarity Checker

A lightweight Java application that compares two text documents and calculates their similarity percentage by analyzing common words and patterns.

## ✨ Features

- **Text Comparison**: Paste and compare two text documents directly
- **Similarity Calculation**: Uses Jaccard similarity algorithm to compute plagiarism percentage
- **Common Words Detection**: Identifies and highlights overlapping vocabulary
- **Real-time Analysis**: Get instant results without file dependencies
- **Clean Console Interface**: Simple, intuitive command-line experience

## 🛠️ Technologies Used

- **Java**: Core programming language
- **Sets**: For efficient word storage and intersection operations
- **Streams API**: For functional-style data processing
- **Collections Framework**: For data manipulation and analysis

## 📋 Prerequisites

- Java Development Kit (JDK) 11 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code) or command line

## 🚀 Getting Started

### Usage

1. Run the program
2. When prompted, paste your first text document
3. Type `END` on a new line to finish the first input
4. Paste your second text document
5. Type `END` on a new line to finish the second input
6. View the similarity analysis results

### Example

```
=== PLAGIARISM SIMILARITY CHECKER ===

Enter first text (type END on new line when done):
Artificial intelligence is transforming the way we live and work.
Machine learning algorithms can analyze large datasets efficiently.
END

Enter second text (type END on new line when done):
Machine learning algorithms are revolutionizing data analysis.
Artificial intelligence technologies are changing our daily lives.
END

=====================================

Similarity Score: 57.69%

Unique words in Text 1: 15
Unique words in Text 2: 13
Common words found: 8

--- COMMON WORDS ---
algorithms artificial intelligence learning machine...
```

## 🧮 How It Works

1. **Text Processing**: Converts input to lowercase and removes punctuation
2. **Word Extraction**: Filters words longer than 2 characters into Sets
3. **Similarity Calculation**: Uses formula: `(2 × Common Words) / (Total Unique Words) × 100`
4. **Result Display**: Shows percentage, word counts, and common vocabulary

## 🎯 Use Cases

- Academic integrity checking
- Content originality verification
- Document comparison
- Text analysis projects
- Learning data structures and algorithms

## 📊 Technical Highlights

- **Time Complexity**: O(n + m) where n and m are word counts
- **Space Complexity**: O(n + m) for storing unique words
- **Algorithm**: Jaccard Similarity Index
- **Data Structure**: HashSet for O(1) lookup operations