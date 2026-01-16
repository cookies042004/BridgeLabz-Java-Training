package coreprogramming.extraBuiltIn.stringPractice;

import java.util.Scanner;

public class LongestWord {
    static String findLongestWord(String sentence) {
        String longest = "";
        String current = "";

        for (int i = 0; i <= sentence.length(); i++) {
            if (i == sentence.length() || sentence.charAt(i) == ' ') {
                if (current.length() > longest.length()) {
                    longest = current;
                }
                current = "";
            } else {
                current += sentence.charAt(i);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter sentence: ");
        String input = sc.nextLine();

        System.out.println("Longest word: " + findLongestWord(input));
    }
}

