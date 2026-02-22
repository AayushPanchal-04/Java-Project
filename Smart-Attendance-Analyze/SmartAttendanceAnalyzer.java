
import java.util.Scanner;

record AttendanceRecord(String studentName, int totalClasses, int attendedClasses){
    public AttendanceRecord{
        if (totalClasses < 0 || attendedClasses < 0){
            throw new IllegalArgumentException("Classes cannot be negative");
        }
        if(attendedClasses > totalClasses){
            throw new IllegalArgumentException("Attended classes cannot exceed total classes");
        }
    }

    public double calculatePercentage(){
        if (totalClasses == 0) return 0.0;
        return (attendedClasses *100.0)/ totalClasses;
    }

    public boolean isBelowThreshold(double threshold){
        return calculatePercentage() < threshold;
    }
    public int classesNeededForTarget(double targetPercentage){
        if(calculatePercentage() >= targetPercentage){
            return 0;
        }
        double numerator = (targetPercentage * totalClasses) - (100.0 * attendedClasses);
        double denominator = 100.0 - targetPercentage;
        if(denominator <= 0){
            return -1;
        }
        return (int) Math.ceil(numerator / denominator);
    }
    public int classesCanMiss(double threshold){
        if (calculatePercentage() < threshold){
            return 0;
        }
        double numerator = (100.0 * attendedClasses) - (threshold * totalClasses);
        double denominator = threshold;
        if(numerator < 0){
            return 0;
        }
        return (int) (numerator / denominator);
    }
}

public class SmartAttendanceAnalyzer {
    private static final double REQUIRED_THRESHOLD = 75.0;
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("===========================================");
        System.out.println("    SMART ATTENDANCE ANALYZER");
        System.out.println("===========================================\n");
        System.out.println("Built by Aayush Panchal\n");  
        try{
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            System.out.print("Enter total number of classes held: ");
            int totalClasses = scanner.nextInt();

            System.out.print("Enter number of classes attended: ");
            int attendedClasses = scanner.nextInt();

            AttendanceRecord record = new AttendanceRecord(name, totalClasses, attendedClasses);
            displayAnalysis(record);
        }
        catch (IllegalArgumentException e){
            System.out.println("\n Error: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("\n Invalid input! Please enter valid numbers.");
        }
        finally{
            scanner.close();
        }

        }
    private static void displayAnalysis(AttendanceRecord record){
        System.out.println("\n===========================================");
        System.out.println("    ATTENDANCE REPORT");
        System.out.println("===========================================");
        System.out.println("Student Name: " + record.studentName());
        System.out.println("Total Classes: " + record.totalClasses());
        System.out.println("Attended Classes: " + record.attendedClasses());
        System.out.println("Missed Classes: " + (record.totalClasses() - record.attendedClasses()));

        double percentage = record.calculatePercentage();
        System.out.printf("Current Attendance: %.2f%%\n", percentage);

        System.out.println("-------------------------------------------");

        if (record.isBelowThreshold(REQUIRED_THRESHOLD)) {
            System.out.println("WARNING: Attendance is BELOW the required threshold!");
            System.out.printf("Required: %.0f%% | Current: %.2f%%\n", REQUIRED_THRESHOLD, percentage);
            System.out.printf("Shortage: %.2f%%\n", REQUIRED_THRESHOLD - percentage);


            int classesNeeded = record.classesNeededForTarget(REQUIRED_THRESHOLD);
            if (classesNeeded > 0) {
                System.out.println("\n RECOMMENDATION:");
                System.out.printf("You need to attend %d more consecutive classes\n", classesNeeded);
                System.out.printf(" to reach %.0f%% attendance.\n", REQUIRED_THRESHOLD);
                int futureTotal = record.totalClasses() + classesNeeded;
                int futureAttended = record.attendedClasses() + classesNeeded;
                double futurePercentage = (futureAttended * 100.0) / futureTotal;
                System.out.printf("Future attendance: %d/%d = %.2f%%\n",
                        futureAttended, futureTotal, futurePercentage);
            } else {
                System.out.println("\n It may not be possible to reach the threshold.");
            }
        }
        else {
            System.out.println("GOOD NEWS: Attendance is above the required threshold!");
            System.out.printf("Required: %.0f%% | Current: %.2f%%\n", REQUIRED_THRESHOLD, percentage);
            System.out.printf("Surplus: %.2f%%\n", percentage - REQUIRED_THRESHOLD);

            int canMiss = record.classesCanMiss(REQUIRED_THRESHOLD);
            if (canMiss > 0) {
                System.out.println("\nBUFFER AVAILABLE:");
                System.out.printf("You can miss up to %d more classes\n", canMiss);
                System.out.printf(" and still maintain %.0f%% attendance.\n", REQUIRED_THRESHOLD);
            } else {
                System.out.println("\n No buffer available. Attend all future classes!");
            }
        }
        System.out.println("===========================================");
        }

    }
