# 📝 Text Auto-Correct System

A lightweight, rule-based text auto-correction engine built in pure Java. This console application intelligently fixes common spelling mistakes, handles repeated characters, and provides smart suggestions using edit distance algorithms.

## ✨ Features

- **Dictionary-Based Corrections**: Automatically fixes 25+ common spelling mistakes
- **Pattern Recognition**: Detects and corrects repeated characters (e.g., "hellooo" → "hello")
- **Case Preservation**: Maintains original capitalization patterns
- **Smart Suggestions**: Uses Levenshtein distance algorithm to suggest corrections
- **Punctuation Handling**: Preserves punctuation marks around corrected words
- **Custom Rules**: Add your own correction rules dynamically
- **Interactive CLI**: User-friendly command-line interface

## 🚀 Quick Start

### Prerequisites
- Java 8 or higher
- IntelliJ IDEA (or any Java IDE)

## 💡 Usage Examples

### Basic Auto-Correction
```
> I beleive teh goverment shoudl fix this
Corrected: I believe the government should fix this
```

### Getting Suggestions
```
> suggest recieve
Suggestions for 'recieve': [receive]
```

### Adding Custom Rules
```
> add wrng wrong
Rule added: wrng -> wrong

> This is wrng
Corrected: This is wrong
```

### Viewing All Rules
```
> rules
=== Correction Rules ===
accomodate -> accommodate
acheive -> achieve
adn -> and
...
```

## 🛠️ Technical Implementation

### Core Algorithms

**Edit Distance (Levenshtein Distance)**
- Dynamic programming approach with O(m×n) time complexity
- Used for intelligent word suggestions
- Finds corrections within 2 character edits

**String Processing**
- HashMap-based lookups for O(1) correction time
- Regex patterns for punctuation handling
- Character iteration for repeated character detection

### Data Structures
- `HashMap<String, String>` for correction mappings
- `ArrayList<String>` for suggestion lists
- 2D array for edit distance calculation

## 📊 Built-in Corrections

The system comes with 25+ pre-configured corrections including:
- teh → the
- recieve → receive
- beleive → believe
- definately → definitely
- goverment → government
- And many more!

## 🎯 Key Concepts Demonstrated

- **Map Data Structure**: Efficient key-value storage
- **String Processing**: Pattern matching and manipulation
- **Dynamic Programming**: Edit distance algorithm
- **Object-Oriented Design**: Clean class structure
- **CLI Design**: Interactive user interface

## 📝 Commands Reference

| Command | Description |
|---------|-------------|
| `<text>` | Auto-correct the entered text |
| `rules` | Display all correction rules |
| `suggest <word>` | Get suggestions for a word |
| `add <wrong> <correct>` | Add custom correction rule |
| `exit` | Quit the application |

## 🔧 Customization

### Adding More Corrections

Edit the `initializeCorrectionRules()` method:
```java
correctionMap.put("yourcustom", "correct");
```

### Adjusting Repeated Character Threshold

Modify the counter in `fixRepeatedCharacters()`:
```java
if (count <= 2) // Change this value
```

## 🎓 Learning Outcomes

This project demonstrates:
- Practical use of HashMap for fast lookups
- String manipulation and regex in Java
- Dynamic programming concepts
- Algorithm implementation (edit distance)
- Clean code practices
- Interactive console application design
