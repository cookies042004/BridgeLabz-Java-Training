package coreprogramming.programmingelements.practice_problem;

import java.util.Scanner;

public class Area {
    public static void main(String[] args){
//        finding area of circle.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the radius");

        double radius = sc.nextDouble();

        double area = 3.14 * radius * radius;

//        printing the area of the circle.
        System.out.println("week1.day1.practice_problem.Area of the circle is: " + area);
    }
}
