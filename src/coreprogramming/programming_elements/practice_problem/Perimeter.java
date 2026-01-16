package coreprogramming.programming_elements.practice_problem;

import java.util.Scanner;

public class Perimeter {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        double length,width;
        System.out.println("Enter the length");
        length = sc.nextDouble();

        System.out.println("Enter the width");
        width = sc.nextDouble();

        double perimeter = 2 * (width + length);

        System.out.println("week1.day1.practice_problem.Perimeter is : " + perimeter);
    }
}
