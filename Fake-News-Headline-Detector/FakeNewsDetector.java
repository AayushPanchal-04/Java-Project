import java.util.*;
import java.util.regex.*;

public class FakeNewsDetector {

    private static final Set<String> SENSATIONAL_WORDS = new HashSet<>(Arrays.asList(
            "shocking", "unbelievable", "amazing", "incredible", "miracle",
            "secret", "exposed", "revealed", "truth", "conspiracy", "hoax",
            "breaking", "urgent", "alert", "warning", "danger", "scary",
            "explosive", "bombshell", "devastating", "terrifying", "outrageous"
    ));

    private static final Pattern EXCESSIVE_PUNCTUATION = Pattern.compile("[!?]{2,}");
    private static final Pattern ALL_CAPS_WORDS = Pattern.compile("\\b[A-Z]{3,}\\b");
    private static final Pattern CLICKBAIT_PATTERN = Pattern.compile(
            "\\b(you won't believe|what happens next|doctors hate|one simple trick|" +
                    "this is why|the reason why|shocking truth|number \\d+ will)\\b",
            Pattern.CASE_INSENSITIVE
    );

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== FAKE NEWS HEADLINE DETECTOR ===\n");
        System.out.println("Built by Aayush Panchal\n");

        while (true) {
            System.out.print("Enter a headline (or type 'exit' to quit): ");
            String headline = scanner.nextLine();

            if (headline.equalsIgnoreCase("exit")) {
                System.out.println("\nThank you for using the Fake News Detector!");
                break;
            }

            if (headline.trim().isEmpty()) {
                System.out.println("Please enter a valid headline.\n");
                continue;
            }

            AnalysisResult result = analyzeHeadline(headline);

            System.out.println("\n" + "=".repeat(80));
            System.out.println("Headline: " + result.headline);
            System.out.println("Suspicion Score: " + result.score + "/100");
            System.out.println("Classification: " + result.classification);
            System.out.println("Flags: " + (result.flags.isEmpty() ? "None" : result.flags));
            System.out.println("=".repeat(80) + "\n");
        }

        scanner.close();
    }

    public static AnalysisResult analyzeHeadline(String headline) {
        List<String> flags = new ArrayList<>();
        int score = 0;

        long sensationalCount = Arrays.stream(headline.toLowerCase().split("\\s+"))
                .filter(SENSATIONAL_WORDS::contains)
                .count();

        if (sensationalCount > 0) {
            score += (int)(sensationalCount * 20);
            flags.add("Contains " + sensationalCount + " sensational word(s)");
        }

        Matcher capsmatcher = ALL_CAPS_WORDS.matcher(headline);
        long capsCount = capsmatcher.results().count();

        if (capsCount >= 2) {
            score += 25;
            flags.add("Multiple words in ALL CAPS");
        } else if (capsCount == 1) {
            score += 15;
            flags.add("Contains ALL CAPS word");
        }

        if (EXCESSIVE_PUNCTUATION.matcher(headline).find()) {
            score += 20;
            flags.add("Excessive punctuation (!!!, ???)");
        }

        if (CLICKBAIT_PATTERN.matcher(headline).find()) {
            score += 30;
            flags.add("Clickbait phrase detected");
        }

        long exclamationCount = headline.chars().filter(ch -> ch == '!').count();
        if (exclamationCount >= 3) {
            score += 15;
            flags.add("Excessive exclamation marks");
        }

        score = Math.min(score, 100);

        String classification;
        if (score >= 70) {
            classification = "HIGHLY SUSPICIOUS";
        } else if (score >= 50) {
            classification = "SUSPICIOUS";
        } else if (score >= 30) {
            classification = "SOMEWHAT SUSPICIOUS";
        } else {
            classification = "LEGITIMATE";
        }

        return new AnalysisResult(headline, score, classification, flags);
    }

    static class AnalysisResult {
        String headline;
        int score;
        String classification;
        List<String> flags;

        AnalysisResult(String headline, int score, String classification, List<String> flags) {
            this.headline = headline;
            this.score = score;
            this.classification = classification;
            this.flags = flags;
        }
    }
}
