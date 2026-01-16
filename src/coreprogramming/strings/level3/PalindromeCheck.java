package coreprogramming.strings.level3;

import java.util.Scanner;

public class PalindromeCheck {
    static boolean isPalindromeLogic1(String text) {
        int start = 0, end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    static boolean isPalindromeLogic2(String text, int start, int end) {
        if (start >= end)
            return true;
        if (text.charAt(start) != text.charAt(end))
            return false;
        return isPalindromeLogic2(text, start + 1, end - 1);
    }

    static char[] reverseText(String text) {
        char[] rev = new char[text.length()];
        int index = 0;

        for (int i = text.length() - 1; i >= 0; i--) {
            rev[index++] = text.charAt(i);
        }
        return rev;
    }

    static boolean isPalindromeLogic3(String text) {
        char[] original = text.toCharArray();
        char[] reverse = reverseText(text);

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reverse[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String input = sc.nextLine();

        System.out.println("Logic 1: " + isPalindromeLogic1(input));
        System.out.println("Logic 2: " + isPalindromeLogic2(input, 0, input.length() - 1));
        System.out.println("Logic 3: " + isPalindromeLogic3(input));
    }
}

