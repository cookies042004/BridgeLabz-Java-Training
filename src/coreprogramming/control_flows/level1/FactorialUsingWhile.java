package coreprogramming.control_flows.level1;

import java.util.Scanner;

public class FactorialUsingWhile {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");

        int number = scanner.nextInt();
        long factorial = 1;

        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else if (number == 0) {
            System.out.println("The Factorial of 0 is: 1");
        } else {
            int i = 1;
            while (i <= number) {
                factorial *= i;
                i++;
            }
            System.out.println("The Factorial of " + number + " is: " + factorial);
        }
    }
}
