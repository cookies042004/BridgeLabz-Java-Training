package coreprogramming.programming_elements.practice_problem;

import java.util.Scanner;

public class AddTwoNumber {
    public static void main(String[] args) {
//      taking input of two numbers and printing their sum.
//      taing first number
        System.out.println("Enter the first number");
//        using Scanner class to take the input
        Scanner sc = new Scanner(System.in);
        int firstNumber = sc.nextInt();
        System.out.println("Enter the first number");
        int secondNumber = sc.nextInt();

        int sum = firstNumber + secondNumber;
//        printing the sum
        System.out.println("Sum of first and second number is : " + sum);
    }
}
