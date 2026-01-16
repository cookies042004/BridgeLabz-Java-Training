package coreprogramming.extrabuiltin.practiceproblem;

import java.util.Scanner;

public class PalindromeChecker {
    static boolean isPalindrome(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String input = sc.nextLine();

        if (isPalindrome(input))
            System.out.println("Palindrome");
        else
            System.out.println("Not a Palindrome");
    }
}

