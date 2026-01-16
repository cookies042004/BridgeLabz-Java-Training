package coreprogramming.programmingelements.practice_problem;

import java.util.Scanner;

public class Kilometer {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        double kilometer;

        System.out.println("Enter the kilometers");
        kilometer = sc.nextDouble();

        double miles = kilometer * 0.621371;

        System.out.println("Distance in miles is: " + miles);
    }
}
