package coreprogramming.strings.level1;

import java.util.Scanner;

public class NumberException {
    public static void generateException(String s){
        int number = Integer.parseInt(s);
        System.out.println("Number is " + number);
    }

    public static void handleException(String s){
        try{
            int number = Integer.parseInt(s);
            System.out.println("Number is " + number);
        }
        catch (NumberFormatException e){
            System.out.println("Number exception handled " + e);
        }
        catch (RuntimeException e){
            System.out.println("Generic runtime handled " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter string");
        String input = sc.nextLine();

//        generateException(input);

        handleException(input);
    }
}
