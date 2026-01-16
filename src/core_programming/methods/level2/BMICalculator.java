package core_programming.methods.level2;

import java.util.Scanner;

public class BMICalculator {
    // Method to calculate BMI and store in 3rd column
    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];

            double heightM = heightCm / 100.0;
            double bmi = weight / (heightM * heightM);

            data[i][2] = bmi;
        }
    }

    // Method to determine BMI status
    public static String getBMIStatus(double bmi) {
        if (bmi <= 18.4)
            return "Underweight";
        else if (bmi <= 24.9)
            return "Normal";
        else if (bmi <= 39.9)
            return "Overweight";
        else
            return "Obese";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] bmiData = new double[10][3];

        // Input
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter weight (kg) for person " + (i + 1));
            bmiData[i][0] = sc.nextDouble();

            System.out.println("Enter height (cm) for person " + (i + 1));
            bmiData[i][1] = sc.nextDouble();
        }

        // Calculate BMI
        calculateBMI(bmiData);

        // Output
        System.out.println("\nWeight\tHeight\tBMI\t\tStatus");
        for (int i = 0; i < 10; i++) {
            double bmi = bmiData[i][2];
            String status = getBMIStatus(bmi);

            System.out.printf("%.2f\t%.2f\t%.2f\t%s%n",
                    bmiData[i][0],
                    bmiData[i][1],
                    bmi,
                    status);
        }
    }
}
