package core_programming.strings.level2;

import java.util.Random;
import java.util.Scanner;

public class StudentsMarks {
    // method for generating random 2-digit marks
    static int[][] generateMarks(int numberOfStudents) {

        int[][] result = new int[numberOfStudents][4];
        Random r = new Random();

        for (int i = 0; i < numberOfStudents; i++) {
            int physics = r.nextInt(90) + 10;
            int chemistry = r.nextInt(90) + 10;
            int maths = r.nextInt(90) + 10;

            result[i][0] = i + 1;
            result[i][1] = physics;
            result[i][2] = chemistry;
            result[i][3] = maths;
        }
        return result;
    }

    // method for calculating total, average and percentage
    static double[][] calculateTotal(int[][] studentsMarks) {

        double[][] result = new double[studentsMarks.length][3];

        for (int i = 0; i < studentsMarks.length; i++) {

            int total =
                    studentsMarks[i][1] +
                            studentsMarks[i][2] +
                            studentsMarks[i][3];

            double average = total / 3.0;
            double percentage = (total / 300.0) * 100.0;

            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;

            result[i][0] = total;
            result[i][1] = average;
            result[i][2] = percentage;
        }
        return result;
    }

    // method for calculating grade
    static String[][] gradeCalculator(double[][] marks) {

        String[][] grades = new String[marks.length][1];

        for (int i = 0; i < marks.length; i++) {

            double percentage = marks[i][2];

            if (percentage >= 80) grades[i][0] = "A";
            else if (percentage >= 70) grades[i][0] = "B";
            else if (percentage >= 60) grades[i][0] = "C";
            else if (percentage >= 50) grades[i][0] = "D";
            else if (percentage >= 40) grades[i][0] = "E";
            else grades[i][0] = "R";
        }
        return grades;
    }

    // method for displaying scorecard
    static void displayScoreCard(
            int[][] scores,
            double[][] result,
            String[][] grades) {

        System.out.println(
                "\nStu\tPhy\tChem\tMath\tTotal\tAvg\t%\tGrade");
        System.out.println(
                "-------------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.println(
                    scores[i][0] + "\t" +
                            scores[i][1] + "\t" +
                            scores[i][2] + "\t" +
                            scores[i][3] + "\t" +
                            (int) result[i][0] + "\t" +
                            result[i][1] + "\t" +
                            result[i][2] + "\t" +
                            grades[i][0]
            );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int number = sc.nextInt();

        int[][] marks = generateMarks(number);
        double[][] total = calculateTotal(marks);
        String[][] grade = gradeCalculator(total);

        displayScoreCard(marks, total, grade);
    }
}
