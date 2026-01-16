package core_programming.array.level2;

import java.util.Scanner;

public class BMIArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        double[] weight = new double[n];
        double[] height = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight: " );
            weight[i] = sc.nextDouble();

            System.out.print("Enter height (cm): ");
            height[i] = sc.nextDouble();

            double h = height[i] / 100;
            bmi[i] = weight[i] / (h * h);

            if (bmi[i] < 18.5)
                status[i] = "Underweight";
            else if (bmi[i] >= 18.5 && bmi[i] < 25)
                status[i] = "Normal";
            else if (bmi[i] >= 25 && bmi[i] < 40)
                status[i] = "Overweight";
            else
                status[i] = "Obese";
        }

        for (int i = 0; i < n; i++) {
            System.out.println(height[i] + " " + weight[i] + " " + bmi[i] + " " + status[i]);
        }
    }
}
