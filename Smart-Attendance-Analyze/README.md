# 🎓 Smart Attendance Analyzer

A console-based Java application that helps students track their attendance, predict future attendance scenarios, and maintain the required attendance threshold. Built with modern Java features including Records.

![Java](https://img.shields.io/badge/Java-17+-orange.svg)
![License](https://img.shields.io/badge/License-MIT-blue.svg)
![Status](https://img.shields.io/badge/Status-Active-success.svg)


## 🎯 Overview

The Smart Attendance Analyzer is an intelligent tool designed for students to manage their academic attendance effectively. It calculates current attendance percentage, warns about low attendance, and provides actionable insights on how many classes need to be attended to reach or maintain the required 75% threshold.

## ✨ Features

### Core Features
- **Attendance Calculation**: Automatically calculates attendance percentage
- **Threshold Monitoring**: Alerts when attendance falls below 75%
- **Predictive Analysis**: Calculates exact number of classes needed to reach target
- **Buffer Calculation**: Shows how many classes can be missed while staying above threshold
- **Input Validation**: Prevents invalid data entry
- **User-Friendly Interface**: Clean console output with emojis and formatting

### Smart Insights
- ⚠️ Warning system for low attendance
- ✅ Positive reinforcement for good attendance
- 📊 Detailed statistical breakdown
- 💡 Personalized recommendations
- 📈 Future attendance projections

## 🔧 Prerequisites

- Java Development Kit (JDK) 17 or higher
- Any text editor or IDE (VS Code, IntelliJ IDEA, Eclipse)
- Basic understanding of Java programming

## 📥 Installation

1. **Compile the Program**
```bash
javac SmartAttendanceAnalyzer.java
```

2. **Run the Application**
```bash
java SmartAttendanceAnalyzer
```

## 💻 Usage

### Running the Program

1. Execute the compiled Java class
2. Enter student name when prompted
3. Input total number of classes held
4. Input number of classes attended
5. View the detailed attendance analysis

### Sample Input
```
Enter student name: Alex Johnson
Enter total number of classes held: 60
Enter number of classes attended: 42
```

### Sample Output
```
===========================================
    ATTENDANCE REPORT
===========================================
Student Name: Alex Johnson
Total Classes: 60
Attended Classes: 42
Missed Classes: 18
Current Attendance: 70.00%
-------------------------------------------
⚠️  WARNING: Attendance is BELOW the required threshold!
📊 Required: 75% | Current: 70.00%
📉 Shortage: 5.00%

💡 RECOMMENDATION:
   You need to attend 12 more consecutive classes
   to reach 75% attendance.
   Future attendance: 54/72 = 75.00%
===========================================
```

## 🔍 How It Works

### Mathematical Formulas

**1. Attendance Percentage**
```
Percentage = (Attended Classes / Total Classes) × 100
```

**2. Classes Needed to Reach Target**
```
Classes Needed = ⌈(Target% × Total - 100 × Attended) / (100 - Target%)⌉
```

**3. Classes That Can Be Missed**
```
Can Miss = ⌊(100 × Attended - Threshold% × Total) / Threshold%⌋
```

### Algorithm Flow
1. Accept user input and validate data
2. Create `AttendanceRecord` with student information
3. Calculate current attendance percentage
4. Compare with threshold (75%)
5. Generate recommendations based on status:
   - **Below threshold**: Calculate classes needed
   - **Above threshold**: Calculate buffer available
6. Display comprehensive report

## 📊 Example Scenarios

### Scenario 1: Below Threshold
**Input**: 50 total classes, 35 attended
- Current: 70%
- Status: ⚠️ Below threshold
- Action: Attend 5 more consecutive classes to reach 75%

### Scenario 2: Above Threshold
**Input**: 80 total classes, 65 attended
- Current: 81.25%
- Status: ✅ Above threshold
- Buffer: Can miss 5 more classes and maintain 75%

### Scenario 3: At Risk
**Input**: 100 total classes, 74 attended
- Current: 74%
- Status: ⚠️ Just below threshold
- Action: Attend 4 more consecutive classes to reach 75%

## 🛠️ Technical Concepts

This project demonstrates the following Java concepts:

### 1. **Records (Java 14+)**
- Immutable data carrier class
- Automatic generation of constructor, getters, equals(), hashCode()
- Compact constructor for validation

### 2. **Object-Oriented Programming**
- Encapsulation of attendance logic
- Method organization and reusability
- Clean separation of concerns

### 3. **Mathematical Operations**
- Percentage calculations
- Ceiling function for rounding up
- Formula derivation and implementation

### 4. **Exception Handling**
- Input validation
- Error messages for invalid data
- Try-catch blocks for robust error handling

### 5. **Conditional Logic**
- If-else statements for decision making
- Threshold comparisons
- Status-based recommendations

### 6. **String Formatting**
- Printf for decimal formatting
- Multi-line string outputs
- User-friendly display formatting

## 📁 Project Structure

```
smart-attendance-analyzer/
│
├── SmartAttendanceAnalyzer.java    # Main application file
├── README.md                        # Project documentation
└── LICENSE                          # License file
```

### Class Structure
```
SmartAttendanceAnalyzer (Main Class)
├── main()                           # Entry point
└── displayAnalysis()                # Display formatted report

AttendanceRecord (Record)
├── calculatePercentage()            # Calculate attendance %
├── isBelowThreshold()               # Check threshold status
├── classesNeededForTarget()         # Predict classes needed
└── classesCanMiss()                 # Calculate buffer
```
