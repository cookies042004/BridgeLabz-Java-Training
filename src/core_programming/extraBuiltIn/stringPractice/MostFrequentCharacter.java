package core_programming.extraBuiltIn.stringPractice;

import java.util.Scanner;

public class MostFrequentCharacter {
    static char findMostFrequentChar(String text) {

        int[] freq = new int[256];

        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        char mostFrequent = text.charAt(0);
        int maxCount = freq[mostFrequent];

        for (int i = 1; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] > maxCount) {
                maxCount = freq[ch];
                mostFrequent = ch;
            }
        }
        return mostFrequent;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String input = sc.nextLine();

        System.out.println("Most Frequent Character: " +
                findMostFrequentChar(input));
    }
}

