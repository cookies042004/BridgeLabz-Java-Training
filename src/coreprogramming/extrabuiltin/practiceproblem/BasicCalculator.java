package coreprogramming.extrabuiltin.practiceproblem;

import java.util.Scanner;

public class BasicCalculator {
    static double add(double a, double b) {
        return a + b;
    }

    static double subtract(double a, double b) {
        return a - b;
    }

    static double multiply(double a, double b) {
        return a * b;
    }

    static double divide(double a, double b) {
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter two numbers: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();

        System.out.println("Choose operation: + - * /");
        char op = sc.next().charAt(0);

        switch (op) {
            case '+': System.out.println("Result = " + add(a, b)); break;
            case '-': System.out.println("Result = " + subtract(a, b)); break;
            case '*': System.out.println("Result = " + multiply(a, b)); break;
            case '/': System.out.println("Result = " + divide(a, b)); break;
            default: System.out.println("Invalid Operation");
        }
    }
}

