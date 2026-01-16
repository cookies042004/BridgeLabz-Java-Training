package core_programming.strings.level2;

import java.util.Scanner;

public class Trim {
    // Method to find start and end index after trimming spaces
    static int[] findTrimIndexes(String text) {
        int start = 0;
        int end = 0;

        // find start index (first non-space)
        for (int i = 0; ; i++) {
            if (text.charAt(i) != ' ') {
                start = i;
                break;
            }
        }

        // find end index (last non-space)
        for (int i = text.length() - 1; ; i--) {
            if (text.charAt(i) != ' ') {
                end = i;
                break;
            }
        }

        return new int[]{start, end};
    }

    // Method to create substring using charAt()
    static String createSubstring(String text, int start, int end) {
        String result = "";

        for (int i = start; i <= end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    // Method to compare two strings using charAt()
    static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string : ");
        String input = sc.nextLine();

        System.out.println("String before trim " + input);

        int[] indexes = findTrimIndexes(input);
        String manualTrim = createSubstring(input, indexes[0], indexes[1]);

        String builtInTrim = input.trim();

        boolean result = compareStrings(manualTrim, builtInTrim);

        System.out.println("Manual Trim    : \"" + manualTrim + "\"");
        System.out.println("Built-in Trim  : \"" + builtInTrim + "\"");
        System.out.println("Comparison Result: " + result);
    }
}
