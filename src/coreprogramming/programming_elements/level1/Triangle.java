package coreprogramming.programming_elements.level1;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the base (in inches)");
        double base = sc.nextDouble();

        System.out.println("Enter the height (in inches)");
        double height = sc.nextDouble();

        double inchToCm = 2.54;

        // week1.day1.practice_problem.Area in square inches
        double areaInInch = 0.5 * base * height;

        // Convert base and height to cm
        double baseCm = base * inchToCm;
        double heightCm = height * inchToCm;

        // week1.day1.practice_problem.Area in square centimeters
        double areaInCm = 0.5 * baseCm * heightCm;

        System.out.println(
                "The area of the triangle is " + areaInInch + " square inches " +
                        "and " + areaInCm + " square centimeters"
        );
    }
}
