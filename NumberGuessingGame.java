import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Step 1: Generate a random number between 1 and 100
        int targetNumber = random.nextInt(100) + 1;
        int maxAttempts = 4;
        boolean guessedCorrectly = false;

        System.out.println("Guess the number between 1 and 100. You have " + maxAttempts + " attempts.");

        // Step 2 & 3: Loop to allow guessing
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.print("Attempt " + attempt + ": Enter your guess: ");
            int userGuess = scanner.nextInt();

            // Compare guess with the target number
            if (userGuess == targetNumber) {
                System.out.println("🎉 Well done! You guessed it right!");
                guessedCorrectly = true;
                break;
            } else {
                int difference = Math.abs(targetNumber - userGuess);
                if (difference <= 5) {
                    System.out.println("🔥 Very close! Better luck next time.");
                } else {
                    System.out.println("❄️ Very far! Try better.");
                }
            }
        }

        // If the user didn't guess correctly
        if (!guessedCorrectly) {
            System.out.println("😞 Out of attempts! The correct number was: " + targetNumber);
        }

        scanner.close();
    }
}
