package coreprogramming.extraBuiltIn.stringPractice;

import java.util.Scanner;

public class CountVowels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sting");
        String userInput = sc.nextLine().toLowerCase();
        int vowel = 0,consonants = 0;

        for(int i = 0;i < userInput.length();i++){
            char ch = userInput.charAt(i);

            if(ch == ' ') continue;

            if(ch == 'a' || ch == 'i' || ch == 'e' || ch == 'o' || ch == 'u') vowel++;
            else consonants++;
        }

        System.out.println("number of vowels is : " + vowel + " number of consonants " + consonants);
    }
}
