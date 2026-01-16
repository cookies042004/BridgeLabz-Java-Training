package coreprogramming.strings.level2;

import java.util.Scanner;

public class StringLength{
    static int findLength(String text) {
        int count = 0;

        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (RuntimeException e) {
            return count;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.next();

        int manualLength = findLength(input);
        int builtInLength = input.length();

        System.out.println("Manual Length   : " + manualLength);
        System.out.println("Built-in Length : " + builtInLength);
    }
}

