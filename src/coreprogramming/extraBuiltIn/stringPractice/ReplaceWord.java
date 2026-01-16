package coreprogramming.extraBuiltIn.stringPractice;

import java.util.Scanner;

public class ReplaceWord {
    static String replaceWord(String sentence, String oldWord, String newWord) {
        String result = "";
        String current = "";

        for (int i = 0; i <= sentence.length(); i++) {
            if (i == sentence.length() || sentence.charAt(i) == ' ') {
                if (current.equals(oldWord))
                    result += newWord;
                else
                    result += current;

                if (i < sentence.length())
                    result += " ";

                current = "";
            } else {
                current += sentence.charAt(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter sentence: ");
        String sentence = sc.nextLine();

        System.out.print("Word to replace: ");
        String oldWord = sc.next();

        System.out.print("New word: ");
        String newWord = sc.next();

        System.out.println("Modified Sentence: " +
                replaceWord(sentence, oldWord, newWord));
    }
}

