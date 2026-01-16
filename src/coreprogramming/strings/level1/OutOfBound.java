package coreprogramming.strings.level1;

import java.util.Scanner;

public class OutOfBound {
    // Method to generate exception (no try-catch)
    static void generateException(String str) {
        char ch = str.charAt(str.length()); // Exception
        System.out.println(ch);
    }

    // Method to handle exception using try-catch
    static void handleException(String str) {
        try {
            char ch = str.charAt(str.length());
            System.out.println(ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception handled: " + e);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

//        generateException(input);

        handleException(input);
    }
}

