package coreprogramming.programming_elements.practice_problem;

import java.util.Scanner;

public class Power {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        double base,exponent;

        System.out.println("Enter the base");
        base = sc.nextDouble();

        System.out.println("Enter the exponent");
        exponent = sc.nextDouble();

        double power = Math.pow(base,exponent);
        System.out.println("week1.day1.practice_problem.Power is : " + power);
    }
}
