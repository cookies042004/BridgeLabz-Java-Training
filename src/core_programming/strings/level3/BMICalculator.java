package core_programming.strings.level3;

import java.util.Scanner;

public class BMICalculator {
    static double[][] weightAndHeightStoring(int persons){
        Scanner sc = new Scanner(System.in);
        double[][] weightAndHeight = new double[persons][2];

        for(int i = 0;i < persons;i++){
            System.out.println("Enter weight(in kg) of " + (i + 1) + " person");
            double weight = sc.nextDouble();

            System.out.println("Enter height(in cm) of " + (i + 1) + "person");
            double height = sc.nextDouble();

            weightAndHeight[i][0] = weight;
            weightAndHeight[i][1] = height;
        }

        return weightAndHeight;
    }

    static double calculateBMI(double weight, double heightInMeters) {
        return weight / (heightInMeters * heightInMeters);
    }

    // Method to calculate BMI status
    static String getBMIStatus(double bmi) {

        if (bmi >= 40)
            return "Obese";
        else if (bmi >= 25)
            return "Overweight";
        else if (bmi >= 18.5)
            return "Normal";
        else
            return "Underweight";
    }

    // Method to build 2D String array with Height, Weight, BMI, Status
    static String[][] buildBMIReport(double[][] weightAndHeight) {

        String[][] report = new String[weightAndHeight.length][4];

        for (int i = 0; i < weightAndHeight.length; i++) {

            double weight = weightAndHeight[i][0];
            double heightCm = weightAndHeight[i][1];
            double heightMeter = heightCm / 100.0;

            double bmi = calculateBMI(weight, heightMeter);
            bmi = Math.round(bmi * 100.0) / 100.0;

            report[i][0] = String.valueOf(heightCm);
            report[i][1] = String.valueOf(weight);
            report[i][2] = String.valueOf(bmi);
            report[i][3] = getBMIStatus(bmi);
        }
        return report;
    }

    static void displayReport(String[][] report){
        System.out.println("Height(Cm)\t\tWeight(kg)\t\tBMI\t\tStatus");
        for(int i = 0;i < report.length;i++){
            System.out.println(
                    report[i][0] + "\t\t\t" +
                    report[i][1] + "\t\t\t" +
                    report[i][2] + "\t\t\t" +
                    report[i][3]
            );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number : ");
        int number = sc.nextInt();

        double[][] weightAndHeight = weightAndHeightStoring(number);
        String[][] report = buildBMIReport(weightAndHeight);
        displayReport(report);
    }
}
