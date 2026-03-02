# 📊 Text Sentiment Analyzer

A rule-based sentiment analysis tool built in Java that evaluates the emotional tone of text using natural language processing techniques.

## 🌟 Features

- **Intelligent Sentiment Detection** - Analyzes text and classifies it as Very Positive, Positive, Neutral, Negative, or Very Negative
- **Weighted Scoring System** - Different sentiment words carry different weights based on their emotional intensity
- **Intensifier Support** - Recognizes words like "very", "extremely", "absolutely" that amplify sentiment
- **Negation Handling** - Properly interprets phrases like "not bad" or "not great" by flipping sentiment
- **Detailed Analytics** - Provides comprehensive statistics including word counts, ratios, and overall sentiment scores
- **Interactive Mode** - Test the analyzer in real-time with your own sentences

## 🛠️ Technologies & Concepts

- **Java Core** - Object-oriented programming, collections framework
- **Maps & Sets** - HashMap for word dictionaries, HashSet for modifier words
- **Streams API** - Modern Java stream processing for text manipulation
- **NLP-lite** - Basic natural language processing without external libraries
- **String Processing** - Text preprocessing, tokenization, and pattern matching

## 📋 Requirements

- Java 11 or higher
- IntelliJ IDEA (or any Java IDE)
- No external dependencies required

## 🚀 Getting Started

### Usage

**Automated Testing Mode:**
The program first runs through predefined test cases to demonstrate various sentiment scenarios.

**Interactive Mode:**
After the test cases, you can enter your own text for analysis:

```
Enter text to analyze: I love this product! It's amazing.

============================================================
Analyzing: "I love this product! It's amazing."
============================================================
Sentiment Analysis Results:
------------------------------------------------------------
Overall Sentiment: VERY POSITIVE
Sentiment Score: 7
Positive Words Found: 2
Negative Words Found: 0
Total Words Analyzed: 6
Positive Word Ratio: 33.33%
Negative Word Ratio: 0.00%
------------------------------------------------------------
```

## 📊 How It Works

1. **Text Preprocessing** - Converts text to lowercase and removes punctuation
2. **Tokenization** - Splits text into individual words
3. **Sentiment Scoring** - Matches words against positive/negative dictionaries
4. **Modifier Application** - Applies intensifiers and negations
5. **Final Classification** - Determines overall sentiment based on cumulative score

### Sentiment Scoring Rules

| Score Range | Classification |
|-------------|----------------|
| ≥ 5 | Very Positive |
| 2 to 4 | Positive |
| -1 to 1 | Neutral |
| -4 to -2 | Negative |
| ≤ -5 | Very Negative |

## 🎯 Example Outputs

| Input Text | Sentiment | Score |
|------------|-----------|-------|
| "I love this product! It's absolutely amazing." | VERY POSITIVE | 10 |
| "This is terrible and disappointing." | VERY NEGATIVE | -7 |
| "This is not bad at all!" | POSITIVE | 2 |
| "The movie was okay." | NEUTRAL | 0 |

## 🔍 Project Structure

```
text-sentiment-analyzer/
│
├── SentimentAnalyzer.java
│   ├── Main class with analysis logic
│   ├── SentimentResult inner class
│   └── Word dictionaries and modifiers
│
└── README.md
```

## 🎓 Learning Outcomes

This project demonstrates:
- Working with Java Collections (HashMap, HashSet, List)
- Stream API for functional programming
- String manipulation and text processing
- Basic NLP concepts without ML libraries
- Clean code architecture with inner classes
- Console-based user interaction
