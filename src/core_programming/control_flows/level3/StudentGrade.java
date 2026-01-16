package core_programming.control_flows.level3;

import java.util.Scanner;

public class StudentGrade {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Physics marks: ");
        int physics = sc.nextInt();

        System.out.print("Chemistry marks: ");
        int chemistry = sc.nextInt();

        System.out.print("Maths marks: ");
        int maths = sc.nextInt();

        double average = (physics + chemistry + maths) / 3.0;
        System.out.println("Average Marks: " + average);

        if (average >= 80) {
            System.out.println("Grade: A | level4, above agency-normalized standards");
        } else if (average >= 70 && average < 80) {
            System.out.println("Grade: B | level3, at agency-normalized standards");
        } else if (average >= 60 && average < 70) {
            System.out.println("Grade: C | level2, below, but approaching agency-normalized standards");
        } else if (average >= 50 && average < 60) {
            System.out.println("Grade: D | level1, well below agency-normalized standards");
        } else if(average >= 40 && average < 50){
            System.out.println("Grade: E | level1-,too below agency-normalized standards");
        }
        else{
            System.out.println("Grade: R | Remedial Standards");
        }
    }
}

