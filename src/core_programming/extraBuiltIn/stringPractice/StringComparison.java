package core_programming.extraBuiltIn.stringPractice;

import java.util.Scanner;

public class StringComparison {
    static int compareStrings(String s1, String s2) {

        int minLen = Math.min(s1.length(), s2.length());

        for (int i = 0; i < minLen; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.charAt(i) - s2.charAt(i);
            }
        }
        return s1.length() - s2.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        int result = compareStrings(s1, s2);

        if (result == 0)
            System.out.println("Strings are equal");
        else if (result < 0)
            System.out.println("First string is smaller");
        else
            System.out.println("First string is greater");
    }
}

