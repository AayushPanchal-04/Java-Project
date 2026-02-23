import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class LogFileAnalyzer {
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";
    private static final String CYAN = "\u001B[36m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(CYAN + "╔══════════════════════════════════════╗");
        System.out.println("║     LOG FILE ANALYZER v1.0           ║");
        System.out.println("╚══════════════════════════════════════╝" + RESET);
        System.out.println();
        System.out.println("Built by Aayush Panchal\n"); 


        System.out.print("Enter log file path (or press Enter for sample): ");
        String filePath = scanner.nextLine().trim();


        if (filePath.isEmpty()) {
            filePath = createSampleLogFile();
            System.out.println(GREEN + "✓ Created sample log file: " + filePath + RESET);
            System.out.println();
        }

        try {

            Map<String, Long> logCounts = analyzeLogFile(filePath);
            List<String> errorLines = getErrorLines(filePath);


            displaySummary(logCounts, filePath);
            displayErrorDetails(errorLines);


            displayAdvancedStats(filePath);

        } catch (IOException e) {
            System.err.println(RED + "✗ Error reading file: " + e.getMessage() + RESET);
        }

        scanner.close();
    }


    private static Map<String, Long> analyzeLogFile(String filePath) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            return lines
                    .filter(line -> !line.trim().isEmpty())
                    .map(LogFileAnalyzer::extractLogLevel)
                    .filter(Objects::nonNull)
                    .collect(Collectors.groupingBy(
                            level -> level,
                            Collectors.counting()
                    ));
        }
    }


    private static String extractLogLevel(String line) {
        String upperLine = line.toUpperCase();
        if (upperLine.contains("ERROR")) return "ERROR";
        if (upperLine.contains("WARNING") || upperLine.contains("WARN")) return "WARNING";
        if (upperLine.contains("INFO")) return "INFO";
        if (upperLine.contains("DEBUG")) return "DEBUG";
        return null;
    }


    private static List<String> getErrorLines(String filePath) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            return lines
                    .filter(line -> line.toUpperCase().contains("ERROR"))
                    .limit(5) // Limit to first 5 errors
                    .collect(Collectors.toList());
        }
    }


    private static void displaySummary(Map<String, Long> logCounts, String filePath) throws IOException {
        System.out.println(BLUE + "═══════════════════════════════════════" + RESET);
        System.out.println(CYAN + "  ANALYSIS SUMMARY" + RESET);
        System.out.println(BLUE + "═══════════════════════════════════════" + RESET);
        System.out.println("File: " + filePath);
        System.out.println("Total Lines: " + Files.lines(Paths.get(filePath)).count());
        System.out.println();

        long errorCount = logCounts.getOrDefault("ERROR", 0L);
        long warningCount = logCounts.getOrDefault("WARNING", 0L);
        long infoCount = logCounts.getOrDefault("INFO", 0L);
        long debugCount = logCounts.getOrDefault("DEBUG", 0L);

        System.out.println(RED + "  ERROR:    " + errorCount + RESET);
        System.out.println(YELLOW + "  WARNING:  " + warningCount + RESET);
        System.out.println(GREEN + "  INFO:     " + infoCount + RESET);
        System.out.println("  DEBUG:    " + debugCount);
        System.out.println();


        long total = errorCount + warningCount + infoCount + debugCount;
        if (total > 0) {
            System.out.println("Log Level Distribution:");
            printBar("ERROR", errorCount, total, RED);
            printBar("WARNING", warningCount, total, YELLOW);
            printBar("INFO", infoCount, total, GREEN);
            printBar("DEBUG", debugCount, total, RESET);
        }
        System.out.println();
    }


    private static void displayErrorDetails(List<String> errorLines) {
        if (!errorLines.isEmpty()) {
            System.out.println(RED + "═══════════════════════════════════════" + RESET);
            System.out.println(RED + "  RECENT ERRORS (First 5)" + RESET);
            System.out.println(RED + "═══════════════════════════════════════" + RESET);

            int count = 1;
            for (String error : errorLines) {
                System.out.println(count++ + ". " + error.trim());
            }
            System.out.println();
        }
    }


    private static void displayAdvancedStats(String filePath) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            Map<String, Long> hourlyDistribution = lines
                    .filter(line -> line.matches(".*\\d{2}:\\d{2}:\\d{2}.*"))
                    .map(LogFileAnalyzer::extractHour)
                    .filter(Objects::nonNull)
                    .collect(Collectors.groupingBy(
                            hour -> hour,
                            Collectors.counting()
                    ));

            if (!hourlyDistribution.isEmpty()) {
                System.out.println(CYAN + "═══════════════════════════════════════" + RESET);
                System.out.println(CYAN + "  HOURLY DISTRIBUTION" + RESET);
                System.out.println(CYAN + "═══════════════════════════════════════" + RESET);

                hourlyDistribution.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(5)
                        .forEach(entry ->
                                System.out.println("  " + entry.getKey() + ":00 → " + entry.getValue() + " logs")
                        );
                System.out.println();
            }
        }
    }


    private static String extractHour(String line) {
        int timeIndex = line.indexOf(":");
        if (timeIndex >= 2) {
            try {
                return line.substring(timeIndex - 2, timeIndex);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }


    private static void printBar(String label, long count, long total, String color) {
        double percentage = (count * 100.0) / total;
        int barLength = (int) (percentage / 2); // Scale to 50 chars max

        System.out.printf("  %-8s [", label);
        System.out.print(color);
        for (int i = 0; i < 50; i++) {
            System.out.print(i < barLength ? "█" : " ");
        }
        System.out.print(RESET);
        System.out.printf("] %.1f%%\n", percentage);
    }


    private static String createSampleLogFile() {
        String fileName = "sample_app.log";
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("2024-01-15 10:23:45 INFO Application started successfully");
            writer.println("2024-01-15 10:23:46 INFO Loading configuration from config.xml");
            writer.println("2024-01-15 10:23:47 DEBUG Connecting to database at localhost:5432");
            writer.println("2024-01-15 10:23:48 INFO Database connection established");
            writer.println("2024-01-15 10:24:12 WARNING Connection pool running low: 2/10 available");
            writer.println("2024-01-15 10:25:33 ERROR Failed to process user request: NullPointerException");
            writer.println("2024-01-15 10:25:34 ERROR Stack trace: at com.app.UserService.process(UserService.java:45)");
            writer.println("2024-01-15 10:26:01 INFO User authentication successful for user: admin");
            writer.println("2024-01-15 10:27:15 WARNING Cache miss for key: user_profile_1234");
            writer.println("2024-01-15 10:28:22 DEBUG Query execution time: 245ms");
            writer.println("2024-01-15 10:29:33 INFO Request processed successfully");
            writer.println("2024-01-15 10:30:45 ERROR Database timeout after 30 seconds");
            writer.println("2024-01-15 10:31:12 WARNING Retrying connection attempt 1 of 3");
            writer.println("2024-01-15 10:31:15 INFO Connection restored successfully");
            writer.println("2024-01-15 10:32:00 DEBUG Memory usage: 456MB / 1024MB");
            writer.println("2024-01-15 10:33:21 INFO Background job started: data_cleanup");
            writer.println("2024-01-15 10:35:44 WARNING Disk space low: 5GB remaining");
            writer.println("2024-01-15 10:37:09 ERROR Failed to send email notification: SMTP connection refused");
            writer.println("2024-01-15 10:38:15 INFO Session created for user: john_doe");
            writer.println("2024-01-15 10:40:00 INFO Application health check: OK");
        } catch (IOException e) {
            System.err.println("Could not create sample file: " + e.getMessage());
        }
        return fileName;
    }
}
