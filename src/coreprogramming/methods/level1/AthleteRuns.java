package coreprogramming.methods.level1;

import java.util.Scanner;

public class AthleteRuns {
    public static double calculateDistance(double distance, double perimeter){
        double rounds = distance / perimeter;

        return rounds;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first side of triangle");
        double first = sc.nextDouble();

        System.out.println("Enter second side of triangle");
        double second = sc.nextDouble();

        System.out.println("Enter third side of triangle");
        double third = sc.nextDouble();

        double perimeter = first + second + third;
        double distance = 5000.0;

        double rounds = calculateDistance(distance,perimeter);

        System.out.println("Number of rounds is " + rounds);
    }
}
