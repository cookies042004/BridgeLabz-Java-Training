package coreprogramming.programming_elements.level2;

import java.util.Scanner;

public class AthleteRounds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter side 1");
        double side1 = sc.nextDouble();

        System.out.println("Enter side 1");
        double side2 = sc.nextDouble();

        System.out.println("Enter side 1");
        double side3 = sc.nextDouble();

        double perimeter = side1 + side2 + side3;
        double rounds = 5000 / perimeter;

        System.out.println(
                "The total number of rounds the athlete will run is " + rounds +
                        " to complete 5 km"
        );
    }
}
