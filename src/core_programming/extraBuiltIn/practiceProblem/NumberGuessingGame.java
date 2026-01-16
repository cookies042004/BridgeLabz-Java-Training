package core_programming.extraBuiltIn.practiceProblem;

import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    // Method to generate computer guess
    static int generateGuess(int low, int high) {
        Random r = new Random();
        return r.nextInt(high - low + 1) + low;
    }

    // Method to get user feedback
    static char getUserFeedback(Scanner sc) {
        System.out.print("Is the guess High (h), Low (l), or Correct (c)? ");
        return sc.next().toLowerCase().charAt(0);
    }

    // Method to update guessing range
    static int[] updateRange(int guess, int low, int high, char feedback) {

        if (feedback == 'h') {
            high = guess - 1;
        } else if (feedback == 'l') {
            low = guess + 1;
        }

        return new int[]{low, high};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int low = 1;
        int high = 100;
        boolean guessedCorrectly = false;

        System.out.println("Think of a number between 1 and 100.");
        System.out.println("Computer will try to guess it!\n");

        while (!guessedCorrectly && low <= high) {

            int guess = generateGuess(low, high);
            System.out.println("Computer guesses: " + guess);

            char feedback = getUserFeedback(sc);

            if (feedback == 'c') {
                System.out.println("\n🎉 Computer guessed the number correctly!");
                guessedCorrectly = true;
            } else {
                int[] range = updateRange(guess, low, high, feedback);
                low = range[0];
                high = range[1];
            }
        }
    }
}
