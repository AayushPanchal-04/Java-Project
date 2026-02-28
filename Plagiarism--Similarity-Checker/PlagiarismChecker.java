import java.util.*;
import java.util.stream.*;

public class PlagiarismChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== PLAGIARISM SIMILARITY CHECKER ===\n");
        System.out.println("Built by Aayush Panchal\n");

        System.out.println("Enter first text (type END on new line when done):");
        String text1 = readMultilineText(scanner);

        System.out.println("\nEnter second text (type END on new line when done):");
        String text2 = readMultilineText(scanner);

        System.out.println("\n=====================================\n");

        Set<String> words1 = extractWords(text1);
        Set<String> words2 = extractWords(text2);

        Set<String> commonWords = findCommonWords(words1, words2);

        double similarity = calculateSimilarity(words1, words2, commonWords);

        displayResults(similarity, commonWords, words1.size(), words2.size());

        scanner.close();
    }

    private static String readMultilineText(Scanner scanner) {
        StringBuilder text = new StringBuilder();
        String line;

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.equals("END")) {
                break;
            }
            text.append(line).append(" ");
        }

        return text.toString();
    }

    private static Set<String> extractWords(String text) {
        return Arrays.stream(text.toLowerCase()
                        .replaceAll("[^a-z0-9\\s]", " ")
                        .split("\\s+"))
                .filter(word -> word.length() > 2)
                .collect(Collectors.toSet());
    }

    private static Set<String> findCommonWords(Set<String> words1, Set<String> words2) {
        return words1.stream()
                .filter(words2::contains)
                .collect(Collectors.toSet());
    }

    private static double calculateSimilarity(Set<String> words1, Set<String> words2, Set<String> common) {
        int totalUniqueWords = words1.size() + words2.size() - common.size();
        if (totalUniqueWords == 0) return 0.0;
        return (common.size() * 2.0 / totalUniqueWords) * 100;
    }

    private static void displayResults(double similarity, Set<String> commonWords, int count1, int count2) {
        System.out.printf("Similarity Score: %.2f%%\n\n", similarity);
        System.out.println("Unique words in Text 1: " + count1);
        System.out.println("Unique words in Text 2: " + count2);
        System.out.println("Common words found: " + commonWords.size());
        System.out.println("\n--- COMMON WORDS ---");

        commonWords.stream()
                .sorted()
                .forEach(word -> System.out.print(word + " "));

        System.out.println("\n\n=====================================");
    }
}
