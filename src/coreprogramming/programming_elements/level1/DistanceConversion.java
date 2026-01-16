package coreprogramming.programming_elements.level1;

import java.util.Scanner;

public class DistanceConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter distance in feet: ");
        double distanceInFeet = sc.nextDouble();

        double yards = distanceInFeet / 3;
        double miles = yards / 1760;

        System.out.println(
                "The distance in feet is " + distanceInFeet +
                        " while in yards is " + yards +
                        " and miles is " + String.format("%.7f",miles)
        );
    }
}
