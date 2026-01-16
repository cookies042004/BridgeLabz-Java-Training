package coreprogramming.programming_elements.level2;

import java.util.Scanner;

public class DoubleOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first number");
        double a = sc.nextDouble();

        System.out.println("Enter the second number");
        double b = sc.nextDouble();

        System.out.println("Enter the third number");
        double c = sc.nextDouble();

        double r1 = a + b * c;
        double r2 = a * b + c;
        double r3 = c + a / b;
        double r4 = a % b + c;

        System.out.println(
                "The results of Double Operations are " +
                        r1 + ", " + r2 + ", " + r3 + ", and " + r4
        );
    }
}
