package coreprogramming.strings.level1;

import java.util.Scanner;

public class IllegalArgument {
    // Method to generate exception (no try-catch)
    static void generateException(String str) {
        String sub = str.substring(5, 2);
        System.out.println(sub);
    }

    // Method to handle exception using try-catch
    static void handleException(String str) {
        try {
            String sub = str.substring(5, 2);
            System.out.println(sub);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException handled: " + e);
        } catch (RuntimeException e) {
            System.out.println("RuntimeException handled: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String s = sc.nextLine();

//        generateException(s);
        handleException(s);
    }
}
