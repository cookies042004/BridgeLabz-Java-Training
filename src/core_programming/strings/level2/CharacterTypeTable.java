package core_programming.strings.level2;

import java.util.Scanner;

public class CharacterTypeTable {
    static String checkCharacter(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                return "Vowel";
            else
                return "Consonant";
        }
        return "Not a Letter";
    }

    static String[][] buildCharacterTable(String text) {
        String[][] table = new String[text.length()][2];

        for (int i = 0; i < text.length(); i++) {
            table[i][0] = String.valueOf(text.charAt(i));
            table[i][1] = checkCharacter(text.charAt(i));
        }
        return table;
    }

    static void displayTable(String[][] table) {
        System.out.println("\nCharacter\tType");
        System.out.println("----------------------");

        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t\t" + table[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();

        String[][] table = buildCharacterTable(input);
        displayTable(table);
    }
}

