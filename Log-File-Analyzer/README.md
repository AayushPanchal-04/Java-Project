# 📊 Log File Analyzer

A modern Java-based log file analyzer that reads `.txt` log files and provides detailed statistical analysis with color-coded terminal output.

## ✨ Features

- **Multi-level Log Analysis**: Counts ERROR, WARNING, INFO, and DEBUG entries
- **Visual Statistics**: Color-coded output with percentage bar charts
- **Error Details**: Displays the first 5 error messages for quick debugging
- **Hourly Distribution**: Shows peak logging hours
- **Sample Generator**: Built-in sample log file for testing

## 🛠️ Technologies Used

- **Java 8+**
- **Java Streams API**
- **Lambda Expressions**
- **File I/O (NIO)**
- **Collections Framework (Map, List)**

## 🚀 How to Run

### Prerequisites
- Java 8 or higher installed
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code) or command line

### Steps

1. **Clone the repository**
```bash
   git clone https://github.com/abhigyaabs2/Log-File-Analyzer.git
   cd Log-File-Analyzer
```

2. **Compile the program**
```bash
   javac LogFileAnalyzer.java
```

3. **Run the program**
```bash
   java LogFileAnalyzer
```

4. **When prompted:**
   - Press `Enter` to use the auto-generated sample log file
   - Or enter the path to your own log file

## 💡 Concepts Demonstrated

- **File I/O**: Reading files using `Files.lines()` and NIO
- **Streams**: Processing data with Java Stream API
- **Lambdas**: Functional programming with lambda expressions
- **Collections**: Using `Map` and `List` for data organization
- **String Processing**: Pattern matching and extraction

## 📚 Learning Outcomes

This project helped me understand:
- Reading and processing text files efficiently
- Using Java Streams for data transformation
- Implementing functional programming concepts
- Creating user-friendly CLI applications
- Working with collections and aggregations

## 🔮 Future Enhancements

- [ ] Export analysis to CSV/JSON
- [ ] Filter logs by date range
- [ ] Real-time log monitoring
- [ ] GUI interface
- [ ] Support for multiple log formats
- [ ] Email alerts for critical errors

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

## 🙏 Acknowledgments

- Inspired by real-world log analysis needs
- Built as a learning project to master Java Streams and File I/O
