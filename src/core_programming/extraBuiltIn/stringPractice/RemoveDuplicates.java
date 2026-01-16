package core_programming.extraBuiltIn.stringPractice;

import java.util.Scanner;

public class RemoveDuplicates {
    static String removeDuplicates(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            boolean duplicate = false;

            for (int j = 0; j < result.length(); j++) {
                if (result.charAt(j) == ch) {
                    duplicate = true;
                    break;
                }
            }

            if (!duplicate) {
                result += ch;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String input = sc.nextLine();

        System.out.println("After removing duplicates: " +
                removeDuplicates(input));
    }
}

