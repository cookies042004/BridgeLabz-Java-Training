package core_programming.extraBuiltIn.stringPractice;

import java.util.Scanner;

public class ReverseString {
    static String reverse(String text) {
        String result = "";

        for (int i = text.length() - 1; i >= 0; i--) {
            result += text.charAt(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String input = sc.nextLine();

        System.out.println("Reversed String: " + reverse(input));
    }
}

