package coreprogramming.programmingelements.level2;

import java.util.Scanner;

public class WeightConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Weight");
        double weightPound = sc.nextDouble();

        double weightKg = weightPound / 2.2;

        System.out.println(
                "The weight of the person in pound is " +
                        weightPound + " and in kg is " + weightKg
        );
    }
}
