import java.util.Scanner;

public class MarksCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        double[] marks = new double[numSubjects];
        double totalMarks = 0;

        // Take marks input for each subject
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            double mark = scanner.nextDouble();

            // Validate input
            while (mark < 0 || mark > 100) {
                System.out.println("Invalid input. Marks should be between 0 and 100.");
                System.out.print("Re-enter marks for subject " + (i + 1) + ": ");
                mark = scanner.nextDouble();
            }

            marks[i] = mark;
            totalMarks += mark;
        }

        // Calculate average percentage
        double averagePercentage = totalMarks / numSubjects;

        // Determine grade
        String grade;
        if (averagePercentage > 95) {
            grade = "A++";
        } else if (averagePercentage > 90) {
            grade = "A+";
        } else if (averagePercentage > 85) {
            grade = "A";
        } else if (averagePercentage > 70) {
            grade = "B+";
        } else if (averagePercentage > 60) {
            grade = "B";
        } else if (averagePercentage > 35) {
            grade = "C";
        } else {
            grade = "D (Fail)";
        }

        // Display results
        System.out.println("\n--- Result Summary ---");
        System.out.println("Total Marks: " + totalMarks + " out of " + (numSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
