package core_programming.extraBuiltIn.stringPractice;

import java.util.Scanner;

public class RemoveSpecificCharacter {
    static String removeCharacter(String text, char remove) {

        String result = "";

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != remove) {
                result += text.charAt(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String input = sc.nextLine();

        System.out.print("Enter character to remove: ");
        char ch = sc.next().charAt(0);

        System.out.println("Modified String: " +
                removeCharacter(input, ch));
    }
}

