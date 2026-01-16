package coreprogramming.methods.level1;

import java.util.Scanner;

public class Angle {
    public static double[] calculateMath(double angle) {
        double angleInRadians = Math.toRadians(angle);

        double sine = Math.sin(angleInRadians);
        double cosine = Math.cos(angleInRadians);
        double tangent = Math.tan(angleInRadians);

        return new double[]{sine, cosine, tangent};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the angle in degrees");
        double angle = sc.nextDouble();

        double[] result = calculateMath(angle);

        System.out.println("Sine is " + result[0] + " Cosine is " + result[1] + " Tangent is " + result[2]);
    }
}
